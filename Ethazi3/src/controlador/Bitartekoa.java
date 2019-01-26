package controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Konexioa;
import modelo.Selekzioak;

/**
 * 
 * @author Aitor
 * vista eta modeloaren arteko metodoak
 */
public class Bitartekoa {
	public final static String bdIzena = "ethazi";// konektatuko garen datu basearen izena
	public final static Connection kon = Konexioa.getConexion();// Datu basearekin konexioa lortu

	/**
	 * konprobatzen du erabiltzailea datu basean dagoela
	 * 
	 * @param dni  erabiltzailearen dnia
	 * @param pass erabiltzailearen pasahitza
	 * @return existitxen bada true ez bada existitzen false
	 */
	public static boolean ceckBezeroa(String dni, String pass) {
		boolean badago = false;
		ResultSet rs = Selekzioak.kontsultaBiz(dni, pass, kon);// egiten dugu datu basean kontsulta bat
		try {
			if (rs.next()) {// zerbait bueltatzen badu erabiltzailea existitzen da
				badago = true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return badago;
	}
/**
 * linea gustiak hartzko resulseta bidaltzen diote modelotik result set horretatik linea objetuaen array lista egin eta bueltazen du
 * @return linea gustiak dauzkan array lista
 */
	public static ArrayList<Linea> artuLieneak() {
		ArrayList<Linea> Lineak = new ArrayList<Linea>();
		ResultSet rs = Selekzioak.datuakLineak(kon);// datu basetik hartzen ditugu linea guztien datuak
		try {
			rs.beforeFirst();
			while (rs.next()) {
				String kodLinea = rs.getObject(1).toString();
				String izLinea = rs.getObject(2).toString();
				Linea lin = new Linea(kodLinea, izLinea);
				Lineak.add(lin);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return Lineak;

	}

	/**
	 * linea bat emanda linea horretan dauden geltokien lista itzultzen du
	 * 
	 * @param kod_Linea autatutako linea
	 * @return autatutako linean dauden geltokien lista
	 */
	public static ArrayList<Geltokia> linearenGeltokiak(String kod_Linea) {
		ArrayList<Geltokia> Geltokiak = new ArrayList<Geltokia>();
		ResultSet rs = Selekzioak.datuakGeltokiak(kon, kod_Linea);// datu basetik hartzen ditugu linea guztien datuak
		try {
			rs.beforeFirst();
			while (rs.next()) {
				int kodGeltoki = rs.getInt(1);
				String izGeltoki = rs.getString(2);
				String kalea = rs.getString(3);
				double latitudea = rs.getDouble(4);
				double longitudea = rs.getDouble(5);

				Geltokia gel = new Geltokia(kodGeltoki, izGeltoki, kalea, latitudea, longitudea);// emandako datuekin
																									// geltoki objetua
																									// sortzen du
				Geltokiak.add(gel);// geltoki objetua listare gehitzen diogu

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return Geltokiak;
	}

	/**
	 * linea bat emanda linea horretan dauden geltokien lista itzultzen du
	 * 
	 * @param kod_Linea autatutako linea
	 * @return autatutako linean dauden geltokien lista
	 */
	public static ArrayList<Autobusa> linearenAutobusak(String kod_Linea) {
		ArrayList<Autobusa> Autobusak = new ArrayList<Autobusa>();
		ResultSet rs = Selekzioak.datuakLineaAutobusa(kon, kod_Linea);// datu basetik hartzen ditugu lineak dauzkan
																		// autobusak
		try {
			rs.beforeFirst();
			while (rs.next()) {
				int kodAutobus = rs.getInt(1);
				int n_plaz = rs.getInt(2);
				double konsumo = rs.getDouble(3);
				String kolore = rs.getString(4);

				Autobusa gel = new Autobusa(kodAutobus, n_plaz, konsumo, kolore);// emandako datuekin objetua sortzen du
				Autobusak.add(gel);// geltoki objetua listare gehitzen diogu

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return Autobusak;
	}

	
}
