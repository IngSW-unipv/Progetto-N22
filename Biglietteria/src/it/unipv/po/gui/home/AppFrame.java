package it.unipv.po.gui.home;

import java.awt.Color; 
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import it.unipv.po.gui.ricerca.CercaPanel;
import it.unipv.po.gui.utente.AreaPersonalePanel;
import it.unipv.po.utente.Utente;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class AppFrame extends JFrame {

	private JPanel contentPane;
	private CercaPanel cercaPanel;
	private HomePanel homePanel;
	private AreaPersonalePanel areaPersonalePanel;
	private ContattiPanel contattiPanel;
	

	/**
	 * Launch the application.
	 */
	public static void main(Utente utente) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppFrame frame = new AppFrame(utente);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AppFrame(Utente utente) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 10, 240, 543);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menu");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 220, 26);
		panel.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 46, 220, 2);
		panel.add(separator);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setFont(new Font("Source Code Pro ExtraLight", Font.PLAIN, 18));
		btnNewButton.setBounds(10, 89, 220, 42);
		panel.add(btnNewButton);
		
		btnNewButton.setOpaque(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(53, 156, 131, 2);
		panel.add(separator_1);
		
		JButton btnCerca = new JButton("Cerca");
		btnCerca.setOpaque(false);
		btnCerca.setFont(new Font("Source Code Pro ExtraLight", Font.PLAIN, 18));
		btnCerca.setContentAreaFilled(false);
		btnCerca.setBorderPainted(false);
		btnCerca.setBounds(10, 191, 220, 42);
		panel.add(btnCerca);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(53, 262, 131, 2);
		panel.add(separator_1_1);
		
		JButton btnCerca_1 = new JButton("Orari");
		btnCerca_1.setOpaque(false);
		btnCerca_1.setFont(new Font("Source Code Pro ExtraLight", Font.PLAIN, 18));
		btnCerca_1.setContentAreaFilled(false);
		btnCerca_1.setBorderPainted(false);
		btnCerca_1.setBounds(10, 413, 220, 42);
		panel.add(btnCerca_1);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(53, 377, 131, 2);
		panel.add(separator_1_1_1);
		
		JButton btnCerca_1_1 = new JButton("Area Personale");
		btnCerca_1_1.setOpaque(false);
		btnCerca_1_1.setFont(new Font("Source Code Pro ExtraLight", Font.PLAIN, 18));
		btnCerca_1_1.setContentAreaFilled(false);
		btnCerca_1_1.setBorderPainted(false);
		btnCerca_1_1.setBounds(10, 296, 220, 42);
		panel.add(btnCerca_1_1);
		
		JButton btnCerca_1_1_1 = new JButton("contatti");
	
		btnCerca_1_1_1.setOpaque(false);
		btnCerca_1_1_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		btnCerca_1_1_1.setContentAreaFilled(false);
		btnCerca_1_1_1.setBorderPainted(false);
		btnCerca_1_1_1.setBounds(10, 507, 220, 26);
		panel.add(btnCerca_1_1_1);
		
		homePanel = new HomePanel(utente.getName());
		contentPane.add(homePanel);
		cercaPanel = new CercaPanel(utente);
		areaPersonalePanel = new AreaPersonalePanel(utente);
		contattiPanel = new ContattiPanel();
	
		
		
		btnCerca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				homePanel.hide();
				contentPane.remove(homePanel);
				areaPersonalePanel.hide();
				contentPane.remove(areaPersonalePanel);
				contattiPanel.hide();
				contentPane.remove(contattiPanel);
				cercaPanel.setVisible(true);
				contentPane.add(cercaPanel);
				
			}
		});
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cercaPanel.hide();
				contentPane.remove(cercaPanel);
				areaPersonalePanel.hide();
				contentPane.remove(areaPersonalePanel);
				contattiPanel.hide();
				contentPane.remove(contattiPanel);
				homePanel.setVisible(true);
				contentPane.add(homePanel);
				
			}
		});
		
		btnCerca_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cercaPanel.hide();
				contentPane.remove(cercaPanel);
				homePanel.hide();
				contentPane.remove(homePanel);
				contattiPanel.hide();
				contentPane.remove(contattiPanel);
				areaPersonalePanel.setVisible(true);
				contentPane.add(areaPersonalePanel);
				
				
			}
		});
		
		
		btnCerca_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cercaPanel.hide();
				contentPane.remove(cercaPanel);
				homePanel.hide();
				contentPane.remove(homePanel);
				areaPersonalePanel.hide();
				contentPane.remove(areaPersonalePanel);
				contattiPanel.setVisible(true);
				contentPane.add(contattiPanel);
			}
		});
		
	}
}
