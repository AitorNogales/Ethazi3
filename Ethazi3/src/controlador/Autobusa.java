package controlador;

public class Autobusa {
	private final double fuelarenPresioa = 0.8;

	private int kod_autobus, eserleku_kop;
	private double erregai_Km;
	private String kolorea;

	///////// Builders/////////////
	/**
	 * Autobus objetua sortzeco
	 * 
	 * @param kod_autobus
	 *            autobusaren kodea
	 * @param eserleku_kop
	 *            autobusak dauzkan eserleku kopurua
	 * @param erregai_Km
	 *            zenbat erregai konsumitzen duen kilometroko
	 * @param kolorea
	 *            zein kolorekoa den autobusa
	 */
	public Autobusa(int kod_autobus, int eserleku_kop, double erregai_Km, String kolorea) {

		this.kod_autobus = kod_autobus;
		this.eserleku_kop = eserleku_kop;
		this.erregai_Km = erregai_Km;
		this.kolorea = kolorea;
	}

	///////// Getters && Setters//////////
	public int getKod_autobus() {
		return kod_autobus;
	}

	public void setKod_autobus(int kod_autobus) {
		this.kod_autobus = kod_autobus;
	}

	public int getEserleku_kop() {
		return eserleku_kop;
	}

	public void setEserleku_kop(int eserleku_kop) {
		this.eserleku_kop = eserleku_kop;
	}

	public double getErregai_Km() {
		return erregai_Km;
	}

	public void setErregai_Km(double erregai_Km) {
		this.erregai_Km = erregai_Km;
	}

	public String getKolorea() {
		return kolorea;
	}

	public void setKolorea(String kolorea) {
		this.kolorea = kolorea;
	}

	public double getFuelarenPresioa() {
		return fuelarenPresioa;
	}
	/////////// Methods///////////////////

	@Override
	public String toString() {
		return kod_autobus + "-" + kolorea;
	}

}
