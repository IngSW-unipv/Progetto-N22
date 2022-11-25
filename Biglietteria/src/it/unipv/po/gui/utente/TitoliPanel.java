package it.unipv.po.gui.utente;

import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import it.unipv.po.connessioneDB.DBread;
import it.unipv.po.utente.Utente;

public class TitoliPanel extends JFrame{

	private JPanel contentPane;
	private static Utente utente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TitoliPanel frame = new TitoliPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public TitoliPanel() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		DBread db = new DBread();
		utente = db.userDownload("rose@unipv.it");
		
		Prova1 p = new Prova1(utente);
		contentPane.add(p);
		
	}

}
