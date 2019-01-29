package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

//import General.Globals;
//import interfaz.InterfaceMethods;

public class Ordainketa extends JPanel {

	private JLabel txtpnFaltatsenDena;
	private JLabel itzuliak;
	private JButton btn200;
	private ActionListener action200;
	private JButton btn100;
	private ActionListener action100;
	private JButton btn50;
	private ActionListener action50;
	private JButton btn20;
	private ActionListener action20;
	private JButton btn10;
	private ActionListener action10;
	private JButton btn5;
	private ActionListener action5;
	private JButton btn2;
	private ActionListener action2;
	private JButton btn1;
	private ActionListener action1;
	private JButton btn50c;
	private ActionListener action050;
	private JButton btn20c;
	private ActionListener action020;
	private JButton btn10c;
	private ActionListener action010;
	private JButton btn5c;
	private ActionListener action005;
	private JButton btn2c;
	private ActionListener action002;
	private JButton btn1c;
	private ActionListener action001;
	private double diru;
	private JFrame window;
	private JButton btnBack;

	/**
	 * Create the panel.
	 */
	public Ordainketa(JFrame window, double dirua) {
		diru = dirua;
		this.window = window;
		// itzul = Double.toString(Globals.dirua);
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		this.setBounds(500, 500, 450, 360); // limiteak

		txtpnFaltatsenDena = new JLabel();
		txtpnFaltatsenDena.setForeground(new Color(255, 255, 255));
		txtpnFaltatsenDena.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtpnFaltatsenDena.setText("Faltatzen dena:");
		txtpnFaltatsenDena.setBackground(SystemColor.text);
		txtpnFaltatsenDena.setBounds(30, 11, 206, 33);// limiteak
		add(txtpnFaltatsenDena);

		itzuliak = new JLabel();
		itzuliak.setForeground(new Color(255, 255, 255));
		itzuliak.setFont(new Font("Tahoma", Font.PLAIN, 20));
		itzuliak.setText(diru + "\u20AC");
		itzuliak.setBackground(new Color(112, 128, 144));
		itzuliak.setBounds(30, 55, 230, 44);// limiteak

		add(itzuliak);

		btn200 = new JButton("200\u20AC");
		btn200.setBounds(30, 115, 70, 44);// limiteak
		add(btn200);
		action200 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kenduDirua(200);
			}
		};
		btn200.addActionListener(action200);

		btn100 = new JButton("100\u20AC");
		action100 = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				kenduDirua(100);
			}
		};
		btn100.addActionListener(action100);
		btn100.setBounds(110, 115, 70, 44);// limiteak
		add(btn100);

		btn50 = new JButton("50\u20AC");
		action50 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kenduDirua(50);
			}
		};
		btn50.addActionListener(action50);
		btn50.setBounds(190, 115, 70, 44);// limiteak
		add(btn50);

		btn20 = new JButton("20\u20AC");
		action20 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kenduDirua(20);
			}
		};
		btn20.addActionListener(action20);
		btn20.setBounds(270, 115, 70, 44);// limiteak
		add(btn20);

		btn10 = new JButton("10\u20AC");
		action10 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kenduDirua(10);
			}
		};
		btn10.addActionListener(action10);
		btn10.setBounds(350, 115, 70, 44);
		add(btn10);

		btn5 = new JButton("5\u20AC");
		action5 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kenduDirua(5);
			}
		};
		btn5.addActionListener(action5);

		btn5.setBounds(30, 170, 70, 44);// limiteak
		add(btn5);

		btn2 = new JButton("2\u20AC");
		action2 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kenduDirua(2);
			}
		};
		btn2.addActionListener(action2);
		btn2.setBounds(110, 170, 70, 44);// limiteak
		add(btn2);

		btn1 = new JButton("1\u20AC");
		action1 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kenduDirua(1);
			}
		};
		btn1.addActionListener(action1);
		btn1.setBounds(190, 170, 70, 44);// limiteak
		add(btn1);

		btn50c = new JButton("50c");
		action050 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kenduDirua(0.5);
			}
		};
		btn50c.addActionListener(action050);
		btn50c.setBounds(270, 170, 70, 44);// limiteak
		add(btn50c);

		btn20c = new JButton("20c");
		action020 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kenduDirua(0.2);
			}
		};
		btn20c.addActionListener(action020);
		btn20c.setBounds(350, 170, 70, 44);// limiteak
		add(btn20c);

		btn10c = new JButton("10c");
		action010 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kenduDirua(0.1);
			}
		};
		btn10c.addActionListener(action010);
		btn10c.setBounds(71, 225, 70, 44);// limiteak
		add(btn10c);

		btn5c = new JButton("5c");
		action005 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kenduDirua(0.05);
			}
		};
		btn5c.addActionListener(action005);

		btn5c.setBounds(151, 225, 70, 44);// limiteak
		add(btn5c);

		btn2c = new JButton("2c");
		action002 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kenduDirua(0.02);
			}
		};
		btn2c.addActionListener(action002);
		btn2c.setBounds(231, 225, 70, 44);// limiteak
		add(btn2c);

		btn1c = new JButton("1c");
		action001 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kenduDirua(0.01);
			}
		};

		btn1c.addActionListener(action001);
		btn1c.setBounds(311, 225, 70, 44);// limiteak
		add(btn1c);

		btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnBack.setIcon(new ImageIcon(Ordainketa.class.getResource("/irudiak/flecha atras.jpg")));
		btnBack.setBounds(11, 270, 47, 39);
		add(btnBack);

	}

	///////////// Methods//////////////
	private void kenduDirua(double kendu) {
		diru -= kendu;
		itzuliak.setText(diru + "\u20AC");
		if (diru <= 0) {
			diru = Math.abs(diru);
			Bueltak buel = new Bueltak(window, diru);

			InterfaseNagusia.changeScene(window, buel);
		}
	}
}
