package it.unipv.po.ticket.supporto.strategie;

import java.sql.Connection;
import java.time.LocalDateTime;

import it.unipv.po.ticket.cus.Sessione;
import it.unipv.po.ticket.cus.Utente;

public interface IDBwriteStrategy {
	public Connection getDBConnection() throws Exception;
	public void aggiungiACronologia(Utente user, Sessione s, LocalDateTime data, double prezzo) throws Exception;
	public void aggiungiUtente(Utente username) throws Exception;

}
