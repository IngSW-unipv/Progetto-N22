package it.unipv.po.connessioneDB.strategie;
 
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import it.unipv.po.sessione.Sessione;
import it.unipv.po.trasporto.titolo.Titolo;

import it.unipv.po.utente.Utente;


public class AccessDBwriteStrategy implements IDBwriteStrategy{
	
	private static final String databaseURL  = "jdbc:ucanaccess://DB//DatabaseBiglietteria.accdb";
	
	@Override
	public Connection getDBConnection() throws SQLException {
		
		// Funzione per creare la connessione
		//System.out.println("------------- DB Connection -------------");
		Connection dbConnection = DriverManager.getConnection(databaseURL);
		
		return dbConnection;
	}

	@Override
	public void aggiungiTotaleACronologia(String email, LocalDateTime data, double prezzo, double puntiUtilizzati) throws SQLException {
		String sql="INSERT into CronologiaTotali(Utente,DataPagamento,Prezzo,PuntiUtilizzati) VALUES(?,?,?,?);";
		Connection connessione= getDBConnection();
		PreparedStatement statement= connessione.prepareStatement(sql);
		statement.setString(1, email);
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
	public void aggiungiTitoliACronologia(String email, LocalDateTime date, ArrayList<Titolo> lista) throws SQLException {
		String sql="INSERT into CronologiaTitoli(Utente,DataPagamento,IDTitolo,PrezzoTitolo,Percorso,Attivo,Disponibile,DataInizio,Durata) VALUES(?,?,?,?,?,?,?,?,?);";
		Connection connessione= getDBConnection();
		PreparedStatement statement= connessione.prepareStatement(sql);
		for(int i=0; i<lista.size(); i++) {
			statement.setString(1, email);
			statement.setString(2, date.toString());
			statement.setString(3, lista.get(i).getIdTitolo());
			statement.setDouble(4, lista.get(i).getPrezzo());
			statement.setString(5, lista.get(i).getStringPercorso());
			//per la ricostruzione degli oggetti Titolo una volta riloggati
			statement.setBoolean(6, lista.get(i).isAttivo());
			statement.setBoolean(7, lista.get(i).isDisponibile());
			statement.setString(8, lista.get(i).getDataInizio());
			statement.setInt(9, lista.get(i).getDurataAbbonamento());
	
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
	public void aggiungiUtente(Utente utente) throws SQLException, NoSuchAlgorithmException {
		String sql="INSERT into Utente(Password,Nome,Cognome,Email,Punti) VALUES(?,?,?,?,?);";
		String password="";
		Connection connessione= getDBConnection();
		PreparedStatement statement= connessione.prepareStatement(sql);
		password = Sessione.sha1(utente.getPassword());
		statement.setString(1, password);
		statement.setString(2,utente.getName());
		statement.setString(3,utente.getCognome());
		statement.setString(4,utente.getEmail());	
		statement.setString(5, "0");
		
		statement.executeUpdate();
		
	}

	@Override
	public void oblitera(String idTitolo) throws SQLException {
		String sql="UPDATE CronologiaTitoli SET Attivo='"+true+"', Disponibile='"+false+"'"
					+ "WHERE IDTitolo='"+idTitolo+"';";
		Connection connessione= getDBConnection();
		PreparedStatement statement= connessione.prepareStatement(sql);
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
	public void aggiornaCredito(double credito, String Email) throws SQLException {
		String sql="UPDATE Utente SET Punti='"+credito+"'"+"WHERE Email='"+ Email +"';";
		Connection connessione= getDBConnection();
		PreparedStatement statement= connessione.prepareStatement(sql);
		statement.executeUpdate();
		
		// Chiudo la connessione
	 	if(statement != null) {
	 		statement.close();
	 	}
	 	if(connessione != null) {
	 		connessione.close();
	 	}
		
	}

}
