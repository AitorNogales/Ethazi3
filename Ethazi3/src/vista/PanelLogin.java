package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import controlador.Bezeroa;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class PanelLogin extends JPanel {
	private JTextField textField;
	private JPasswordField passwordField;
	private ArrayList<Bezeroa> Bezeroak;
	/**
	 * Create the panel.
	 */
	public PanelLogin() {
		this.setBounds(0,0,425,350); //limiteak
		setBackground(Color.LIGHT_GRAY);
		ArrayList<Bezeroa>bz=controlador.Bitartekoa.artuBezeroak();
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
		
		JButton btnAtzera = new JButton("ATZERA");
		btnAtzera.setBounds(95, 266, 89, 23);
		add(btnAtzera);
		
		JButton btnJarraitu = new JButton("JARRAITU");
		btnJarraitu.setBounds(222, 266, 93, 23);
		add(btnJarraitu);

	}
}
