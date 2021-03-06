package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Agurra extends JPanel {
	
	public JButton btnNewButton = new JButton("");
	private ActionListener panelaAldatu;
	private PanelLogin	Loging;
	/**
	 * lehenengo panela clicatzean  hurrengo p�nelara aldatzen da 
	 * @param window zein JFramean ireki behar den hurrengo JPanla
	 */
	public Agurra( JFrame window) {
		setLayout(null);
		this.setBounds(0,0,430,300); //limiteak
		panelaAldatu = new ActionListener() { //panela aldatzen duen actionListenerra
			public void actionPerformed(ActionEvent arg0) {
			Loging =new PanelLogin(window);
				InterfaseNagusia.changeScene(window, Loging);
			}
		};
		btnNewButton.setSelectedIcon(new ImageIcon(Agurra.class.getResource("/irudiak/AgurraIrudia.png")));
		btnNewButton.setIcon(new ImageIcon(Agurra.class.getResource("/irudiak/AgurraIrudia.png")));
		
		btnNewButton.addActionListener(panelaAldatu);
		btnNewButton.setBounds(0, 0, 427, 300);
		add(btnNewButton);
	}
}
