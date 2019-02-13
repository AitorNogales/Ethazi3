package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;

import controlador.Bezeroa;
import controlador.Txartela;

public class Inportak {
 /**
  * datu basera txartel baten datuak igotzeko metodoa
  * @param txar zein txartel
  * @param kon zein konexio erabilita
  */
	public static void igoTxartela(Txartela txar, Connection kon) {
		
		try {
			PreparedStatement statement = kon.prepareStatement("INSERT INTO `billete` (`Cod_Billete`, `NTrayecto`, `Cod_Linea`, `Cod_Bus`, `Cod_Parada_Inicio`, `Cod_Parada_Fin`, `Fecha`, `Hora`, `DNI`, `Precio`)"
					+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			statement.setInt(1, txar.getTxar_zenb());
			statement.setInt(2, txar.getBidaiKop());
			statement.setString(3, txar.getLineak().getKod_linea());
			statement.setInt(4, txar.getAutobusak().getKod_autobus());
			statement.setInt(5, txar.getJatorriGeltokiak().getKod_geltoki());
			statement.setInt(6, txar.getHelmugaGeltokia().getKod_geltoki());
			statement.setDate(7,Date.valueOf(LocalDate.now()));
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
	/**
	 * bezeroa jasota datu basera igotzen du 
	 * @param bezero zein bezero igo behart den 
	 * @param kon zen konexio erabilita
	 */
	public static void igoBezeroa (Bezeroa bezero, Connection kon) {
		try {
			PreparedStatement st = kon.prepareStatement("INSERT INTO `cliente`(`DNI`, `Nombre`, `Apellidos`, `Fecha_nac`, `Sexo`, `Contraseña`) "
					+ "VALUES( ?, ?, ?, ?, ?, MD5( ? ))");
			st.setString(1, bezero.getNAN());
			st.setString(2, bezero.getIzen());
			st.setString(3, bezero.getAbizen());
			st.setDate(4, bezero.getJaiotze_data());
			st.setString(5, bezero.getSexua());
			st.setString(6, bezero.getPasahitza());
		
			st.executeUpdate();
			st.close();
	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	

}
