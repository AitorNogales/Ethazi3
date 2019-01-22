package controlador;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Konexioa;
import modelo.Selekzioak;
/**
 * 
 * @author Aitor
 *
 */
public class Bitartekoa {
	public final static String bdIzena = "ethazi";// konektatuko garen datu basearen izena
	private final static Connection kon = Konexioa.getConexion();// Datu basearekin konexioa lortu
	
/**
 * konektatu garen datu bezetik bezero guztien zerrenda ateratze du 
 * @return bezero Guztien Zerrenda
 */


	public static ArrayList<Bezeroa> artuBezeroak() {
		ArrayList<Bezeroa> bz = new ArrayList<Bezeroa>();// buektatuko dugun array lista
		ResultSet rs =Selekzioak.datuakBezeroa(kon, bdIzena);//modelotik result set bezala hartzen ditugu bezero gustien datuak

		try {
			while (rs.next()) {
				String dni =rs.getString(0);
				String nombre  =rs.getString(1);
				String apellido =rs.getString(2);
				Date fecha_nac=rs.getDate(3);
				String sexo=rs.getString(4);
				String pass = rs.getString(5);
				String izernabizen = nombre+apellido;
				Bezeroa be=new Bezeroa(dni, izernabizen, sexo, pass, fecha_nac);//bezeroo berria sortzen dugu lortutako datuekin
				bz.add(be);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bz;
	}
}
