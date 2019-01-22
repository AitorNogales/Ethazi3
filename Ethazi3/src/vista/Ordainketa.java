package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

//import General.Globals;
//import interfaz.InterfaceMethods;

public class Ordainketa extends JPanel {

	/**
	 * Create the panel.
	 */
	public Ordainketa() {

		String itzul;
		//itzul = Double.toString(Globals.dirua);
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		this.setBounds(500, 500, 450, 320); //limiteak

		JLabel txtpnFaltatsenDena = new JLabel();
		txtpnFaltatsenDena.setForeground(new Color(255, 255, 255));
		txtpnFaltatsenDena.setFont(new Font("Tahoma", Font.PLAIN, 22)); 
		txtpnFaltatsenDena.setText("Faltatzen dena:");
		txtpnFaltatsenDena.setBackground(SystemColor.text);
		txtpnFaltatsenDena.setBounds(30, 11, 206, 33);//limiteak
		add(txtpnFaltatsenDena);

		JLabel itzuliak = new JLabel();
		itzuliak.setForeground(new Color(255, 255, 255));
		itzuliak.setFont(new Font("Tahoma", Font.PLAIN, 20));
		//itzuliak.setText(itzul + "\u20AC");
		itzuliak.setBackground(new Color(112, 128, 144));
		itzuliak.setBounds(30, 55, 230, 44);//limiteak
		add(itzuliak);

		JButton btn200 = new JButton("200\u20AC");
		btn200.setBounds(30, 115, 70, 44);//limiteak
		add(btn200);
		ActionListener action200 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//InterfaceMethods.kenduDirua(200, itzuliak, Globals.window.frame);
			}
		};
		btn200.addActionListener(action200);

		JButton btn100 = new JButton("100\u20AC");
		ActionListener action100 = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//InterfaceMethods.kenduDirua(100, itzuliak, Globals.window.frame);
			}
		};
		btn100.addActionListener(action100);
		btn100.setBounds(110, 115, 70, 44);//limiteak
		add(btn100);

		JButton btn50 = new JButton("50\u20AC");
		ActionListener action50 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//InterfaceMethods.kenduDirua(50, itzuliak, Globals.window.frame);
			}
		};
		btn50.addActionListener(action50);
		btn50.setBounds(190, 115, 70, 44);//limiteak
		add(btn50);

		JButton btn20 = new JButton("20\u20AC");
		ActionListener action20 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//InterfaceMethods.kenduDirua(20, itzuliak, Globals.window.frame);
			}
		};
		btn20.addActionListener(action20);
		btn20.setBounds(270, 115, 70, 44);//limiteak
		add(btn20);

		JButton btn10 = new JButton("10\u20AC");
		ActionListener action10 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//InterfaceMethods.kenduDirua(10, itzuliak, Globals.window.frame);
			}
		};
		btn10.addActionListener(action10);
		btn10.setBounds(350, 115, 70, 44);
		add(btn10);

		JButton btn5 = new JButton("5\u20AC");
		ActionListener action5 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//InterfaceMethods.kenduDirua(5, itzuliak, Globals.window.frame);
			}
		};
		btn5.addActionListener(action5);
		btn5.setBounds(30, 170, 70, 44);//limiteak
		add(btn5);

		JButton btn2 = new JButton("2\u20AC");
		ActionListener action2 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//InterfaceMethods.kenduDirua(2, itzuliak, Globals.window.frame);
			}
		};
		btn2.addActionListener(action2);
		btn2.setBounds(110, 170, 70, 44);//limiteak
		add(btn2);

		JButton btn1 = new JButton("1\u20AC");
		ActionListener action1 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//InterfaceMethods.kenduDirua(1, itzuliak, Globals.window.frame);
			}
		};
		btn1.addActionListener(action1);
		btn1.setBounds(190, 170, 70, 44);//limiteak
		add(btn1);

		JButton btn50c = new JButton("50c");
		ActionListener action050 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//InterfaceMethods.kenduDirua(.5, itzuliak, Globals.window.frame);
			}
		};
		btn50c.addActionListener(action050);
		btn50c.setBounds(270, 170, 70, 44);//limiteak
		add(btn50c);

		JButton btn20c = new JButton("20c");
		ActionListener action020 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//InterfaceMethods.kenduDirua(.2, itzuliak, Globals.window.frame);
			}
		};
		btn20c.addActionListener(action020);
		btn20c.setBounds(350, 170, 70, 44);//limiteak
		add(btn20c);

		JButton btn10c = new JButton("10c");
		ActionListener action010 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//InterfaceMethods.kenduDirua(.1, itzuliak, Globals.window.frame);
			}
		};
		btn10c.addActionListener(action010);
		btn10c.setBounds(71, 225, 70, 44);//limiteak
		add(btn10c);

		JButton btn5c = new JButton("5c");
		ActionListener action005 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//InterfaceMethods.kenduDirua(0.05, itzuliak, Globals.window.frame);

			}
		};
		btn5c.addActionListener(action005);

		btn5c.setBounds(151, 225, 70, 44);//limiteak
		add(btn5c);

		JButton btn2c = new JButton("2c");
		ActionListener action002 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//InterfaceMethods.kenduDirua(.02, itzuliak, Globals.window.frame);

			}
		};
		btn2c.addActionListener(action002);
		btn2c.setBounds(231, 225, 70, 44);//limiteak
		add(btn2c);

		JButton btn1c = new JButton("1c");
		ActionListener action001 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//InterfaceMethods.kenduDirua(.01, itzuliak, Globals.window.frame);
			}
		};
		btn1c.addActionListener(action001);
		btn1c.setBounds(311, 225, 70, 44);//limiteak
		add(btn1c);

	}

	

}
