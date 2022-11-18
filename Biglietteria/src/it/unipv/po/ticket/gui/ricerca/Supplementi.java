package it.unipv.po.ticket.gui.ricerca;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;

import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import it.unipv.po.ticket.titolo.Biglietto;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Supplementi {

	private JFrame frame;
	Biglietto biglietto = null;
	double prezzoTot=0;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
			
					Supplementi window = new Supplementi(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Supplementi(Biglietto biglietto) {
		this.biglietto = biglietto;
		initialize();
		
	}

	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 525, 670);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JTextArea textArea = new JTextArea();
		textArea.setText("①------------------❷------------------③");
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textArea.setEditable(false);
		textArea.setBackground(SystemColor.windowBorder);
		textArea.setBounds(12, 64, 491, 31);
		frame.getContentPane().add(textArea);
		
		JLabel lblNewLabel_1 = new JLabel("Soluzioni di viaggio");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNewLabel_1.setBounds(12, 35, 150, 31);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Passeggeri e supplementi");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(SystemColor.controlShadow);
		lblNewLabel_1_1.setBounds(184, 35, 150, 31);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Riepilogo e pagamento");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setForeground(SystemColor.controlShadow);
		lblNewLabel_1_2.setBounds(356, 35, 150, 31);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JButton btnIndietro = new JButton("");
		btnIndietro.setBounds(12, 0, 20, 20);
		frame.getContentPane().add(btnIndietro);
		
		JPanel panel = new JPanel();
		panel.setBounds(22, 107, 491, 515);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("Biglietto animale ");
		lblNewLabel.setBounds(33, 315, 163, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Biglietto anziano");
		lblNewLabel_2.setBounds(33, 233, 163, 15);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Biglietto bambino");
		lblNewLabel_3.setBounds(33, 160, 163, 15);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Biglietto adulto");
		lblNewLabel_4.setBounds(33, 65, 180, 42);
		panel.add(lblNewLabel_4);
		
		
		

		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(257, 54, 222, 422);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JTextArea textarea1 = new JTextArea();
		textarea1.setBounds(12, 28, 119, 71);
		panel_1.add(textarea1);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(166, 55, 44, 25);
		panel_1.add(lblNewLabel_5);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 281, 198, 2);
		panel_1.add(separator);
		
		JLabel lblPrezzoTotale = new JLabel("Prezzo totale");
		lblPrezzoTotale.setBounds(12, 295, 136, 25);
		panel_1.add(lblPrezzoTotale);
		
		JLabel labelPrezzo = new JLabel("0");
		labelPrezzo.setBounds(140, 289, 70, 15);
		panel_1.add(labelPrezzo);
		
		JButton btnNewButton = new JButton("Prosegui ⟶");
		btnNewButton.setFont( new Font("Arial", Font.BOLD, 14));
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(22, 332, 188, 59);
		panel_1.add(btnNewButton);
		
		JLabel lbladulto = new JLabel("Biglietto adulto x");
		lbladulto.setBounds(12, 148, 180, 42);
		panel_1.add(lbladulto);
		lbladulto.setVisible(false);
		
		JLabel lblbambino = new JLabel("Biglietto bambino x");
		lblbambino.setBounds(12, 202, 163, 15);
		panel_1.add(lblbambino);
		lblbambino.setVisible(false);
		
		JLabel lblanziano = new JLabel("Biglietto anziano x");
		lblanziano.setBounds(12, 176, 163, 15);
		panel_1.add(lblanziano);
		lblanziano.setVisible(false);
		
		JLabel lblBigliettoAnimaleX = new JLabel("Biglietto animale x");
		lblBigliettoAnimaleX.setBounds(12, 188, 163, 15);
		panel_1.add(lblBigliettoAnimaleX);
		lblBigliettoAnimaleX.setVisible(false);
		
		
		JLabel lblNewLabel_6 = new JLabel(" ");
		lblNewLabel_6.setBounds(152, 162, 70, 15);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel(" ");
		lblNewLabel_7.setBounds(152, 176, 70, 15);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel(" ");
		lblNewLabel_8.setBounds(152, 188, 70, 15);
		panel_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel(" ");
		lblNewLabel_9.setBounds(152, 202, 70, 15);
		panel_1.add(lblNewLabel_9);
		
		 JSpinner spinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1) );
		 JSpinner spinner_1 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
			JSpinner spinner_3 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
			JSpinner spinner_2 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		 
		 
		 
		 spinner_1.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					
					if((int)spinner_1.getValue() == 0) {
						lblbambino.setVisible(false);
						lblNewLabel_9.setText(" ");
					}
					else {
						lblbambino.setVisible(true);
						lblNewLabel_9.setText(" " + spinner_1.getValue() + " ");
					}
					
					prezzoTot= biglietto.getPrezzo() * (int)spinner.getValue() + (biglietto.getPrezzo()+2) * (int) spinner_3.getValue() + (biglietto.getPrezzo()-2) * (int) spinner_1.getValue() + (biglietto.getPrezzo()-1) * (int) spinner_2.getValue();
					labelPrezzo.setText(""+prezzoTot+"");
				}
			});
         spinner_1.setBounds(182, 147, 46, 42);
         panel.add(spinner_1);
		
		

		spinner_2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				if((int)spinner_2.getValue() == 0) {
					lblanziano.setVisible(false);
					lblNewLabel_7.setText(" ");
				}
				else {
				lblanziano.setVisible(true);
				lblNewLabel_7.setText(" " + spinner_2.getValue() + " ");
			
				}	
				
				prezzoTot= biglietto.getPrezzo() * (int)spinner.getValue() + (biglietto.getPrezzo()+2) * (int) spinner_3.getValue() + (biglietto.getPrezzo()-2) * (int) spinner_1.getValue() + (biglietto.getPrezzo()-1) * (int) spinner_2.getValue();
				labelPrezzo.setText(""+prezzoTot+"");
			}
		});
		spinner_2.setBounds(182, 220, 46, 42);
		panel.add(spinner_2);
		
	
		spinner_3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				if((int)spinner_3.getValue() == 0) {
					lblBigliettoAnimaleX.setVisible(false);
					lblNewLabel_8.setText(" ");
				}
				else {
					lblBigliettoAnimaleX.setVisible(true);
				lblNewLabel_8.setText(" " + spinner_3.getValue() + " ");
			
				
			
				}	
				
				prezzoTot= biglietto.getPrezzo() * (int)spinner.getValue() + (biglietto.getPrezzo()+2) * (int) spinner_3.getValue() + (biglietto.getPrezzo()-2) * (int) spinner_1.getValue() + (biglietto.getPrezzo()-1) * (int) spinner_2.getValue();
				labelPrezzo.setText(""+prezzoTot+"");
			}
		});
		spinner_3.setBounds(182, 302, 46, 42);
		panel.add(spinner_3);
		
		
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				if((int)spinner.getValue() == 0) {
					lbladulto.setVisible(false);
					lblNewLabel_6.setText(" ");
				}
				else {
					lbladulto.setVisible(true);
				lblNewLabel_6.setText(" " + spinner.getValue() + " ");
				
			
				
				}	
				
				prezzoTot= biglietto.getPrezzo() * (int)spinner.getValue() + (biglietto.getPrezzo()+2) * (int) spinner_3.getValue() + (biglietto.getPrezzo()-2) * (int) spinner_1.getValue() + (biglietto.getPrezzo()-1) * (int) spinner_2.getValue();
				labelPrezzo.setText(""+prezzoTot+"");
			}
		});
		spinner.setBounds(182, 66, 46, 42);
		panel.add(spinner);
		
		
		
	}
}
