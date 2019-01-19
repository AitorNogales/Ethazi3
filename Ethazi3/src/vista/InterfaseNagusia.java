package vista;

import javax.swing.JFrame;

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
}
