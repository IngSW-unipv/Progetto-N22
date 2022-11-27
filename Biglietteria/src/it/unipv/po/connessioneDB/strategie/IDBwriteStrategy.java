package it.unipv.po.connessioneDB.strategie;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import it.unipv.po.trasporto.titolo.Titolo;
import it.unipv.po.utente.Utente;


public interface IDBwriteStrategy {
	public Connection getDBConnection() throws SQLException;
	public void aggiungiUtente(Utente username) throws SQLException, NoSuchAlgorithmException;
	void aggiungiTitoliACronologia(String username, LocalDateTime date, ArrayList<Titolo> lista) throws SQLException;
	void aggiungiTotaleACronologia(String username, LocalDateTime data, double prezzo, double puntiUtilizzati) throws SQLException;
	public void oblitera(String idTitolo) throws SQLException;
	public void aggiornaCredito(double credito, String Email)throws SQLException;
	


}
