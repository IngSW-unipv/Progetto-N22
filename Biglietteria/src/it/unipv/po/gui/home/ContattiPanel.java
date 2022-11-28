package it.unipv.po.gui.home;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class ContattiPanel extends JPanel {

	public ContattiPanel() {
		
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setBounds(317, 10, 559, 543);
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Ecco come puoi contattare il supporto");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 10, 539, 29);
		add(lblNewLabel_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(90, 49, 386, 2);
		add(separator_2);
		
		JLabel lblNewLabel = new JLabel("Email:   BiglietteriaProject.GiavaTeam@support.com");
		lblNewLabel.setBounds(75, 117, 399, 15);
		add(lblNewLabel);
		
		JLabel lblLiveChat = new JLabel("Live chat:  +39 3473950612");
		lblLiveChat.setBounds(75, 163, 399, 15);
		add(lblLiveChat);
		
		JLabel lblNewLabel_3 = new JLabel("Facebook: www.facebook.com/Giava  tramite messaggio privato");
		lblNewLabel_3.setBounds(75, 207, 474, 15);
		add(lblNewLabel_3);
		
		JLabel lemail = new JLabel("");
		lemail.setBounds(42, 117, 20, 20);
		ImageIcon img = new ImageIcon("Image/email.png");
		lemail.setIcon(img);
		add(lemail);
		
		JLabel lwhat = new JLabel(" ");
		lwhat.setBounds(42, 163, 20, 20);
		ImageIcon img2 = new ImageIcon("Image/whatsapp.png");
		lwhat.setIcon(img2);
		add(lwhat);
		
		JLabel lface = new JLabel(" ");
		lface.setBounds(42, 207, 20, 20);
		ImageIcon img3 = new ImageIcon("Image/facebook.png");
		lface.setIcon(img3);
		add(lface);
		
		JLabel lthank = new JLabel(" ");
		lthank.setBounds(139, 259, 250, 250);
		ImageIcon img4 = new ImageIcon("Image/thank.png");
		lthank.setIcon(img4);
		add(lthank);
		
		
	}

	}


