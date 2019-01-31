package vista;

import java.awt.Color;
import java.awt.Font;
import java.sql.Date;
import java.time.LocalDate;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class PanelSignIn extends JPanel {
	private JTextField tfIzena;
	private JTextField tfAbizena;
	private JTextField tfNAN;
	private JPasswordField pwd;
	private JDateChooser dateChooser;
	private ButtonGroup sexuaRadioGroup;
	private JRadioButton rdbtnEmakumezkoa;
	private JRadioButton rdbtnGizonezkoa;
	private JLabel lblSexua, lblJaiotzeData, lblPasahitza, lblNan, lblIzena, lblSingIn;

	/**
	 * Create the panel.
	 */
		public PanelSignIn(JFrame window) {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		setBounds(200, 200, 450, 360);

		lblSingIn = new JLabel("Sing in");
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

		rdbtnGizonezkoa = new JRadioButton("Gizoneskoa");
		rdbtnGizonezkoa.setBounds(286, 206, 111, 24);

		add(rdbtnGizonezkoa);

		rdbtnEmakumezkoa = new JRadioButton("Emakumezkoa");
		rdbtnEmakumezkoa.setBounds(286, 235, 111, 25);
		add(rdbtnEmakumezkoa);

		JLabel lblAbizena = new JLabel("Abizena:");
		lblAbizena.setBounds(64, 121, 56, 16);
		add(lblAbizena);

		lblNan = new JLabel("NAN:");
		lblNan.setBounds(64, 63, 56, 16);
		add(lblNan);

		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setBounds(54, 291, 97, 25);
		add(btnAtzera);

		JButton btnJarraitu = new JButton("Jarraitu");
		btnJarraitu.setBounds(300, 291, 97, 25);
		add(btnJarraitu);

		pwd = new JPasswordField();
		pwd.setBounds(132, 148, 193, 22);
		add(pwd);

		lblPasahitza = new JLabel("Pasahitza");
		lblPasahitza.setBounds(64, 150, 56, 16);
		add(lblPasahitza);

		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd-MM-yyyy");
		dateChooser.setBounds(38, 206, 116, 20);
		add(dateChooser);
		dateChooser.setDate(Date.valueOf(LocalDate.now())); // gaurko data jarri
		dateChooser.setMaxSelectableDate(Date.valueOf(LocalDate.now()));// gaur jarri data minimo moduan

		lblJaiotzeData = new JLabel("Jaiotze data:");
		lblJaiotzeData.setBounds(38, 179, 87, 16);
		add(lblJaiotzeData);

		lblSexua = new JLabel("Sexua:");
		lblSexua.setBounds(288, 185, 56, 16);
		add(lblSexua);
		sexuaRadioGroup = new ButtonGroup();
		sexuaRadioGroup.add(rdbtnGizonezkoa);
		sexuaRadioGroup.add(rdbtnEmakumezkoa);
		// rdbtnEmakumezkoa.isSelected();
	}
}
