package controlador;

public class Geltokia {
	private int  kod_geltoki;
	private String kalea,gel_izena;
	private double latitudea,longitudea;
	
/////////Builders/////////////
	public Geltokia(int kod_geltoki, String kalea, String gel_izena, double latitudea, double longitudea) {
		
		this.kod_geltoki = kod_geltoki;
		this.kalea = kalea;
		this.gel_izena = gel_izena;
		this.latitudea = latitudea;
		this.longitudea = longitudea;
	}
/////////Getters && Setters//////////
	public int getKod_geltoki() {
		return kod_geltoki;
	}


	public void setKod_geltoki(int kod_geltoki) {
		this.kod_geltoki = kod_geltoki;
	}


	public String getKalea() {
		return kalea;
	}


	public void setKalea(String kalea) {
		this.kalea = kalea;
	}


	public String getGel_izena() {
		return gel_izena;
	}


	public void setGel_izena(String gel_izena) {
		this.gel_izena = gel_izena;
	}


	public double getLatitudea() {
		return latitudea;
	}


	public void setLatitudea(double latitudea) {
		this.latitudea = latitudea;
	}


	public double getLongitudea() {
		return longitudea;
	}


	public void setLongitudea(double longitudea) {
		this.longitudea = longitudea;
	}


	
	

}
