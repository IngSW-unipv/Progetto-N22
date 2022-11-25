package it.unipv.po.gui.home;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class HomePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public HomePanel(String name) {
		
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setBounds(317, 10, 559, 543);
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Benvenuto " + name );
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 10, 539, 29);
		add(lblNewLabel_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(90, 49, 386, 2);
		add(separator_2);
		
		JLabel label = new JLabel("  ");
		
		
		ImageIcon img = new ImageIcon("Image/mappaPiccola.png");
		label.setIcon(img);
 
        label.setBounds(100, 95, 364, 261);
        
        
        
        
		
		add(label);
		
		JLabel l1 = new JLabel(" ");
		l1.setBounds(100, 384, 15, 15);
		l1.setBackground(Color.decode("#ff0000"));
		l1.setOpaque(true);
		add(l1);
		
		JLabel l2 = new JLabel(" ");
		l2.setBounds(100, 411, 15, 15);
		l2.setBackground(Color.decode("#00fff6"));
		l2.setOpaque(true);
		add(l2);
		
		JLabel l3 = new JLabel(" ");
		l3.setBounds(100, 438, 15, 15);
		l3.setBackground(Color.decode("#ffde00"));
		l3.setOpaque(true);
		add(l3);
		
		JLabel l4 = new JLabel(" ");
		l4.setBounds(100, 465, 15, 15);
		l4.setBackground(Color.decode("#0b0190"));
		l4.setOpaque(true);
		add(l4);
		
		JLabel l5 = new JLabel(" ");
		l5.setBounds(100, 492, 15, 15);
		l5.setBackground(Color.decode("#f000ff"));
		l5.setOpaque(true);
		add(l5);

	}
	


}
