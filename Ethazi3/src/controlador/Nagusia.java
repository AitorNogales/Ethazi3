package controlador;

import modelo.Konexioa;
import vista.Agurra;
import vista.InterfaseNagusia;

public class Nagusia {

	public static void main(String[] args) {
	new Konexioa(Bitartekoa.bdIzena);// zer datu baserekin konectatu behar den esaten diogui
	
	InterfaseNagusia window = new InterfaseNagusia();

	Agurra agur=new Agurra(window.frame);
	window.frame.setVisible(true);// leihoa bistaragarria egiten dugu
	InterfaseNagusia.changeScene(window.frame, agur);
	
	}
}
