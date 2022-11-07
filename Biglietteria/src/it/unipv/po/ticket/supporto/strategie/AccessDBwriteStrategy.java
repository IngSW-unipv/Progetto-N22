package it.unipv.po.ticket.supporto.strategie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;

import it.unipv.po.ticket.cus.Sessione;
import it.unipv.po.ticket.cus.Utente;

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
	public void aggiungiACronologia(Utente username, LocalDateTime data, double prezzo) throws Exception {
		String sql="INSERT into Cronologia(Utente,DataPagamento,Prezzo) VALUES(?,?,?);";
		Connection connessione= getDBConnection();
		PreparedStatement statement= connessione.prepareStatement(sql);
		statement.setString(1, username.getUsername());
		statement.setString(2, data.toString());
		statement.setDouble(3, prezzo);	
		
		statement.executeUpdate();
	}
	//metodo per la registrazione degli utenti
	public void aggiungiUtente(Utente username) throws Exception {
		String sql="INSERT into Utente(Utente,Nome,Cognome,Email,Username,Password) VALUES(?,?,?,?);";
		Connection connessione= getDBConnection();
		PreparedStatement statement= connessione.prepareStatement(sql);
		statement.setString(1, username.getUsername());
		statement.setString(2, username.getNome());
		statement.setString(3,username.getCognome());
		statement.setString(4,username.geteMail());	
		statement.setString(5,username.getPassword());
		
		statement.executeUpdate();
	}

	



}
