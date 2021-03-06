package controlador;

import java.util.ArrayList;


/**
 * zenbait metodo statiko kalkiluak egiteko
 * @author Aitor 
 */
public class Metodoak {
	/**
	 * bidaiaren datuak emanda zenbat balioko duen tiketa buelktatzen du
	 * @param jatorriGelt  jatorri geltokia 
	 * @param helmugaGelt helmuga geltokia 
	 * @param auto zein autobus erabuliko den bidaia egiteko 
	 * @param lineakoGelt lineako geltokiak ordenaturik distantziaren arabera 
	 * @return zenbat diru kostatzen duen jatorri geltokitk helmuga geltokiraino joatea
	 */
	public static double kalkulatuPrezioa(Geltokia jatorriGelt, Geltokia helmugaGelt, Autobusa auto,
			ArrayList<Geltokia> lineakoGelt) {
		double diru = 0, dist = 0;
		int a, b;
		a = lineakoGelt.indexOf(jatorriGelt);// jatorriko linearen posisioa
		b = lineakoGelt.indexOf(helmugaGelt);// helmuga geltokiaren posisio
		while (a != b) {

			dist += lineakoGelt.get(a).geltokiArtekoDistantzia(lineakoGelt.get(b));
			a++;
			if (a >= lineakoGelt.size()) {
				a = 0;
			}

		}

		diru = dist * auto.getErregai_Km() * auto.getFuelarenPresioa() * 1.2 / auto.getEserleku_kop();

		return diru;
	}

	/**
	 * diru kantitate bat emanda txanpon eta billete kantitate txikiena buetatxen du String bezala
	 * @param Money diru kantitatea sartzen diogu
	 * @return itzultzen digu zartutako dirua zenbat txanpon eta billete textu
	 *         moduan
	 */
	public static String itzuliakKalkulatu(double Money) {
		// euroko txanponen valio posible gustien arraya
		double[] txanpon = { 500, 200, 100, 50, 20, 10, 5, 2, 1, 0.5, 0.20, 0.10, 0.05, 0.02, 0.01 };
		String zerrenda = ""; // zerrendak gordeko du zenbat mota bakoitzeko tzanpon daunden

		// array honek gordeko du txanpon mota bakoitxaren kantitatea
		double[] Itzuliak = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

		// txanpon mota bakouitxa konparaatzen dugu
		for (int i = 0; i < txanpon.length; i++) {
			// dirua txanponaren balioa baino handiagoa da
			if (Money >= txanpon[i]) {
				// txanpon horren kantitatea
				Itzuliak[i] = Math.floor(Money / txanpon[i]);

				// diruaren balioa aldatzen dugu
				Money -= (Itzuliak[i] * txanpon[i]);
			}
		}

		// string a gordetzen dugu
		for (int i = 0; i < txanpon.length; i++) {
			if (Itzuliak[i] > 0) {
				if (txanpon[i] > 2)// billeteak etatxanen arteco ezberdintasuna
				{
					// billetea da
					zerrenda += (+Itzuliak[i] + "x" + txanpon[i] + " euroko billete\n");
				} else {
					// txanpona da
					zerrenda += (Itzuliak[i] + "x" + txanpon[i] + " euroko txanpon\n ");
				}
			}
		}
		return zerrenda;// itzulien textu zerrenda bueltatu
	}
	/**
	 * balio hamartar baten biribilketa egiten du nahi bezte zenbaki hamartarrekin 
	 * @param num hasiaerako double balioa
	 * @param cant hamartar zenbaki kopurua
	 * @return hasierako zenbakia hamartar zenbaki kopuruarekin biribilduta
	 */
	public static double redondearDecimales(double num, int cant ) {
		double a =Math.pow(10, cant);
		num=(double)Math.round(num * a) / a;
		return num;
	}
}
