package it.unipv.po.ticket.supporto.strategie;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.util.LinkedList;

import it.unipv.po.ticket.cus.SessioneService;
import it.unipv.po.ticket.cus.Utente;
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
	public void aggiungiTotaleACronologia(Utente username, LocalDateTime data, double prezzo) throws Exception {
		String sql="INSERT into CronologiaTotali(Utente,DataPagamento,Prezzo) VALUES(?,?,?);";
		Connection connessione= getDBConnection();
		PreparedStatement statement= connessione.prepareStatement(sql);
		statement.setString(1, username.getUsername());
		statement.setString(2, data.toString());
		statement.setDouble(3, prezzo);	
		
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
	public void aggiungiTitoliACronologia(Utente username, LocalDateTime date, LinkedList<Titolo> lista) throws Exception {
		String sql="INSERT into CronologiaTitoli(Utente,DataPagamento,IDTitolo,PrezzoTitolo) VALUES(?,?,?,?);";
		Connection connessione= getDBConnection();
		PreparedStatement statement= connessione.prepareStatement(sql);
		for(int i=0; i<lista.size(); i++) {
			statement.setString(1, username.getUsername());
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
	public void aggiungiUtente(Utente username) throws Exception {
		String sql="INSERT into Utente(Utente,Nome,Cognome,Email,Username,Password) VALUES(?,?,?,?);";
		Connection connessione= getDBConnection();
		PreparedStatement statement= connessione.prepareStatement(sql);
		statement.setString(1, username.getUsername());
		statement.setString(2, username.getName());
		statement.setString(3,username.getSurname());
		statement.setString(4,username.getEmail());	
		statement.setString(5,username.getPassword());
		
		statement.executeUpdate();
		
	}

	



}
