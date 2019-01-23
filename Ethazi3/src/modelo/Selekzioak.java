package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Selekzioak {

	public static ResultSet datuakBezeroa(String bdIzena) {
		Statement sta = null;
		ResultSet rs = null;
Connection kon =Konexioa.getConexion();
		try {
			// Se crea un Statement, para realizar la consulta
			sta = kon.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs

			rs = sta.executeQuery("select * from cliente");

			// Se recorre el ResultSet, mostrando por pantalla los resultados.
			while (rs.next()) {
				System.out.println(rs.getString(1) + "\t\t " + rs.getString(2));
			}
		} catch (Exception e) {
			e.getMessage();
		}

		return rs;
	}

	public static ResultSet datuakLineak(Connection kon, String bdIzena) {
		Statement sta = null;
		ResultSet rs = null;

		try {
			// Se crea un Statement, para realizar la consulta
			sta = kon.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs

			rs = sta.executeQuery("select * from " + bdIzena + ".linea");

			// Se recorre el ResultSet, mostrando por pantalla los resultados.
			while (rs.next()) {
				System.out.println(rs.getString(1) + "\t\t " + rs.getString(2));
			}
		} catch (Exception e) {
			e.getMessage();
		}

		return rs;
	}
	public static ResultSet datuakAutobusak(Connection kon, String bdIzena) {
		Statement sta = null;
		ResultSet rs = null;

		try {
			// Se crea un Statement, para realizar la consulta
			sta = kon.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs

			rs = sta.executeQuery("select * from " + bdIzena + ".autobus");

			// Se recorre el ResultSet, mostrando por pantalla los resultados.
			while (rs.next()) {
				System.out.println(rs.getString(1) + "\t\t " + rs.getString(2));
			}
		} catch (Exception e) {
			e.getMessage();
		}

		return rs;
	}

	public static ResultSet datuakGeltokiak(Connection kon, String bdIzena, String kod_Linea) {
		Statement sta = null;
		ResultSet rs = null;

		try {
			// Se crea un Statement, para realizar la consulta
			sta = kon.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs

			rs = sta.executeQuery("select * from parada where Cod_Parada in (select Cod_Parada from linea_parada where Cod_Linea like ('L1')");
			
// Se recorre el ResultSet, mostrando por pantalla los resultados.
			while (rs.next()) {
				System.out.println(rs.getString(1) + "\t\t " + rs.getString(2));
			}
		} catch (Exception e) {
			e.getMessage();
		}

		return rs;
	}
	public static ResultSet kontsultaBiz(String dni,String pass, String bdIzena ,Connection kon) {
		ResultSet rs = null;
		
		Statement sta = null;
		
		try {
			// Se crea un Statement, para realizar la consulta
			sta = kon.createStatement();
			rs = sta.executeQuery("select * from " + bdIzena + ".cliente where DNI LIKE("+dni+") AND Contraseña LIKE ("+pass+");");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rs;
	}
}
