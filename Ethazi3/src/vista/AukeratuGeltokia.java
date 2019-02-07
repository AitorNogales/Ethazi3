package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import com.toedter.calendar.JDateChooser;
import controlador.Autobusa;
import controlador.Bitartekoa;
import controlador.Geltokia;
import controlador.Metodoak;
import controlador.Txartela;
import javax.swing.ImageIcon;

public class AukeratuGeltokia extends JPanel {

	/**
	 * 
	 */
	
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
	private Autobusa autobus;
	private Geltokia helmugaGeltokia, jatorriGeltokia;
	private JDateChooser dateChooser_etorrera;
	private JLabel lblEtorreraData, labelFondo, lblZenbatekoa, lblAutobusa,lblData,lblHelmuga,lblJatorria ;

	/**
	 * bidaiaren esaugarriak ahutatzeko panela 
	 * @param window zein leihoan irekiko den urrengo panela
	 * @param kodLinea zein lineako geltokiak agetu behar diren panelean 
	 * @param txartela askenean inprimatuk den txartela 
	 */
	//////constructor//////////
	public AukeratuGeltokia(JFrame window, String kodLinea, Txartela txartela) {

		Geltokiak = Bitartekoa.linearenGeltokiak(kodLinea);
		Collections.sort(Geltokiak);// ordenamos el array por su distancia a termibus gracias a la racarga del
									// metodo compare To()
		Autobusak = Bitartekoa.linearenAutobusak(kodLinea);

		this.setBounds(200, 200, 440, 450);
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

		lblJatorria = new JLabel("Jatorria");
		lblJatorria.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblJatorria.setBounds(36, 43, 87, 14);
		add(lblJatorria);

		lblHelmuga = new JLabel("Helmuga");
		lblHelmuga.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHelmuga.setBounds(242, 45, 87, 14);
		add(lblHelmuga);

		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd-MM-yyyy");
		dateChooser.setBounds(123, 319, 116, 20);
		add(dateChooser);
		dateChooser.setDate(Date.valueOf(LocalDate.now())); // gaurko data jarri
		dateChooser.setMinSelectableDate(Date.valueOf(LocalDate.now()));// gaur jarri data minimo moduan

		lblData = new JLabel("Data:");
		lblData.setBounds(34, 314, 46, 23);
		add(lblData);

		 lblAutobusa = new JLabel("Autobusa:");
		lblAutobusa.setBounds(34, 268, 65, 14);
		add(lblAutobusa);
		 lblZenbatekoa = new JLabel("ZENBATEKOA: ");
		lblZenbatekoa.setBounds(253, 286, 108, 14);
		add(lblZenbatekoa);

		lblDirua = new JLabel("dirua");
		lblDirua.setBounds(362, 286, 46, 14);
		add(lblDirua);

		ActionListener panelaAtzera = new ActionListener() { // panela aldatzen duen actionListenerra
			public void actionPerformed(ActionEvent arg0) {
				AukeratuLinea Linea = new AukeratuLinea(window, txartela);
				InterfaseNagusia.changeScene(window, Linea);
				timer.cancel();
			}
		};

		chckbxJoanEtorria = new JCheckBox("Joan Etorria");
		chckbxJoanEtorria.setBounds(294, 329, 97, 23);
		add(chckbxJoanEtorria);

		ActionListener panelaJarraitu = new ActionListener() { // panela aldatzen duen actionListenerra
			public void actionPerformed(ActionEvent arg0) { // panela aldatzen duen actionListenerra

				if (dirua > 0) {
					Date bidaiDate = new Date(dateChooser.getDate().getTime());
					Date etorreraData= new Date (dateChooser_etorrera.getDate().getTime());
					txartela.setHelmugaGeltokia(helmugaGeltokia);
					txartela.setAutobusak(autobus);
					txartela.setJatorriGeltokiak(jatorriGeltokia);
					txartela.setPrezioa(dirua);
					txartela.setDatak(bidaiDate);
					if(chckbxJoanEtorria.isSelected()) {
						txartela.setBidaiKop(2);
						txartela.setEtorrera_Data(etorreraData);
						
					}
					Ordainketa ordain = new Ordainketa(window, dirua, txartela);
					InterfaseNagusia.changeScene(window, ordain);
					timer.cancel();
				}
			}
		};

		btnAtzera = new JButton("ATZERA");
		btnAtzera.addActionListener(panelaAtzera);
		btnAtzera.setBounds(34, 377, 89, 23);
		add(btnAtzera);

		btnJarraitu = new JButton("JARRAITU");
		btnJarraitu.setBounds(310, 377, 98, 23);
		add(btnJarraitu);
		
	    lblEtorreraData = new JLabel("Etorrera data:");
		lblEtorreraData.setBounds(34, 348, 116, 16);
		add(lblEtorreraData);
		lblEtorreraData.setVisible(false);//okultatu
		
		dateChooser_etorrera = new JDateChooser();
		dateChooser_etorrera.setDateFormatString("dd-MM-yyyy");
		dateChooser_etorrera.setBounds(123, 344, 116, 20);
		add(dateChooser_etorrera);
		
		dateChooser_etorrera.setDate(Date.valueOf(LocalDate.now())); // gaurko data jarri
		dateChooser_etorrera.setMinSelectableDate(Date.valueOf(LocalDate.now()));// gaur jarri data minimo moduan
		
		labelFondo = new JLabel("");
		labelFondo.setIcon(null);
		labelFondo.setBounds(0, 0, 440, 450);
		add(labelFondo);
		dateChooser_etorrera.setVisible(false);//okultatu
		btnJarraitu.addActionListener(panelaJarraitu);

		timer.schedule(Task, (long) 500, ((long) (500)));// segundu erdiro comprobatzen du billetearen presioa

	}

	TimerTask Task = new TimerTask() // ahu egingo du denbora bat pasa ostean
	{

		@Override
		public void run() {///panelaren aktualisasioa

			int a = listJatorria.getSelectedIndex();
			int b = listHelmuga.getSelectedIndex();
			Date bidaiDate = new Date(dateChooser.getDate().getTime());
			if (a >= 0 && b >= 0) {// gausak seleksionatuta baditugu

				jatorriGeltokia = Geltokiak.get(a);
				helmugaGeltokia = Geltokiak.get(b);
				autobus = Autobusak.get(comboBoxAutobus.getSelectedIndex());//Autobusen zerrndatik hartzen dugu 

				dirua = Metodoak.kalkulatuPresioa(jatorriGeltokia, helmugaGeltokia, autobus, Geltokiak);
				
				if (chckbxJoanEtorria.isSelected()) {//joan etorri bidaia bada 
					dirua +=Metodoak.kalkulatuPresioa( helmugaGeltokia,jatorriGeltokia, autobus, Geltokiak);//falta movidita de q se vean etorria
					Date etorreraDate = new Date(dateChooser_etorrera.getDate().getTime());
					if (etorreraDate.before(bidaiDate)) {
						dateChooser_etorrera.setDate(bidaiDate);
					}
					dateChooser_etorrera.setMinSelectableDate(bidaiDate);
					
					 dateChooser_etorrera.setVisible(true);
					 lblEtorreraData.setVisible(true);
					
				}
				else {
					 dateChooser_etorrera.setVisible(false);
					 lblEtorreraData.setVisible(false);
				}
				
				dirua = Metodoak.redondearDecimales(dirua, 2);
				lblDirua.setText(dirua + "€");
			}
			

		};

	};
}
