package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;

//import General.Globals;
//import General.metodoak;
//import interfaz.InterfaceMethods;

public class InterfaseNagusia {
	public JFrame frame;


	/**
	 * Create the application.
	 */
	public InterfaseNagusia() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() { // Jframe-a sortzen du 
		frame = new JFrame(); 
		frame.setBounds(200, 200, 450, 360); //limiteak
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Jframe-a izten tu X sakatzean
	}
	/**
	 * metodo honek frame bat eta panel hartzen ditu eta frame horren content pane
	 * bezala jartzen du panela
	 * 
	 * @param frame
	 *            hartutako framea
	 * @param panel
	 *            hartutako panela
	 */
	public static void changeScene(JFrame frame, JPanel panel) {
		frame.setContentPane(panel);

		frame.setPreferredSize(panel.getSize()); 
		frame.setResizable(false);
		frame.pack(); 

		frame.setPreferredSize(null);
	}
	
}
