package it.unipv.po.connessioneDB;

import java.sql.*; 


public class DBconnection {
	//percorso della directory del database
	//private static final String databaseURL  = "jdbc:ucanaccess://DB//DatabaseBiglietteria.accdb";
	private static IDBconnectionStrategy strategiaDiConnessione;
	
	public DBconnection() {
		strategiaDiConnessione= new AccessDBconnectionStrategy();
	}
	
	public static Connection getDBConnection() {
		try {
			return strategiaDiConnessione.getDBConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
