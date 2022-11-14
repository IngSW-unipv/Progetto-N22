package it.unipv.po.ticket.gui.home;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Choice;
import javax.swing.JFormattedTextField;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Label;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;

import it.unipv.po.ticket.supporto.DBread;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Cerca extends JFrame {


	private JPanel contentPane;
	DBread leggi = new DBread();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cerca frame = new Cerca();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public Cerca() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel bar = new JPanel();
		bar.setBounds(0, 0, 222, 524);
		bar.setLayout(null);
		contentPane.add(bar);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setBounds(10, 71, 192, 63);
		bar.add(btnNewButton);
		
		JButton btnCerca = new JButton("Cerca");
		btnCerca.setBounds(10, 167, 192, 63);
		bar.add(btnCerca);
		
		JButton btnAreaPersonale = new JButton("Area personale");
		btnAreaPersonale.setBounds(10, 258, 192, 63);
		bar.add(btnAreaPersonale);
		
		JButton btnContatti = new JButton("Contatti");
		btnContatti.setBounds(10, 356, 192, 63);
		bar.add(btnContatti);
		
		JPanel searchPagePanel = new JPanel();
		searchPagePanel.setBounds(232, -19, 627, 524);
		contentPane.add(searchPagePanel);
		searchPagePanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(SystemColor.menu);
		panel.setBounds(10, 36, 284, 465);
		searchPagePanel.add(panel);
		
		JToggleButton tglBiglietto = new JToggleButton("Biglietto");
		tglBiglietto.setSelected(true);
		tglBiglietto.setBounds(10, 21, 127, 21);
		panel.add(tglBiglietto);
		
		JToggleButton tglAbbonamento = new JToggleButton("Abbonamento");
		tglAbbonamento.setBounds(147, 21, 127, 21);
		panel.add(tglAbbonamento);
		
		JComboBox comboBoxPartenza = new JComboBox(leggi.elencoFermate());
		comboBoxPartenza.setMaximumRowCount(10);
		comboBoxPartenza.setBackground(Color.WHITE);
		comboBoxPartenza.setBounds(147, 90, 103, 30);
		panel.add(comboBoxPartenza);
		
		JComboBox comboBoxArrivo = new JComboBox(leggi.elencoFermate());
		comboBoxArrivo.setMaximumRowCount(10);
		comboBoxArrivo.setBackground(Color.WHITE);
		comboBoxArrivo.setBounds(147, 157, 103, 30);
		panel.add(comboBoxArrivo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 225, 264, 2);
		panel.add(separator);
		
		JButton btnNewButton_1 = new JButton("Cerca");
		btnNewButton_1.setBounds(98, 412, 85, 21);
		panel.add(btnNewButton_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 400, 264, 2);
		panel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 52, 264, 3);
		panel.add(separator_2);
		
		JLabel lblNewLabel = new JLabel("Fermata di partenza");
		lblNewLabel.setBounds(10, 99, 148, 13);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Fermata di arrivo");
		lblNewLabel_1.setBounds(10, 166, 148, 13);
		panel.add(lblNewLabel_1);
		
		JTextArea txtCerca = new JTextArea();
		txtCerca.setBackground(SystemColor.menu);
		txtCerca.setBounds(10, 231, 264, 159);
		panel.add(txtCerca);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(304, 36, 284, 465);
		searchPagePanel.add(scrollPane);
		

		//Azioni
		
		tglBiglietto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tglBiglietto.isSelected() == true) {
					tglAbbonamento.setSelected(false);
					separator.setVisible(true);
				}
				else {
					tglAbbonamento.setSelected(true);
					separator.setVisible(false);
				}
				
			}
		});
				
		tglAbbonamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglAbbonamento.isSelected() == true) {
					tglBiglietto.setSelected(false);
					separator.setVisible(false);
				}
				else {
					tglBiglietto.setSelected(true);
					separator.setVisible(true);
				}
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = "";
				
				if(comboBoxPartenza.getSelectedItem() != "" && comboBoxArrivo.getSelectedItem() != "") {
				
					try {
						//str = corsa.cerca(comboBoxPartenza.getSelectedItem().toString(), comboBoxArrivo.getSelectedItem().toString());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					//txtDettagli.setText(str);
				}else {
					JOptionPane.showMessageDialog(null, "Fermate non selezionate","Search error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
		
	}
}
