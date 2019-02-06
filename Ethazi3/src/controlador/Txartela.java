package controlador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Date;
import java.util.ArrayList;

public class Txartela {
	private int txar_zenb;
	private static int currentTxartela = Bitartekoa.getMaxTxartel();
	private Date Datak, Etorrera_Data;
	

	private Autobusa Autobusak;
	private Geltokia JatorriGeltokiak;
	private Geltokia HelmugaGeltokia;
	private Linea Lineak;
	private Bezeroa Jabea;
	private double prezioa;
	private int bidaiKop=1;

////////////Builders///////////////

	public Txartela(Date datak, Autobusa autobusak, Geltokia jatorrigeltokiak, Geltokia helmugageltokia, Linea lineak,
			Bezeroa jabea) {

		Datak = datak;
		Autobusak = autobusak;
		JatorriGeltokiak = jatorrigeltokiak;
		HelmugaGeltokia = helmugageltokia;
		Lineak = lineak;
		Jabea = jabea;
		currentTxartela++;//asignasio automatiko
		txar_zenb = currentTxartela;
	}

	

	public Txartela() {

		currentTxartela++;//asignasio automatiko
		txar_zenb = currentTxartela;

	}

	

//////////////Getters && Setters/////////////////
	public Date getEtorrera_Data() {
		return Etorrera_Data;
	}

	public void setEtorrera_Data(Date etorrera_Data) {
		Etorrera_Data = etorrera_Data;
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
	public double getPrezioa() {
		return prezioa;
	}

	public void setPrezioa(double prezioa) {
		this.prezioa = prezioa;
	}
	public int getBidaiKop() {
		return bidaiKop;
	}

	public void setBidaiKop(int bidaiKop) {
		this.bidaiKop = bidaiKop;
	}
	
	////////////// Methods/////////////////

	// txartel honek dauzkan datuekin .txt fitxero bat sortzen du
	public void printTxartela() {
		 String ruta = "src\\txartelenfitxategiak\\txartela" + txar_zenb+".txt";
		//String ruta = "txartela" + txar_zenb + ".txt";
		try {
			File archivo = new File(ruta);
			
			BufferedWriter bw = null;

			// fitxategia berridazten du existitxen bada
			bw = new BufferedWriter((new OutputStreamWriter(new FileOutputStream(archivo), "UTF-8")));
			ArrayList<String >texto=this.subdividedString();
			for(String li:texto) {
			bw.write(li + "\n");
			bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<String> subdividedString(){
		ArrayList<String >texto=new ArrayList<String>();
		texto.add("Txartela");
		texto.add("txartel Zenbakia: " + txar_zenb);
		if (Etorrera_Data != null) {
		texto.add("Data: " + Datak.toString() + " Etorrera Data:"+ Etorrera_Data.toString());
		}else{
			texto.add("Data: " + Datak.toString());
		}
		texto.add("Autobusak: "+ Autobusak.getKod_autobus());
		texto.add("JatorriGeltokia: " + JatorriGeltokiak.toString());
		texto.add("HelmugaGeltokia: " + HelmugaGeltokia.toString() );
		texto.add("Lineak: " + Lineak.toString() + " Jabea:"+ Jabea.getNAN() + "\t prezioa: " + prezioa + "€");
		return texto;
	}

	@Override
	public String toString() {
		
		String stringa="Txartela \n txartel Zenbakia: " + txar_zenb + "\n Datak: " + Datak.toString()+"\n Autobusak: "
				+ Autobusak.getKod_autobus() + "\n JatorriGeltokiak: " + JatorriGeltokiak.toString()
				+ "\n HelmugaGeltokia: " + HelmugaGeltokia.toString() + "\n Lineak: " + Lineak.toString() + " Jabea:"
				+ Jabea.getNAN() + "\t prezioa: " + prezioa + "€";
		if (Etorrera_Data != null){
			stringa="Txartela \n txartel Zenbakia: " + txar_zenb + "\n Datak: " + Datak.toString() + " Etorrera Data:"+ Etorrera_Data.toString()+"\n Autobusak: "
					+ Autobusak.getKod_autobus() + "\n JatorriGeltokiak: " + JatorriGeltokiak.toString()
					+ "\n HelmugaGeltokia: " + HelmugaGeltokia.toString() + "\n Lineak: " + Lineak.toString() + " Jabea:"
					+ Jabea.getNAN() + "\t prezioa: " + prezioa + "€";
		
		}
		
		
		return stringa;
	}


}
