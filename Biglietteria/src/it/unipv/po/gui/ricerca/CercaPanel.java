package it.unipv.po.gui.ricerca;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import it.unipv.po.connessioneDB.DBread;
import it.unipv.po.trasporto.ricerca.Ricerca;
import it.unipv.po.utente.Utente;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalTime;
import javax.swing.JSlider;

public class CercaPanel extends JPanel {
	private DBread reader = new DBread();
	private Ricerca ricerca = new Ricerca();

	/**
	 * Create the panel.
	 */
	public CercaPanel(Utente utente) {
		setLayout(null);
		setBounds(317, 10, 559, 543);
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		
		JLabel lblCerca = new JLabel("Cerca biglietto");
		lblCerca.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCerca.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerca.setBounds(10, 10, 539, 29);
		add(lblCerca);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(90, 49, 386, 2);
		add(separator_2);
		
		JComboBox comboBoxPartenza = new JComboBox();
		JComboBox comboBoxArrivo = new JComboBox();
		try {
			comboBoxPartenza.setModel(new DefaultComboBoxModel<String>(reader.elencoFermate()));
			//JComboBox comboBoxPartenza = new JComboBox(leggi.elencoFermate());
			comboBoxPartenza.setMaximumRowCount(10);
			comboBoxPartenza.setBackground(Color.WHITE);
			comboBoxPartenza.setBounds(311, 116, 103, 30);
			add(comboBoxPartenza);
			
			comboBoxArrivo.setModel(new DefaultComboBoxModel<String>(reader.elencoFermate()));
			//JComboBox comboBoxArrivo = new JComboBox(leggi.elencoFermate());
			comboBoxArrivo.setMaximumRowCount(10);
			comboBoxArrivo.setBackground(Color.WHITE);
			comboBoxArrivo.setBounds(311, 189, 103, 30);
			add(comboBoxArrivo);
		} catch(SQLException sqlExc) {
			JOptionPane.showMessageDialog(null, "Connessione fallita!","DB error",JOptionPane.ERROR_MESSAGE);
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Qualcosa non va","Generic error",JOptionPane.ERROR_MESSAGE);
		}
		
		JButton cercaBtnMain = new JButton("Cerca");
		cercaBtnMain.setFont(new Font("Dialog", Font.PLAIN, 12));
		cercaBtnMain.setBackground(SystemColor.menu);
		cercaBtnMain.setBounds(243, 437, 85, 21);
		add(cercaBtnMain);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(150, 377, 264, 2);
		add(separator_1_2);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(150, 250, 264, 3);
		add(separator_2_1);
		
		JLabel lblFermataPartenza = new JLabel("Fermata di partenza");
		lblFermataPartenza.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblFermataPartenza.setBounds(116, 124, 148, 13);
		add(lblFermataPartenza);
		
		JLabel lblFermataArrivo = new JLabel("Fermata di arrivo");
		lblFermataArrivo.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblFermataArrivo.setBounds(116, 197, 148, 13);
		add(lblFermataArrivo);
		
		JSlider orarioSlider = new JSlider();
		orarioSlider.setValue(24);
		orarioSlider.setMaximum(47);
		orarioSlider.setBounds(185, 323, 200, 22);
		add(orarioSlider);
		
		JLabel orarioPartenzatxt = new JLabel("12:00");
		orarioPartenzatxt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		orarioPartenzatxt.setBounds(141, 313, 45, 13);
		add(orarioPartenzatxt);
		
		JLabel orarioMaxtxt = new JLabel("23:59");
		orarioMaxtxt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		orarioMaxtxt.setHorizontalAlignment(SwingConstants.CENTER);
		orarioMaxtxt.setBounds(395, 313, 45, 13);
		add(orarioMaxtxt);
		
		JLabel orariotxt = new JLabel("A che ora vuoi partire?");
		orariotxt.setHorizontalAlignment(SwingConstants.CENTER);
		orariotxt.setFont(new Font("Dialog", Font.PLAIN, 13));
		orariotxt.setBounds(90, 264, 386, 13);
		add(orariotxt);
				
				cercaBtnMain.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//Controllo che siano state selezionate le fermate
						if(comboBoxPartenza.getSelectedItem() != "" && comboBoxArrivo.getSelectedItem() != "") {
							try {
								//Controllo se la ricerca non da esito nullo e quindi non esista un percorso che rispetta le indicazioni inserite
								if(ricerca.cercaEGenera(comboBoxPartenza.getSelectedItem().toString(), comboBoxArrivo.getSelectedItem().toString(), LocalTime.parse(orarioPartenzatxt.getText())).size() != 0) {
									String[] args = {comboBoxPartenza.getSelectedItem().toString(), comboBoxArrivo.getSelectedItem().toString(), orarioPartenzatxt.getText()};
									
									Viaggi.main(utente, args);
								}else JOptionPane.showMessageDialog(null, "Non è stato possibile trovare un percorso che rispettasse \nl'orario inseriro, si prega di cambiare orario e riprovare","Search error",JOptionPane.INFORMATION_MESSAGE);
								
								
							} catch (SQLException sqlExc) {
								JOptionPane.showMessageDialog(null, "Connessione fallita!","DB error",JOptionPane.ERROR_MESSAGE);
							} catch (Exception e1) {
								JOptionPane.showMessageDialog(null, "Qualcosa non va","Generic error",JOptionPane.ERROR_MESSAGE);
							}
						}else JOptionPane.showMessageDialog(null, "Fermate non selezionate","Search error",JOptionPane.ERROR_MESSAGE);
						
					}
				});
				
				orarioSlider.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent e) {
						
						int a = orarioSlider.getValue()/2;
						int b = (orarioSlider.getValue()%2)*30;	

						String str = LocalTime.of(a,b).toString();
						
						orarioPartenzatxt.setText(str);
					}
				});
		
		
	}
}
