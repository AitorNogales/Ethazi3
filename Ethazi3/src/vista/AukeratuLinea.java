package vista;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;

import com.toedter.calendar.JDateChooser;

import controlador.Bitartekoa;
import controlador.Linea;
import javax.swing.JTextPane;

public class AukeratuLinea extends JPanel {

	/**
	 * Create the panel.
	 */
	public AukeratuLinea(JFrame window) {
		
		ArrayList<Linea> Lineak = new ArrayList<Linea>();

		Lineak = Bitartekoa.artuLieneak();
		this.setBounds(200, 200, 450, 400);
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		

		// lista sortzen dugu
		JList<String> list = new JList<String>();
		list.setBounds(47, 66, 355, 197);
		DefaultListModel<String> modelo = new DefaultListModel<String>();
		for (Linea li : Lineak) {
			System.out.println(li.toString());
			modelo.addElement(li.toString());// modeloan jartzen dugu zein baio izango dituen listak
		}
		list.setModel(modelo);// listari balioak esleitzen dizkiogu
		add(list);

		ActionListener panelaAtzera = new ActionListener() { // panela aldatzen duen actionListenerra
			public void actionPerformed(ActionEvent arg0) {
				PanelLogin Loging = new PanelLogin(window);
				InterfaseNagusia.changeScene(window, Loging);
			}
		};

		ActionListener panelaJarraitu = new ActionListener() { // panela aldatzen duen actionListenerra
			public void actionPerformed(ActionEvent arg0) {
				String autLinea = "";
				autLinea = list.getSelectedValue().toString();// listaren balioa hartzen dugu
				if (autLinea.length() > 0) {
					autLinea = autLinea.substring(0, 2);// listaren lehenengo bi balioak hartzen ditugu hau da kodea
					AukeratuGeltokia panGeltoki = new AukeratuGeltokia(window, autLinea);
					InterfaseNagusia.changeScene(window, panGeltoki);
				}
			}
		};

		JButton btnAtzera = new JButton("ATZERA");
		btnAtzera.setBounds(47, 304, 89, 23);
		btnAtzera.addActionListener(panelaAtzera);
		add(btnAtzera);
		btnAtzera.addActionListener(panelaAtzera);

		JButton btnJarraitu = new JButton("JARRAITU");
		btnJarraitu.setBounds(313, 304, 89, 23);
		add(btnJarraitu);
		
		JTextPane txtpnAukeratuLinea = new JTextPane();
		txtpnAukeratuLinea.setEditable(false);
		txtpnAukeratuLinea.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnAukeratuLinea.setText("AUKERATU LINEA");
		txtpnAukeratuLinea.setBounds(133, 11, 169, 31);
		add(txtpnAukeratuLinea);
		btnJarraitu.addActionListener(panelaJarraitu);

		

		

	}
}
