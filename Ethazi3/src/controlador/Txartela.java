package controlador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

public class Txartela {
	private int txar_zenb;
	private ArrayList<Date> Datak;
	private ArrayList<Autobusa> Autobusak;
	private ArrayList<Geltokia> Geltokiak;
	private ArrayList<Linea> Lineak;
	private Bezeroa Jabea;

////////////Builders///////////////

	public Txartela(int char_zenb, ArrayList<Date> datak, ArrayList<Autobusa> autobusak, ArrayList<Geltokia> geltokiak,
			ArrayList<Linea> lineak, Bezeroa jabea) {

		this.txar_zenb = char_zenb;
		Datak = datak;
		Autobusak = autobusak;
		Geltokiak = geltokiak;
		Lineak = lineak;
		Jabea = jabea;
	}

	public Txartela(int char_zenb, Bezeroa jabea) {

		this.txar_zenb = char_zenb;
		Datak = new ArrayList<Date>();
		Autobusak = new ArrayList<Autobusa>();
		Geltokiak = new ArrayList<Geltokia>();
		Lineak = new ArrayList<Linea>();
		Jabea = jabea;
	}

//////////////Getters && Setters/////////////////
	public int getChar_zenb() {
		return txar_zenb;
	}

	public void setChar_zenb(int char_zenb) {
		this.txar_zenb = char_zenb;
	}

	public ArrayList<Date> getDatak() {
		return Datak;
	}

	public void setDatak(ArrayList<Date> datak) {
		Datak = datak;
	}

	public ArrayList<Autobusa> getAutobusak() {
		return Autobusak;
	}

	public void setAutobusak(ArrayList<Autobusa> autobusak) {
		Autobusak = autobusak;
	}

	public ArrayList<Geltokia> getGeltokial() {
		return Geltokiak;
	}

	public void setGeltokial(ArrayList<Geltokia> geltokial) {
		Geltokiak = geltokial;
	}

	public ArrayList<Linea> getLineak() {
		return Lineak;
	}

	public void setLineak(ArrayList<Linea> lineak) {
		Lineak = lineak;
	}

	public Bezeroa getJabea() {
		return Jabea;
	}

	public void setJabea(Bezeroa jabea) {
		Jabea = jabea;
	}
	////////////////Methods///////////////////
	
	//*****geltokiak kudeatzeko metodoak******
	public void addGeltoki(Geltokia g) {
		Geltokiak.add(g);
	}
	
	public void removeGeltoki(Geltokia g) {
		Geltokiak.remove(g);
		
	}
	public void removeGeltoki(int g) {
		Geltokiak.remove(g);
		
	}
	//*****autobusak kudeatzeko metodoak******
	public void addAutobusa(Autobusa au) {
		Autobusak.add(au);
	}

	public void removeAutobusa(Autobusa au) {
		Autobusak.remove(au);
		
	}
	public void removeAutobusa(int a) {
		Autobusak.remove(a);
		
	}
	//*****Lineak kudeatzeko metodoak******
	public void addLinea(Linea au) {
		Lineak.add(au);
	}

	public void removeLinea(Linea au) {
		Lineak.remove(au);
		
	}
	public void removeLinea(int a) {
		Lineak.remove(a);
	}
	//*****Datak kudeatzeko metodoak******
	public void addData(Date au) {
		Datak.add(au);
	}

	public void removeData(Date au) {
		Datak.remove(au);
		
	}
	public void removeData(int a) {
		Datak.remove(a);
	}
	//txartel honek dauzkan datuekin .txt fitxero bat sortzen du 
	public void printTxartela() {
		String ruta = "/src/txartelenfitxategiak/Txartela"+txar_zenb;
		try {
		File archivo = new File(ruta);
		BufferedWriter bw=null;
		if(archivo.exists()) {
		      // fitxategia berridazten du existitxen bada
			 bw = new BufferedWriter(new FileWriter(archivo));
			 bw.write("El fichero de texto ya estaba creado.");
		} else {
		      // fitxategia zortu eta idazten du
			 bw = new BufferedWriter(new FileWriter(archivo));
			 bw.write("Acabo de crear el fichero de texto.");
		}
		
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
