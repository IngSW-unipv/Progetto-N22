package it.unipv.po.ticket.supporto;

import java.sql.*;
import java.util.ArrayList;

import it.unipv.po.ticket.trasporto.fermata.Fermata;
import it.unipv.po.ticket.trasporto.linea.Linea;
import it.unipv.po.ticket.trasporto.vehicleModel.Vehicle;
import it.unipv.po.ticket.trasporto.zonaModel.Zona;

public class DBconnection {
	//percorso della directory del database
	private static final String databaseURL  = "jdbc:ucanaccess://DB//DatabaseBiglietteria.accdb";
	
	public static Connection getDBConnection() throws Exception {
		// Funzione per creare la connessione
		//System.out.println("------------- DB Connection -------------");
		Connection dbConnection = null;
				
		dbConnection = DriverManager.getConnection(databaseURL);
		
		return dbConnection;
	}
	
	public static Linea getLinee(int id) throws Exception{
		String sql = "SELECT * FROM Linea WHERE ID = "+ id;
		Connection connection = null;
		Statement statement = null;
		
		Linea lineaDB = new Linea();
		
		connection = getDBConnection();
		statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        
        result.next();
			
        //inserisco gli elementi della tabella
	    lineaDB.setIDlinea(result.getString("IDlinea"));
	    lineaDB.setMezzo(Vehicle.valueOf(result.getString("Mezzo")));
	    lineaDB.setZona(Zona.valueOf(result.getString("Zona")));
	    lineaDB.setKm(0);
	    lineaDB.setLinieAttive(0);
       
        
		// Chiudo la connessione
		if(statement != null) {
			statement.close();
				}
		if(connection != null) {
			connection.close();
		}		
		
		//rihciamo la funzione per inserire anche l'elenco delle fermate
		lineaDB.setLinea(getFermate(lineaDB.getIDlinea()));
				
		return lineaDB;
	}
	
	public static ArrayList<Fermata> getFermate(String IDlinea) throws Exception{
		String sql = "SELECT * FROM Corsa WHERE IDlinea = '"+ IDlinea +"'";
		Connection connection = null;
		Statement statement = null;
		
		Fermata fermataDB;
		ArrayList<Fermata> lineaDB = new ArrayList<Fermata>();
		
		connection = getDBConnection();
		statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
		
		while (result.next()) {
			
			fermataDB = new Fermata();

        	//leggo la tabella
        	fermataDB.setCodiceFermata(result.getString("IDfermata"));
        	fermataDB.setOrario(result.getString("Orario"));
       
            //inserisco le fermate nell'array
        	lineaDB.add(fermataDB);
            
	    }
		
		// Chiudo la connessione
		if(statement != null) {
			statement.close();
		}
		if(connection != null) {
			connection.close();
		}
			
		return lineaDB;
		
	}
	
	public static int searchLinea(String IDfermata) throws Exception {
		String sql = "SELECT Linea.ID FROM Corsa inner join Linea on Linea.IDlinea = corsa.IDlinea WHERE IDfermata = '"+ IDfermata +"'";
		Connection connection = null;
		Statement statement = null;
		
		connection = getDBConnection();
		statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        
        result.next();
        
    	// Chiudo la connessione
     	if(statement != null) {
     		statement.close();
     	}
     	if(connection != null) {
     		connection.close();
     	}
     		
		return result.getInt("Linea.ID");
		
	}
	
	public static String getSnodi(int partenza, int destinazione) throws Exception {
		String sql = "select distinct IDfermata from Corsa where IDlinea = (select distinct IDlinea from Linea Where ID = '"+ partenza +"') "
					+ "and IDfermata IN (select distinct IDfermata from Corsa where IDlinea =(select distinct IDlinea from Linea Where ID = '"+ partenza +"'))";
		Connection connection = null;
		Statement statement = null;
		
		connection = getDBConnection();
		statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
       
        result.next();
        
        // Chiudo la connessione
     	if(statement != null) {
     		statement.close();
     	}
     	if(connection != null) {
     		connection.close();
     	}
		
		return result.getString("IDfermata");
		
	}
}
