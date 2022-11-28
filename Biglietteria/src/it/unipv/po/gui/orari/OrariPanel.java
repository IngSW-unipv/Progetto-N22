package it.unipv.po.gui.orari;

import java.awt.Color; 
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import it.unipv.po.connessioneDB.DBread;
import it.unipv.po.trasporto.fermata.Fermata;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;

public class OrariPanel extends JPanel {
	ArrayList<Fermata> fermate;

	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public OrariPanel(){
		
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
		
		JComboBox comboBox = new JComboBox();
		try {
		comboBox.setModel(new DefaultComboBoxModel<String>(db.elencoLinee()));
		} catch (SQLException sqlExc) {
			JOptionPane.showMessageDialog(null, "Connessione fallita!","DB error",JOptionPane.ERROR_MESSAGE);
	    } catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Qualcosa non va","Generic error",JOptionPane.ERROR_MESSAGE);
		}
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
					
				} catch (SQLException sqlExc) {
					JOptionPane.showMessageDialog(null, "Connessione fallita!","DB error",JOptionPane.ERROR_MESSAGE);
			    } catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Qualcosa non va","Generic error",JOptionPane.ERROR_MESSAGE);
				}	    	
		    }
		});

	
		comboBox.setBounds(279, 65, 112, 24);
		add(comboBox);
		
	}
}

