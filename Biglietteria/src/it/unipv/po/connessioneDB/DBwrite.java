package it.unipv.po.connessioneDB;
   
import java.time.LocalDateTime;
import java.util.LinkedList;
import it.unipv.po.connessioneDB.strategie.AccessDBwriteStrategy;
import it.unipv.po.connessioneDB.strategie.IDBwriteStrategy;
import it.unipv.po.trasporto.titolo.Titolo;
import it.unipv.po.utente.Utente;


public class DBwrite{
private static IDBwriteStrategy strategiaDiScrittura;
	
	public DBwrite() {
		strategiaDiScrittura= new AccessDBwriteStrategy();
	}
	

	
	public void aggiungiTotaleACronologia(String username, LocalDateTime data, double prezzo, double puntiUtilizzati) throws Exception {
		 strategiaDiScrittura.aggiungiTotaleACronologia(username, data, prezzo, puntiUtilizzati);
	
	}
	public void aggiungiTitoliACronologia(String user, LocalDateTime date, LinkedList<Titolo> list) throws Exception {
		 strategiaDiScrittura.aggiungiTitoliACronologia(user, date, list);
	}
	
	public void aggiungiUtente(Utente utente) throws Exception {
		 strategiaDiScrittura.aggiungiUtente(utente);
	}
	
	
	
}

