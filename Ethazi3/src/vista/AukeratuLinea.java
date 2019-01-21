package vista;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

public class AukeratuLinea extends JPanel {
	private JTextField txtAukeratuLinea;

	/**
	 * Create the panel.
	 */
	public AukeratuLinea() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		txtAukeratuLinea = new JTextField();
		txtAukeratuLinea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtAukeratuLinea.setText("AUKERATU LINEA");
		txtAukeratuLinea.setBounds(136, 11, 169, 31);
		add(txtAukeratuLinea);
		txtAukeratuLinea.setColumns(10);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(385, 66, 17, 140);
		add(scrollBar);
		
		JList list = new JList();
		list.setBounds(47, 66, 355, 140);
		add(list);
		
		JButton btnAtzera = new JButton("ATZERA");
		btnAtzera.setBounds(47, 266, 89, 23);
		add(btnAtzera);
		
		JButton btnJarraitu = new JButton("JARRAITU");
		btnJarraitu.setBounds(313, 266, 89, 23);
		add(btnJarraitu);
		
		JLabel lblJoanData = new JLabel("JOAN DATA: ");
		lblJoanData.setBounds(47, 223, 64, 14);
		add(lblJoanData);
		
		JLabel lblItzultzeData = new JLabel("ITZULTZE DATA: ");
		lblItzultzeData.setBounds(233, 223, 83, 14);
		add(lblItzultzeData);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(121, 217, 76, 20);
		add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(326, 217, 76, 20);
		add(dateChooser_1);

	}
}
