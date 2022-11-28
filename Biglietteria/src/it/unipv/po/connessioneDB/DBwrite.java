package it.unipv.po.connessioneDB;
   
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import it.unipv.po.connessioneDB.strategie.AccessDBwriteStrategy;
import it.unipv.po.connessioneDB.strategie.IDBwriteStrategy;
import it.unipv.po.trasporto.titolo.Titolo;
import it.unipv.po.utente.Utente;


public class DBwrite{
private static IDBwriteStrategy strategiaDiScrittura;
	
	/**
	 * costruttore dello strumento con la responsabilità di scrivere sul DataBase
	 */
	public DBwrite() {
		strategiaDiScrittura= new AccessDBwriteStrategy();
	}
	
	/**
	 * chiama l'analoga funzione nella strategia di lettura.
	 * @param username			email dell'utente che ha eseguito l'acquisto
	 * @param data				data del pagamento
	 * @param prezzo			prezzo finale pagato (sottratto del credito utilizzato)
	 * @param puntiUtilizzati	credito utilizzato
	 * @throws SQLException		dovuta alla connessione al DataBase
	 */
	public void aggiungiTotaleACronologia(String username, LocalDateTime data, double prezzo, double puntiUtilizzati) throws SQLException {
		 strategiaDiScrittura.aggiungiTotaleACronologia(username, data, prezzo, puntiUtilizzati);
	
	}
	
	/**
	 * chiama l'analoga funzione nella strategia di lettura.
	 * @param user			email dell'utente che ha eseguito l'acquisto
	 * @param date			data del pagamento
	 * @param lista			lista dei titoli acquistati
	 * @throws SQLException dovuta alla connessione al DataBase
	 */
	public void aggiungiTitoliACronologia(String user, LocalDateTime date, ArrayList<Titolo> lista) throws SQLException {
		 strategiaDiScrittura.aggiungiTitoliACronologia(user, date, lista);
	}
	
	/**
	 * chiama l'analoga funzione nella strategia di lettura.
	 * @param utente					nuovo utente da registrare su DB
	 * @throws SQLException				dovuta alla connessione al DataBase
	 * @throws NoSuchAlgorithmException 
	 */
	public void aggiungiUtente(Utente utente) throws SQLException, NoSuchAlgorithmException{
		 strategiaDiScrittura.aggiungiUtente(utente);
	}

	/**
	 * chiama l'analoga funzione nella strategia di lettura.
	 * @param idTitolo		titolo utilizzato	
	 * @throws SQLException dovuta alla connessione al DataBase
	 */
	public void oblitera(String idTitolo) throws SQLException {
		strategiaDiScrittura.oblitera(idTitolo);
		
	}

	/**
	 * chiama l'analoga funzione nella strategia di lettura.
	 * @param credito		credito dell'utente
	 * @param Email			email dell'utente
	 * @throws SQLException dovuta alla connessione al DataBase
	 */
	public void aggiornaCredito(double credito, String Email) throws SQLException{
		strategiaDiScrittura.aggiornaCredito(credito, Email);
		
	}
	
	
	
}

