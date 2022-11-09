package it.unipv.po.ticket.gui.home;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Choice;
import javax.swing.JFormattedTextField;
import java.awt.TextField;
import java.awt.Label;

public class Cerca extends JFrame {


	private JPanel contentPane;

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
	 */
	public Cerca() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 873, 552);
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
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(Cerca.class.getResource("/it/unipv/po/ticket/gui/home/bar3.png")));
		lblNewLabel_2.setBounds(0, 0, 222, 524);
		bar.add(lblNewLabel_2);
		
		JPanel searchPagePanel = new JPanel();
		searchPagePanel.setBounds(232, 0, 627, 524);
		contentPane.add(searchPagePanel);
		searchPagePanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ricerca Percorso");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(197, 10, 223, 47);
		searchPagePanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Fermata di partenza");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(54, 97, 223, 25);
		searchPagePanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Fermata di arrivo");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(54, 212, 223, 25);
		searchPagePanel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Orario di partenza");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(54, 351, 223, 25);
		searchPagePanel.add(lblNewLabel_1_1_1);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(54, 152, 169, 19);
		
		searchPagePanel.add(formattedTextField);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(54, 268, 169, 19);
		searchPagePanel.add(formattedTextField_1);
		

		
		
		
		
	}
}
