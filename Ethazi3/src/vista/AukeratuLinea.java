package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import controlador.Bitartekoa;
import controlador.Linea;
import controlador.Txartela;

public class AukeratuLinea extends JPanel {
	private JList<String> list;
	private DefaultListModel<String> modelo;
	private ActionListener panelaAtzera;
	private PanelLogin Loging;
	private ActionListener panelaJarraitu;
	private AukeratuGeltokia panGeltoki;
	private JButton btnAtzera;
	private JButton btnJarraitu;
	private JTextPane txtpnAukeratuLinea;
	private ArrayList<Linea> Lineak;

	/**
	 * Create the panel.
	 * 
	 * @param txartela imprimatuko den txartela
	 */
	public AukeratuLinea(JFrame window, Txartela txartela) {

		Lineak = new ArrayList<Linea>();

		Lineak = Bitartekoa.artuLieneak();
		this.setBounds(200, 200, 450, 400);
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		// lista sortzen dugu
		list = new JList<String>();
		list.setBounds(47, 66, 355, 197);
		modelo = new DefaultListModel<String>();
		for (Linea li : Lineak) {
			System.out.println(li.toString());
			modelo.addElement(li.toString());// modeloan jartzen dugu zein baio izango dituen listak
		}
		list.setModel(modelo);// listari balioak esleitzen dizkiogu
		add(list);

		panelaAtzera = new ActionListener() { // panela aldatzen duen actionListenerra
			public void actionPerformed(ActionEvent arg0) {
				Loging = new PanelLogin(window);
				InterfaseNagusia.changeScene(window, Loging);
			}
		};

		panelaJarraitu = new ActionListener() { // panela aldatzen duen actionListenerra
			public void actionPerformed(ActionEvent arg0) {
				if (!list.isSelectionEmpty()) {// Zerbait autatu badugu

					int a = list.getSelectedIndex();
					Linea lin = Lineak.get(a);
					String autLinea = list.getSelectedValue().toString();// listaren balioa hartzen dugu
					txartela.setLineak(lin);
					autLinea = autLinea.substring(0, 2);// listaren lehenengo bi balioak hartzen ditugu
					panGeltoki = new AukeratuGeltokia(window, autLinea, txartela);
					InterfaseNagusia.changeScene(window, panGeltoki);
				}
			}
		};

		btnAtzera = new JButton("ATZERA");
		btnAtzera.setBounds(47, 304, 89, 23);
		btnAtzera.addActionListener(panelaAtzera);
		add(btnAtzera);
		btnAtzera.addActionListener(panelaAtzera);

		btnJarraitu = new JButton("JARRAITU");
		btnJarraitu.setBounds(303, 304, 99, 23);
		add(btnJarraitu);

		txtpnAukeratuLinea = new JTextPane();
		txtpnAukeratuLinea.setBackground(Color.LIGHT_GRAY);
		txtpnAukeratuLinea.setEditable(false);
		txtpnAukeratuLinea.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnAukeratuLinea.setText("AUKERATU LINEA");
		txtpnAukeratuLinea.setBounds(130, 10, 170, 30);
		add(txtpnAukeratuLinea);
		btnJarraitu.addActionListener(panelaJarraitu);

	}
}
