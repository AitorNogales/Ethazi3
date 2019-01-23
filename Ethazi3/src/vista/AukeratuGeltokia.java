package vista;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class AukeratuGeltokia extends JPanel {

	/**
	 * Create the panel.
	 */
	public AukeratuGeltokia() {
		this.setBounds(200, 200, 450, 300);
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		JLabel lblAukeratuGeltokia = new JLabel("AUKERATU GELTOKIA");
		lblAukeratuGeltokia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAukeratuGeltokia.setBounds(125, 11, 204, 25);
		add(lblAukeratuGeltokia);
		
		JList list = new JList();
		list.setBounds(36, 48, 372, 154);
		add(list);
		
		JLabel lblZenbatTxartel = new JLabel("ZENBAT TXARTEL:");
		lblZenbatTxartel.setBounds(46, 213, 92, 14);
		add(lblZenbatTxartel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"--", "1", "2", "3", "4", "5"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(141, 210, 33, 20);
		add(comboBox);
		
		JLabel lblZenbatekoa = new JLabel("ZENBATEKOA: ");
		lblZenbatekoa.setBounds(240, 213, 72, 14);
		add(lblZenbatekoa);
		
		JLabel lblNewLabel = new JLabel("dirua");
		lblNewLabel.setBounds(322, 213, 46, 14);
		add(lblNewLabel);
		
		JButton btnAtzera = new JButton("ATZERA");
		btnAtzera.setBounds(97, 266, 89, 23);
		add(btnAtzera);
		
		JButton btnJarraitu = new JButton("JARRAITU");
		btnJarraitu.setBounds(268, 266, 89, 23);
		add(btnJarraitu);

	}
}
