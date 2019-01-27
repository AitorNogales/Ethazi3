package vista;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import controlador.Metodoak;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;



public class Bueltak extends JPanel {

	/**
	 * Create the panel.
	 */
	public Bueltak(JFrame window, double dirua) {
		setBackground(Color.LIGHT_GRAY);

			this.setBounds(500,500,450,300);//limiteak
			setLayout(null);
			String bueltas;
			bueltas = Metodoak.itzuliakKalkulatu(dirua);
			JTextArea txtItzuliak = new JTextArea(); 
			txtItzuliak.setEditable(false);
			txtItzuliak.setText(bueltas);
			txtItzuliak.setBounds(70, 45, 300, 161);//limiteak
			add(txtItzuliak);
			
			JLabel lblZureBueltak = new JLabel("ZURE BUELTAK: ");
			lblZureBueltak.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblZureBueltak.setBackground(Color.BLACK);
			lblZureBueltak.setForeground(Color.BLACK);
			lblZureBueltak.setBounds(141, 14, 184, 20);//limiteak
			add(lblZureBueltak);
			
			ActionListener aldatuInprimakia = new ActionListener() { // panela aldatzen duen actionListenerra
				public void actionPerformed(ActionEvent arg0) {
					Imprimakia Loging = new Imprimakia(window);
					InterfaseNagusia.changeScene(window, Loging);
				
				}
			};
			
			JLabel lblNewLabel = new JLabel("");
			//lblNewLabel.setIcon(new ImageIcon(Bueltak.class.getResource("/images/image.jpg")));
			lblNewLabel.setBounds(0, 0, 450, 300);//limiteak
			add(lblNewLabel);
			
			JButton btnJarraitu = new JButton("Jarraitu");
			btnJarraitu.setBounds(170, 242, 89, 23);
			add(btnJarraitu);
			btnJarraitu.addActionListener(aldatuInprimakia);
			
		}
	}
