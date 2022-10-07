package it.unipv.po.ticket.supporto.strategie;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import it.unipv.po.ticket.trasporto.fermata.Fermata;
import it.unipv.po.ticket.trasporto.linea.Linea;

public interface IDBreadStrategy {
	
	public Connection getDBConnection() throws Exception;
	public Linea getLinee(int id) throws Exception;
	public ArrayList<Fermata> getFermate(String IDlinea) throws Exception;
	public int searchLinea(String IDfermata) throws Exception;
	public String getSnodi(int partenza, int destinazione) throws Exception;
	public String[] elencoFermate() throws Exception;
	
	
	
	
}
