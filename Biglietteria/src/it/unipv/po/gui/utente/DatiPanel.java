package it.unipv.po.gui.utente;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import it.unipv.po.utente.Utente;

public class DatiPanel extends JPanel {
	private JTextField nometxt;
	private JTextField cognometxt;
	private JTextField emailtxt;
	private JTextField creditotxt;

	/**
	 * Create the panel.
	 */
	public DatiPanel(Utente utente) {
		setLocation(10, 129);
		setSize(539, 391);
		setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(90, 56, 78, 21);
		add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Cognome:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(90, 120, 78, 21);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("E-Mail:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(90, 182, 78, 21);
		add(lblNewLabel_3);
		
		
		JLabel lblNewLabel_5 = new JLabel("Credito:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(90, 248, 78, 21);
		add(lblNewLabel_5);
		
		nometxt = new JTextField();
		nometxt.setEnabled(false);
		nometxt.setEditable(false);
		nometxt.setBounds(209, 59, 149, 19);
		add(nometxt);
		nometxt.setColumns(10);
		nometxt.setText(utente.getName());
		
		cognometxt = new JTextField();
		cognometxt.setEnabled(false);
		cognometxt.setEditable(false);
		cognometxt.setColumns(10);
		cognometxt.setBounds(209, 123, 149, 19);
		add(cognometxt);
		cognometxt.setText(utente.getCognome());
		
		emailtxt = new JTextField();
		emailtxt.setEnabled(false);
		emailtxt.setEditable(false);
		emailtxt.setColumns(10);
		emailtxt.setBounds(209, 185, 149, 19);
		add(emailtxt);
		emailtxt.setText(utente.getEmail());
		
		
		creditotxt = new JTextField();
		creditotxt.setEnabled(false);
		creditotxt.setEditable(false);
		creditotxt.setColumns(10);
		creditotxt.setBounds(209, 251, 149, 19);
		add(creditotxt);
		creditotxt.setText(""+utente.getCredito());
	}

}
