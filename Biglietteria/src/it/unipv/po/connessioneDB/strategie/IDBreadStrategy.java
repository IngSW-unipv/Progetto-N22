package it.unipv.po.connessioneDB.strategie;

import java.sql.Connection;  
import java.util.ArrayList;
import it.unipv.po.trasporto.fermata.Fermata;
import it.unipv.po.trasporto.linea.Linea;
import it.unipv.po.trasporto.titolo.Titolo;
import it.unipv.po.trasporto.vehicleModel.Vehicle;
import it.unipv.po.utente.Utente;


public interface IDBreadStrategy {
	
	public Connection getDBConnection() throws Exception;
	public Linea getLinea(int id) throws Exception;
	public ArrayList<Fermata> getFermate(String IDlinea) throws Exception;
	public ArrayList<Linea> searchLinea(String IDfermata) throws Exception;
	public String getSnodi(String partenza, String destinazione) throws Exception;
	public String[] elencoFermate() throws Exception;	
	double searchTariffaMezzo(Vehicle mezzo) throws Exception;
	public Utente userDownload(String username) throws Exception;
	public ArrayList<Titolo> scaricaTitoliUtente(String user) throws Exception;

	
	
	
	
}
