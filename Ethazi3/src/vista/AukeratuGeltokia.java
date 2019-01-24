package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import controlador.Bitartekoa;
import controlador.Geltokia;

public class AukeratuGeltokia extends JPanel {

	private JButton btnJarraitu;
	private JLabel lblNewLabel;

	/**
	 * Create the panel.
	 * 
	 * @param      window, String kodLinea zein da interfaseak erabiliko duen lehioa
	 * @param zein lineako geltokiak agertuko diren panelean
	 */
	public AukeratuGeltokia(JFrame window, String kodLinea) {

		ArrayList<Geltokia> Geltokiak = Bitartekoa.linearenGeltokiak(kodLinea);
		this.setBounds(200, 200, 450, 400);
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		JLabel lblAukeratuGeltokia = new JLabel("AUKERATU GELTOKIA");
		lblAukeratuGeltokia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAukeratuGeltokia.setBounds(125, 11, 204, 25);
		add(lblAukeratuGeltokia);

		// lista sortzen dugu
		JList<String> list = new JList<String>();
		list.setBounds(47, 66, 355, 140);
		DefaultListModel<String> modelo = new DefaultListModel<String>();
		for (Geltokia gel : Geltokiak) {
			System.out.println(gel.toString());
			modelo.addElement(gel.toString());// modeloan jartzen dugu zein baio izango dituen listak
		}
		list.setModel(modelo);// listari balioak esleitzen dizkiogu
		add(list);

		list.setBounds(36, 48, 372, 154);
		add(list);

		JLabel lblZenbatTxartel = new JLabel("ZENBAT TXARTEL:");
		lblZenbatTxartel.setBounds(46, 213, 92, 14);
		add(lblZenbatTxartel);

		JLabel lblZenbatekoa = new JLabel("ZENBATEKOA: ");
		lblZenbatekoa.setBounds(240, 213, 72, 14);
		add(lblZenbatekoa);
		

		lblNewLabel = new JLabel("dirua");
		lblNewLabel.setBounds(322, 213, 46, 14);
		add(lblNewLabel);
		
		ActionListener panelaAtzera = new ActionListener() { // panela aldatzen duen actionListenerra
			public void actionPerformed(ActionEvent arg0) {
				AukeratuLinea Linea =new AukeratuLinea(window);
				InterfaseNagusia.changeScene(window, Linea);
			}
		};
		
		ActionListener panelaJarraitu = new ActionListener() { // panela aldatzen duen actionListenerra
			public void actionPerformed(ActionEvent arg0) {
				String autLinea =list.getSelectedValue();//listaren balioa hartzen dugu
				if(autLinea.length()>0) {
				autLinea =autLinea.substring(0, 2);//listaren lehenengo bi balioak hartzen ditugu hau da kodea
				AukeratuGeltokia	panGeltoki =new AukeratuGeltokia(window,autLinea);
				InterfaseNagusia.changeScene(window, panGeltoki);
				}
			}
		};

		JButton btnAtzera = new JButton("ATZERA");
		btnAtzera.setBounds(97, 266, 89, 23);
		add(btnAtzera);

		btnJarraitu = new JButton("JARRAITU");
		btnJarraitu.setBounds(268, 266, 89, 23);
		add(btnJarraitu);

	}

}
