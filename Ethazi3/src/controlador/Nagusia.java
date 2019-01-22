package controlador;

import java.sql.Connection;
import java.sql.ResultSet;

import modelo.Konexioa;
import modelo.Selekzioak;
import vista.InterfaseNagusia;

public class Nagusia {

	public static void main(String[] args) {
		
	String nombreBase = "ethazi";//konektatuko garen datu basearen izena
	new Konexioa(nombreBase);// zer datu baserekin konectatu behar den esaten diogui
	Connection kon = Konexioa.getConexion();// Datu basearekin konexioa lortu
	InterfaseNagusia window = new InterfaseNagusia();
	
	
	
	window.frame.setVisible(true);// leihoa bistaragarria egiten dugu
	
	ResultSet rsBezeroa=Selekzioak.datuakBezeroa(kon,nombreBase);
	Selekzioak.datuakGeltokiak(kon,nombreBase);
	Selekzioak.datuakAutobusak(kon,nombreBase);
	}
}
