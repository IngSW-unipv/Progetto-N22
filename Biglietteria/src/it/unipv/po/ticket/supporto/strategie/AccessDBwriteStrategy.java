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
	public void aggiungiACronologia(Utente username, Sessione sessione, LocalDateTime data, double prezzo) throws Exception {
		String sql="INSERT into Cronologia(Utente,Sessione,DataPagamento,Prezzo) VALUES(?,?,?,?);";
		Connection connessione= getDBConnection();
		PreparedStatement statement= connessione.prepareStatement(sql);
		statement.setString(1, username.getUsername());
		statement.setString(2, sessione.getIDsessione());
		statement.setString(3, data.toString());
		statement.setDouble(4, prezzo);	
		
		statement.executeUpdate();
	}



}
