package it.unipv.po.connessioneDB.strategie;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import it.unipv.po.connessioneDB.eccezioni.DBException;
import it.unipv.po.trasporto.fermata.Fermata;
import it.unipv.po.trasporto.linea.Linea;
import it.unipv.po.trasporto.titolo.Titolo;
import it.unipv.po.trasporto.vehicleModel.Vehicle;
import it.unipv.po.utente.Utente;


public interface IDBreadStrategy {
	
	public Connection getDBConnection() throws SQLException;
	public Linea getLinea(int id) throws SQLException;
	public ArrayList<Fermata> getFermate(String IDlinea) throws SQLException;
	public ArrayList<Linea> searchLinea(String IDfermata) throws SQLException;
	public String getSnodi(String partenza, String destinazione) throws SQLException;
	public String[] elencoFermate() throws SQLException;	
	double searchTariffaMezzo(Vehicle mezzo) throws SQLException;
	public Utente userDownload(String username) throws SQLException;
	public ArrayList<Titolo> scaricaTitoliUtente(String user) throws SQLException;

	
	
	
	
}
