package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Selekzioak {
	
	public static ResultSet datuakBezeroa(Connection kon) {
		Statement sta=null;
		 ResultSet rs =null;
		//Connection kon=konexioa.getConexion();
		try {
		// Se crea un Statement, para realizar la consulta
        sta = kon.createStatement();
        
        // Se realiza la consulta. Los resultados se guardan en el ResultSet rs
        
         rs = sta.executeQuery("SELECT * FROM `cliente`");
        
        // Se recorre el ResultSet, mostrando por pantalla los resultados.
        while (rs.next()) {
            System.out.println(rs.getString(1) + "\t\t " + rs.getString(2));
        }
		}catch(Exception e) {e.getMessage();}
		
		
		return rs;
	}
}
