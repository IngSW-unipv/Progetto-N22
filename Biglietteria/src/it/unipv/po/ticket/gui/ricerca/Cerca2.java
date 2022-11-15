package it.unipv.po.ticket.gui.ricerca;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Choice;
import javax.swing.JFormattedTextField;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Label;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;

import it.unipv.po.ticket.supporto.DBread;
import it.unipv.po.ticket.trasporto.fermata.Fermata;
import it.unipv.po.ticket.trasporto.ricerca.Ricerca;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;

public class Cerca2 extends JFrame {

	private JPanel contentPane;
	private Ricerca corsa = new Ricerca();
	private static ArrayList<Fermata> elenco;

	/**
	 * Launch the application.
	 */
	public static void main(ArrayList<Fermata> cerca) {
		elenco = cerca;
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cerca2 frame = new Cerca2();
					frame.setVisible(true);
					
					
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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 10, 494, 205);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("");
		rdbtnNewRadioButton.setBounds(6, 20, 21, 21);
		panel.add(rdbtnNewRadioButton);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(33, 10, 59, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(33, 32, 59, 13);
		panel.add(lblNewLabel_2);
		
		JTextArea txtrF = new JTextArea();
		txtrF.setEditable(false);
		txtrF.setText("⦿ F004 9:30\r\n ¦\r\n⦿ F026 12:30");
		txtrF.setBackground(SystemColor.menu);
		txtrF.setBounds(129, 4, 119, 51);
		panel.add(txtrF);
		
		JTextArea txtrOre = new JTextArea();
		txtrOre.setEditable(false);
		txtrOre.setText("8 ore, 12 minuti\r\n2 cambi");
		txtrOre.setBackground(SystemColor.menu);
		txtrOre.setBounds(250, 4, 113, 51);
		panel.add(txtrOre);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("");
		rdbtnNewRadioButton_1.setBounds(6, 91, 21, 21);
		panel.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setBounds(33, 81, 59, 13);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("New label");
		lblNewLabel_2_1.setBounds(33, 103, 59, 13);
		panel.add(lblNewLabel_2_1);
		
		JTextArea txtrF_1 = new JTextArea();
		txtrF_1.setEditable(false);
		txtrF_1.setText("⦿ F004 9:30\r\n ¦\r\n⦿ F026 12:30");
		txtrF_1.setBackground(SystemColor.menu);
		txtrF_1.setBounds(129, 75, 119, 51);
		panel.add(txtrF_1);
		
		JTextArea txtrOre_1 = new JTextArea();
		txtrOre_1.setEditable(false);
		txtrOre_1.setText("8 ore, 12 minuti\r\n2 cambi");
		txtrOre_1.setBackground(SystemColor.menu);
		txtrOre_1.setBounds(250, 75, 113, 51);
		panel.add(txtrOre_1);
		
		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("");
		rdbtnNewRadioButton_1_1.setBounds(6, 160, 21, 21);
		panel.add(rdbtnNewRadioButton_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("New label");
		lblNewLabel_1_1_1.setBounds(33, 150, 59, 13);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("New label");
		lblNewLabel_2_1_1.setBounds(33, 172, 59, 13);
		panel.add(lblNewLabel_2_1_1);
		
		JTextArea txtrF_1_1 = new JTextArea();
		txtrF_1_1.setEditable(false);
		txtrF_1_1.setText("⦿ F004 9:30\r\n ¦\r\n⦿ F026 12:30");
		txtrF_1_1.setBackground(SystemColor.menu);
		txtrF_1_1.setBounds(129, 144, 119, 51);
		panel.add(txtrF_1_1);
		
		JTextArea txtrOre_1_1 = new JTextArea();
		txtrOre_1_1.setEditable(false);
		txtrOre_1_1.setText("8 ore, 12 minuti\r\n2 cambi");
		txtrOre_1_1.setBackground(SystemColor.menu);
		txtrOre_1_1.setBounds(250, 144, 113, 51);
		panel.add(txtrOre_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 220, 494, 210);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Dettagli viaggio:");
		panel_1.add(lblNewLabel, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		JTextArea dettaglitxt = new JTextArea();
		scrollPane.setViewportView(dettaglitxt);
		//dettaglitxt.setText(corsa.stampaRicerca(elenco));
		
	}
}
