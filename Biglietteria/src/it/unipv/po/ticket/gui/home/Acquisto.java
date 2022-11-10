package it.unipv.po.ticket.gui.home;

import java.awt.EventQueue; 
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JToggleButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JButton;
import it.unipv.po.ticket.supporto.DBread;
import it.unipv.po.ticket.trasporto.ricerca.Ricerca;

import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.Box;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class Acquisto {

	private JFrame frame;
	private Image img;
	private Image newImage;
	private static Ricerca corsa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					corsa = new Ricerca();
			   //     corsa.setPercorsi();
					Acquisto window = new Acquisto();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public Acquisto() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	private void initialize() throws Exception {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("image\\monkey_128.png"));
		frame.setBounds(100, 100, 608, 567);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(UIManager.getColor("Button.background"));
		panel.setBounds(10, 32, 284, 465);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JToggleButton tglBiglietto = new JToggleButton("Biglietto");
		tglBiglietto.setSelected(true);
		tglBiglietto.setBounds(10, 21, 127, 21);
		panel.add(tglBiglietto);
		
		JToggleButton tglAbbonamento = new JToggleButton("Abbonamento");
		tglAbbonamento.setBounds(147, 21, 127, 21);
		panel.add(tglAbbonamento);
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBoxPartenza = new JComboBox(DBread.elencoFermate());
		comboBoxPartenza.setBackground(Color.WHITE);
		comboBoxPartenza.setBounds(147, 90, 103, 30);
		panel.add(comboBoxPartenza);
		comboBoxPartenza.setMaximumRowCount(10);
		
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBoxArrivo = new JComboBox(DBread.elencoFermate());
		comboBoxArrivo.setBackground(Color.WHITE);
		comboBoxArrivo.setMaximumRowCount(10);
		comboBoxArrivo.setBounds(147, 157, 103, 30);
		panel.add(comboBoxArrivo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 225, 264, 2);
		panel.add(separator);
		
		JButton btnNewButton = new JButton("Cerca");
		btnNewButton.setBounds(98, 412, 85, 21);
		panel.add(btnNewButton);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 400, 264, 2);
		panel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 52, 264, 3);
		panel.add(separator_2);
		
		JLabel lblNewLabel = new JLabel("Fermata di partenza");
		lblNewLabel.setBounds(10, 99, 148, 13);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Fermata di arrivo");
		lblNewLabel_1.setBounds(10, 166, 148, 13);
		panel.add(lblNewLabel_1);
		
		JTextArea txtCerca = new JTextArea();
		txtCerca.setBackground(UIManager.getColor("Button.background"));
		txtCerca.setBounds(10, 231, 264, 159);
		panel.add(txtCerca);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 594, 22);
		frame.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Home");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_2 = new JMenu("Biglietto");
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu_3 = new JMenu("New menu");
		menuBar.add(mnNewMenu_3);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		menuBar.add(horizontalGlue);
		
		JMenu mnNewMenu_4 = new JMenu("");
		this.img = new ImageIcon("image\\Profilo.png").getImage();
		this.newImage = img.getScaledInstance(25, 25, Image.SCALE_DEFAULT);
		mnNewMenu_4.setIcon(new ImageIcon(this.newImage));
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Profilo");
		mnNewMenu_4.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Conologia Acquisti");
		mnNewMenu_4.add(mntmNewMenuItem_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(304, 32, 284, 465);
		frame.getContentPane().add(scrollPane);
		
		JTextArea txtDettagli = new JTextArea();
		txtDettagli.setEditable(false);
		scrollPane.setViewportView(txtDettagli);
		
		
		//Azioni
		
		tglBiglietto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tglBiglietto.isSelected() == true) {
					tglAbbonamento.setSelected(false);
					separator.setVisible(true);
				}
				else {
					tglAbbonamento.setSelected(true);
					separator.setVisible(false);
				}
				
			}
		});
		
		tglAbbonamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglAbbonamento.isSelected() == true) {
					tglBiglietto.setSelected(false);
					separator.setVisible(false);
				}
				else {
					tglBiglietto.setSelected(true);
					separator.setVisible(true);
				}
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = "";
				
				if(comboBoxPartenza.getSelectedItem() != "" && comboBoxArrivo.getSelectedItem() != "") {
				
					try {
						//str = corsa.cerca(comboBoxPartenza.getSelectedItem().toString(), comboBoxArrivo.getSelectedItem().toString());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					txtDettagli.setText(str);
				}else {
					JOptionPane.showMessageDialog(null, "Fermate non selezionate","Search error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
	}
}
