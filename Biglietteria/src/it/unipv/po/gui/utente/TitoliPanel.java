package it.unipv.po.gui.utente;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

import it.unipv.po.connessioneDB.DBread;
import it.unipv.po.utente.Utente;

public class TitoliPanel extends JPanel{

	private static Utente utente;

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public TitoliPanel(Utente utente){
		initialize(utente);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize(Utente utente){
		setLocation(10, 129);
		setSize(539, 391);
		setLayout(null);

		DBread db = new DBread();
		JPanel contentPane = new JPanel();
		JScrollPane scroll = new JScrollPane();
		SpringLayout layout = new SpringLayout();
		JPanel mainPanel = new JPanel();
		
		mainPanel.setLayout(layout);
		setLayout(new BorderLayout());
		
		ArrayList<JLabel> label = new ArrayList<JLabel>();
		ArrayList<JTextArea> text = new ArrayList<JTextArea>();
		ArrayList<JButton> button = new ArrayList<JButton>();
		
		int j = 40;
	    for(int i =0;i<utente.getTitoliAcquistati().size();i++){
	    	final int temp = i;
	    	    	
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
	    	layout.putConstraint(SpringLayout.NORTH, label.get(i), j-40, SpringLayout.NORTH, contentPane);
	    	
	    	layout.putConstraint(SpringLayout.NORTH, text.get(i), j-23, SpringLayout.NORTH, contentPane);
		    layout.putConstraint(SpringLayout.WEST, text.get(i), 10, SpringLayout.WEST, label.get(i));
		    
		    layout.putConstraint(SpringLayout.WEST, button.get(i), 20, SpringLayout.WEST, contentPane);
	    	layout.putConstraint(SpringLayout.NORTH, button.get(i), j, SpringLayout.NORTH, contentPane);
	    	 	
		    j+=100;
		    
		    //azioni
		    if(!(utente.getTitoliAcquistati().get(i).isDisponibile()) || utente.getTitoliAcquistati().get(i).isAttivo()) {
		    	button.get(i).disable();
		    	button.get(i).setVisible(false);
		    }
			button.get(i).addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
						utente.getTitoliAcquistati().get(temp).oblitera();
						button.get(temp).disable();
				    	button.get(temp).setVisible(false);
						} catch (SQLException sqlExc) {
							JOptionPane.showMessageDialog(null, "Connessione fallita!","DB error",JOptionPane.ERROR_MESSAGE);
					    } catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Qualcosa non va","Generic error",JOptionPane.ERROR_MESSAGE);
						} 
						
					}
				});
	    }
	    
	   
		
		mainPanel.setPreferredSize(new Dimension(mainPanel.getWidth(), j));
	    scroll.setPreferredSize(new Dimension(520,380));
	    add(contentPane);
	    scroll.setViewportView(mainPanel);
	    contentPane.add(scroll);
	}
		
		
}
