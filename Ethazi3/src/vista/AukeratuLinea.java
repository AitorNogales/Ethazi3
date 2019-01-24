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

public class AukeratuLinea extends JPanel {
	private JTextField txtAukeratuLinea;

	/**
	 * Create the panel.
	 */
	public AukeratuLinea(JFrame window) {
		ArrayList<Linea> Lineak = new ArrayList<Linea>();

		Lineak = Bitartekoa.artuLieneak();
		this.setBounds(200, 200, 450, 400);
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		txtAukeratuLinea = new JTextField();
		txtAukeratuLinea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtAukeratuLinea.setText("AUKERATU LINEA");
		txtAukeratuLinea.setBounds(133, 11, 169, 31);
		add(txtAukeratuLinea);
		txtAukeratuLinea.setColumns(10);

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(385, 66, 17, 140);
		add(scrollBar);

		// lista sortzen dugu
		JList<String> list = new JList<String>();
		list.setBounds(47, 66, 355, 140);
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
				autLinea = list.getSelectedValue();// listaren balioa hartzen dugu
				if (autLinea.length() > 0) {
					autLinea = autLinea.substring(0, 2);// listaren lehenengo bi balioak hartzen ditugu hau da kodea
					AukeratuGeltokia panGeltoki = new AukeratuGeltokia(window, autLinea);
					InterfaseNagusia.changeScene(window, panGeltoki);
				}
			}
		};

		JButton btnAtzera = new JButton("ATZERA");
		btnAtzera.setBounds(51, 266, 89, 23);
		btnAtzera.addActionListener(panelaAtzera);
		add(btnAtzera);
		btnAtzera.addActionListener(panelaAtzera);

		JButton btnJarraitu = new JButton("JARRAITU");
		btnJarraitu.setBounds(313, 266, 89, 23);
		add(btnJarraitu);
		btnJarraitu.addActionListener(panelaJarraitu);

		JLabel lblJoanData = new JLabel("JOAN DATA: ");
		lblJoanData.setBounds(47, 223, 64, 14);
		add(lblJoanData);

		JLabel lblItzultzeData = new JLabel("ITZULTZE DATA: ");
		lblItzultzeData.setBounds(233, 223, 83, 14);
		add(lblItzultzeData);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(121, 217, 76, 20);
		add(dateChooser);

		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(326, 217, 76, 20);
		add(dateChooser_1);

	}
}
