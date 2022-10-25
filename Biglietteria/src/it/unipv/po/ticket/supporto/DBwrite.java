package it.unipv.po.ticket.supporto;

import java.sql.Connection;
import java.time.LocalDateTime;

import it.unipv.po.ticket.cus.Sessione;
import it.unipv.po.ticket.cus.Utente;
import it.unipv.po.ticket.supporto.strategie.AccessDBwriteStrategy;
import it.unipv.po.ticket.supporto.strategie.IDBwriteStrategy;

public class DBwrite{
private static IDBwriteStrategy strategiaDiScrittura;
	
	public DBwrite() {
		strategiaDiScrittura= new AccessDBwriteStrategy();
	}
	
	public Connection getDBConnection() throws Exception{
		return strategiaDiScrittura.getDBConnection();
	}
	
	public void aggiungiACronologia(Utente username, Sessione sessione, LocalDateTime data, double prezzo) throws Exception {
		 strategiaDiScrittura.aggiungiACronologia(username, sessione, data, prezzo);
	
	}
	
	public void aggiungiUtente(Utente username) throws Exception {
		 strategiaDiScrittura.aggiungiUtente(username);
	}
	
}

