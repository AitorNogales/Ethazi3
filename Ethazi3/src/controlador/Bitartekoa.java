package controlador;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Inportak;
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
	 * 
	 * @param dni bezeroaren DNIa
	 * @return existitxen bada true ez bada existitzen false
	 */
	public static boolean bezeroaExistitu(String dni) {
		boolean badago = false;
		ResultSet rs = Selekzioak.bezeroaBadago(dni, kon);// egiten dugu datu basean kontsulta bat
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
	 * bezero baten dnia eta pasahitza sartuz besero objetua bueltzatzen dizu datu basetik lortutako datuekin
	 * @param dni bezeroaren dnia
	 * @param pass beseroaren pasahitza 
	 * @return bezeroa objetua 
	 */
	public static Bezeroa artuBezeroa(String dni, String pass) {
		
		ResultSet rs = Selekzioak.kontsultaBiz(dni, pass,kon);
	
		String DNI="";
		String izena="";
		String abizena="" ;
		Date fecha =new Date(0);
		String sexo="";
		String contra="";
		try {
			rs.first();
			DNI =rs.getString(1);
			izena=rs.getString(2);
			abizena =rs.getString(3);
			fecha =rs.getDate(4);
			sexo =rs.getString(5);
			contra = rs.getString(6);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Bezeroa bezero =new Bezeroa(DNI,izena,abizena,fecha,sexo,contra);
		return bezero;
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
/**
 * 
 * @param txar igoko den txartelaren balioa
 * @return true bueltatxen du ondo ejekutatu bada false arasoak izan baditu
 */
	public static boolean inportTxartela(Txartela txar) {
		boolean  bool=true;
		
		Inportak.igoTxartela( txar, kon);
		
		return bool;
		
	}
	/**
	 * 
	 * @param txar
	 * @return
	 */
	public static boolean inportBezeroa(Bezeroa bezero) {
		boolean  bool=true;
		
		Inportak.igoBezeroa(bezero, kon);
		
		return bool;
		
	}
	/**
	 * 
	 * @return bueltatxen du txartel koderik altuena
	 */
	public static int getMaxTxartel() {
	int num=Selekzioak.maxTxartelZenb(kon);
	System.out.println(num);
	return num;
	}
}
