package it.unipv.po.ticket.gui.utente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import it.unipv.po.ticket.gui.home.Acquisto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login{

	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField txtpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("image\\monkey_128.png"));
		frame.setResizable(false);
		frame.setBounds(200, 200, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login system");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(175, 22, 136, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(124, 80, 96, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(124, 134, 96, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(216, 77, 162, 19);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(216, 131, 162, 19);
		frame.getContentPane().add(txtpassword);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(199, 212, 85, 21);
		frame.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(341, 212, 85, 21);
		frame.getContentPane().add(btnExit);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(58, 212, 85, 21);
		frame.getContentPane().add(btnLogin);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 191, 466, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 45, 466, 2);
		frame.getContentPane().add(separator_1);
		
		JLabel lblNewLabel_3 = new JLabel("Sign up");
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_3.setBounds(431, 10, 45, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		//Azioni
		
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Registrazione.main(null);
				frame.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 10));
			}
		});
		
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsername.setText(null);
				txtpassword.setText(null);
			}
		});
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = txtUsername.getText();
				@SuppressWarnings("deprecation")
				String password = txtpassword.getText();			
				
				if(user.compareTo("king") == 0 && password.compareTo("12345") == 0) {
					
					txtUsername.setText(null);
					txtpassword.setText(null);
					
					Acquisto.main(null);
					frame.setVisible(false);
					
				}else {
					JOptionPane.showMessageDialog(null, "Invalid login details","Login error",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
	}
}
