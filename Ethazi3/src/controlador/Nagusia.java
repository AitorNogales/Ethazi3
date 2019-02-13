package controlador;

import modelo.Konexioa;
import modelo.Selekzioak;
import vista.Agurra;
import vista.InterfaseNagusia;

public class Nagusia {
/**
 * Programaren metodo nagusia leihoa srtzen du eta datu basea ¡rekin konektatzen da 
 * @param args string array bat ez da erabiltzen programa honetan 
 */
	public static void main(String[] args) {
		
		new Konexioa(Bitartekoa.bdIzena);// zer datu baserekin konectatu behar den esaten diogui
		Selekzioak.datuakBezeroa();//bezero guztien datuak pantilaratzen ditu 
		InterfaseNagusia window = new InterfaseNagusia();
		Agurra agur = new Agurra(window.frame);
		InterfaseNagusia.changeScene(window.frame, agur);
		window.frame.setVisible(true);// leihoa bistaragarria egiten dugu

	}
}
