package it.unipv.po.ticket.supporto.strategie;

import java.sql.Connection; 
import java.time.LocalDateTime;
import java.util.LinkedList;

import it.unipv.po.ticket.gui.utente.Utente;
import it.unipv.po.ticket.titolo.Titolo;

public interface IDBwriteStrategy {
	public Connection getDBConnection() throws Exception;
	public void aggiungiUtente(Utente username) throws Exception;
	void aggiungiTitoliACronologia(String username, LocalDateTime date, LinkedList<Titolo> lista) throws Exception;
	void aggiungiTotaleACronologia(String username, LocalDateTime data, double prezzo, double puntiUtilizzati) throws Exception;

}
