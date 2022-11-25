package it.unipv.po.connessioneDB.strategie;

import java.sql.Connection;   
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.ArrayList;
import it.unipv.po.trasporto.fermata.Fermata;
import it.unipv.po.trasporto.linea.Linea;
import it.unipv.po.trasporto.titolo.Abbonamento;
import it.unipv.po.trasporto.titolo.Biglietto;
import it.unipv.po.trasporto.titolo.Titolo;
import it.unipv.po.trasporto.vehicleModel.Vehicle;
import it.unipv.po.utente.Utente;


public class AccessDBreadStrategy implements IDBreadStrategy{
	
	//percorso della directory del database
	private static final String databaseURL  = "jdbc:ucanaccess://DB//DatabaseBiglietteria.accdb";
	//private static final String databaseURL  = "jdbc:ucanaccess://DB//DatabaseBiglietteri.accdb";
	public Connection getDBConnection() throws SQLException{
		Connection dbConnection = null;
		// Funzione per creare la connessione
		//System.out.println("------------- DB Connection -------------");
		dbConnection = DriverManager.getConnection(databaseURL);
		
		return dbConnection;
	}

	public Linea getLinea(int id) throws SQLException{
		String sql = "SELECT * FROM Linea where Linea.ID = "+ id;
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

	public String getSnodi(String partenza, String destinazione) throws SQLException {
		
		String sql = "select distinct IDfermata from Orario where IDlinea = (select distinct IDlinea from Linea Where IDlinea = '"+ partenza +"') and IDfermata IN (select distinct IDfermata from Orario where IDlinea = (select distinct IDlinea from Linea Where IDlinea = '"+ destinazione+"'))";
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

	public String[] elencoFermate() throws SQLException {
		String sql = "SELECT COUNT(IDfermata) FROM Fermata";
		Connection connection = null;
		Statement statement = null;
		
		connection = getDBConnection();
		statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        
        result.next();
        
        int i = 1;
        String[] str = new String[result.getInt(1)+1];
        str[0] = "";
        sql = "SELECT IDfermata FROM Fermata";
        result = statement.executeQuery(sql);
        
        while (result.next()) {
			
			str[i] = result.getString("IDfermata");
			i++;
            
	    }
        
        // Chiudo la connessione
     	if(statement != null) {
     		statement.close();
     	}
     	if(connection != null) {
     		connection.close();
     	}
		
		return str;
	}

	public ArrayList<Fermata> getFermate(String IDlinea) throws SQLException {
		String sql = "SELECT * FROM Orario inner join Linea on Orario.IDlinea = Linea.IDlinea WHERE Orario.IDlinea = '"+ IDlinea +"'";
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
        	fermataDB.setOrario(LocalTime.parse(result.getString("Orario")));
        	
        	fermataDB.setMezzo(Vehicle.valueOf(result.getString("Mezzo")));
        	fermataDB.setCodiceLinea(result.getString("IDlinea"));
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

	public ArrayList<Linea> searchLinea(String IDfermata) throws SQLException {
		String sql = "SELECT distinct Linea.ID FROM Orario inner join Linea on Linea.IDlinea = Orario.IDlinea WHERE IDfermata = '"+ IDfermata +"'";
		Connection connection = null;
		Statement statement = null;
		
		connection = getDBConnection();
		statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);

        ArrayList<Linea> corsa = new ArrayList<Linea>();
        
        while (result.next()) {
        
        	corsa.add(getLinea(result.getInt("Linea.ID")));
        			
        }
        
    	// Chiudo la connessione
     	if(statement != null) {
     		statement.close();
     	}
     	if(connection != null) {
     		connection.close();
     	}
     		
		return corsa;
	}

	public double searchTariffaMezzo(Vehicle mezzo) throws SQLException {
		String sql = "SELECT Tariffa FROM TariffaMezzo WHERE Mezzo = '"+ mezzo.toString() +"'";
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
     	
        return result.getDouble("Tariffa");
		
	}
	
	public Utente userDownload(String email) throws SQLException{
		String sql = "SELECT * FROM Utente WHERE Email = '"+ email + "'" ;
		Connection connection = null;
		Statement statement = null;
		
		connection = getDBConnection();
		statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
     
        Utente utente;
        
        if(result.next()) utente = new Utente(result.getString("Nome"),result.getString("Cognome"),result.getString("Email"),result.getString("Password"), result.getDouble("Punti"));
        else utente = null;
        
    	// Chiudo la connessione
     	if(statement != null) {
     		statement.close();
     	}
     	if(connection != null) {
     		connection.close();
     	}
     	
		return utente;
	}

	public ArrayList<Titolo> scaricaTitoliUtente(String email) throws SQLException {
		String sql = "SELECT * FROM CronologiaTitoli WHERE Utente = '"+ email + "'" ;
		Connection connection = null;
		Statement statement = null;
		
		connection = getDBConnection();
		statement = connection.createStatement();
	    ResultSet result = statement.executeQuery(sql);
	    
	    ArrayList<Titolo> titoliGenerati = new ArrayList<Titolo>();
	    while(result.next()) {
		    String idTitolo = result.getString("IDtitolo");
			String dataAcquisto = result.getString("DataPagamento");
			double prezzo = result.getDouble("PrezzoTitolo");
			String percorso = result.getString("Percorso");
		    if(result.getString("DataInizio").compareTo("") == 0) {
		    	//è un biglietto
		    	boolean attivo = result.getBoolean("Attivo");
		    	boolean disponibile = result.getBoolean("Disponibile");
		    	Biglietto titolo = new Biglietto(idTitolo, prezzo, percorso, disponibile, attivo, dataAcquisto);
		    	titoliGenerati.add(titolo);
		    }
		    else {
		    	//è un abbonamento
		    	String dataInizio = result.getString("DataInizio");
		    	int durataGiorni = result.getInt("Durata");
		    	Abbonamento titolo = new Abbonamento(idTitolo, prezzo, percorso,dataInizio,durataGiorni,dataAcquisto);
		    	titoliGenerati.add(titolo);
		    }
		    
	    }
	    
		// Chiudo la connessione
     	if(statement != null) {
     		statement.close();
     	}
     	if(connection != null) {
     		connection.close();
     	}
     	
	    
	    return titoliGenerati;
	
	}
	
	public String[] elencoLinee() throws SQLException {
		String sql = "SELECT IDlinea FROM Linea";
		Connection connection = null;
		Statement statement = null;
		
		connection = getDBConnection();
		statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        
        
        int i = 1;
        String[] str = new String[100];
        str[0]="";
 
        
        while (result.next()) {
			
			str[i] = result.getString("IDlinea");
			i++;
            
	    }
        
        // Chiudo la connessione
     	if(statement != null) {
     		statement.close();
     	}
     	if(connection != null) {
     		connection.close();
     	}
		
		return str;
	}
		
}
