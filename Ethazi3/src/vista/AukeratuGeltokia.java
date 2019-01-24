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

import com.toedter.calendar.JDateChooser;

import controlador.Autobusa;
import controlador.Bitartekoa;
import controlador.Geltokia;
import javax.swing.JComboBox;

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
		ArrayList<Autobusa> Autobusak=Bitartekoa.linearenAutobusak(kodLinea);
		
		this.setBounds(200, 200, 450, 425);
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		JLabel lblAukeratuGeltokia = new JLabel("AUKERATU GELTOKIA");
		lblAukeratuGeltokia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAukeratuGeltokia.setBounds(125, 11, 204, 25);
		add(lblAukeratuGeltokia);
		DefaultListModel<String> model = new DefaultListModel<String>();
		for (Geltokia gel : Geltokiak) {
			System.out.println(gel.toString());
			model.addElement(gel.toString());// modeloan jartzen dugu zein baio izango dituen listak
		}
		
		JList<String> listJatorria = new JList<String>();
		listJatorria.setBounds(34, 68, 166, 189);
		add(listJatorria);
		listJatorria.setModel(model);
		
		JList<String> listHelmuga = new JList<String>();
		listHelmuga.setBounds(242, 68, 166, 189);
		add(listHelmuga);
		listHelmuga.setModel(model);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(34, 281, 166, 25);
		add(comboBox);
		for(Autobusa aut: Autobusak) {
			comboBox.addItem(aut.toString());
		}
		
		JLabel lblJatorria = new JLabel("Jatorria");
		lblJatorria.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblJatorria.setBounds(36, 43, 87, 14);
		add(lblJatorria);
		
		JLabel lblHelmuga = new JLabel("Helmuga");
		lblHelmuga.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHelmuga.setBounds(242, 45, 87, 14);
		add(lblHelmuga);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(69, 317, 116, 20);
		add(dateChooser);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(34, 314, 46, 23);
		add(lblData);
		
		JLabel lblAutobusa = new JLabel("Autobusa:");
		lblAutobusa.setBounds(34, 268, 65, 14);
		add(lblAutobusa);
		JLabel lblZenbatekoa = new JLabel("ZENBATEKOA: ");
		lblZenbatekoa.setBounds(253, 286, 72, 14);
		add(lblZenbatekoa);
		

		lblNewLabel = new JLabel("dirua");
		lblNewLabel.setBounds(327, 286, 46, 14);
		add(lblNewLabel);
		
		ActionListener panelaAtzera = new ActionListener() { // panela aldatzen duen actionListenerra
			public void actionPerformed(ActionEvent arg0) {
				AukeratuLinea Linea =new AukeratuLinea(window);
				InterfaseNagusia.changeScene(window, Linea);
			}
		};
		
	/*	ActionListener panelaJarraitu = new ActionListener() { // panela aldatzen duen actionListenerra
			public void actionPerformed(ActionEvent arg0) {
				String autLinea =list.getSelectedValue();//listaren balioa hartzen dugu
				if(autLinea.length()>0) {
				autLinea =autLinea.substring(0, 2);//listaren lehenengo bi balioak hartzen ditugu hau da kodea
				AukeratuGeltokia	panGeltoki =new AukeratuGeltokia(window,autLinea);
				InterfaseNagusia.changeScene(window, panGeltoki);
				}
			}
		};*/

		JButton btnAtzera = new JButton("ATZERA");
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAtzera.setBounds(34, 348, 89, 23);
		add(btnAtzera);

		btnJarraitu = new JButton("JARRAITU");
		btnJarraitu.setBounds(319, 348, 89, 23);
		add(btnJarraitu);
		
		
	

	}
}
