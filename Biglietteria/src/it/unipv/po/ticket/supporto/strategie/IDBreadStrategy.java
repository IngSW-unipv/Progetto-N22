package it.unipv.po.ticket.supporto.strategie;

import java.sql.Connection; 
import java.sql.SQLException;
import java.util.ArrayList;

import it.unipv.po.ticket.gui.utente.Utente;
import it.unipv.po.ticket.titolo.Titolo;
import it.unipv.po.ticket.trasporto.fermata.Fermata;
import it.unipv.po.ticket.trasporto.linea.Linea;
import it.unipv.po.ticket.trasporto.vehicleModel.Vehicle;

public interface IDBreadStrategy {
	
	public Connection getDBConnection() throws Exception;
	public Linea getLinea(int id) throws Exception;
	public ArrayList<Fermata> getFermate(String IDlinea) throws Exception;
	public ArrayList<Linea> searchLinea(String IDfermata) throws Exception;
	public String getSnodi(String partenza, String destinazione) throws Exception;
	public String[] elencoFermate() throws Exception;	
	public String searchPassword(String user) throws Exception;
	public int searchUsername(String user) throws Exception;
	double searchTariffaMezzo(Vehicle mezzo) throws Exception;
	public Utente userDownload(String username) throws Exception;
	public ArrayList<Titolo> scaricaTitoliUtente(String user) throws Exception;

	
	
	
	
}
