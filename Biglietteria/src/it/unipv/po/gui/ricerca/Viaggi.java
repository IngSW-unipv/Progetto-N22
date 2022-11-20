package it.unipv.po.gui.ricerca;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import it.unipv.po.trasporto.titolo.Biglietto;
import it.unipv.po.trasporto.fermata.Fermata;
import it.unipv.po.trasporto.ricerca.Ricerca;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.time.LocalTime;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Viaggi extends JFrame {

	private JFrame frame;
	private Ricerca corsa = new Ricerca();
	private static ArrayList<Biglietto> biglietti;
	
	private static ArrayList<JRadioButton> radioButton = new ArrayList<JRadioButton>();
	private static ArrayList<JTextArea> autobustxt = new ArrayList<JTextArea>();
	private static ArrayList<JTextArea> orariotxt = new ArrayList<JTextArea>();
	private static ArrayList<JTextArea> fermatetxt = new ArrayList<JTextArea>();
	private static ArrayList<JButton> btnPrezzo = new ArrayList<JButton>();
	
	private static JTextArea textArea;
	private static JButton btnIndietro;

	public static void main(ArrayList<Biglietto> bigliettiTrovati) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Viaggi window = new Viaggi(bigliettiTrovati);
					window.frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

	public Viaggi(ArrayList<Biglietto> bigliettiTrovati) throws Exception {
		biglietti = bigliettiTrovati;
		initialize();
		
		//Metodo per l'inizializzazione dell'interfaccia
		//riempie le celle con le informazioni riguardanti le varie tratte trovate dalla ricerca
		setGraficaRicerca();
	}
	
	
	
	private void initialize() {
		frame = new JFrame();
		
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 525, 670);
		frame.getContentPane().setLayout(null);
		
		//inserzione iniziale
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textArea.setText("❶------------------②------------------③");
		textArea.setBackground(SystemColor.menu);
		textArea.setBounds(10, 74, 491, 31);
		frame.getContentPane().add(textArea);
		
		JLabel lblNewLabel_1 = new JLabel("Soluzioni di viaggio");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(10, 45, 150, 31);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Passeggeri e supplementi");
		lblNewLabel_1_1.setForeground(SystemColor.controlShadow);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(180, 45, 150, 31);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Riepilogo e pagamento");
		lblNewLabel_1_2.setForeground(SystemColor.controlShadow);
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setBounds(354, 45, 150, 31);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		Image img = new ImageIcon("image\\freccia.png").getImage();
		Image newImage = img.getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		
		btnIndietro = new JButton("");
		btnIndietro.setBounds(10, 10, 20, 20);
		btnIndietro.setIcon(new ImageIcon(newImage));
		frame.getContentPane().add(btnIndietro);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 109, 494, 281);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		//interfaccia dinamica per la visualizzazione della ricerca
		
		int y = 20;
		
		for(int i = 0; i < 4; i++) {
			radioButton.add(new JRadioButton(""));
			radioButton.get(i).setBounds(6, y, 21, 21);
			radioButton.get(i).setVisible(false);
			panel.add(radioButton.get(i));
			
			autobustxt.add(new JTextArea());
			autobustxt.get(i).setEditable(false);
			autobustxt.get(i).setBackground(SystemColor.menu);
			autobustxt.get(i).setBounds(35, y-7, 84, 36);
			autobustxt.get(i).setVisible(false);
			panel.add(autobustxt.get(i));
			
			fermatetxt.add(new JTextArea());
			fermatetxt.get(i).setEditable(false);
			fermatetxt.get(i).setBackground(SystemColor.menu);
			fermatetxt.get(i).setBounds(129, y-16, 119, 51);
			fermatetxt.get(i).setVisible(false);
			panel.add(fermatetxt.get(i));
			
			orariotxt.add(new JTextArea());
			orariotxt.get(i).setEditable(false);
			orariotxt.get(i).setBackground(SystemColor.menu);
			orariotxt.get(i).setBounds(129, y-16, 119, 51);
			orariotxt.get(i).setVisible(false);
			panel.add(orariotxt.get(i));
			
			btnPrezzo.add(new JButton(""));
			btnPrezzo.get(i).setBounds(373, y, 105, 21);
			btnPrezzo.get(i).setVisible(false);
			btnPrezzo.get(i).setBackground(null);
			btnPrezzo.get(i).setBorder(new RoundedBorder(10)); //10 is the radius
			panel.add(btnPrezzo.get(i));
			
			y += 71;
		}
		
		//Contenitore della stampa del percorso
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 400, 494, 223);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Dettagli viaggio");
		panel_1.add(lblNewLabel, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		JTextArea dettaglitxt = new JTextArea();
		scrollPane.setViewportView(dettaglitxt);
		
		//Azioni
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//permette di tornare una pagina indietro alla pressione del tasto
				Cerca.main(null);
				frame.setVisible(false);
			}
		});
		
		radioButton.get(0).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(radioButton.get(0).isSelected() == true) {
					radioButton.get(1).setSelected(false);
					radioButton.get(2).setSelected(false);
					radioButton.get(3).setSelected(false);
					
					//Alla pressione del tasto 1 stampo i dettagli del viaggio assocaito
					dettaglitxt.setText(corsa.stampaRicerca(biglietti.get(0).getPercorso()));
				}
				
			}
		});
		
		radioButton.get(1).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(radioButton.get(1).isSelected() == true) {
					radioButton.get(0).setSelected(false);
					radioButton.get(2).setSelected(false);
					radioButton.get(3).setSelected(false);
					
					//Alla pressione del tasto 2 stampo i dettagli del viaggio assocaito
					dettaglitxt.setText(corsa.stampaRicerca(biglietti.get(1).getPercorso()));
				}
			
			}
		});
		
		radioButton.get(2).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(radioButton.get(2).isSelected() == true) {
					radioButton.get(1).setSelected(false);
					radioButton.get(0).setSelected(false);
					radioButton.get(3).setSelected(false);
					
					//Alla pressione del tasto 3 stampo i dettagli del viaggio assocaito
					dettaglitxt.setText(corsa.stampaRicerca(biglietti.get(2).getPercorso()));
				}
				
			}
		});
		
		radioButton.get(3).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(radioButton.get(3).isSelected() == true) {
					radioButton.get(1).setSelected(false);
					radioButton.get(2).setSelected(false);
					radioButton.get(0).setSelected(false);
					
					//Alla pressione del tasto 4 stampo i dettagli del viaggio assocaito
					dettaglitxt.setText(corsa.stampaRicerca(biglietti.get(3).getPercorso()));
				}
				
			}
		});
		
		//Eventi che al passaggio del mouse sopra i bottoni dei prezzi li evidenzia
		btnPrezzo.get(0).addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(btnPrezzo.get(0).getBackground() == Color.LIGHT_GRAY) btnPrezzo.get(0).setBackground(UIManager.getColor("control"));
				else btnPrezzo.get(0).setBackground(Color.LIGHT_GRAY);
			}
		});
		
		btnPrezzo.get(1).addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(btnPrezzo.get(1).getBackground() == Color.LIGHT_GRAY) btnPrezzo.get(1).setBackground(UIManager.getColor("control"));
				else btnPrezzo.get(1).setBackground(Color.LIGHT_GRAY);
			}
		});
		
		btnPrezzo.get(2).addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(btnPrezzo.get(2).getBackground() == Color.LIGHT_GRAY) btnPrezzo.get(2).setBackground(UIManager.getColor("control"));
				else btnPrezzo.get(2).setBackground(Color.LIGHT_GRAY);
			}
		});
		
		btnPrezzo.get(3).addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(btnPrezzo.get(3).getBackground() == Color.LIGHT_GRAY) btnPrezzo.get(3).setBackground(UIManager.getColor("control"));
				else btnPrezzo.get(3).setBackground(Color.LIGHT_GRAY);
			}
		});
		
		btnPrezzo.get(0).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Supplementi.main(biglietti.get(0));
				frame.setVisible(false);
			}
		});
		
		btnPrezzo.get(1).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Supplementi.main(biglietti.get(1));
				frame.setVisible(false);
			}
		});
		
		btnPrezzo.get(2).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Supplementi.main(biglietti.get(2));
				frame.setVisible(false);
			}
		});
		
		btnPrezzo.get(3).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Supplementi.main(biglietti.get(3));
				frame.setVisible(false);
			}
		});
		
	}
	
	public static void setGraficaRicerca() {
		DecimalFormat df=new DecimalFormat("0.00"); //formato per il prezzo con due decimali
		LocalTime time;
		Biglietto b;
		String autobus;
		String fermata;
		String orario;
		String prezzo;
		
		for(int i = 0; i < biglietti.size(); i++) {
			//Inizializzo le informazioni del biglietto e preparo le varie stringhe per la stampa nelle celle:
			//preparo le stringhe tutte assieme per agevolare future modifiche del caso, 
			//in questo modo non devo modificare ogni riga dova la uso ma solo quella dove la instanzio
			b = biglietti.get(i);
			autobus = b.getPercorso().get(0).getMezzo() +" "+ b.getPercorso().get(0).getCodiceLinea() +"\n"+ b.getPercorso().get(b.getPercorso().size()-1).getMezzo() +" "+ b.getPercorso().get(b.getPercorso().size()-1).getCodiceLinea();
			fermata = "⦿ "+ b.getPercorso().get(0).getCodiceFermata() +" "+ b.getPercorso().get(0).getOrario() +"\r\n ¦\r\n⦿ "+ b.getPercorso().get(b.getPercorso().size()-1).getCodiceFermata() +" "+ b.getPercorso().get(b.getPercorso().size()-1).getOrario();
			prezzo = String.valueOf(df.format(b.getPrezzo())) + " € | 🛒";
			
			time = b.getDurataViaggio(b.getPercorso());
			if(time.getHour() != 0 && time.getMinute() != 0) orario = time.getHour() +" ore, "+ time.getMinute() +" minuti\nCambi "+ getNumeroCambi(b.getPercorso());
			else if(time.getHour() == 0)  orario = time.getMinute() +" minuti\nCambi "+ getNumeroCambi(b.getPercorso());
			else  orario = time.getHour() +" ore\nCambi "+ getNumeroCambi(b.getPercorso());
			
			
				
			autobustxt.get(i).setText(autobus);
		    fermatetxt.get(i).setText(fermata);
		    orariotxt.get(i).setText(orario);
		    btnPrezzo.get(i).setText(prezzo);
		  
		    //rendo l'interfaccia visibile nel frame
		    radioButton.get(i).setVisible(true);
		    autobustxt.get(i).setVisible(true);
		    fermatetxt.get(i).setVisible(true);
		    orariotxt.get(i).setVisible(true);
		    btnPrezzo.get(i).setVisible(true);
			
		}
		
	}
	
	public static int getNumeroCambi(ArrayList<Fermata> ricerca) {
		int cambi = 0;
		
		for(Fermata n : ricerca) if(n.isSnodo()) cambi++;
		
		return cambi;
	}
}
