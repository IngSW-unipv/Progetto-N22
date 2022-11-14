package it.unipv.po.ticket.supporto;

import java.sql.Connection; 
import java.time.LocalDateTime;
import java.util.LinkedList;

import it.unipv.po.ticket.gui.utente.Utente;
import it.unipv.po.ticket.supporto.strategie.AccessDBwriteStrategy;
import it.unipv.po.ticket.supporto.strategie.IDBwriteStrategy;
import it.unipv.po.ticket.titolo.Titolo;

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

