package it.unipv.po.ticket.supporto.strategie;

import java.sql.Connection; 
import java.sql.SQLException;
import java.util.ArrayList;

import it.unipv.po.ticket.cus.Utente;
import it.unipv.po.ticket.trasporto.fermata.Fermata;
import it.unipv.po.ticket.trasporto.linea.Linea;

public interface IDBreadStrategy {
	
	public Connection getDBConnection() throws Exception;
	public Linea getLinea(int id) throws Exception;
	public ArrayList<Fermata> getFermate(String IDlinea) throws Exception;
	public ArrayList<Linea> searchLinea(String IDfermata) throws Exception;
	public String getSnodi(String partenza, String destinazione) throws Exception;
	public String[] elencoFermate() throws Exception;
	public Utente login(String username, String password) throws Exception;
	
	
	
	
}
