package it.unipv.po.ticket.gui.home;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.Box;
import java.awt.Component;

public class Home {

	private JFrame frame;
	private Image img;
	private Image newImage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 508, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Home");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_2 = new JMenu("Biglietto");
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu_3 = new JMenu("New menu");
		menuBar.add(mnNewMenu_3);
			
		frame.getContentPane().setLayout(null);
		
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
		
		
		//Azioni
		
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home.main(null);
				frame.setVisible(false);
			}
		});
	}
}
