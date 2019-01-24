package controlador;

public class Geltokia implements Comparable<Geltokia> {
	private static final double terLat = 43.261111, termLong = -2.949722;

	private int kod_geltoki;
	private String kalea, gel_izena;
	private double latitudea, longitudea, disTerm;

	///////// Builders/////////////
	public Geltokia(int kod_geltoki, String kalea, String gel_izena, double latitudea, double longitudea) {

		this.kod_geltoki = kod_geltoki;
		this.kalea = kalea;
		this.gel_izena = gel_izena;
		this.latitudea = latitudea;
		this.longitudea = longitudea;
		this.disTerm = distantziaKalkulatu();
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

	public double getDisTerm() {
		return disTerm;
	}

	public void setLongitudea(double longitudea) {
		this.longitudea = longitudea;
	}

	///////////////////// Methods/////////////////
	private double distantziaKalkulatu() {
		double lurrarenRadioa = 6371;// kilometrotan Lurraren radioa
		double dLat = Math.toRadians(terLat - latitudea); //
		double dLng = Math.toRadians(termLong - longitudea);
		double sindLat = Math.sin(dLat / 2);
		double sindLng = Math.sin(dLng / 2);
		double va1 = Math.pow(sindLat, 2)
				+ Math.pow(sindLng, 2) * Math.cos(Math.toRadians(terLat)) * Math.cos(Math.toRadians(latitudea));
		double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
		double distancia = lurrarenRadioa * va2;

		return distancia;
	}
	
	public double geltokiArtekoDistantzia(Geltokia gel) {
		
		double lurrarenRadioa = 6371;// kilometrotan Lurraren radioa
		double dLat = Math.toRadians(this.latitudea - gel.latitudea); 
		double dLng = Math.toRadians(this.longitudea - gel.longitudea);
		double sindLat = Math.sin(dLat / 2);
		double sindLng = Math.sin(dLng / 2);
		double va1 = Math.pow(sindLat, 2)
				+ Math.pow(sindLng, 2) * Math.cos(Math.toRadians(this.latitudea)) * Math.cos(Math.toRadians(gel.latitudea));
		double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
		double distancia = lurrarenRadioa * va2;

		return distancia;
	}
	@Override
	public String toString() {
		return kod_geltoki + "-" + kalea;
	}

	
	
	@Override
	 public int compareTo(Geltokia o) {
         if (disTerm < o.disTerm) {
             return -1;
         }
         if (disTerm > o.disTerm) {
             return 1;
         }
         return 0;
     }
}
