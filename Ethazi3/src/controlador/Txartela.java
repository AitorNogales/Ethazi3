package controlador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;

public class Txartela {
	private int txar_zenb;
	private static int currentTxartela = 0;
	private Date Datak;
	private Autobusa Autobusak;
	private Geltokia JatorriGeltokiak;
	private Geltokia HelmugaGeltokia;
	private Linea Lineak;
	private Bezeroa Jabea;
	private double prezioa;

////////////Builders///////////////

	public Txartela(Date datak, Autobusa autobusak, Geltokia jatorrigeltokiak, Geltokia helmugageltokia, Linea lineak,
			Bezeroa jabea) {

		Datak = datak;
		Autobusak = autobusak;
		JatorriGeltokiak = jatorrigeltokiak;
		HelmugaGeltokia = helmugageltokia;
		Lineak = lineak;
		Jabea = jabea;
		currentTxartela++;
		txar_zenb = currentTxartela;
	}

	public Txartela() {

		currentTxartela++;
		txar_zenb = currentTxartela;

	}

	public int getTxar_zenb() {
		return txar_zenb;
	}

	public void setTxar_zenb(int txar_zenb) {
		this.txar_zenb = txar_zenb;
	}

	public Geltokia getJatorriGeltokiak() {
		return JatorriGeltokiak;
	}

	public void setJatorriGeltokiak(Geltokia jatorriGeltokiak) {
		JatorriGeltokiak = jatorriGeltokiak;
	}

	public Geltokia getHelmugaGeltokia() {
		return HelmugaGeltokia;
	}

	public void setHelmugaGeltokia(Geltokia helmugaGeltokia) {
		HelmugaGeltokia = helmugaGeltokia;
	}

	public double getPrezioa() {
		return prezioa;
	}

	public void setPrezioa(double prezioa) {
		this.prezioa = prezioa;
	}

	public Txartela(int char_zenb, Bezeroa jabea) {

		this.txar_zenb = char_zenb;

		Jabea = jabea;
	}

//////////////Getters && Setters/////////////////
	public int getChar_zenb() {
		return txar_zenb;
	}

	public void setChar_zenb(int char_zenb) {
		this.txar_zenb = char_zenb;
	}

	public Date getDatak() {
		return Datak;
	}

	public void setDatak(Date datak) {
		Datak = datak;
	}

	public Autobusa getAutobusak() {
		return Autobusak;
	}

	public void setAutobusak(Autobusa autobusak) {
		Autobusak = autobusak;
	}

	public Linea getLineak() {
		return Lineak;
	}

	public void setLineak(Linea lineak) {
		Lineak = lineak;
	}

	public Bezeroa getJabea() {
		return Jabea;
	}

	public void setJabea(Bezeroa jabea) {
		Jabea = jabea;
	}

	////////////// Methods/////////////////

	// txartel honek dauzkan datuekin .txt fitxero bat sortzen du
	public void printTxartela() {
		String ruta = "/src/txartelenfitxategiak/Txartela" + txar_zenb;
		try {
			File archivo = new File(ruta);
			BufferedWriter bw = null;

			// fitxategia berridazten du existitxen bada
			bw = new BufferedWriter(new FileWriter(archivo));
			bw.write("El fichero de texto ya estaba creado.");

			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Txartela \n txartel Zenbakia: " + txar_zenb + "\n Datak: " + Datak.toString() + "\n Autobusak: "
				+ Autobusak.getKod_autobus() + "\n JatorriGeltokiak: " + JatorriGeltokiak.toString()
				+ "\n HelmugaGeltokia: " + HelmugaGeltokia.toString() + "\n Lineak: " + Lineak.toString() + " Jabea:"
				+ Jabea.getNAN() + "\t prezioa: " + prezioa + "€";
	}

}
