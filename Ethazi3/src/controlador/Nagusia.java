package controlador;

import java.sql.Connection;
import java.sql.ResultSet;

import modelo.Konexioa;
import modelo.Selekzioak;
import vista.InterfaseNagusia;

public class Nagusia {

	public static void main(String[] args) {
	String nombreBase = "ethazi";//konektatuko garen datu basearen izena
	Konexioa bd = new Konexioa(nombreBase);// zer datu baserekin konectatu behar den esaten diogui
	Connection kon = Konexioa.getConexion();// Datu basearekin konexioa lortu
	InterfaseNagusia window = new InterfaseNagusia();
	
	
	
	
	
	
	
	
	
	
	window.frame.setVisible(true);// leihoa bistaragarria egiten dugu
	
	ResultSet rsBezeroa=Selekzioak.datuakBezeroa(kon);
	/*try {
		
		while(rsBezeroa.next()) {
			String DNI=rsBezeroa.getString(0);
			String Nombre=rsBezeroa.getString(1);
			String Apellido=rsBezeroa.getString(2);
			Date Fecha=rsBezeroa.getDate(3);
			String Sexo=rsBezeroa.getString(4);
			System.out.println(DNI+Nombre+Apellido+Fecha+Sexo);
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}*/
	}
}
