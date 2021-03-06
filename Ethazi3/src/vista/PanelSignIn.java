package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import controlador.Bezeroa;
import controlador.Bitartekoa;
import controlador.Txartela;

public class PanelSignIn extends JPanel {

	private JTextField tfIzena;
	private JTextField tfAbizena;
	private JTextField tfNAN;
	private JPasswordField pwd;
	private JDateChooser dateChooser;
	private ButtonGroup sexuaRadioGroup;
	private JRadioButton rdbtnEmakumezkoa;
	private JRadioButton rdbtnGizonezkoa;
	private JLabel lblSexua, lblJaiotzeData, lblPasahitza, lblNan, lblIzena, lblSingIn, lblAbizena, lblErroreMesua;
	private JButton btnAtzera, btnJarraitu;
	private JFrame window;
//atzera joteko aktion listenerra
	private ActionListener atzera = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			PanelLogin Loging = new PanelLogin(window);
			InterfaseNagusia.changeScene(window, Loging);
		}
	};
//erabiltxaileak sartutako datuak egokiak diren konprobatxen du eta badira datu basera igotzen du eta lineak panelera aldatzen du 
	private ActionListener jarraitu = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String izena = tfIzena.getText();
			String nan = tfNAN.getText();
			nan = nan.toUpperCase();
			String abizena = tfAbizena.getText();

			char[] arrayC = pwd.getPassword(); // pasahitzan dagoena hartzen dugu char array moduan
			String pass = new String(arrayC);// lortutako char arraya stringera pasatzen dugu

			if (nan.matches("^[1-9]{8}[A-Z]$") && izena.matches("^[a-zA-Z ]*$") && abizena.matches("^[a-zA-Z ]*$")) {
				if(rdbtnEmakumezkoa.isSelected() || rdbtnGizonezkoa.isSelected()) {
				if (pass.length() > 0) {
					if(!Bitartekoa.bezeroaExistitu(nan)) {
					String sex;
					if (rdbtnEmakumezkoa.isSelected()) {
						sex="M";
					}
					else {
						sex="V";
					}
					
					Date jaiotzeData = new Date(dateChooser.getDate().getTime());
					Bezeroa clien =new Bezeroa(nan, izena, abizena, jaiotzeData, sex, pass);
					
					Bitartekoa.inportBezeroa(clien);
					
					Txartela txartela=new Txartela();
					txartela.setJabea(clien);
					AukeratuLinea lineak= new AukeratuLinea(window,txartela);
					InterfaseNagusia.changeScene(window, lineak);
					}else {
						//el usuario esta en la base de datos
						lblErroreMesua.setText("Erabiltzailea lehendik existitzen  da");
						lblErroreMesua.setVisible(true);
					}
				} else {
					//cuando el pasword esta mal
					lblErroreMesua.setText("Ez duzu pasahitzik sartu");
					lblErroreMesua.setVisible(true);
				}
				}else{
					//no hay sexo seleccionado
					lblErroreMesua.setText("Ez duzu sexua sartu");
					lblErroreMesua.setVisible(true);
				}
			} else {
				
					//el usuario esta mal  
				lblErroreMesua.setText("Erabiltzaile datuak txarto daude");
				lblErroreMesua.setVisible(true);
			}
		}
	};
	private  JLabel labelFondo = new JLabel("");

	/**
	 * panel honek erabiltzaile berriak sortzeko erabiltxen da 
	 * @param window zein lehiotan zabaldu behar den hurrenggo leihoa 
	 */
	 
	public PanelSignIn(JFrame window) {
		this.window = window;
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		setBounds(200, 200, 450, 360);

		lblSingIn = new JLabel("Sign in");
		lblSingIn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSingIn.setBounds(200, 13, 88, 34);
		add(lblSingIn);

		lblIzena = new JLabel("Izena:");
		lblIzena.setBounds(64, 92, 56, 16);
		add(lblIzena);

		tfIzena = new JTextField();
		tfIzena.setBounds(132, 89, 193, 22);
		add(tfIzena);
		tfIzena.setColumns(10);

		tfAbizena = new JTextField();
		tfAbizena.setColumns(10);
		tfAbizena.setBounds(132, 118, 193, 22);
		add(tfAbizena);

		tfNAN = new JTextField();
		tfNAN.setColumns(10);
		tfNAN.setBounds(132, 60, 193, 22);
		add(tfNAN);

		rdbtnGizonezkoa = new JRadioButton("Gizonezkoa");
		rdbtnGizonezkoa.setBounds(298, 210, 111, 24);

		add(rdbtnGizonezkoa);

		rdbtnEmakumezkoa = new JRadioButton("Emakumezkoa");
		rdbtnEmakumezkoa.setBounds(298, 235, 111, 25);
		add(rdbtnEmakumezkoa);

		lblAbizena = new JLabel("Abizena:");
		lblAbizena.setBounds(64, 121, 56, 16);
		add(lblAbizena);

		lblNan = new JLabel("NAN:");
		lblNan.setBounds(64, 63, 56, 16);
		add(lblNan);

		btnAtzera = new JButton("Atzera");
		btnAtzera.addActionListener(atzera);
		btnAtzera.setBounds(54, 269, 97, 25);
		add(btnAtzera);

		btnJarraitu = new JButton("Jarraitu");
		btnJarraitu.addActionListener(jarraitu);
		btnJarraitu.setBounds(325, 269, 97, 25);
		add(btnJarraitu);

		pwd = new JPasswordField();
		pwd.setBounds(132, 148, 193, 22);
		add(pwd);
		
		lblErroreMesua = new JLabel("Errore mesua");
		lblErroreMesua.setForeground(Color.RED);
		lblErroreMesua.setBounds(54, 239, 234, 16);
		add(lblErroreMesua);
		lblErroreMesua.setVisible(false);

		lblPasahitza = new JLabel("Pasahitza");
		lblPasahitza.setBounds(64, 150, 56, 16);
		add(lblPasahitza);

		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd-MM-yyyy");
		dateChooser.setBounds(64, 214, 116, 20);
		add(dateChooser);
		dateChooser.setDate(Date.valueOf(LocalDate.now())); // gaurko data jarri
		dateChooser.setMaxSelectableDate(Date.valueOf(LocalDate.now()));

		lblJaiotzeData = new JLabel("Jaiotze data:");
		lblJaiotzeData.setBounds(65, 193, 87, 16);
		add(lblJaiotzeData);

		lblSexua = new JLabel("Sexua:");
		lblSexua.setBounds(288, 185, 56, 16);
		add(lblSexua);
		sexuaRadioGroup = new ButtonGroup();
		sexuaRadioGroup.add(rdbtnGizonezkoa);
		sexuaRadioGroup.add(rdbtnEmakumezkoa);
		labelFondo.setIcon(new ImageIcon(PanelSignIn.class.getResource("/irudiak/FondoTermibus.png")));
		labelFondo.setBounds(0, 0, 450, 360);
		add(labelFondo);
		
	}
}
