package controlador;

import java.sql.Connection;
import java.sql.Statement;

import modelo.Seleksioak;
import modelo.konexioa;

public class nagusia {

	public static void main(String[] args) {
	String nombreBase = "ethazi";
	konexioa bd = new konexioa(nombreBase);
	Connection kon = konexioa.getConexion();
	Statement st=Seleksioak.datuakBezeroa(kon);
	}
}
