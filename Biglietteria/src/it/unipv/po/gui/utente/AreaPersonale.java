package it.unipv.po.gui.utente;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AreaPersonale extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AreaPersonale frame = new AreaPersonale();
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
	public AreaPersonale() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 10, 240, 543);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menu");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 220, 26);
		panel.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 46, 220, 2);
		panel.add(separator);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setFont(new Font("Source Code Pro ExtraLight", Font.PLAIN, 18));
		btnNewButton.setBounds(10, 89, 220, 42);
		panel.add(btnNewButton);
		
		btnNewButton.setOpaque(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(53, 156, 131, 2);
		panel.add(separator_1);
		
		JButton btnCerca = new JButton("Cerca");
		btnCerca.setOpaque(false);
		btnCerca.setFont(new Font("Source Code Pro ExtraLight", Font.PLAIN, 18));
		btnCerca.setContentAreaFilled(false);
		btnCerca.setBorderPainted(false);
		btnCerca.setBounds(10, 191, 220, 42);
		panel.add(btnCerca);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(53, 262, 131, 2);
		panel.add(separator_1_1);
		
		JButton btnCerca_1 = new JButton("Orari");
		btnCerca_1.setOpaque(false);
		btnCerca_1.setFont(new Font("Source Code Pro ExtraLight", Font.PLAIN, 18));
		btnCerca_1.setContentAreaFilled(false);
		btnCerca_1.setBorderPainted(false);
		btnCerca_1.setBounds(10, 413, 220, 42);
		panel.add(btnCerca_1);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(53, 377, 131, 2);
		panel.add(separator_1_1_1);
		
		JButton btnCerca_1_1 = new JButton("Area Personale");
		btnCerca_1_1.setOpaque(false);
		btnCerca_1_1.setFont(new Font("Source Code Pro ExtraLight", Font.PLAIN, 18));
		btnCerca_1_1.setContentAreaFilled(false);
		btnCerca_1_1.setBorderPainted(false);
		btnCerca_1_1.setBounds(10, 296, 220, 42);
		panel.add(btnCerca_1_1);
		
		JButton btnCerca_1_1_1 = new JButton("contatti");
		btnCerca_1_1_1.setOpaque(false);
		btnCerca_1_1_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		btnCerca_1_1_1.setContentAreaFilled(false);
		btnCerca_1_1_1.setBorderPainted(false);
		btnCerca_1_1_1.setBounds(10, 507, 220, 26);
		panel.add(btnCerca_1_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(317, 10, 559, 543);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Area Personale");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 10, 539, 29);
		panel_1.add(lblNewLabel_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(90, 49, 386, 2);
		panel_1.add(separator_2);
	}
}
