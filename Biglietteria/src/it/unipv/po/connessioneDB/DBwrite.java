package it.unipv.po.connessioneDB;
   
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
	

	
	public void aggiungiTotaleACronologia(String username, LocalDateTime data, double prezzo, double puntiUtilizzati) throws SQLException {
		 strategiaDiScrittura.aggiungiTotaleACronologia(username, data, prezzo, puntiUtilizzati);
	
	}
	public void aggiungiTitoliACronologia(String user, LocalDateTime date, ArrayList<Titolo> lista) throws SQLException {
		 strategiaDiScrittura.aggiungiTitoliACronologia(user, date, lista);
	}
	
	public void aggiungiUtente(Utente utente) throws SQLException, NoSuchAlgorithmException {
		 strategiaDiScrittura.aggiungiUtente(utente);
	}



	public void oblitera(String idTitolo) throws SQLException {
		strategiaDiScrittura.oblitera(idTitolo);
		
	}



	public void aggiornaCredito(double credito, String Email) throws SQLException{
		strategiaDiScrittura.aggiornaCredito(credito, Email);
		
	}
	
	
	
}

