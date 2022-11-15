package it.unipv.po.ticket.supporto.strategie;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.ArrayList;

import it.unipv.po.ticket.gui.utente.Utente;
import it.unipv.po.ticket.trasporto.fermata.Fermata;
import it.unipv.po.ticket.trasporto.linea.Linea;
import it.unipv.po.ticket.trasporto.vehicleModel.Vehicle;

public class AccessDBreadStrategy implements IDBreadStrategy{
	
	//percorso della directory del database
	private static final String databaseURL  = "jdbc:ucanaccess://DB//DatabaseBiglietteria.accdb";

	@Override
	public Connection getDBConnection() throws Exception {
		
		// Funzione per creare la connessione
		//System.out.println("------------- DB Connection -------------");
		Connection dbConnection = DriverManager.getConnection(databaseURL);
		
		return dbConnection;
		
	}

	@Override
	public Linea getLinea(int id) throws Exception{
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

	@Override
	public String getSnodi(String partenza, String destinazione) throws Exception {
		
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

	@Override
	public String[] elencoFermate() throws Exception{
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

	@Override
	public ArrayList<Fermata> getFermate(String IDlinea) throws Exception {
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

	@Override
	public ArrayList<Linea> searchLinea(String IDfermata) throws Exception {
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
	
	
	
	
	public String searchPassword(String user) throws Exception {
		String sql = "SELECT Password FROM Utente WHERE Username = '"+ user +"'";
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
     		
		return result.getString("Password");
		
	}
	
	
	public int searchUsername(String user) throws Exception {
		String sql = "SELECT count(*) FROM Utente WHERE Username = '"+ user +"'";
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
     		
		return ((Number) result.getObject(1)).intValue();
		
	}
	
	@Override
	public double searchTariffaMezzo(Vehicle mezzo) throws Exception {
		String sql = "SELECT Tariffa FROM TariffaMezzo WHERE Mezzo = '"+ mezzo.toString() +"'";
		Connection connection = null;
		Statement statement = null;
		
		connection = getDBConnection();
		statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        
        result.next();
        return result.getDouble("Tariffa");
		
	}
	

/*	@Override
	public Utente login(String username,String password) throws Exception {
		String sql = "SELECT * FROM Utente WHERE Username = '"+ username +"' and Password = '"+ password +"'" ;
		Connection connection = null;
		Statement statement = null;
		
		connection = getDBConnection();
		statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        Utente user = new Utente();
        user.setUsername(result.getString(1));
        user.setPassword(result.getString(2));
        user.setName(result.getString(3));
        user.setCognome(result.getString(4));
        user.setEmail(result.getString(5));
        
		return user;
	}*/
		
}
