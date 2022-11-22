package it.unipv.po.gui.ricerca;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import it.unipv.po.connessioneDB.DBread;
import it.unipv.po.gui.errore.Errore;
import it.unipv.po.trasporto.ricerca.Ricerca;
import it.unipv.po.utente.Utente;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.Font;

public class Cerca extends JFrame {

	private JFrame frame;
	private DBread leggi = new DBread();
	private Ricerca ricerca = new Ricerca();
	
	public static void main(Utente utente) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cerca window = new Cerca(utente);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Cerca(Utente utente) {
		frame = new JFrame();
		
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 320, 530);
		frame.getContentPane().setLayout(null);
		
		JPanel bar = new JPanel();
		bar.setBackground(SystemColor.activeCaptionBorder);
		bar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		bar.setLayout(null);
		bar.setBounds(314, 0, 207, 493);
		frame.getContentPane().add(bar);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setBounds(0, 56, 207, 63);
		bar.add(btnNewButton);
		
		JButton btnCerca = new JButton("Cerca");
		btnCerca.setBounds(0, 117, 207, 63);
		bar.add(btnCerca);
		
		JButton btnAreaPersonale = new JButton("Area personale");
		btnAreaPersonale.setBounds(0, 178, 207, 63);
		bar.add(btnAreaPersonale);
		
		JButton btnContatti = new JButton("Contatti");
		btnContatti.setBounds(0, 240, 207, 63);
		bar.add(btnContatti);
		
		JLabel lblNewLabel_2 = new JLabel("Menu");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 22, 207, 13);
		bar.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(SystemColor.menu);
		panel.setBounds(10, 63, 284, 420);
		frame.getContentPane().add(panel);
		
		JToggleButton tglBiglietto = new JToggleButton("Biglietto");
		tglBiglietto.setFont(new Font("Arial Nova", Font.PLAIN, 10));
		tglBiglietto.setSelected(true);
		tglBiglietto.setBounds(10, 21, 127, 21);
		panel.add(tglBiglietto);
		
		JToggleButton tglAbbonamento = new JToggleButton("Abbonamento");
		tglAbbonamento.setFont(new Font("Arial Nova", Font.PLAIN, 10));
		tglAbbonamento.setBounds(147, 21, 127, 21);
		panel.add(tglAbbonamento);
		
		JComboBox comboBoxPartenza = new JComboBox();
		JComboBox comboBoxArrivo = new JComboBox();
		try {
			comboBoxPartenza.setModel(new DefaultComboBoxModel<String>(leggi.elencoFermate()));
			//JComboBox comboBoxPartenza = new JComboBox(leggi.elencoFermate());
			comboBoxPartenza.setMaximumRowCount(10);
			comboBoxPartenza.setBackground(Color.WHITE);
			comboBoxPartenza.setBounds(147, 90, 103, 30);
			panel.add(comboBoxPartenza);
			
			comboBoxArrivo.setModel(new DefaultComboBoxModel<String>(leggi.elencoFermate()));
			//JComboBox comboBoxArrivo = new JComboBox(leggi.elencoFermate());
			comboBoxArrivo.setMaximumRowCount(10);
			comboBoxArrivo.setBackground(Color.WHITE);
			comboBoxArrivo.setBounds(147, 157, 103, 30);
			panel.add(comboBoxArrivo);
		} catch(SQLException sqlExc) {
			JOptionPane.showMessageDialog(null, "Connessione fallita!","DB error",JOptionPane.ERROR_MESSAGE);
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Qualcosa non va","Generic error",JOptionPane.ERROR_MESSAGE);
		}
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 225, 264, 2);
		panel.add(separator);
		
		JButton cercaBtn = new JButton("Cerca");
		cercaBtn.setFont(new Font("Arial Nova", Font.PLAIN, 10));
		cercaBtn.setBounds(98, 382, 85, 21);
		cercaBtn.setBackground(UIManager.getColor("control"));
		panel.add(cercaBtn);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 370, 264, 2);
		panel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 52, 264, 3);
		panel.add(separator_2);
		
		JLabel lblNewLabel = new JLabel("Fermata di partenza");
		lblNewLabel.setFont(new Font("Arial Nova", Font.PLAIN, 11));
		lblNewLabel.setBounds(10, 99, 148, 13);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Fermata di arrivo");
		lblNewLabel_1.setFont(new Font("Arial Nova", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(10, 166, 148, 13);
		panel.add(lblNewLabel_1);
		
		JSlider orarioSlider = new JSlider();
		orarioSlider.setValue(24);
		orarioSlider.setMaximum(47);
		orarioSlider.setBounds(40, 318, 200, 22);
		panel.add(orarioSlider);
		
		JLabel orarioPartenzatxt = new JLabel("12:00");
		orarioPartenzatxt.setBounds(28, 295, 45, 13);
		panel.add(orarioPartenzatxt);
		
		JLabel orarioMaxtxt = new JLabel("23:59");
		orarioMaxtxt.setHorizontalAlignment(SwingConstants.CENTER);
		orarioMaxtxt.setBounds(205, 295, 45, 13);
		panel.add(orarioMaxtxt);
		
		JLabel orariotxt = new JLabel("A che ora vuoi partire?");
		orariotxt.setFont(new Font("Arial Nova", Font.PLAIN, 11));
		orariotxt.setBounds(28, 250, 172, 13);
		panel.add(orariotxt);
		
		Image img = new ImageIcon("image\\menu.png").getImage();
		Image newImage = img.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBounds(262, 23, 30, 30);
		btnNewButton_1.setIcon(new ImageIcon(newImage));
		frame.getContentPane().add(btnNewButton_1);
	
		//Azioni
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Image img;
				Image newImage;
				
				if(frame.getBounds().width != 528) {				
					frame.setBounds(frame.getBounds().x, frame.getBounds().y, 528, 530);
					img = new ImageIcon("image\\close.png").getImage();
					newImage = img.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
					btnNewButton_1.setIcon(new ImageIcon(newImage));
				}else {
					frame.setBounds(frame.getBounds().x, frame.getBounds().y, 320, 530);
					img = new ImageIcon("image\\menu.png").getImage();
					newImage = img.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
				    btnNewButton_1.setIcon(new ImageIcon(newImage));
				}
			}
		});
		
		tglBiglietto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tglBiglietto.isSelected() == true) {
					tglAbbonamento.setSelected(false);
					separator.setVisible(true);
					orarioMaxtxt.setVisible(true);
					orarioPartenzatxt.setVisible(true);
					orarioSlider.setVisible(true);
					orariotxt.setVisible(true);
				}
				else {
					tglAbbonamento.setSelected(true);
					separator.setVisible(false);
					orarioMaxtxt.setVisible(false);
					orarioPartenzatxt.setVisible(false);
					orarioSlider.setVisible(false);
					orariotxt.setVisible(false);
				}
				
			}
		});
				
		tglAbbonamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglAbbonamento.isSelected() == true) {
					tglBiglietto.setSelected(false);
					separator.setVisible(false);
					orarioMaxtxt.setVisible(false);
					orarioPartenzatxt.setVisible(false);
					orarioSlider.setVisible(false);
					orariotxt.setVisible(false);
				}
				else {
					tglBiglietto.setSelected(true);
					separator.setVisible(true);
					orarioMaxtxt.setVisible(true);
					orarioPartenzatxt.setVisible(true);
					orarioSlider.setVisible(true);
					orariotxt.setVisible(true);
				}
			}
		});
		
		cercaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Controllo che siano state selezionate le fermate
				if(comboBoxPartenza.getSelectedItem() != "" && comboBoxArrivo.getSelectedItem() != "") {
					try {
						//Controllo se la ricerca non da esito nullo e quindi non esista un percorso che rispetta le indicazioni inserite
						if(ricerca.cercaEGenera(comboBoxPartenza.getSelectedItem().toString(), comboBoxArrivo.getSelectedItem().toString(), LocalTime.parse(orarioPartenzatxt.getText())).size() != 0) {
							String[] args = {comboBoxPartenza.getSelectedItem().toString(), comboBoxArrivo.getSelectedItem().toString(), orarioPartenzatxt.getText()};
							
							Viaggi.main(utente, args);
							frame.setVisible(false);
						}else JOptionPane.showMessageDialog(null, "Non è stato possibile trovare un percorso che rispettasse \nl'orario inseriro, si prega di cambiare orario e riprovare","Search error",JOptionPane.INFORMATION_MESSAGE);
						
						
					} catch (SQLException sqlExc) {
						JOptionPane.showMessageDialog(null, "Connessione fallita!","DB error",JOptionPane.ERROR_MESSAGE);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Qualcosa non va","Generic error",JOptionPane.ERROR_MESSAGE);
					}
				}else JOptionPane.showMessageDialog(null, "Fermate non selezionate","Search error",JOptionPane.ERROR_MESSAGE);
				
			}
		});
		
		orarioSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				int a = orarioSlider.getValue()/2;
				int b = (orarioSlider.getValue()%2)*30;	

				String str = LocalTime.of(a,b).toString();
				
				orarioPartenzatxt.setText(str);
			}
		});
		
		
	}
}
