package vista;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class Imprimakia extends JPanel {

	/**
	 * Create the panel.
	 */
	public Imprimakia() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		JLabel lblTxartela = new JLabel("TXARTELA");
		lblTxartela.setFont(new Font("DialogInput", Font.BOLD, 25));
		lblTxartela.setBounds(157, 33, 127, 56);
		add(lblTxartela);
		
		JLabel lblInprimatzen = new JLabel("INPRIMATZEN");
		lblInprimatzen.setFont(new Font("DialogInput", Font.BOLD, 25));
		lblInprimatzen.setBounds(136, 73, 174, 56);
		add(lblInprimatzen);
		
		JLabel label = new JLabel(". . . . . . . . . . . . . . . . . ");
		label.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label.setBounds(75, 128, 308, 49);
		add(label);
		
		JLabel lblEskerrikAsko = new JLabel("ESKERRIK ASKO");
		lblEskerrikAsko.setFont(new Font("DialogInput", Font.BOLD, 28));
		lblEskerrikAsko.setBounds(109, 188, 241, 28);
		add(lblEskerrikAsko);

	}

}