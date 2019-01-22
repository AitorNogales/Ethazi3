package controlador;

import java.sql.Connection;
import java.sql.ResultSet;

import modelo.Konexioa;
import modelo.Selekzioak;
import vista.Agurra;
import vista.InterfaseNagusia;

public class Nagusia {

	public static void main(String[] args) {
		
	String nombreBase = "ethazi";//konektatuko garen datu basearen izena
	new Konexioa(nombreBase);// zer datu baserekin konectatu behar den esaten diogui
	Connection kon = Konexioa.getConexion();// Datu basearekin konexioa lortu
	InterfaseNagusia window = new InterfaseNagusia();

	Agurra agur=new Agurra(window.frame);
	window.frame.setVisible(true);// leihoa bistaragarria egiten dugu
	InterfaseNagusia.changeScene(window.frame, agur);
	
	}
}
