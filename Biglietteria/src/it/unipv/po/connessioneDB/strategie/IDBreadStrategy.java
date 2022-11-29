package it.unipv.po.connessioneDB.strategie;

import java.sql.Connection; 
import java.sql.SQLException;
import java.util.ArrayList;
import it.unipv.po.trasporto.fermata.Fermata;
import it.unipv.po.trasporto.linea.Linea;
import it.unipv.po.trasporto.titolo.Titolo;
import it.unipv.po.trasporto.vehicleModel.Vehicle;
import it.unipv.po.utente.Utente;


public interface IDBreadStrategy {
	
	public Connection getDBConnection() throws SQLException;
	
	/**
	 * Costruisce una Linea a partire dalle informazioni trovate nel DataBase ottenute
	 * cercando la linea per id.
	 * @param id della linea interessata
	 * @return la linea con l'id specificato
	 * @throws SQLException dovuta alla connessione al DataBase
	 */
	public Linea getLinea(int id) throws SQLException;
	
	/**
	 * Costruisce un array list di fermate appartenenti a una linea specifica.
	 * Reperisce le informazioni dal DataBase.
	 * @param IDlinea della linea interessata
	 * @return un'arrayList di fermate appartenenti alla linea IDlinea
	 * @throws SQLException dovuta alla connessione al DataBase
	 */
	public ArrayList<Fermata> getFermate(String IDlinea) throws SQLException;
	
	/**
	 * Costruisce un array di linee che intersecano la fermata indicata.
	 * Reperisce le informazioni dal DataBase.
	 * @param IDfermata 	id della fermata di interesse
	 * @return restituisce 	l'arrayList di linee associate a quella fermata
	 * @throws SQLException dovuta alla connessione al DataBase
	 */
	public ArrayList<Linea> searchLinea(String IDfermata) throws SQLException;
	
	/**
	 * 
	 * @param partenza 		stringa dell'id della fermata di partenza
	 * @param destinazione	stringa dell'id della fermata di arrivo
	 * @return				identificativo della fermata snodo tra le due fermate
	 * @throws SQLException dovuta alla connessione al DataBase
	 */
	public String getSnodi(String partenza, String destinazione) throws SQLException;
	
	/**
	 * Costruisce un vettore di fermate appartenenti al sistema.
	 * Reperisce le informazioni dal DataBase.
	 * @return				elenco delle fermate presenti sulla mappa
	 * @throws SQLException dovuta alla connessione al DataBase
	 */
	public String[] elencoFermate() throws SQLException;	
	
	/**
	 * Cerca su database le tariffe per fermata di ciascun mezzo.
	 * @param mezzo			enumeration della tipologia di mezzo
	 * @return				la tariffa per fermata del mezzo
	 * @throws SQLException dovuta alla connessione al DataBase
	 */
	double searchTariffaMezzo(Vehicle mezzo) throws SQLException;
	
	/**
	 * Reperisce informazioni dal DataBase per ricostruire un Utente registrato al sistema.
	 * @param email			dell'utente di cui reperire informazioni da DB
	 * @return				Utente corrispondente alla determinata email
	 * @throws SQLException dovuta alla connessione al DataBase
	 */
	public Utente userDownload(String username) throws SQLException;
	
	/**
	 * Scarica dal DB tutti i titoli acquistati dall'utente.
	 * Ricostruisce dalle informazioni presenti su DB dei titoli obliterabili.
	 * @param user			email dell'utente
	 * @return				ArrayList di titoli acquistati dall'utente con la specifica mail
	 * @throws SQLException dovuta alla connessione al DataBase
	 */
	public ArrayList<Titolo> scaricaTitoliUtente(String user) throws SQLException;
	
	/**
	 * Legge il dataBase per costruire l'elenco degli identificativi delle linee
	 * presenti nel sistema.
	 * @return				elenco di linee presenti sulla mappa
	 * @throws SQLException dovuta alla connessione al DataBase
	 */
	public String[] elencoLinee() throws SQLException;

	public ArrayList<Fermata> getFermateOrario(String selected, String Orario) throws SQLException;
	

	
	
	
	
}
