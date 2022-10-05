package it.unipv.po.ticket.supporto;

import java.sql.*;
import java.util.ArrayList;

import it.unipv.po.ticket.titolo.Titolo;
import it.unipv.po.ticket.trasporto.fermata.Fermata;
import it.unipv.po.ticket.trasporto.linea.Linea;
import it.unipv.po.ticket.trasporto.vehicleModel.Vehicle;
import it.unipv.po.ticket.trasporto.zonaModel.Zona;

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
	
	public static Linea getLinee(int id) throws Exception{
		return strategiaDiConnessione.getLinee(id);
	}
	
	public static ArrayList<Fermata> getFermate(String IDlinea) throws Exception{
		return strategiaDiConnessione.getFermate(IDlinea);
	}
	
	public static int searchLinea(String IDfermata) throws Exception {
		return strategiaDiConnessione.searchLinea(IDfermata);
		
	}
	
	public static String getSnodi(int partenza, int destinazione) throws Exception {
		return strategiaDiConnessione.getSnodi(partenza, destinazione);
		
	}
	
	public static String[] elencoFermate() throws Exception {
		
		return strategiaDiConnessione.elencoFermate();
		
	}
	
	/*
	public static Titolo getPrezzo(String id) throws Exception{
		String sql = "SELECT Prezzo FROM Titolo WHERE ID = "+ id;
		Connection connection = null;
		Statement statement = null;
		
		Titolo titoloDB = new Titolo();
		
		connection = getDBConnection();
		statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        
        result.next();
			
        //inserisco gli elementi della tabella
	    titoloDB.setIDtitolo(result.getString("IDtitolo"));
	    titoloDB.setPrezzo(result.getFloat("Prezzo"));
	    titoloDB.setAttivo(result.getBoolean("Attivo"));
	    
       
        
		// Chiudo la connessione
		if(statement != null) {
			statement.close();
				}
		if(connection != null) {
			connection.close();
		}		
		
		
		
				
		return titoloDB;
	}*/
}
