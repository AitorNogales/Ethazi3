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
	 * konprobatzen du erabiltzailea datu basean dagoela
	 * @param dni erabiltzailearen dnia
	 * @param pass erabiltzailearen pasahitza
	 * @return existitxen bada true ez bada existitzen false
	 */
	public static boolean ceckBezeroa(String dni, String pass) {
		boolean badago = false;
		ResultSet rs = Selekzioak.kontsultaBiz(dni, pass, bdIzena, kon);//egiten dugu datu basean kontsulta bat 
		try {
			if (rs.next()) {//zerbait bueltatzen badu erabiltzailea existitzen da 
				badago = true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return badago;
	}
	
	public static ArrayList<Linea> artuLieneak(){
		ArrayList<Linea> Lineak =new  ArrayList<Linea>();
		ResultSet rs = Selekzioak.datuakLineak(kon, bdIzena);//datu basetik hartzen ditugu linea guztien datuak
		try {
			while(rs.next()) {
				String kodLinea=rs.getString(0);
				String izLinea=rs.getString(1);
				Linea lin =new Linea(kodLinea,izLinea);
				Lineak.add(lin);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return Lineak;
		
	}
	public static ArrayList<Geltokia> linearenGeltokiak(String kod_Linea){
		ArrayList<Geltokia> Geltokiak =new  ArrayList<Geltokia>();
		ResultSet rs = Selekzioak.datuakGeltokiak(kon, bdIzena,kod_Linea);//datu basetik hartzen ditugu linea guztien datuak
		try {
			while(rs.next()) {
				String kodLinea=rs.getString(0);
				String izLinea=rs.getString(1);
				//Geltokia lin =new Linea(kodLinea,izLinea);
				//Geltokiak.add(lin);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return Geltokiak;
	}
}
