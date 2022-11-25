package it.unipv.po.gui.utente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.EtchedBorder;

import it.unipv.po.connessioneDB.DBread;
import it.unipv.po.trasporto.titolo.Titolo;
import it.unipv.po.utente.Utente;

public class Prova1 extends JPanel{

	public Prova1(Utente utente) throws SQLException {
		DBread db = new DBread();
		System.out.println(utente.getName());
		
		utente.setTitoliAcquistati(db.scaricaTitoliUtente(utente.getEmail()));
		
		System.out.println(utente.getTitoliAcquistati());
		
		setLocation(10, 129);
		setSize(539, 391);
		setLayout(null);
		setBackground(Color.BLACK);
		
		JPanel contentPane = new JPanel();
		JScrollPane scroll = new JScrollPane();
		SpringLayout layout = new SpringLayout();
		JPanel mainPanel = new JPanel();
		
		mainPanel.setLayout(layout);
		setLayout(new BorderLayout());
		
		ArrayList<JLabel> label = new ArrayList<JLabel>();
		ArrayList<JTextArea> text = new ArrayList<JTextArea>();
		ArrayList<JButton> button = new ArrayList<JButton>();
		
		int j = 25;
	    for(int i =0;i<utente.getTitoliAcquistati().size();i++){
		    /*JLabel label = new JLabel("Enter Name " + i );
		    JTextField text = new JTextField(15);
		
		    mainPanel.add(label);
		    mainPanel.add(text);
		   
		    layout.putConstraint(SpringLayout.WEST, label, 10, SpringLayout.WEST, contentPane);
		    layout.putConstraint(SpringLayout.NORTH, label, j, SpringLayout.NORTH, contentPane);
		    layout.putConstraint(SpringLayout.NORTH, text, j, SpringLayout.NORTH, contentPane);
		    layout.putConstraint(SpringLayout.WEST, text, 20, SpringLayout.EAST, label);*/
	    	
	    	label.add(new JLabel(String.valueOf(utente.getTitoliAcquistati().get(i).getIdTitolo().substring(0, 13))));
	    	String str = utente.getTitoliAcquistati().get(i).getStringPercorso().replace("-", " ");;
	    	str = str.replace("T", "-");
	    	text.add(new JTextArea(String.valueOf(str)));
	    	text.get(i).setBackground(SystemColor.menu);
	    	button.add(new JButton("Oblitera"));
	    	
	    	mainPanel.add(label.get(i));
	    	mainPanel.add(text.get(i));
	    	mainPanel.add(button.get(i));
	    	
	    	layout.putConstraint(SpringLayout.WEST, label.get(i), 10, SpringLayout.WEST, contentPane);
	    	layout.putConstraint(SpringLayout.NORTH, label.get(i), j-20, SpringLayout.NORTH, contentPane);
	    	
	    	layout.putConstraint(SpringLayout.NORTH, text.get(i), j, SpringLayout.NORTH, contentPane);
		    layout.putConstraint(SpringLayout.WEST, text.get(i), 10, SpringLayout.WEST, label.get(i));
		    
		    layout.putConstraint(SpringLayout.NORTH, button.get(i), j-20, SpringLayout.NORTH, contentPane);
		    layout.putConstraint(SpringLayout.WEST, button.get(i), 20, SpringLayout.EAST, contentPane);
	    	 	
		    j+=60;
	    }
	   
		
		mainPanel.setPreferredSize(new Dimension(mainPanel.getWidth(), 1500));
	    scroll.setPreferredSize(new Dimension(520,380));
	    add(contentPane);
	    scroll.setViewportView(mainPanel);
	    contentPane.add(scroll);
	}


}
