package it.unipv.po.ticket.gui.home;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private JPanel contentPane;
	private JPanel homePagePanel;
	private JPanel searchPagePanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 873, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel bar = new JPanel();
		bar.setBounds(0, 0, 222, 524);
		contentPane.add(bar);
		bar.setLayout(null);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setBounds(10, 71, 192, 63);
		bar.add(btnNewButton);
		
		JButton btnCerca = new JButton("Cerca");
		btnCerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homePagePanel.hide();
				contentPane.remove(homePagePanel);
				contentPane.add(searchPagePanel);
				searchPagePanel.setLayout(null);
			}
		});
		btnCerca.setBounds(10, 167, 192, 63);
		bar.add(btnCerca);
		
		JButton btnAreaPersonale = new JButton("Area personale");
		btnAreaPersonale.setBounds(10, 258, 192, 63);
		bar.add(btnAreaPersonale);
		
		JButton btnContatti = new JButton("Contatti");
		btnContatti.setBounds(10, 356, 192, 63);
		bar.add(btnContatti);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("Image/bar3.png"));
		lblNewLabel_2.setBounds(0, 0, 222, 524);
		bar.add(lblNewLabel_2);
		
		homePagePanel = new JPanel();
		homePagePanel.setBounds(234, 0, 636, 524);
		contentPane.add(homePagePanel);
		homePagePanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Biglietteria");
		lblNewLabel_1.setBounds(204, 22, 225, 46);
		homePagePanel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 26));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Image/mappaPiccola.png"));
		lblNewLabel.setBounds(28, 80, 598, 356);
		homePagePanel.add(lblNewLabel);
		
		searchPagePanel = new JPanel();
		searchPagePanel.setBounds(234, 0, 636, 524);
		
		JLabel searchLabelTitle = new JLabel("Cerca");
		searchLabelTitle.setBounds(240, 24, 155, 46);
		searchPagePanel.add(searchLabelTitle);
		searchLabelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		searchLabelTitle.setFont(new Font("Calibri", Font.BOLD, 26));
		
	
	}
}
