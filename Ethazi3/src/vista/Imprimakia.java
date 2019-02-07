package vista;

import javax.swing.JPanel;

import controlador.Bitartekoa;
import controlador.Metodoak;
import controlador.Txartela;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;

public class Imprimakia extends JPanel {
	
    private JLabel lblTxartela;
    private JLabel lblInprimatzen;
    private JLabel label;
    private JLabel lblEskerrikAsko;
    private Timer timer =new Timer();
    private Agurra agurra;
    private JFrame window;
	/**
	 * panel hau agertxen dad  fitxeroa inprimatxen dagoen bitartean 5 segundu ostean aldatu egiten da 
	 * @param window zein leihoa zbaldu behar dfen hurrengo panela 
	 * @param txartela inprimatu behar den txartela 
	 */
	 
	public Imprimakia(JFrame window, Txartela txartela) {
		this.window=window;
		System.out.println(txartela.toString());//frogatxeko
		txartela.printTxartela();
		Bitartekoa.inportTxartela(txartela);
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
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Imprimakia.class.getResource("/irudiak/FondoTermibus.png")));
		label_1.setBounds(0, 0, 450, 360);
		add(label_1);
		timer.schedule(Task, (long) 5000, ((long) (500)));// segundu erdiro comprobatzen du billetearen presioa

	}
	
	TimerTask Task = new TimerTask() // ahu egingo du denbora bat pasa ostean
			{
				@Override
				public void run() {
						 agurra = new Agurra(window);
						InterfaseNagusia.changeScene(window, agurra);
						timer.cancel();
					};
					
			};		
	private JLabel label_1;
}
					

			
				

			
	
