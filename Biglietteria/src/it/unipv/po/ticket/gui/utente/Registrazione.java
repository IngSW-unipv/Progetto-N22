package it.unipv.po.ticket.gui.utente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registrazione {

	private JFrame frame;
	private Image img;
	private Image newImage;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registrazione window = new Registrazione();
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
	public Registrazione() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 478, 556);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register system");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(163, 27, 137, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 50, 444, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 454, 444, 2);
		frame.getContentPane().add(separator_1);
		
		JButton btnNewButton = new JButton("Conferma");
		btnNewButton.setBounds(43, 476, 97, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.setBounds(183, 476, 97, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.setBounds(323, 476, 97, 21);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		
		this.img = new ImageIcon("image\\freccia.png").getImage();
		this.newImage = img.getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		
		btnNewButton_3.setIcon(new ImageIcon(this.newImage));
		btnNewButton_3.setBounds(10, 10, 20, 20);
		frame.getContentPane().add(btnNewButton_3);
		
		//Azioni
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				frame.setVisible(false);
			}
		});
		
	}
}
