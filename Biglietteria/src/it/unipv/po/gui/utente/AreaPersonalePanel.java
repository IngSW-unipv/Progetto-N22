package it.unipv.po.gui.utente;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import it.unipv.po.utente.Utente;

import javax.swing.JButton;
import javax.swing.JTextField;

public class AreaPersonalePanel extends JPanel {
	private DatiPanel datiPanel;
	

	/**
	 * Create the panel.
	 */
	public AreaPersonalePanel(Utente utente) {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setBounds(317, 10, 559, 543);
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("AreaPersonale");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 10, 539, 29);
		add(lblNewLabel_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(90, 49, 386, 2);
		add(separator_2);
		
		JButton btnNewButton = new JButton("Dati Utente");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(109, 81, 116, 21);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Titoli");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBounds(343, 81, 116, 21);
		
		add(btnNewButton_1);
		
		datiPanel = new DatiPanel(utente);
		add(datiPanel);
		
		
	}
}
