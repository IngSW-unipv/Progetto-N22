package it.unipv.po.connessioneDB;

import java.sql.Connection; 
import java.sql.DriverManager;



public class AccessDBconnectionStrategy implements IDBconnectionStrategy{
	private static final String databaseURL  = "jdbc:ucanaccess://DB//DatabaseBiglietteria.accdb";
	
	@Override
	public Connection getDBConnection() throws Exception {
		// Funzione per creare la connessione
		//System.out.println("------------- DB Connection -------------");
		Connection dbConnection = null;						
		dbConnection = DriverManager.getConnection(databaseURL);
		
		return dbConnection;
	}
		
}
