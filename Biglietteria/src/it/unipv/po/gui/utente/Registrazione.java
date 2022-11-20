package it.unipv.po.gui.utente;

import java.awt.EventQueue; 

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import it.unipv.po.connessioneDB.DBwrite;
import it.unipv.po.sessione.Sessione;
import it.unipv.po.utente.Utente;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Registrazione {
	private JFrame frame;
	DBwrite db = new DBwrite();
	
	String error;
	private JTextField cognometxt;
	private JTextField nometxt;
	private JTextField emailtxt;
	private JPasswordField passwordtxt;
	
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

	public Registrazione() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 7));
		frame.setBounds(100, 100, 478, 687);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registrati");
		lblNewLabel.setFont(new Font("Arial Nova", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(163, 10, 137, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 50, 444, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 597, 444, 2);
		frame.getContentPane().add(separator_1);
		
		JButton btnCreaAccount = new JButton("Crea account");
		btnCreaAccount.setFont(new Font("Arial Nova", Font.BOLD, 11));
		btnCreaAccount.setBounds(320, 615, 114, 21);
		frame.getContentPane().add(btnCreaAccount);
		
		JLabel lblNewLabel_1 = new JLabel("Crea un account GiavaTrip e scopri un mondo di vantaggi");
		lblNewLabel_1.setFont(new Font("Arial Nova", Font.BOLD, 11));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(20, 62, 434, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Hai già un account?");
		lblNewLabel_2.setFont(new Font("Arial Nova", Font.PLAIN, 10));
		lblNewLabel_2.setBounds(163, 78, 121, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel btnAccedi = new JLabel("Accedi");
		btnAccedi.setForeground(Color.BLUE);
		btnAccedi.setFont(new Font("Arial Nova", Font.BOLD, 10));
		btnAccedi.setBounds(255, 78, 45, 13);
		frame.getContentPane().add(btnAccedi);
		
		JLabel lblNewLabel_4 = new JLabel("Attenzione: Per poter procedere alla registrazione occorre essere maggiorenni");
		lblNewLabel_4.setForeground(SystemColor.textInactiveText);
		lblNewLabel_4.setFont(new Font("Arial Nova", Font.PLAIN, 9));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(10, 93, 444, 13);
		frame.getContentPane().add(lblNewLabel_4);
		
		cognometxt = new JTextField();
		cognometxt.setFont(new Font("Arial Nova", Font.PLAIN, 10));
		cognometxt.setColumns(10);
		cognometxt.setBounds(256, 152, 164, 19);
		frame.getContentPane().add(cognometxt);
		
		JLabel lblNewLabel_5 = new JLabel("Cognome");
		lblNewLabel_5.setFont(new Font("Arial Nova", Font.PLAIN, 10));
		lblNewLabel_5.setBounds(255, 136, 97, 13);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Nome");
		lblNewLabel_5_1.setFont(new Font("Arial Nova", Font.PLAIN, 10));
		lblNewLabel_5_1.setBounds(38, 136, 97, 13);
		frame.getContentPane().add(lblNewLabel_5_1);
		
		nometxt = new JTextField();
		nometxt.setFont(new Font("Arial Nova", Font.PLAIN, 10));
		nometxt.setColumns(10);
		nometxt.setBounds(39, 152, 164, 19);
		frame.getContentPane().add(nometxt);
		
		JLabel lblNewLabel_5_2 = new JLabel("Email");
		lblNewLabel_5_2.setFont(new Font("Arial Nova", Font.PLAIN, 10));
		lblNewLabel_5_2.setBounds(38, 209, 97, 13);
		frame.getContentPane().add(lblNewLabel_5_2);
		
		emailtxt = new JTextField();
		emailtxt.setFont(new Font("Arial Nova", Font.PLAIN, 10));
		emailtxt.setColumns(10);
		emailtxt.setBounds(39, 225, 164, 19);
		frame.getContentPane().add(emailtxt);
		
		JLabel lblNewLabel_5_3 = new JLabel("Password");
		lblNewLabel_5_3.setFont(new Font("Arial Nova", Font.PLAIN, 10));
		lblNewLabel_5_3.setBounds(255, 209, 97, 13);
		frame.getContentPane().add(lblNewLabel_5_3);
		
		JTextArea dettaglipasswordtxt = new JTextArea();
		dettaglipasswordtxt.setForeground(SystemColor.textInactiveText);
		dettaglipasswordtxt.setEditable(false);
		dettaglipasswordtxt.setBackground(SystemColor.menu);
		dettaglipasswordtxt.setFont(new Font("Arial Nova", Font.PLAIN, 9));
		dettaglipasswordtxt.setText("La password deve contenere:\r\n · Lunghezza tra 8 e 20 caratteri\r\n · Almeno una letttera maiuscola\r\n · Almeno una lettera minuscola\r\n · Almeno un numero");
		dettaglipasswordtxt.setBounds(255, 254, 164, 64);
		dettaglipasswordtxt.setVisible(false);
		frame.getContentPane().add(dettaglipasswordtxt);
		
		passwordtxt = new JPasswordField();
		passwordtxt.setFont(new Font("Arial Nova", Font.PLAIN, 10));
		passwordtxt.setBounds(256, 225, 164, 19);
		frame.getContentPane().add(passwordtxt);
		
		JLabel lblNewLabel_6 = new JLabel("Consenso al trattamento dei dati personali");
		lblNewLabel_6.setFont(new Font("Arial Nova", Font.BOLD, 11));
		lblNewLabel_6.setBounds(101, 338, 262, 13);
		frame.getContentPane().add(lblNewLabel_6);
		
		JTextArea txtrAiSensiDellart = new JTextArea();
		txtrAiSensiDellart.setForeground(SystemColor.textInactiveText);
		txtrAiSensiDellart.setEditable(false);
		txtrAiSensiDellart.setBackground(SystemColor.menu);
		txtrAiSensiDellart.setFont(new Font("Arial Nova", Font.PLAIN, 9));
		txtrAiSensiDellart.setText("Ai sensi dell’art. 6.1 lett. a) del Regolamento (UE) 2016/679 (il “GDPR”) dichiaro di aver preso visione \r\ndell' INFORMATIVA SULLA PRIVACY  ed esprimo liberamente il consenso al trattamento dei miei dati \r\npersonali, anche mediante elaborazioni elettroniche, da parte di GiavaTrip S.r.l. (il Titolare) per finalità di:");
		txtrAiSensiDellart.setBounds(34, 353, 396, 38);
		frame.getContentPane().add(txtrAiSensiDellart);
		
		JCheckBox check1 = new JCheckBox("Acconsento");
		check1.setFont(new Font("Arial Nova", Font.PLAIN, 10));
		check1.setBounds(20, 463, 93, 21);
		frame.getContentPane().add(check1);
		
		JLabel lblNewLabel_7 = new JLabel("1. Vendita dei titoli di viaggio e servizi GiavaTrip ");
		lblNewLabel_7.setFont(new Font("Arial Nova", Font.BOLD, 10));
		lblNewLabel_7.setBounds(20, 401, 299, 13);
		frame.getContentPane().add(lblNewLabel_7);
		
		JTextArea txtrProfilazioneDellaClientela = new JTextArea();
		txtrProfilazioneDellaClientela.setForeground(SystemColor.textInactiveText);
		txtrProfilazioneDellaClientela.setBackground(SystemColor.menu);
		txtrProfilazioneDellaClientela.setEditable(false);
		txtrProfilazioneDellaClientela.setFont(new Font("Arial Nova", Font.PLAIN, 9));
		txtrProfilazioneDellaClientela.setText("Profilazione della clientela, per la vendita di titoli, offerte di viaggio Trenord e servizi dedicati quali effettuazione \r\nreclami, rimborsi etc.. Si ribadisce che in assenza di tale consenso non sarà possibile dare seguito alle obbligazioni \r\ncontrattualmente assunte.");
		txtrProfilazioneDellaClientela.setBounds(20, 419, 434, 38);
		frame.getContentPane().add(txtrProfilazioneDellaClientela);
		
		JLabel lblNewLabel_7_1 = new JLabel("2. Trattamento dei dati personali sensibili");
		lblNewLabel_7_1.setFont(new Font("Arial Nova", Font.BOLD, 10));
		lblNewLabel_7_1.setBounds(20, 493, 299, 13);
		frame.getContentPane().add(lblNewLabel_7_1);
		
		JTextArea txtrAiSensiDellart_1 = new JTextArea();
		txtrAiSensiDellart_1.setText("Ai sensi dell’art. 9.2 lett. a) del GDPR, presa visione dell'INFORMATIVA SULLA PRIVACY dei dati personali da \r\nparte del Titolare, esprimo liberamente il consenso al trattamento dei miei dati sensibili per finalità di conclusione \r\ned esecuzione del rapporto contrattuale con il Titolare.");
		txtrAiSensiDellart_1.setForeground(SystemColor.textInactiveText);
		txtrAiSensiDellart_1.setFont(new Font("Arial Nova", Font.PLAIN, 9));
		txtrAiSensiDellart_1.setEditable(false);
		txtrAiSensiDellart_1.setBackground(SystemColor.menu);
		txtrAiSensiDellart_1.setBounds(20, 511, 434, 38);
		frame.getContentPane().add(txtrAiSensiDellart_1);
		
		JCheckBox check2 = new JCheckBox("Acconsento");
		check2.setFont(new Font("Arial Nova", Font.PLAIN, 10));
		check2.setBounds(20, 555, 93, 21);
		frame.getContentPane().add(check2);
		
		JLabel btnIndietro = new JLabel("Idietro");
		btnIndietro.setForeground(Color.BLUE);
		btnIndietro.setFont(new Font("Arial Nova", Font.BOLD, 10));
		btnIndietro.setBounds(20, 619, 45, 13);
		frame.getContentPane().add(btnIndietro);
		
		//Azioni
		btnCreaAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String error = "";
				
				try {
					if(!check1.isSelected() && !check2.isSelected()) error = "Consenso alla privacy obbligatorio";
					
					error = Sessione.CheckRegistration(emailtxt.getText(), nometxt.getText(),cognometxt.getText(),String.valueOf(passwordtxt.getPassword()));
	
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				if(error.isEmpty()) {
					Utente utente = new Utente();
					
					utente.setName(nometxt.getText());
					utente.setPassword(String.valueOf(passwordtxt.getPassword()));
					utente.setCognome(cognometxt.getText());
					utente.setEmail(emailtxt.getText());
			
					try {
						db.aggiungiUtente(utente);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					String[] arg = {utente.getEmail(), utente.getPassword()};	
					Login.main(arg);
					frame.setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, error,"Register error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		passwordtxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				dettaglipasswordtxt.setVisible(false);
			}
			@Override
			public void focusGained(FocusEvent e) {
				dettaglipasswordtxt.setVisible(true);
			}
		});
		
		btnIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login.main(null);
				frame.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIndietro.setFont(new Font("Arial Nova", Font.PLAIN, 10));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnIndietro.setFont(new Font("Arial Nova", Font.BOLD, 10));
			}
		});
		
		btnAccedi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login.main(null);
				frame.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAccedi.setFont(new Font("Arial Nova", Font.PLAIN, 10));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAccedi.setFont(new Font("Arial Nova", Font.BOLD, 10));
			}
		});

		
	}
}
