package it.unipv.po.ticket.gui.orari;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import it.unipv.po.ticket.trasporto.ricerca.Ricerca;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;

public class Orari {
	
	private static Ricerca corsa;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					corsa = new Ricerca();
			        corsa.setPercorsi();
					Orari window = new Orari();
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
	public Orari() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	private void initialize() throws Exception {
		frame = new JFrame();
		frame.setBounds(100, 100, 365, 543);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
        
		@SuppressWarnings("rawtypes")
		JComboBox comboBox = new JComboBox(corsa.getLinee());
		comboBox.setBounds(114, 112, 123, 21);
		frame.getContentPane().add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(86, 143, 178, 329);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		textArea.setText(corsa.getPercorso(1));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 78, 351, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblNewLabel = new JLabel("Tabella orari fermate");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(105, 55, 141, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 351, 31);
		frame.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Home");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_2 = new JMenu("Biglietto");
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu_3 = new JMenu("New menu");
		menuBar.add(mnNewMenu_3);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		menuBar.add(horizontalGlue);
		
		Image img = new ImageIcon("image\\Profilo.png").getImage();
		Image newImage = img.getScaledInstance(25, 25, Image.SCALE_DEFAULT);
		
		JMenu mnNewMenu_4 = new JMenu("");
		
		mnNewMenu_4.setIcon(new ImageIcon(newImage));
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Profilo");
		mnNewMenu_4.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Conologia Acquisti");
		mnNewMenu_4.add(mntmNewMenuItem_1);
		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				int str = Integer.parseInt(((String) comboBox.getSelectedItem()).substring(3));
				textArea.setText(corsa.getPercorso(str));
			}
		});
	}
}
