package vista;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import controlador.Metodoak;
import controlador.Txartela;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.ImageIcon;



public class Bueltak extends JPanel {
	private JLabel lblNewLabel,lblZureBueltak, labelFondo;
	private String bueltas;
	private JButton btnJarraitu;
	private JTextArea txtItzuliak;
	/**
	 * ordainu ostean zein diren bueltak aurkesten duen panela 
	 * @param window sein Jframean sabaldu behar den innprimakiak panela 
	 * @param dirua zenbat diruren bueltak kalkulatu behar diren 
	 * @param txartela bueltak ijusi ostean zein txartel inprimatu behar den
	 */
	public Bueltak(JFrame window, double dirua, Txartela txartela) {
		setBackground(Color.LIGHT_GRAY);

			this.setBounds(500,500,450,360);//limiteak
			setLayout(null);
			bueltas = Metodoak.itzuliakKalkulatu(dirua);
			txtItzuliak = new JTextArea(); 
			txtItzuliak.setEditable(false);
			txtItzuliak.setText(bueltas);
			txtItzuliak.setBounds(70, 45, 300, 161);//limiteak
			add(txtItzuliak);
			
			 lblZureBueltak = new JLabel("ZURE BUELTAK: ");
			lblZureBueltak.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblZureBueltak.setBackground(Color.BLACK);
			lblZureBueltak.setForeground(Color.BLACK);
			lblZureBueltak.setBounds(141, 14, 184, 20);//limiteak
			add(lblZureBueltak);
			
			/**
			 * hurrengo pantailara pasaatzeko botoiaren action listenerra
			 */
			ActionListener aldatuInprimakia = new ActionListener() { // panela aldatzen duen actionListenerra
				public void actionPerformed(ActionEvent arg0) {
					Imprimakia Loging = new Imprimakia(window,txartela);
					InterfaseNagusia.changeScene(window, Loging);
				
				}
			};
			
			 lblNewLabel = new JLabel("");
			//lblNewLabel.setIcon(new ImageIcon(Bueltak.class.getResource("/images/image.jpg")));
			lblNewLabel.setBounds(0, 0, 450, 300);//limiteak
			add(lblNewLabel);
			
			btnJarraitu = new JButton("Jarraitu");
			btnJarraitu.setBounds(170, 242, 89, 23);
			add(btnJarraitu);
			
			labelFondo = new JLabel("");
			labelFondo.setIcon(new ImageIcon(Bueltak.class.getResource("/irudiak/FondoTermibus.png")));
			labelFondo.setBounds(0, 0, 450, 360);
			add(labelFondo);
			btnJarraitu.addActionListener(aldatuInprimakia);
			
		}
	}
