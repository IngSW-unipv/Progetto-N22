package it.unipv.po.gui.utente;

import java.awt.EventQueue;  
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import it.unipv.po.gui.home.AppFrame;
import it.unipv.po.sessione.CredenzialiErrateException;
import it.unipv.po.sessione.Sessione;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class Login{

	private JFrame frame;
	private JTextField emailtxt;
	private JPasswordField passwordtxt;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login(args);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login(String[] args) {	
		initialize(args);
	}

	private void initialize(String[] args) {
		frame = new JFrame();

		frame.setResizable(false);
		frame.setBounds(200, 200, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Accedi");
		lblNewLabel.setFont(new Font("Arial Nova", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(175, 10, 136, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setFont(new Font("Arial Nova", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(124, 80, 96, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Arial Nova", Font.PLAIN, 10));
		lblNewLabel_2.setBounds(124, 134, 96, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		emailtxt = new JTextField();
		emailtxt.setFont(new Font("Arial Nova", Font.PLAIN, 10));
		emailtxt.setBounds(216, 77, 162, 19);
	    if(args!=null && args.length == 2) emailtxt.setText(args[0]);
		frame.getContentPane().add(emailtxt);
		
		passwordtxt = new JPasswordField();
		passwordtxt.setFont(new Font("Arial Nova", Font.PLAIN, 10));
		passwordtxt.setBounds(216, 131, 162, 19);
		if(args!=null && args.length == 2) passwordtxt.setText(args[1]);
		frame.getContentPane().add(passwordtxt);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Arial Nova", Font.BOLD, 11));
		btnReset.setBounds(199, 212, 85, 21);
		frame.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Arial Nova", Font.BOLD, 11));
		btnExit.setBounds(341, 212, 85, 21);
		frame.getContentPane().add(btnExit);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Arial Nova", Font.BOLD, 11));
		btnLogin.setBounds(58, 212, 85, 21);
		frame.getContentPane().add(btnLogin);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 191, 466, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 45, 466, 2);
		frame.getContentPane().add(separator_1);
		
		JLabel btnRegistrati = new JLabel("Sign up");
		btnRegistrati.setForeground(Color.BLUE);
		btnRegistrati.setFont(new Font("Arial Nova", Font.BOLD, 10));
		btnRegistrati.setBounds(431, 10, 45, 13);
		frame.getContentPane().add(btnRegistrati);
		
		//Azioni
		
		btnRegistrati.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Registrazione.main(null);
				frame.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRegistrati.setFont(new Font("Arial Nova", Font.PLAIN, 10));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnRegistrati.setFont(new Font("Arial Nova", Font.BOLD, 10));
			}
		});
		
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				emailtxt.setText(null);
				passwordtxt.setText(null);
			}
		});
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sessione sessione = new Sessione();
				String email = emailtxt.getText();
				String password = String.valueOf(passwordtxt.getPassword());	
				
				try {
					if(!email.isEmpty() && !password.isEmpty()) {
								AppFrame.main(sessione.UserLogin(email,password));
								frame.setVisible(false);
					} else JOptionPane.showMessageDialog(null, "Invalid login details","Login error",JOptionPane.ERROR_MESSAGE);
				
				} catch (SQLException sqlExc) {
					JOptionPane.showMessageDialog(null, "Connessione fallita!","DB error",JOptionPane.ERROR_MESSAGE);
			    } catch (CredenzialiErrateException cErr) {
					JOptionPane.showMessageDialog(null, "Credenziali errate","Login error",JOptionPane.ERROR_MESSAGE);
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Qualcosa non va","Generic error",JOptionPane.ERROR_MESSAGE);
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
