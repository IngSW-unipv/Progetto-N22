package it.unipv.po.ticket.gui.ricerca;

import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import it.unipv.po.ticket.titolo.Biglietto;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JSeparator;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Supplementi {

	private JFrame frame;
	private Biglietto biglietto;
	private String[] passeggeri = {"","","",""};
	private String[] prezzi = {"","","",""};
	private DecimalFormat df=new DecimalFormat("0.00");
	private static JTextArea dettaglitxt;
	private static JLabel totalePrezzotxt;
	private static JTextArea bigliettitxt;
	private static JTextArea prezzitxt;
	
	public static void main(Biglietto bigliettoSelezionato) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Supplementi window = new Supplementi(bigliettoSelezionato);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Supplementi(Biglietto bigliettoSelezionato) {
		biglietto = bigliettoSelezionato;
		initialize();
		setGraficaRicerca();
	
	}

	private void initialize() {
		frame = new JFrame();
		
		frame.setBounds(100, 100, 525, 494);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("①------------------❷------------------③");
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textArea.setEditable(false);
		textArea.setBackground(SystemColor.menu);
		textArea.setBounds(10, 64, 491, 31);
		frame.getContentPane().add(textArea);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Soluzioni di viaggio");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_1.setForeground(SystemColor.controlShadow);
		lblNewLabel_1_2_1.setBounds(10, 35, 150, 31);
		frame.getContentPane().add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Passeggeri e supplementi");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(SystemColor.desktop);
		lblNewLabel_1_1.setBounds(180, 35, 150, 31);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Riepilogo e pagamento");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setForeground(SystemColor.controlShadow);
		lblNewLabel_1_2.setBounds(356, 35, 150, 31);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		Image img = new ImageIcon("image\\freccia.png").getImage();
		Image newImage = img.getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		
		JButton btnIndietro = new JButton("");
		btnIndietro.setBounds(10, 5, 20, 20);
		btnIndietro.setIcon(new ImageIcon(newImage));
		frame.getContentPane().add(btnIndietro);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(12, 105, 491, 341);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
	
		JPanel bigliettopanel = new JPanel();
		bigliettopanel.setBackground(SystemColor.controlHighlight);
		bigliettopanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		bigliettopanel.setBounds(249, 51, 222, 277);
		panel.add(bigliettopanel);
		bigliettopanel.setLayout(null);
		
		JButton btnProsegui = new JButton("Prosegui");
		btnProsegui.setBounds(56, 232, 119, 33);
		btnProsegui.setBorder(new RoundedBorder(10));
		bigliettopanel.add(btnProsegui);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 185, 198, 2);
		bigliettopanel.add(separator);
				
		JLabel lblNewLabel_4 = new JLabel("Passegeri");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setBounds(9, 28, 90, 20);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("Il tuo biglietto");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_6.setBounds(249, 28, 90, 20);
		panel.add(lblNewLabel_6);
		
		JLabel lblPrezzoTotale = new JLabel("Totale da pagare:");
		lblPrezzoTotale.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrezzoTotale.setBounds(12, 197, 119, 25);
		bigliettopanel.add(lblPrezzoTotale);	
		
		JPanel panel1 = new JPanel();
		panel1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel1.setBounds(9, 51, 230, 56);
		panel.add(panel1);
		panel1.setLayout(null);
		JPanel panel2 = new JPanel();
		panel2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel2.setBounds(9, 117, 230, 56);
		panel.add(panel2);
		panel2.setLayout(null);
		JSpinner spinnerBambino = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		spinnerBambino.setBounds(173, 13, 40, 30);
		panel2.add(spinnerBambino);
		JPanel panel3 = new JPanel();
		panel3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel3.setBounds(9, 183, 230, 56);
		panel.add(panel3);
		panel3.setLayout(null);
		JSpinner spinnerAnziano = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		spinnerAnziano.setBounds(173, 13, 40, 30);
		panel3.add(spinnerAnziano);	
		JPanel panel4 = new JPanel();
		panel4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel4.setBounds(9, 249, 230, 56);
		panel.add(panel4);
		panel4.setLayout(null);
		JSpinner spinnerAnimale = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		spinnerAnimale.setBounds(173, 13, 40, 30);
		panel4.add(spinnerAnimale);
		JSpinner spinnerAdulto = new JSpinner(new SpinnerNumberModel(1, 0, 100, 1) );
		spinnerAdulto.setBounds(173, 13, 40, 30);
		panel1.add(spinnerAdulto);
		
		JLabel lblNewLabel_3_1 = new JLabel("Biglietto adulto");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_1.setBounds(10, 17, 136, 22);
		panel1.add(lblNewLabel_3_1);	
		JLabel lblNewLabel_3 = new JLabel("Biglietto bambino");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setBounds(10, 15, 136, 25);
		panel2.add(lblNewLabel_3);
		JLabel lblNewLabel_2 = new JLabel("Biglietto anziano");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(10, 15, 136, 25);
		panel3.add(lblNewLabel_2);		
		JLabel lblNewLabel = new JLabel("Biglietto animale ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(10, 15, 136, 25);
		panel4.add(lblNewLabel);

		dettaglitxt = new JTextArea();
		dettaglitxt.setBackground(SystemColor.controlHighlight);
		dettaglitxt.setBounds(12, 10, 119, 71);
		bigliettopanel.add(dettaglitxt);
		
		totalePrezzotxt = new JLabel("");
		totalePrezzotxt.setFont(new Font("Tahoma", Font.BOLD, 12));
		totalePrezzotxt.setHorizontalAlignment(SwingConstants.CENTER);
		totalePrezzotxt.setBounds(166, 202, 44, 15);
		bigliettopanel.add(totalePrezzotxt);
		
		bigliettitxt = new JTextArea();
		bigliettitxt.setBackground(SystemColor.controlHighlight);
		bigliettitxt.setBounds(29, 91, 119, 84);
		bigliettopanel.add(bigliettitxt);
		
		prezzitxt = new JTextArea();
		prezzitxt.setBackground(SystemColor.controlHighlight);
		prezzitxt.setBounds(158, 91, 54, 84);
		prezzitxt.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);;
		bigliettopanel.add(prezzitxt);
		
		//Azioni
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//permette di tornare una pagina indietro alla pressione del tasto
				Cerca.main(null);
				frame.setVisible(false);
			}
		});
		
		spinnerAdulto.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int myint = (Integer) spinnerAdulto.getValue();
				
				if(myint != 0) {
					passeggeri[0] = " • "+ spinnerAdulto.getValue() +" Biglietto adulto";
					prezzi[0] = df.format(biglietto.getPrezzo()*myint);
				}else  {
					passeggeri[0]= "";
					prezzi[0] = "";
				}
					
				aggiornaBiglietti();
				aggiornaPrezzi();
			}
		});
		
		spinnerBambino.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int myint = (Integer) spinnerBambino.getValue();
				
				if(myint != 0) {
					passeggeri[1] = " • "+ spinnerBambino.getValue() +" Biglietto bambino";
					prezzi[1] = df.format(biglietto.getPrezzo()*myint*0.5);
				}else  {
					passeggeri[1]= "";
					prezzi[1] = "";
				}
				aggiornaBiglietti();
				aggiornaPrezzi();
			}
		});
		
		spinnerAnziano.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int myint = (Integer) spinnerAnziano.getValue();
				
				if(myint != 0) {
					passeggeri[2] = " • "+ spinnerAnziano.getValue() +" Biglietto anziano";
					prezzi[2] = df.format(biglietto.getPrezzo()*myint*0.8);
				}else  {
					passeggeri[2]= "";
					prezzi[2] = "";
				}
					
				aggiornaBiglietti();
				aggiornaPrezzi();
			}
		});
		
		spinnerAnimale.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int myint = (Integer) spinnerAnimale.getValue();
				 //formato per il prezzo con due decimali
				
				if(myint != 0) {
					passeggeri[3] = " • "+ spinnerAnimale.getValue() +" Biglietto animale";
					prezzi[3] = df.format(biglietto.getPrezzo()*myint*0.6);
				}else  {
					passeggeri[3]= "";
					prezzi[3] = "";
				}
					
				aggiornaBiglietti();
				aggiornaPrezzi();
			}
		});
		
		btnProsegui.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<Biglietto> b = new ArrayList<Biglietto>();
				ArrayList<Integer> spinner = new ArrayList<Integer>();
				int adulto = (Integer) spinnerAdulto.getValue();
				int bambino = (Integer) spinnerBambino.getValue();
				int anziano = (Integer) spinnerAnziano.getValue();
				int animale = (Integer) spinnerAnimale.getValue();
				
				spinner.add((Integer) spinnerAdulto.getValue()); 
				spinner.add((Integer) spinnerBambino.getValue()); 
				spinner.add((Integer) spinnerAnziano.getValue()); 
				spinner.add((Integer) spinnerAnimale.getValue()); 
				
				if((bambino != 0 || animale != 0) && (adulto == 0 && anziano == 0)) JOptionPane.showMessageDialog(null, "Minori e animali non posso viaggiare senza un maturo","Search error",JOptionPane.ERROR_MESSAGE);
				else if(adulto != 0 || anziano != 0){
					for(int i = 0; i < 4; i++) {		
						for(int j = 0; j < spinner.get(i); j++) {
							biglietto.setPasseggero(passeggeri[i].replace(" • "+ spinner.get(i) +" Biglietto ", ""));
							biglietto.setPrezzo(Double.valueOf(prezzi[i].replace(",", "."))/spinner.get(i));
							b.add(biglietto);
						}	
					}
				}
				
				Riepilogo.main(b);
				frame.setVisible(false);
			}
		});
		
	}
	
	public void aggiornaBiglietti() {
		String str = "";
		for(int i = 0; i < 4; i++) if(passeggeri[i] != null && passeggeri[i] != "") str += passeggeri[i] +"\n";
			
		bigliettitxt.setText(str);
	}
	
	public void aggiornaPrezzi() {
		String str = "";
		double totale = 0;
		
		for(int i = 0; i < 4; i++) if(prezzi[i] != null && prezzi[i] != "") {
			str += prezzi[i] +" €\n";	
			totale += Double.valueOf(prezzi[i].replace(",", "."));
			
		}
		
		prezzitxt.setText(str);
		totalePrezzotxt.setText(String.valueOf(df.format(totale)) + " €");
	}
	
	private void setGraficaRicerca() {
		
		String dettagliotxt = "🚍\n⦿ "+ biglietto.getPercorso().get(0).getCodiceFermata() +"\n ¦\n⦿ "+ biglietto.getPercorso().get(biglietto.getPercorso().size()-1).getCodiceFermata();
		String passeggeritxt = " • 1 Biglietto adulto";
		
		dettaglitxt.setText(dettagliotxt);
		
		passeggeri[0] = passeggeritxt;
		prezzi[0] = String.valueOf(df.format(biglietto.getPrezzo()));;
		
		aggiornaBiglietti();
		aggiornaPrezzi();
	}
}
