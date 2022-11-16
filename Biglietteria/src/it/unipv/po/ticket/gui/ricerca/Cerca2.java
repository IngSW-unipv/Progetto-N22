package it.unipv.po.ticket.gui.ricerca;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import it.unipv.po.ticket.trasporto.fermata.Fermata;
import it.unipv.po.ticket.trasporto.ricerca.Ricerca;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Cerca2 extends JFrame {

	private JFrame frame;
	private Ricerca corsa = new Ricerca();
	private static ArrayList<ArrayList<Fermata>> elenco;
	
	private static JRadioButton RadioButton1;
	private static JRadioButton RadioButton2;
	private static JRadioButton RadioButton3;
	private static JRadioButton RadioButton4;
	private static JTextArea autobustxt1;
	private static JTextArea autobustxt2;
	private static JTextArea autobustxt3;
	private static JTextArea autobustxt4;
	private static JTextArea orariotxt1;
	private static JTextArea orariotxt2;
	private static JTextArea orariotxt3;
	private static JTextArea orariotxt4;
	private static JTextArea fermatetxt1;
	private static JTextArea fermatetxt2;
	private static JTextArea fermatetxt3;
	private static JTextArea fermatetxt4;
	private JTextArea textArea;
	private JButton btnIndietro;


	/**
	 * Launch the application.
	 */
	public static void main(ArrayList<ArrayList<Fermata>> arrayList) {
		elenco = arrayList;
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cerca2 window = new Cerca2();
					window.frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}
	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public Cerca2() throws Exception {
		frame = new JFrame();
		
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 525, 670);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 109, 494, 281);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		RadioButton1 = new JRadioButton("");
		RadioButton1.setBounds(6, 20, 21, 21);
		RadioButton1.setVisible(false);
		panel.add(RadioButton1);
	
		RadioButton2 = new JRadioButton("");
		RadioButton2.setBounds(6, 91, 21, 21);
		RadioButton2.setVisible(false);
		panel.add(RadioButton2);

		RadioButton3 = new JRadioButton("");
		RadioButton3.setBounds(6, 162, 21, 21);
		RadioButton3.setVisible(false);
		panel.add(RadioButton3);
		
		RadioButton4 = new JRadioButton("");
		RadioButton4.setBounds(6, 233, 21, 21);
		RadioButton4.setVisible(false);
		panel.add(RadioButton4);
		
		autobustxt1 = new JTextArea();
		autobustxt1.setEditable(false);
		autobustxt1.setBackground(SystemColor.menu);
		autobustxt1.setBounds(35, 13, 84, 36);
		autobustxt1.setVisible(false);
		panel.add(autobustxt1);
		
		autobustxt2 = new JTextArea();
		autobustxt2.setEditable(false);
		autobustxt2.setBackground(SystemColor.menu);
		autobustxt2.setBounds(35, 84, 84, 36);
		autobustxt2.setVisible(false);
		panel.add(autobustxt2);
		
		autobustxt3 = new JTextArea();
		autobustxt3.setEditable(false);
		autobustxt3.setBackground(SystemColor.menu);
		autobustxt3.setBounds(35, 155, 84, 36);
		autobustxt3.setVisible(false);
		panel.add(autobustxt3);
		
		autobustxt4 = new JTextArea();
		autobustxt4.setBackground(SystemColor.menu);
		autobustxt4.setEditable(false);
		autobustxt4.setBounds(35, 220, 84, 36);
		autobustxt4.setVisible(false);
		panel.add(autobustxt4);
		
		fermatetxt1 = new JTextArea();
		fermatetxt1.setEditable(false);
		fermatetxt1.setBackground(SystemColor.menu);
		fermatetxt1.setBounds(129, 4, 119, 51);
		fermatetxt1.setVisible(false);
		panel.add(fermatetxt1);
		
		fermatetxt2 = new JTextArea();
		fermatetxt2.setEditable(false);
		fermatetxt2.setBackground(SystemColor.menu);
		fermatetxt2.setBounds(129, 75, 119, 51);
		fermatetxt2.setVisible(false);
		panel.add(fermatetxt2);
		
		fermatetxt3 = new JTextArea();
		fermatetxt3.setEditable(false);
		fermatetxt3.setBackground(SystemColor.menu);
		fermatetxt3.setBounds(129, 146, 119, 51);
		fermatetxt3.setVisible(false);
		panel.add(fermatetxt3);
		
		fermatetxt4 = new JTextArea();
		fermatetxt4.setBackground(SystemColor.menu);
		fermatetxt4.setEditable(false);
		fermatetxt4.setBounds(129, 217, 119, 51);
		fermatetxt4.setVisible(false);
		panel.add(fermatetxt4);
		
		orariotxt1 = new JTextArea();
		orariotxt1.setEditable(false);
		orariotxt1.setBackground(SystemColor.menu);
		orariotxt1.setBounds(250, 4, 113, 51);
		orariotxt1.setVisible(false);
		panel.add(orariotxt1);
		
		orariotxt2 = new JTextArea();
		orariotxt2.setEditable(false);
		orariotxt2.setBackground(SystemColor.menu);
		orariotxt2.setBounds(250, 75, 113, 51);
		orariotxt2.setVisible(false);
		panel.add(orariotxt2);
		
		orariotxt3 = new JTextArea();
		orariotxt3.setEditable(false);
		orariotxt3.setBackground(SystemColor.menu);
		orariotxt3.setBounds(250, 146, 113, 51);
		orariotxt3.setVisible(false);
		panel.add(orariotxt3);

		orariotxt4 = new JTextArea();
		orariotxt4.setBackground(SystemColor.menu);
		orariotxt4.setEditable(false);
		orariotxt4.setBounds(250, 217, 119, 51);
		orariotxt4.setVisible(false);
		panel.add(orariotxt4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 400, 494, 223);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Dettagli viaggio:");
		panel_1.add(lblNewLabel, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		JTextArea dettaglitxt = new JTextArea();
		scrollPane.setViewportView(dettaglitxt);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textArea.setText("❶------------------②------------------③");
		textArea.setBackground(SystemColor.menu);
		textArea.setBounds(10, 74, 491, 31);
		frame.getContentPane().add(textArea);
		
		JLabel lblNewLabel_1 = new JLabel("Soluzioni di viaggio");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1.setBounds(10, 45, 150, 31);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Passeggeri e supplementi");
		lblNewLabel_1_1.setForeground(SystemColor.controlShadow);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(182, 45, 150, 31);
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
		
		setGraficaRicerca();
		
		//Azioni
		RadioButton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(RadioButton1.isSelected() == true) {
					RadioButton2.setSelected(false);
					RadioButton3.setSelected(false);
					RadioButton4.setSelected(false);
					dettaglitxt.setText(corsa.stampaRicerca(elenco.get(0)));
				}
				
			}
		});
		
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cerca.main(null);
				frame.setVisible(false);
			}
		});
		
		RadioButton2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(RadioButton2.isSelected() == true) {
					RadioButton1.setSelected(false);
					RadioButton3.setSelected(false);
					RadioButton4.setSelected(false);
					dettaglitxt.setText(corsa.stampaRicerca(elenco.get(1)));
				}
			
			}
		});
		
		RadioButton3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(RadioButton3.isSelected() == true) {
					RadioButton1.setSelected(false);
					RadioButton2.setSelected(false);
					RadioButton4.setSelected(false);
					dettaglitxt.setText(corsa.stampaRicerca(elenco.get(2)));
				}
				
			}
		});
		
		RadioButton4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(RadioButton4.isSelected() == true) {
					RadioButton1.setSelected(false);
					RadioButton2.setSelected(false);
					RadioButton3.setSelected(false);
					dettaglitxt.setText(corsa.stampaRicerca(elenco.get(3)));
				}
				
			}
		});
		
	}
	
	public static void setGraficaRicerca() {
		
		for(int i = 0; i < elenco.size(); i++) {

			switch(i) {
			  case 0:
				  autobustxt1.setText(elenco.get(i).get(0).getMezzo() +" "+ elenco.get(i).get(0).getCodiceLinea() +"\n"+ elenco.get(i).get(elenco.get(i).size()-1).getMezzo() +" "+ elenco.get(i).get(elenco.get(i).size()-1).getCodiceLinea());
				  fermatetxt1.setText("⦿ "+ elenco.get(i).get(0).getCodiceFermata() +" "+ elenco.get(i).get(0).getOrario() +"\r\n ¦\r\n⦿ "+ elenco.get(i).get(elenco.get(i).size()-1).getCodiceFermata() +" "+ elenco.get(i).get(elenco.get(i).size()-1).getOrario());
				  orariotxt1.setText(getDiurataViaggio(elenco.get(i)) +"\n"+ getNumeroScambi(elenco.get(i)) +" cambi");
				  
				  RadioButton1.setVisible(true);
				  autobustxt1.setVisible(true);
				  fermatetxt1.setVisible(true);
				  orariotxt1.setVisible(true);
				  
			  break;
			  case 1:
				  autobustxt2.setText(elenco.get(i).get(0).getMezzo() +" "+ elenco.get(i).get(0).getCodiceLinea() +"\n"+ elenco.get(i).get(elenco.get(i).size()-1).getMezzo() +" "+ elenco.get(i).get(elenco.get(i).size()-1).getCodiceLinea());
				  fermatetxt2.setText("⦿ "+ elenco.get(i).get(0).getCodiceFermata() +" "+ elenco.get(i).get(0).getOrario() +"\r\n ¦\r\n⦿ "+ elenco.get(i).get(elenco.get(i).size()-1).getCodiceFermata() +" "+ elenco.get(i).get(elenco.get(i).size()-1).getOrario());
				  orariotxt2.setText(getDiurataViaggio(elenco.get(i)) +"\n"+ getNumeroScambi(elenco.get(i)) +" cambi");
				  
				  RadioButton2.setVisible(true);
				  autobustxt2.setVisible(true);
				  fermatetxt2.setVisible(true);
				  orariotxt2.setVisible(true);
				  
			  break;
			  case 2:
				  autobustxt3.setText(elenco.get(i).get(0).getMezzo() +" "+ elenco.get(i).get(0).getCodiceLinea() +"\n"+ elenco.get(i).get(elenco.get(i).size()-1).getMezzo() +" "+ elenco.get(i).get(elenco.get(i).size()-1).getCodiceLinea());
				  fermatetxt3.setText("⦿ "+ elenco.get(i).get(0).getCodiceFermata() +" "+ elenco.get(i).get(0).getOrario() +"\r\n ¦\r\n⦿ "+ elenco.get(i).get(elenco.get(i).size()-1).getCodiceFermata() +" "+ elenco.get(i).get(elenco.get(i).size()-1).getOrario());
				  orariotxt3.setText(getDiurataViaggio(elenco.get(i)) +"\n"+ getNumeroScambi(elenco.get(i)) +" cambi");
				  
				  RadioButton3.setVisible(true);
				  autobustxt3.setVisible(true);
				  fermatetxt3.setVisible(true);
				  orariotxt3.setVisible(true);
				  
			  break;
			  case 3:
				  autobustxt4.setText(elenco.get(i).get(0).getMezzo() +" "+ elenco.get(i).get(0).getCodiceLinea() +"\n"+ elenco.get(i).get(elenco.get(i).size()-1).getMezzo() +" "+ elenco.get(i).get(elenco.get(i).size()-1).getCodiceLinea());
				  fermatetxt4.setText("⦿ "+ elenco.get(i).get(0).getCodiceFermata() +" "+ elenco.get(i).get(0).getOrario() +"\r\n ¦\r\n⦿ "+ elenco.get(i).get(elenco.get(i).size()-1).getCodiceFermata() +" "+ elenco.get(i).get(elenco.get(i).size()-1).getOrario());
				  orariotxt4.setText(getDiurataViaggio(elenco.get(i)) +"\n"+ getNumeroScambi(elenco.get(i)) +" cambi");
				  
				  RadioButton4.setVisible(true);
				  autobustxt4.setVisible(true);
				  fermatetxt4.setVisible(true);
				  orariotxt4.setVisible(true);
				  
			  break;
			  default:
				  System.out.println("Errore...");
			}
			
		}
		
	}
	
	public static int getNumeroScambi(ArrayList<Fermata> ricerca) {
		int scambi = 0;
		
		for(Fermata n : ricerca) if(n.isSnodo()) scambi++;
		
		return scambi;
	}
	
	public static String getDiurataViaggio(ArrayList<Fermata> ricerca) {
		
		int ora = ricerca.get(ricerca.size()-1).getOrario().getHour() - ricerca.get(0).getOrario().getHour();
		int minuti = ricerca.get(ricerca.size()-1).getOrario().getMinute() - ricerca.get(0).getOrario().getMinute();
		int tempo = minuti + ora*60;
		
		String str = tempo/60 + " ore, "+ tempo%60 +" minuti";
		return str;
	}
}
