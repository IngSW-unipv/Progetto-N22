package it.unipv.po.ticket.supporto;

import java.sql.Connection; 
import java.time.LocalDateTime;
import java.util.LinkedList;

import it.unipv.po.ticket.cus.SessioneService;
import it.unipv.po.ticket.cus.Utente;
import it.unipv.po.ticket.supporto.strategie.AccessDBwriteStrategy;
import it.unipv.po.ticket.supporto.strategie.IDBwriteStrategy;
import it.unipv.po.ticket.titolo.Titolo;

public class DBwrite{
private static IDBwriteStrategy strategiaDiScrittura;
	
	public DBwrite() {
		strategiaDiScrittura= new AccessDBwriteStrategy();
	}
	
	public Connection getDBConnection() throws Exception{
		return strategiaDiScrittura.getDBConnection();
	}
	
	public void aggiungiTotaleACronologia(Utente username, LocalDateTime data, double prezzo) throws Exception {
		 strategiaDiScrittura.aggiungiTotaleACronologia(username, data, prezzo);
	
	}
	public void aggiungiTitoliACronologia(Utente user, LocalDateTime date, LinkedList<Titolo> list) throws Exception {
		 strategiaDiScrittura.aggiungiTitoliACronologia(user, date, list);
	}
	
	public void aggiungiUtente(Utente username) throws Exception {
		 strategiaDiScrittura.aggiungiUtente(username);
	}
	
	
	
}

