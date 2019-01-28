package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import controlador.Autobusa;
import controlador.Bitartekoa;
import controlador.Geltokia;
import controlador.Metodoak;

import javax.swing.JCheckBox;

public class AukeratuGeltokia extends JPanel {

	private JButton btnJarraitu;
	private JButton btnAtzera;
	private JLabel lblDirua;
	private ArrayList<Geltokia> Geltokiak;
	private ArrayList<Autobusa> Autobusak;
	private JLabel lblAukeratuGeltokia;
	private JList<String> listJatorria;
	private JList<String> listHelmuga;
	private JComboBox<String> comboBoxAutobus;
	private JCheckBox chckbxJoanEtorria;
	private JDateChooser dateChooser;
	private double dirua;
	private Timer timer = new Timer();// denbora kontatzen du

	/**
	 * Create the panel.
	 * 
	 * @param      window, String kodLinea zein da interfaseak erabiliko duen lehioa
	 * @param zein lineako geltokiak agertuko diren panelean
	 */
	public AukeratuGeltokia(JFrame window, String kodLinea) {

		Geltokiak = Bitartekoa.linearenGeltokiak(kodLinea);
		Collections.sort(Geltokiak);// ordenamos el array por su distancia a termibus gracias a la racarga del
									// metodo compare To()
		Autobusak = Bitartekoa.linearenAutobusak(kodLinea);

		this.setBounds(200, 200, 450, 425);
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		lblAukeratuGeltokia = new JLabel("AUKERATU GELTOKIA");
		lblAukeratuGeltokia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAukeratuGeltokia.setBounds(125, 11, 204, 25);
		add(lblAukeratuGeltokia);

		DefaultListModel<String> model = new DefaultListModel<String>();
		for (Geltokia gel : Geltokiak) {
			System.out.println(gel.toString());
			model.addElement(gel.toString());// modeloan jartzen dugu zein baio izango dituen listak
		}

		DefaultListModel<String> modelo = new DefaultListModel<String>();
		for (Geltokia gelt : Geltokiak) {
			System.out.println(gelt.toString());
			modelo.addElement(gelt.toString());// modeloan jartzen dugu zein baio izango dituen listak
		}

		listJatorria = new JList<String>();
		listJatorria.setBounds(34, 68, 166, 189);
		add(listJatorria);
		listJatorria.setModel(model);

		listHelmuga = new JList<String>();
		listHelmuga.setBounds(242, 68, 166, 189);
		add(listHelmuga);
		listHelmuga.setModel(modelo);

		comboBoxAutobus = new JComboBox<String>();
		comboBoxAutobus.setBounds(34, 281, 166, 25);
		add(comboBoxAutobus);
		for (Autobusa aut : Autobusak) {
			comboBoxAutobus.addItem(aut.toString());
		}

		JLabel lblJatorria = new JLabel("Jatorria");
		lblJatorria.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblJatorria.setBounds(36, 43, 87, 14);
		add(lblJatorria);

		JLabel lblHelmuga = new JLabel("Helmuga");
		lblHelmuga.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHelmuga.setBounds(242, 45, 87, 14);
		add(lblHelmuga);

		dateChooser = new JDateChooser();
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

		lblDirua = new JLabel("dirua");
		lblDirua.setBounds(327, 286, 46, 14);
		add(lblDirua);

		ActionListener panelaAtzera = new ActionListener() { // panela aldatzen duen actionListenerra
			public void actionPerformed(ActionEvent arg0) {
				AukeratuLinea Linea = new AukeratuLinea(window);
				InterfaseNagusia.changeScene(window, Linea);
				timer.cancel();
			}
		};

		chckbxJoanEtorria = new JCheckBox("Joan Etorria");
		chckbxJoanEtorria.setBounds(247, 314, 97, 23);
		add(chckbxJoanEtorria);

		ActionListener panelaJarraitu = new ActionListener() { // panela aldatzen duen actionListenerra
			public void actionPerformed(ActionEvent arg0) { // panela aldatzen duen actionListenerra
				
				if (dirua > 0 ) {
					Date bidaiDate = new Date(dateChooser.getDate().getTime());
					Ordainketa ordain = new Ordainketa(window, dirua);
					InterfaseNagusia.changeScene(window, ordain);
					timer.cancel();
				}
			}
		};

		btnAtzera = new JButton("ATZERA");
		btnAtzera.addActionListener(panelaAtzera);
		btnAtzera.setBounds(34, 348, 89, 23);
		add(btnAtzera);

		btnJarraitu = new JButton("JARRAITU");
		btnJarraitu.setBounds(310, 348, 98, 23);
		add(btnJarraitu);
		btnJarraitu.addActionListener(panelaJarraitu);

		timer.schedule(Task, (long) 500, ((long) (500)));// segundu erdiro comprobatzen du billetearen presioa

	}

	TimerTask Task = new TimerTask() // ahu egingo du denbora bat pasa ostean
	{

		@Override
		public void run() {

			int a = listJatorria.getSelectedIndex();
			int b = listHelmuga.getSelectedIndex();

			if (a >= 0 && b >= 0) {// gausak seleksionatuta baditugu
				System.out.println("entre");
				Geltokia jatorriGeltokia = Geltokiak.get(a);
				Geltokia helmugaGeltokia = Geltokiak.get(b);
				Autobusa autobus = Autobusak.get(comboBoxAutobus.getSelectedIndex());

				dirua = Metodoak.kalkulatuPresioa(jatorriGeltokia, helmugaGeltokia, autobus,Geltokiak);
				if (chckbxJoanEtorria.isSelected()) {
					dirua *= 2;
				}
				lblDirua.setText(dirua + "€");
			}

		};

	};
}
