package controlador;
/**
 * 
 * @author Aitor
 *zenbait metodo statiko kalkiluak egiteko
 */
public class Metodoak {
	/**
	 * bidaiaren datuak emanda zenbat balioko duen tiketa buelktatzen du
	 * @param jatorriGelt bidiaraan jatorrisko geltokia
	 * @param helmugaGelt bidaiaren helmuga geltokia
	 * @param auto zein autobuzean egingo da bidaia
	 * @return zenbatekoa izango da bidaiaren prezioa
	 */
public static double kalkulatuPresioa(Geltokia jatorriGelt  ,Geltokia helmugaGelt, Autobusa auto) {
		double diru=0,dist;
		dist= jatorriGelt.geltokiArtekoDistantzia(helmugaGelt);
		
		 diru=dist/auto.getErregai_Km()/auto.getFuelarenPresioa()*1.2/auto.getEserleku_kop();
		
		
		return diru;
	}

/**
 * 
 * @param Money diru kantitatea sartzen diogu
 * @return itzultzen digu zartutako dirua zenbat txanpon eta billete textu moduan
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
}
