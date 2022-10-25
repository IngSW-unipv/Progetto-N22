package it.unipv.po.ticket.gui.utente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import it.unipv.po.ticket.supporto.DBconnection;

import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class Registrazione {
//facadecontroller
	private JFrame frame;
	private Image img;
	private Image newImage;
	private JTextField txtpassword;
	private JTextField txtemail;
	private JTextField txtnome;
	private JTextField txtcognome;
	private JTextField txtusername;
	private JTextField txttelefono;
	private JPasswordField txtconferma;
	
	String error;
	
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
		
		JButton btnNewButton = new JButton("->");
		btnNewButton.setBounds(182, 476, 97, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.setBounds(38, 476, 97, 21);
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
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(166, 266, 207, 19);
		frame.getContentPane().add(txtpassword);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(57, 64, 70, 15);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(57, 145, 70, 15);
		frame.getContentPane().add(lblNome);
		
		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setBounds(57, 189, 70, 15);
		frame.getContentPane().add(lblCognome);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(57, 230, 70, 15);
		frame.getContentPane().add(lblTelefono);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(57, 270, 70, 15);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblConfermaPassword = new JLabel("Conferma ");
		lblConfermaPassword.setBounds(57, 297, 91, 15);
		frame.getContentPane().add(lblConfermaPassword);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(57, 107, 91, 15);
		frame.getContentPane().add(lblUsername);
		
		txtemail = new JTextField();
		txtemail.setBounds(166, 60, 207, 19);
		frame.getContentPane().add(txtemail);
		txtemail.setColumns(10);
		
		txtnome = new JTextField();
		txtnome.setBounds(166, 141, 207, 19);
		frame.getContentPane().add(txtnome);
		txtnome.setColumns(10);
		
		txtcognome = new JTextField();
		txtcognome.setBounds(166, 185, 207, 19);
		frame.getContentPane().add(txtcognome);
		txtcognome.setColumns(10);
		
		txtusername = new JTextField();
		txtusername.setBounds(166, 103, 207, 19);
		frame.getContentPane().add(txtusername);
		txtusername.setColumns(10);
		
		txttelefono = new JTextField();
		txttelefono.setBounds(166, 224, 207, 19);
		frame.getContentPane().add(txttelefono);
		txttelefono.setColumns(10);
		
		txtconferma = new JPasswordField();
		txtconferma.setBounds(166, 306, 207, 19);
		frame.getContentPane().add(txtconferma);
		
		JCheckBox agreement = new JCheckBox("Accetto termini e condizioni.");
		agreement.setBounds(99, 374, 302, 23);
		frame.getContentPane().add(agreement);
		
		JLabel lblPassword_1 = new JLabel("password");
		lblPassword_1.setBounds(57, 310, 70, 15);
		frame.getContentPane().add(lblPassword_1);
		
		JLabel txterrore = new JLabel("Errore");
		txterrore.setVisible(false);
		txterrore.setBounds(34, 413, 420, 15);
		frame.getContentPane().add(txterrore);
		
		//Azioni
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				frame.setVisible(false);
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			error=Sessione.CheckRegistration(txtemail.getText(),txtusername.getText(),txtnome.getText(),txtcognome.getText(),txttelefono.getText(),txtpassword.getText(),txtconferma.getText());
				
			
			
			
			if(error.isEmpty()) {
				try {
					DBconnection.UserRegistration(txtusername.getText(), txtpassword.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Login.main(null);
				frame.setVisible(false);
			} 
			
			else {
				   txterrore.setText(error);
				   txterrore.setVisible(true);
			}
			  
		
				
			
			
			}
		});

		
	}
}
