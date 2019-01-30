package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Selekzioak {

	public static ResultSet datuakBezeroa() {
		Statement sta = null;
		ResultSet rs = null;
		Connection kon = Konexioa.getConexion();
		try {
			// Se crea un Statement, para realizar la consulta
			sta = kon.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs

			rs = sta.executeQuery("select * from cliente");

			// Se recorre el ResultSet, mostrando por pantalla los resultados.
			while (rs.next()) {
				System.out.println(rs.getString(1) + "\t\t " + rs.getString(2) + "\t\t " + rs.getString(3) + "\t\t "
						+ rs.getString(4) + "\t\t " + rs.getString(5) + "\t\t " + rs.getString(6));
			}
		} catch (Exception e) {
			e.getMessage();
		}

		return rs;
	}

	public static ResultSet datuakLineak(Connection kon) {
		Statement sta = null;
		ResultSet rs = null;

		try {
			// Se crea un Statement, para realizar la consulta
			sta = kon.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs

			rs = sta.executeQuery("select * from linea");
			/*while (rs.next()) {
				System.out.println(rs.getString(1) + "\t\t " + rs.getString(2));
			}*/
			
		} catch (Exception e) {
			e.getMessage();
		}

		return rs;
	}

	

	public static ResultSet datuakGeltokiak(Connection kon, String kod_Linea) {
		Statement sta = null;
		ResultSet rs = null;

		try {
			// Se crea un Statement, para realizar la consulta
			sta = kon.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs

			rs = sta.executeQuery(
					"select * from parada where Cod_Parada in (select Cod_Parada from linea_parada where Cod_Linea like '"
							+ kod_Linea + "') ");
			

			// Se recorre el ResultSet, mostrando por pantalla los resultados.
			while (rs.next()) {
				System.out.println(rs.getString(1) + "\t\t " + rs.getString(2));
			}
		} catch (Exception e) {
			e.getMessage();
		}

		return rs;
	}
	/**
	 * 
	 * @param kon la conexion en la que buscamos 
	 * @param kod_Linea linea a la que pertenece el autobus
	 * @return result set de autobus
	 */
	public static ResultSet datuakLineaAutobusa(Connection kon, String kod_Linea) {
		Statement sta = null;
		ResultSet rs = null;

		try {
			// Se crea un Statement, para realizar la consulta
			sta = kon.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs

			rs = sta.executeQuery("select * from autobus where Cod_bus in (select Cod_bus from linea_autobus where Cod_linea like '"+ kod_Linea +"')");
			

			// Se recorre el ResultSet, mostrando por pantalla los resultados.
			while (rs.next()) {
				System.out.println(rs.getString(1) + "\t\t " + rs.getString(2));
			}
		} catch (Exception e) {
			e.getMessage();
		}

		return rs;
	}
	

	public static int maxTxartelZenb(Connection kon) {
		int num=0;
		Statement sta = null;
		ResultSet rs = null;

		try {
			// Se crea un Statement, para realizar la consulta
			sta = kon.createStatement();
			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs
			rs = sta.executeQuery("select MAX(Cod_Billete) from billete ");
			rs.first();
			num=rs.getInt(1);
		} catch (Exception e) {
			e.getMessage();
		}
		
		return num;
	}
	
	public static ResultSet kontsultaBiz(String dni, String pass, Connection kon) {
		ResultSet rs = null;

		Statement sta = null;

		try {
			// Se crea un Statement, para realizar la consulta
			sta = kon.createStatement();
			rs = sta.executeQuery("select * from cliente where DNI LIKE '" + dni + "' AND Contraseña LIKE  MD5('" + pass + "')");
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return rs;
	}
}
