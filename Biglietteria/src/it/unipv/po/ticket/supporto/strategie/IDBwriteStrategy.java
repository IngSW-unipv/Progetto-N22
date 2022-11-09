package it.unipv.po.ticket.supporto.strategie;

import java.sql.Connection; 
import java.time.LocalDateTime;
import java.util.LinkedList;

import it.unipv.po.ticket.cus.SessioneService;
import it.unipv.po.ticket.cus.Utente;
import it.unipv.po.ticket.titolo.Titolo;

public interface IDBwriteStrategy {
	public Connection getDBConnection() throws Exception;
	public void aggiungiUtente(Utente username) throws Exception;
	void aggiungiTitoliACronologia(Utente username, LocalDateTime date, LinkedList<Titolo> lista) throws Exception;
	void aggiungiTotaleACronologia(Utente username, LocalDateTime data, double prezzo) throws Exception;

}
