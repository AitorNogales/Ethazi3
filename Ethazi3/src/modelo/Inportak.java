package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;

import controlador.Txartela;

public class Inportak {
 
	public static void igoTxartela(Txartela txar, Connection kon) {
		

		try {
			PreparedStatement statement = kon.prepareStatement("INSERT INTO `billete` (`Cod_Billete`, `NTrayecto`, `Cod_Linea`, `Cod_Bus`, `Cod_Parada_Inicio`, `Cod_Parada_Fin`, `Fecha`, `Hora`, `DNI`, `Precio`)"
					+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			statement.setInt(1, txar.getTxar_zenb());
			statement.setInt(2, 1);
			statement.setString(3, txar.getLineak().getKod_linea());
			statement.setInt(4, txar.getAutobusak().getKod_autobus());
			statement.setInt(5, txar.getJatorriGeltokiak().getKod_geltoki());
			statement.setInt(6, txar.getHelmugaGeltokia().getKod_geltoki());
			statement.setDate(7,txar.getDatak());
			statement.setTimestamp(8,new Timestamp(System.currentTimeMillis()));
			statement.setString(9, txar.getJabea().getNAN());
			statement.setDouble(10, txar.getPrezioa());
			
			// execute the preparedstatement insert
		    statement.executeUpdate();
		    statement.close();
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}

}
