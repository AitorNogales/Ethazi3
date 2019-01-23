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

import controlador.Bitartekoa;

public class PanelLogin extends JPanel {
	private JTextField textField;
	private JPasswordField passwordField;
	

	/**
	 * Create the panel.
	 */
	public PanelLogin(JFrame window) {
		this.setBounds(200, 200, 450, 350); // limiteak
		setBackground(Color.LIGHT_GRAY);

		setLayout(null);

		JLabel lblLogIn = new JLabel("LOG IN");
		lblLogIn.setFont(new Font("Batang", Font.BOLD, 20));
		lblLogIn.setBounds(177, 0, 86, 56);
		add(lblLogIn);

		JLabel lblErabiltzailea = new JLabel("DNI");
		lblErabiltzailea.setBounds(91, 107, 93, 14);
		add(lblErabiltzailea);

		JLabel lblPasahitza = new JLabel("PASAHITZA");
		lblPasahitza.setBounds(91, 135, 93, 14);
		add(lblPasahitza);

		textField = new JTextField();
		textField.setBounds(177, 104, 86, 20);
		add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(177, 132, 86, 20);
		add(passwordField);

		ActionListener panelaLineak = new ActionListener() { // panela aldatzen duen actionListenerra
			public void actionPerformed(ActionEvent arg0) {
				char[] arrayC = passwordField.getPassword(); // pasahitzan dagoena hartzen dugu char array moduan
				String pass = new String(arrayC);// lortutako char arraya stringera pasatzen dugu
				String dni = textField.getText();//erabiltzailearen dnia lortzen dugu
				if (Bitartekoa.ceckBezeroa(dni, pass)) {//dnia eta pasahitza DB badaude orduan lineak panelera aldatzen dugu
					AukeratuLinea lineak= new AukeratuLinea(window);
					InterfaseNagusia.changeScene(window, lineak);
				}
			}
		};

		ActionListener panelaAtzera = new ActionListener() { // panela aldatzen duen actionListenerra
			public void actionPerformed(ActionEvent arg0) {
				Agurra agurra = new Agurra(window);
				InterfaseNagusia.changeScene(window, agurra);
			}
		};

		// atzera botoiaren parametroak
		JButton btnAtzera = new JButton("ATZERA");
		btnAtzera.setBounds(95, 266, 89, 23);
		add(btnAtzera);
		btnAtzera.addActionListener(panelaAtzera);
		// jarraitu botoiaren parametroak
		JButton btnJarraitu = new JButton("JARRAITU");
		btnJarraitu.setBounds(222, 266, 93, 23);
		add(btnJarraitu);
		btnJarraitu.addActionListener(panelaLineak);

	}
}
