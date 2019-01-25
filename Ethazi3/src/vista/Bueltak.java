package vista;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;



public class Bueltak extends JPanel {

	/**
	 * Create the panel.
	 */
	public Bueltak(JFrame window, double dirua) {

			this.setBounds(500,500,450,300);//limiteak
			//setLayout(null);
			String bueltas;
			//bueltas = metodoak.itzuliakKalkulatu(Globals.dirua);
			JTextArea txtItzuliak = new JTextArea(); 
			//txtItzuliak.setText(bueltas);
			txtItzuliak.setBounds(70, 42, 300, 100);//limiteak
			//add(txtItzuliak);
			
			JLabel lblZureBueltak = new JLabel("ZURE BUELTAK: ");
			lblZureBueltak.setForeground(Color.WHITE);
			lblZureBueltak.setBounds(186, 0, 184, 20);//limiteak
			//add(lblZureBueltak);
			
			JLabel lblNewLabel = new JLabel("");
			//lblNewLabel.setIcon(new ImageIcon(Bueltak.class.getResource("/images/image.jpg")));
			lblNewLabel.setBounds(0, 0, 450, 300);//limiteak
			//add(lblNewLabel);
			
		
		
			//InterfaceMethods.timer();
			
		}
	}
