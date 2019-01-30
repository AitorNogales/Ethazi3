package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import controlador.Txartela;

public class Inportak {
 
	public static void igoTxartela(Txartela txar, Connection kon) {
		Statement sta = null;

		try {
			// Se crea un Statement, para realizar la consulta
			sta =kon.createStatement();
			Date data =txar.getDatak();
			
			 sta.executeUpdate("INSERT INTO billete (Cod_Billete, NTrayecto,Cod_Linea, Cod_Bus, Cod_Parada_Inicio,Cod_Parada_Fin,Fecha,Hora,DNI,Precio) "
			          +"VALUES ("+txar.getTxar_zenb()+",1, '"+txar.getLineak().getKod_linea()+"'," +txar.getAutobusak().getKod_autobus()+",'"+txar.getJatorriGeltokiak().getKod_geltoki()+"','"+txar.getHelmugaGeltokia().getKod_geltoki()+"',"+data+",00-00-00,'"+txar.getJabea().getNAN()+"',"+txar.getPrezioa()+")");
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}

}
