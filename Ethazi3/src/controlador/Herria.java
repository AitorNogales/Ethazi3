package controlador;

import java.util.ArrayList;

public class Herria {
	private int PK ;
	private String Izena;
	private ArrayList<Geltokia>Geltokiak;
	
/////////Builders/////////////
	public Herria(int pK, String izena) {
		
		PK = pK;
		Izena = izena;
		Geltokiak = new ArrayList<Geltokia>();
	}
/////////Getters && Setters//////////

	public int getPK() {
		return PK;
	}

	public void setPK(int pK) {
		PK = pK;
	}

	public String getIzena() {
		return Izena;
	}

	public void setIzena(String izena) {
		Izena = izena;
	}

	public ArrayList<Geltokia> getGeltokiak() {
		return Geltokiak;
	}

	public void setGeltokiak(ArrayList<Geltokia> geltokiak) {
		Geltokiak = geltokiak;
	}
	//////Methods///////////////////////
	
	public void addGeltoki(Geltokia g) {
		Geltokiak.add(g);
	}
	
	public void removeGeltoki(Geltokia g) {
		Geltokiak.remove(g);
		
	}
	public void removeGeltoki(int g) {
		Geltokiak.remove(g);
		
	}
	
	
}
