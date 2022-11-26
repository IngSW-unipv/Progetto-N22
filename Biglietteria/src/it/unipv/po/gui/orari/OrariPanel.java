package it.unipv.po.gui.orari;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import it.unipv.po.connessioneDB.DBread;
import it.unipv.po.trasporto.fermata.Fermata;
import it.unipv.po.trasporto.linea.Linea;
import it.unipv.po.trasporto.vehicleModel.Vehicle;

import javax.swing.JComboBox;
import java.awt.event.InputMethodListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JTable;

public class OrariPanel extends JPanel {
	ArrayList<Fermata> fermate;

	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public OrariPanel() throws SQLException {
		final Linea linee = new Linea();
		DBread db = new DBread();

		
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setBounds(317, 10, 559, 543);
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Orari");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 10, 539, 29);
		add(lblNewLabel_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(90, 49, 386, 2);
		add(separator_2);
		
		

		
		JLabel lblNewLabel = new JLabel("Linea: ");
		lblNewLabel.setBounds(178, 63, 58, 29);
		add(lblNewLabel);
		
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(90, 101, 386, 2);
		add(separator_3);
		
		JLabel lFermate = new JLabel("Fermate");
		lFermate.setBounds(121, 137, 70, 15);
		add(lFermate);
		
		JLabel lOrari = new JLabel("Orari");
		lOrari.setBounds(363, 137, 70, 15);
		add(lOrari);
		
		JTextArea textAreaFermate = new JTextArea();
		textAreaFermate.setBounds(74, 171, 184, 305);
		add(textAreaFermate);
		
		JTextArea textAreaOrari = new JTextArea();
		textAreaOrari.setBounds(309, 171, 184, 305);
		add(textAreaOrari);
		
		JComboBox comboBox = new JComboBox(db.elencoLinee());
		comboBox.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
			    String selected; 
				selected = String.valueOf(comboBox.getSelectedItem());
				
				 textAreaFermate.setText("");
				 textAreaOrari.setText("");
				
				
				try {
				 fermate = db.getFermate(selected);
				 
				 for (int i = 0; i < fermate.size(); i++) {
				 textAreaFermate.append(fermate.get(i).getCodiceFermata()+"\n");
				 textAreaOrari.append(fermate.get(i).getOrario()+"\n");
				    }
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				 
				
			
		    	
		    }
		});
		
		

	
		comboBox.setBounds(279, 65, 112, 24);
		add(comboBox);
		

		

		
	
		
		 
		
		

	}
	}

