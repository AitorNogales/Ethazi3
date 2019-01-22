package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
		frame.setBounds(200, 200, 450, 300); //limiteak
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Jframe-a ixten tu X sakatzean
	}
	/**
	 * metodo honek frame bat eta panel hartzen ditu eta frame horren content pane
	 * besala jartzen du panela
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
