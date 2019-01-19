package controlador;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Konexioa;
import modelo.Selekzioak;

public class Nagusia {

	public static void main(String[] args) {
	String nombreBase = "ethazi";
	Konexioa bd = new Konexioa(nombreBase);
	Connection kon = Konexioa.getConexion();
	
	/*ResultSet rsBezeroa=Selekzioak.datuakBezeroa(kon);
	try {
		
		while(rsBezeroa.next()) {
			String DNI=rsBezeroa.getString(0);
			String Nombre=rsBezeroa.getString(1);
			String Apellido=rsBezeroa.getString(2);
			Date Fecha=rsBezeroa.getDate(3);
			String Sexo=rsBezeroa.getString(4);
			System.out.println(DNI+Nombre+Apellido+Fecha+Sexo);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	}
}
