package it.unipv.po.ticket.supporto.strategie;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.util.LinkedList;


import it.unipv.po.ticket.gui.utente.Utente;
import it.unipv.po.ticket.titolo.Titolo;

public class AccessDBwriteStrategy implements IDBwriteStrategy{
	
	private static final String databaseURL  = "jdbc:ucanaccess://DB//DatabaseBiglietteria.accdb";
	
	@Override
	public Connection getDBConnection() throws Exception {
		
		// Funzione per creare la connessione
		//System.out.println("------------- DB Connection -------------");
		Connection dbConnection = DriverManager.getConnection(databaseURL);
		
		return dbConnection;
	}

	@Override
	public void aggiungiTotaleACronologia(String username, LocalDateTime data, double prezzo, double puntiUtilizzati) throws Exception {
		String sql="INSERT into CronologiaTotali(Utente,DataPagamento,Prezzo,PuntiUtilizzati) VALUES(?,?,?,?);";
		Connection connessione= getDBConnection();
		PreparedStatement statement= connessione.prepareStatement(sql);
		statement.setString(1, username);
		statement.setString(2, data.toString());
		statement.setDouble(3, prezzo);	
		statement.setDouble(4, puntiUtilizzati);
		
		statement.executeUpdate();
	 	// Chiudo la connessione
     	if(statement != null) {
     		statement.close();
     	}
     	if(connessione != null) {
     		connessione.close();
     	}
	}
	
	@Override
	public void aggiungiTitoliACronologia(String username, LocalDateTime date, LinkedList<Titolo> lista) throws Exception {
		String sql="INSERT into CronologiaTitoli(Utente,DataPagamento,IDTitolo,PrezzoTitolo) VALUES(?,?,?,?);";
		Connection connessione= getDBConnection();
		PreparedStatement statement= connessione.prepareStatement(sql);
		for(int i=0; i<lista.size(); i++) {
			statement.setString(1, username);
			statement.setString(2, date.toString());
			statement.setString(3, lista.get(i).getID());
			statement.setDouble(4, lista.get(i).getPrezzo());
	
			statement.executeUpdate();
		}
    	// Chiudo la connessione
     	if(statement != null) {
     		statement.close();
     	}
     	if(connessione != null) {
     		connessione.close();
     	}
	}
	
	
	//metodo per la registrazione degli utenti
	public void aggiungiUtente(Utente utente) throws Exception {
		String sql="INSERT into Utente(Username,Password,Nome,Cognome,Email,Punti) VALUES(?,?,?,?,?,?);";
		Connection connessione= getDBConnection();
		PreparedStatement statement= connessione.prepareStatement(sql);
		statement.setString(1, utente.getUsername());
		statement.setString(2, utente.getPassword());
		statement.setString(3,utente.getName());
		statement.setString(4,utente.getCognome());
		statement.setString(5,utente.getEmail());	
		statement.setString(6, "0");
		
		statement.executeUpdate();
		
	}


	

	



}
