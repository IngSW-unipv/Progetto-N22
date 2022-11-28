package it.unipv.po.connessioneDB.strategie;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import it.unipv.po.trasporto.titolo.Titolo;
import it.unipv.po.utente.Utente;


public interface IDBwriteStrategy {
	public Connection getDBConnection() throws SQLException;
	
	/**
	 * Scrive su database gli attributi dell'utente passato come parametro.
	 * Table: Utente.
	 * @param utente					nuovo utente da registrare su DB
	 * @throws SQLException				dovuta alla connessione al DataBase
	 * @throws NoSuchAlgorithmException 
	 */
	public void aggiungiUtente(Utente username) throws SQLException, NoSuchAlgorithmException;
	
	/**
	 * Scrive su DB i informazioni dei titoli passati come argomento e informazioni dell'utente che li ha acquistati.
	 * Table: CronologiaTitoli.
	 * @param username		email dell'utente che ha eseguito l'acquisto
	 * @param date			data del pagamento
	 * @param lista			lista dei titoli acquistati
	 * @throws SQLException dovuta alla connessione al DataBase
	 */
	void aggiungiTitoliACronologia(String username, LocalDateTime date, ArrayList<Titolo> lista) throws SQLException;
	
	/**
	 * Scrive su DB il totale del pagamento effettuato dall'utente.
	 * Table: CronologiaTotali.
	 * @param username			email dell'utente che ha eseguito l'acquisto
	 * @param data				data del pagamento
	 * @param prezzo			prezzo finale pagato (sottratto del credito utilizzato)
	 * @param puntiUtilizzati	credito utilizzato
	 * @throws SQLException		dovuta alla connessione al DataBase
	 */
	void aggiungiTotaleACronologia(String username, LocalDateTime data, double prezzo, double puntiUtilizzati) throws SQLException;
	
	/**
	 * Aggiorna il database a seguito dell'obliterazione di un titolo
	 * @param idTitolo		titolo utilizzato	
	 * @throws SQLException dovuta alla connessione al DataBase
	 * Table: CronologiaTitoli.
	 */
	public void oblitera(String idTitolo) throws SQLException;
	
	/**
	 * Aggiorna il database reimpostando il credito dell'utente.
	 * Table: Utente.
	 * @param credito		credito dell'utente
	 * @param Email			email dell'utente
	 * @throws SQLException dovuta alla connessione al DataBase
	 */
	public void aggiornaCredito(double credito, String Email)throws SQLException;
	


}
