package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Agurra extends JPanel {
	public JButton btnNewButton = new JButton(""); 
	/**
	 * Create the panel.
	 */
	public Agurra( JFrame window) {
		setLayout(null);
		this.setBounds(0,0,425,300); //limiteak
		ActionListener panelaAldatu = new ActionListener() { //panela aldatzen duen actionListenerra
			public void actionPerformed(ActionEvent arg0) {
			PanelLogin	Loging=new PanelLogin();
				InterfaseNagusia.changeScene(window, Loging);
			}
		};
	//	btnNewButton.setIcon(new ImageIcon(Agurra.class.getResource("/images/Panel_1.jpg")));
		
		btnNewButton.addActionListener(panelaAldatu);
		btnNewButton.setBounds(0, 0, 427, 300);
		add(btnNewButton);
	}
}