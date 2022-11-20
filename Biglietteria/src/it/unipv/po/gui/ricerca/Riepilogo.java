package it.unipv.po.gui.ricerca;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import it.unipv.po.trasporto.titolo.Biglietto;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.ComponentOrientation;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class Riepilogo {
	private JFrame frame;
	private DecimalFormat df = new DecimalFormat("0.00");
	private static ArrayList<Biglietto> biglietto;
	
	private JTextField txtAlessandro;
	private JTextField txtAlbertini;
	private JTextField txtAlealbertinigmailcom;
	
	private static JTextArea dettaglitxt;
	private static JLabel totalePrezzotxt;
	private static JTextArea bigliettitxt;
	private static JTextArea prezzitxt;
	private static JRadioButton rdbtnCreditcard;
	private static JRadioButton rdbtnVisa;
	private static JRadioButton rdbtnPaypal;
	private static JRadioButton rdbtnPostepay;

	/**
	 * Launch the application.
	 * @param prezzo 
	 * @param passeggero 
	 */
	public static void main(ArrayList<Biglietto> biglietti, String passeggero, String prezzo) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Riepilogo window = new Riepilogo(biglietti, passeggero, prezzo);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Riepilogo(ArrayList<Biglietto> biglietti, String passeggero, String prezzo) {
		biglietto = biglietti;
		
		initialize();
		setGraficaBiglietto(passeggero, prezzo);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 525, 632);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("①------------------②------------------❸");
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textArea.setEditable(false);
		textArea.setBackground(SystemColor.menu);
		textArea.setBounds(10, 69, 491, 31);
		frame.getContentPane().add(textArea);
		
		JLabel lblNewLabel_1_1 = new JLabel("Passeggeri e supplementi");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(SystemColor.controlShadow);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1_1.setBounds(180, 40, 150, 31);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Riepilogo e pagamento");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setForeground(SystemColor.desktop);
		lblNewLabel_1_2.setBounds(356, 40, 150, 31);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		Image img = new ImageIcon("image\\freccia.png").getImage();
		Image newImage = img.getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		
		JButton btnIndietro = new JButton("");
		btnIndietro.setBounds(10, 5, 20, 20);
		btnIndietro.setIcon(new ImageIcon(newImage));
		frame.getContentPane().add(btnIndietro);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 110, 491, 479);
		frame.getContentPane().add(panel);
		
		JPanel panelProfilo = new JPanel();
		panelProfilo.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panelProfilo.setBounds(9, 51, 229, 117);
		panel.add(panelProfilo);
		panelProfilo.setLayout(null);
		
		JPanel panelBiglietto = new JPanel();
		panelBiglietto.setLayout(null);
		panelBiglietto.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelBiglietto.setBackground(SystemColor.controlHighlight);
		panelBiglietto.setBounds(259, 51, 222, 277);
		panel.add(panelBiglietto);
		
		JPanel panelPunti = new JPanel();
		panelPunti.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelPunti.setBounds(9, 213, 229, 81);
		panel.add(panelPunti);
		panelPunti.setLayout(null);
		
		JPanel panelCarta = new JPanel();
		panelCarta.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelCarta.setBounds(9, 361, 229, 49);
		panel.add(panelCarta);
		panelCarta.setLayout(null);
		
		JPanel panelPaypall = new JPanel();
		panelPaypall.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelPaypall.setBounds(9, 420, 229, 49);
		panel.add(panelPaypall);
		panelPaypall.setLayout(null);
		
		JPanel panelAmericaExpress = new JPanel();
		panelAmericaExpress.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelAmericaExpress.setBounds(252, 361, 229, 49);
		panel.add(panelAmericaExpress);
		panelAmericaExpress.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 185, 198, 2);
		panelBiglietto.add(separator);
		
		JLabel lblPrezzoTotale = new JLabel("Totale da pagare:");
		lblPrezzoTotale.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrezzoTotale.setBounds(12, 197, 119, 25);
		panelBiglietto.add(lblPrezzoTotale);
		
		JPanel panelAmericaExpress_1 = new JPanel();
		panelAmericaExpress_1.setLayout(null);
		panelAmericaExpress_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelAmericaExpress_1.setBounds(252, 420, 229, 49);
		panel.add(panelAmericaExpress_1);
		
		dettaglitxt = new JTextArea();
		dettaglitxt.setEditable(false);
		dettaglitxt.setText("🚍\r\n⦿ <dynamic>\r\n ¦\r\n⦿ <dynamic>");
		dettaglitxt.setBackground(SystemColor.controlHighlight);
		dettaglitxt.setBounds(12, 10, 119, 71);
		panelBiglietto.add(dettaglitxt);
		
		totalePrezzotxt = new JLabel("");
		totalePrezzotxt.setHorizontalAlignment(SwingConstants.CENTER);
		totalePrezzotxt.setFont(new Font("Tahoma", Font.BOLD, 12));
		totalePrezzotxt.setBounds(140, 202, 70, 15);
		panelBiglietto.add(totalePrezzotxt);
		
		bigliettitxt = new JTextArea();
		bigliettitxt.setText("");
		bigliettitxt.setBackground(SystemColor.controlHighlight);
		bigliettitxt.setBounds(29, 91, 119, 84);
		panelBiglietto.add(bigliettitxt);
		
		prezzitxt = new JTextArea();
		prezzitxt.setText("");
		prezzitxt.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		prezzitxt.setBackground(SystemColor.controlHighlight);
		prezzitxt.setBounds(158, 91, 54, 84);
		panelBiglietto.add(prezzitxt);
		
		JButton btnAcquista = new JButton("Acquista");
		btnAcquista.setBorder(new RoundedBorder(10));
		btnAcquista.setBounds(68, 232, 85, 21);
		panelBiglietto.add(btnAcquista);
		
		JLabel lblNewLabel_4 = new JLabel("INSERISCI DATI ACQUIRENTE");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setBounds(9, 28, 176, 20);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("IL TUO BIGLIETTO");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_6.setBounds(259, 28, 146, 20);
		panel.add(lblNewLabel_6);	
		
		txtAlessandro = new JTextField();
		txtAlessandro.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtAlessandro.setText("ALESSANDRO");
		txtAlessandro.setEnabled(false);
		txtAlessandro.setEditable(false);
		txtAlessandro.setBounds(10, 21, 96, 25);
		panelProfilo.add(txtAlessandro);
		txtAlessandro.setColumns(10);
		
		txtAlbertini = new JTextField();
		txtAlbertini.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtAlbertini.setText("ALBERTINI");
		txtAlbertini.setEnabled(false);
		txtAlbertini.setEditable(false);
		txtAlbertini.setColumns(10);
		txtAlbertini.setBounds(123, 21, 96, 25);
		panelProfilo.add(txtAlbertini);
		
		txtAlealbertinigmailcom = new JTextField();
		txtAlealbertinigmailcom.setText("ale.albertini2000@gmail.com");
		txtAlealbertinigmailcom.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtAlealbertinigmailcom.setBackground(SystemColor.menu);
		txtAlealbertinigmailcom.setColumns(10);
		txtAlealbertinigmailcom.setBounds(10, 73, 209, 25);
		panelProfilo.add(txtAlealbertinigmailcom);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblNewLabel.setEnabled(false);
		lblNewLabel.setBounds(10, 9, 45, 13);
		panelProfilo.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cognome");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblNewLabel_1.setEnabled(false);
		lblNewLabel_1.setBounds(125, 9, 45, 13);
		panelProfilo.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email*");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblNewLabel_2.setBounds(10, 61, 45, 13);
		panelProfilo.add(lblNewLabel_2);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Utilizza il tuo credito residuo");
		chckbxNewCheckBox_1.setBounds(6, 6, 217, 21);
		panelPunti.add(chckbxNewCheckBox_1);
		
		JTextArea txtrHaiADisposizione = new JTextArea();
		txtrHaiADisposizione.setBackground(SystemColor.menu);
		txtrHaiADisposizione.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtrHaiADisposizione.setText("Hai a disposizione 0,00 € (salda l'eventuale \r\ndifferenza con un altro metodo di pagamento)\r\n\r\n");
		txtrHaiADisposizione.setBounds(6, 33, 213, 38);
		panelPunti.add(txtrHaiADisposizione);
		
		JLabel lblNewLabel_3 = new JLabel("SCEGLI IL METODO DI PAGAMENTO");
		lblNewLabel_3.setBounds(9, 190, 229, 13);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Scegli come saldare la differenza");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(134, 342, 222, 13);
		panel.add(lblNewLabel_5);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(9, 349, 125, 2);
		panel.add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(356, 349, 125, 2);
		panel.add(separator_1_1);
		
		rdbtnCreditcard = new JRadioButton("Creditcard");
		rdbtnCreditcard.setSelected(true);
		rdbtnCreditcard.setBounds(6, 14, 174, 21);
		panelCarta.add(rdbtnCreditcard);
		
		rdbtnVisa = new JRadioButton("Visa");
		rdbtnVisa.setBounds(6, 14, 175, 21);
		panelAmericaExpress.add(rdbtnVisa);
		
		rdbtnPostepay = new JRadioButton("Postepay");
		rdbtnPostepay.setBounds(6, 14, 103, 21);
		panelPaypall.add(rdbtnPostepay);
		
		rdbtnPaypal = new JRadioButton("Paypal");
		rdbtnPaypal.setBounds(6, 14, 175, 21);
		panelAmericaExpress_1.add(rdbtnPaypal);		
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Soluzioni viaggio");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1.setForeground(SystemColor.controlShadow);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1_1_1.setBounds(10, 40, 150, 31);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		//Azioni
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//permette di tornare una pagina indietro alla pressione del tasto
				
				try {
					Supplementi.main(biglietto.get(0));
					frame.setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		rdbtnCreditcard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(rdbtnCreditcard.isSelected() == true) {
					rdbtnVisa.setSelected(false);
					rdbtnPostepay.setSelected(false);
					rdbtnPaypal.setSelected(false);
				}
				
			}
		});
		
		rdbtnVisa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(rdbtnVisa.isSelected() == true) {
					rdbtnCreditcard.setSelected(false);
					rdbtnPostepay.setSelected(false);
					rdbtnPaypal.setSelected(false);
				}
				
			}
		});
		
		rdbtnPostepay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(rdbtnPostepay.isSelected() == true) {
					rdbtnVisa.setSelected(false);
					rdbtnCreditcard.setSelected(false);
					rdbtnPaypal.setSelected(false);
				}
				
			}
		});
		
		rdbtnPaypal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(rdbtnPaypal.isSelected() == true) {
					rdbtnVisa.setSelected(false);
					rdbtnPostepay.setSelected(false);
					rdbtnCreditcard.setSelected(false);
				}
				
			}
		});
		
		btnAcquista.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(btnAcquista.getBackground() == Color.LIGHT_GRAY) btnAcquista.setBackground(UIManager.getColor("control"));
				else btnAcquista.setBackground(Color.LIGHT_GRAY);
			}
		});
		
	}
	
	private void setGraficaBiglietto(String passeggero, String prezzo) {
		
		String dettagliotxt = "🚍\n⦿ "+ biglietto.get(0).getPercorso().get(0).getCodiceFermata() +"\n ¦\n⦿ "+ biglietto.get(0).getPercorso().get(biglietto.get(0).getPercorso().size()-1).getCodiceFermata();
		
		double totale = 0;
		
		for(Biglietto n : biglietto) {
			totale += n.getPrezzo();
		}

		dettaglitxt.setText(dettagliotxt);
		bigliettitxt.setText(passeggero);
		prezzitxt.setText(prezzo);
		totalePrezzotxt.setText(String.valueOf(df.format(totale)) +" €");
		
	}
}
