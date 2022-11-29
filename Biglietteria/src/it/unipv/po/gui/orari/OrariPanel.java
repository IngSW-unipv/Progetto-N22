package it.unipv.po.gui.orari;



import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import it.unipv.po.connessioneDB.DBread;
import it.unipv.po.trasporto.fermata.Fermata;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JSlider;


public class OrariPanel extends JPanel {
	ArrayList<Fermata> fermate;

	/**
	 * Create the panel.
	 * @throws SQLException 
	 */ 
	JTextArea textAreaOrari = new JTextArea();
	JTextArea textAreaFermate = new JTextArea();
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
		separator_3.setBounds(90, 151, 386, 2);
		add(separator_3);
		
		JLabel lFermate = new JLabel("Fermate");
		lFermate.setBounds(120, 182, 70, 15);
		add(lFermate);
		
		JLabel lOrari = new JLabel("Orari");
		lOrari.setBounds(362, 182, 70, 15);
		add(lOrari);
		
	
		textAreaFermate.setBounds(74, 209, 184, 305);
		add(textAreaFermate);
		textAreaFermate.setEditable(false); 
		

		textAreaOrari.setBounds(310, 209, 184, 305);
		add(textAreaOrari);
		textAreaOrari.setEditable(false); 
		
		
		JSlider orarioSlider = new JSlider();
		orarioSlider.setValue(24);
		orarioSlider.setMaximum(47);
		orarioSlider.setBounds(177, 117, 200, 22);
		add(orarioSlider);
		
		JLabel orarioPartenzatxt = new JLabel("12:00");
		orarioPartenzatxt.setFont(new Font("Dialog", Font.PLAIN, 12));
		orarioPartenzatxt.setBounds(133, 107, 45, 13);
		add(orarioPartenzatxt);
		
		JLabel orarioMaxtxt = new JLabel("23:59");
		orarioMaxtxt.setHorizontalAlignment(SwingConstants.CENTER);
		orarioMaxtxt.setFont(new Font("Dialog", Font.PLAIN, 12));
		orarioMaxtxt.setBounds(387, 107, 45, 13);
		add(orarioMaxtxt);
		
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

					int a = orarioSlider.getValue()/2;
					int b = (orarioSlider.getValue()%2)*30;	

					String str = LocalTime.of(a,b).toString();
					
					try {
						UpdateTextArea(comboBox.getSelectedItem().toString(),str);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
					
		    }
		});

	
		comboBox.setBounds(279, 65, 112, 24);
		add(comboBox);
		

		
		
		orarioSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				int a = orarioSlider.getValue()/2;
				int b = (orarioSlider.getValue()%2)*30;	

				String str = LocalTime.of(a,b).toString();
				
				orarioPartenzatxt.setText(str);
		
				try {
					UpdateTextArea(String.valueOf(comboBox.getSelectedItem()),str);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		
		 
	}

		public void UpdateTextArea(String selected, String orario) throws SQLException {
			     DBread db = new DBread();
			
			  if(selected!="") {   
				 textAreaFermate.setText("");
				 textAreaOrari.setText("");
				
				
				try {
				 fermate = db.getFermateOrario(selected,orario);
				 
				
				 for (int i = 0; i < fermate.size(); i++) {
		
				 textAreaFermate.append(fermate.get(i).getCodiceFermata()+"\n");
				 textAreaOrari.append(fermate.get(i).getOrario()+"\n");
				    }
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Qualcosa non va","Generic error",JOptionPane.ERROR_MESSAGE);
				}
		
			  }
		}
	
		
	
}

