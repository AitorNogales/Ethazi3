package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Seleksioak {
	
	public static Statement datuakBezeroa(Connection kon) {
		Statement sta=null;
		//Connection kon=konexioa.getConexion();
		try {
		// Se crea un Statement, para realizar la consulta
        sta = kon.createStatement();
        
        // Se realiza la consulta. Los resultados se guardan en el ResultSet rs
        
        ResultSet rs = sta.executeQuery("select * from cliente");
        
        // Se recorre el ResultSet, mostrando por pantalla los resultados.
        while (rs.next()) {
            System.out.println(rs.getString(1) + "\t\t " + rs.getString(2));
        }
		}catch(Exception e) {e.getMessage();}
		
		
		return sta;
	}
}
