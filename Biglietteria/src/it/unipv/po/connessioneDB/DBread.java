package it.unipv.po.connessioneDB;

import java.sql.SQLException; 
import java.util.ArrayList;
import it.unipv.po.connessioneDB.strategie.AccessDBreadStrategy;
import it.unipv.po.connessioneDB.strategie.IDBreadStrategy;
import it.unipv.po.trasporto.fermata.Fermata;
import it.unipv.po.trasporto.linea.Linea;
import it.unipv.po.trasporto.titolo.Titolo;
import it.unipv.po.trasporto.vehicleModel.Vehicle;
import it.unipv.po.utente.Utente; 


public class DBread {
	private static IDBreadStrategy strategiaDiLettura;
	
	/**
	 * costruttore dello strumento di lettura del DataBase
	 */
	public DBread() {
		strategiaDiLettura = new AccessDBreadStrategy();
	}
	
	/**
	 * chiama l'analoga funzione nella strategia di lettura.
	 * @param id della linea interessata
	 * @return la linea con l'id specificato
	 * @throws SQLException dovuta alla connessione al DataBase
	 */
	public static Linea getLinea(int id) throws SQLException{
		return strategiaDiLettura.getLinea(id);
	}
	
	/**
	 * chiama l'analoga funzione nella strategia di lettura.
	 * @param IDlinea della linea interessata
	 * @return un'arrayList di fermate appartenenti alla linea IDlinea
	 * @throws SQLException dovuta alla connessione al DataBase
	 */
	public static ArrayList<Fermata> getFermate(String IDlinea) throws SQLException{
		return strategiaDiLettura.getFermate(IDlinea);
	}
	
	/**
	 * chiama l'analoga funzione nella strategia di lettura.
	 * @param IDfermata 	id della fermata di interesse
	 * @return restituisce 	l'arrayList di linee associate a quella fermata
	 * @throws SQLException dovuta alla connessione al DataBase
	 */
	public static ArrayList<Linea> searchLinea(String IDfermata) throws SQLException {
		return strategiaDiLettura.searchLinea(IDfermata);
		
	}
	
	/**
	 * chiama l'analoga funzione nella strategia di lettura.
	 * @param partenza 		stringa dell'id della fermata di partenza
	 * @param destinazione	stringa dell'id della fermata di arrivo
	 * @return				identificativo della fermata snodo tra le due fermate
	 * @throws SQLException dovuta alla connessione al DataBase
	 */
	public static String getSnodi(String partenza, String destinazione) throws SQLException {
		return strategiaDiLettura.getSnodi(partenza, destinazione);
		
	}
	
	/**
	 * chiama l'analoga funzione nella strategia di lettura.
	 * @return				elenco delle fermate presenti sulla mappa
	 * @throws SQLException dovuta alla connessione al DataBase
	 */
	public static String[] elencoFermate() throws SQLException {
		
		return strategiaDiLettura.elencoFermate();
		
	}
	
	/**
	 * chiama l'analoga funzione nella strategia di lettura.
	 * @param mezzo			enumeration della tipologia di mezzo
	 * @return				la tariffa per fermata del mezzo
	 * @throws SQLException dovuta alla connessione al DataBase
	 */
	public double searchTariffaMezzo(Vehicle mezzo) throws SQLException{
		return strategiaDiLettura.searchTariffaMezzo(mezzo);
	}
	
	/**
	 * chiama l'analoga funzione nella strategia di lettura.
	 * @param email		dell'utente di cui reperire informazioni da DB
	 * @return				Utente corrispondente alla determinata email
	 * @throws SQLException dovuta alla connessione al DataBase
	 */
	public Utente userDownload(String email) throws SQLException{
		
		return strategiaDiLettura.userDownload(email);
		
	}
	
	/**
	 * chiama l'analoga funzione nella strategia di lettura.
	 * @param user			email dell'utente
	 * @return				ArrayList di titoli acquistati dall'utente con la specifica mail
	 * @throws SQLException dovuta alla connessione al DataBase
	 */
	public ArrayList<Titolo> scaricaTitoliUtente(String user) throws SQLException {
		return strategiaDiLettura.scaricaTitoliUtente(user);
		
	}
	
	/**
	 * chiama l'analoga funzione nella strategia di lettura.
	 * @return				elenco di linee presenti sulla mappa
	 * @throws SQLException dovuta alla connessione al DataBase
	 */
	public String[] elencoLinee() throws SQLException{
		return strategiaDiLettura.elencoLinee();
	}
}
