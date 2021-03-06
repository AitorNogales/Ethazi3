package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controlador.Bezeroa;
import controlador.Bitartekoa;
import controlador.Txartela;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;

public class PanelLogin extends JPanel {
	
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblLogIn;
	private JLabel lblErabiltzailea;
	private JLabel lblPasahitza, Fondo ;
	private ActionListener panelaLineak; 
    private String pass;
    private String dni;
    private AukeratuLinea lineak;
    private ActionListener panelaAtzera;
    private Agurra agurra;
    private JButton btnAtzera;
    private JButton btnJarraitu;
    private Txartela txartela;
    private JLabel lblErabiltzaileaEdoPasahitza;
    private JButton btnSignIn;
    
/**
 * Login panelaren sortzaila
 * @param window zein lehiotan zabaldu behar den hurrengo leihoa 
 */
		public PanelLogin(JFrame window) {
		setBorder(UIManager.getBorder("InternalFrame.border"));
		this.setBounds(200, 200, 450, 360); // limiteak
		setBackground(Color.LIGHT_GRAY);

		setLayout(null);

		lblLogIn = new JLabel("LOG IN");
		lblLogIn.setFont(new Font("Batang", Font.BOLD, 20));
		lblLogIn.setBounds(177, 0, 86, 56);
		add(lblLogIn);

		lblErabiltzailea = new JLabel("DNI");
		lblErabiltzailea.setBounds(91, 107, 93, 14);
		add(lblErabiltzailea);

		lblPasahitza = new JLabel("PASAHITZA");
		lblPasahitza.setBounds(91, 156, 93, 14);
		add(lblPasahitza);

		textField = new JTextField();
		textField.setBounds(177, 104, 147, 20);
		add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(177, 153, 147, 20);
		add(passwordField);

		panelaLineak = new ActionListener() { // panela aldatzen duen actionListenerra
			public void actionPerformed(ActionEvent arg0) {
				char[] arrayC = passwordField.getPassword(); // pasahitzan dagoena hartzen dugu char array moduan
				pass = new String(arrayC);// lortutako char arraya stringera pasatzen dugu
				dni = textField.getText();//erabiltzailearen dnia lortzen dugu
				if (Bitartekoa.ceckBezeroa(dni, pass)) {//dnia eta pasahitza DB badaude orduan lineak panelera aldatzen dugu
					Bezeroa beze= Bitartekoa.artuBezeroa(dni, pass);
					txartela=new Txartela();
					txartela.setJabea(beze);
					lineak= new AukeratuLinea(window,txartela);
					InterfaseNagusia.changeScene(window, lineak);
				}
				else {
					passwordField.setText("");
					lblErabiltzaileaEdoPasahitza.setVisible(true);
				}
			}
		};

		panelaAtzera = new ActionListener() { // panela aldatzen duen actionListenerra
			public void actionPerformed(ActionEvent arg0) {
				agurra = new Agurra(window);
				InterfaseNagusia.changeScene(window, agurra);
			}
		};

		// atzera botoiaren parametroak
		btnAtzera = new JButton("ATZERA");
		btnAtzera.setBounds(54, 266, 89, 23);
		add(btnAtzera);
		btnAtzera.addActionListener(panelaAtzera);
		// jarraitu botoiaren parametroak
		btnJarraitu = new JButton("JARRAITU");
		btnJarraitu.setBounds(306, 266, 93, 23);
		btnJarraitu.addActionListener(panelaLineak);
		add(btnJarraitu);
		
		lblErabiltzaileaEdoPasahitza = new JLabel("Erabiltzailea edo pasahitza okerra da");
		lblErabiltzaileaEdoPasahitza.setForeground(Color.RED);
		lblErabiltzaileaEdoPasahitza.setBounds(111, 199, 260, 16);
		lblErabiltzaileaEdoPasahitza.setVisible(false);
		add(lblErabiltzaileaEdoPasahitza);
		
		btnSignIn = new JButton("SIGN IN");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			PanelSignIn Signin = new PanelSignIn(window);
			InterfaseNagusia.changeScene(window, Signin);
			}
		});
		btnSignIn.setBounds(177, 265, 97, 25);
		add(btnSignIn);
		
		Fondo = new JLabel("");
		Fondo.setIcon(new ImageIcon(PanelLogin.class.getResource("/irudiak/FondoTermibus.png")));
		Fondo.setBounds(0, 0, 450, 360);
		add(Fondo);
		btnJarraitu.addActionListener(panelaLineak);

	}
}
