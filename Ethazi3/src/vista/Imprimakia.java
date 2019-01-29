package vista;

import javax.swing.JPanel;

import controlador.Txartela;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class Imprimakia extends JPanel {
	
    private JLabel lblTxartela;
    private JLabel lblInprimatzen;
    private JLabel label;
    private JLabel lblEskerrikAsko;
	/**
	 * Create the panel.
	 * @param txartela 
	 */
	public Imprimakia(JFrame window, Txartela txartela) {
		System.out.println(txartela.toString());//frogatxeko
		txartela.printTxartela();
		this.setBounds(500,500,450,360);//limiteak
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		lblTxartela = new JLabel("TXARTELA");
		lblTxartela.setFont(new Font("DialogInput", Font.BOLD, 25));
		lblTxartela.setBounds(157, 33, 127, 56);
		add(lblTxartela);
		
		lblInprimatzen = new JLabel("INPRIMATZEN");
		lblInprimatzen.setFont(new Font("DialogInput", Font.BOLD, 25));
		lblInprimatzen.setBounds(136, 73, 174, 56);
		add(lblInprimatzen);
		
		label = new JLabel(". . . . . . . . . . . . . . . . . ");
		label.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label.setBounds(75, 128, 308, 49);
		add(label);
		
		lblEskerrikAsko = new JLabel("ESKERRIK ASKO");
		lblEskerrikAsko.setFont(new Font("DialogInput", Font.BOLD, 28));
		lblEskerrikAsko.setBounds(109, 188, 241, 28);
		add(lblEskerrikAsko);

	}

}
