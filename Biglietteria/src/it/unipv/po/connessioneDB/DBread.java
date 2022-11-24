package it.unipv.po.connessioneDB;

import java.sql.SQLException; 
import java.util.ArrayList;
import it.unipv.po.connessioneDB.strategie.AccessDBreadStrategy;
import it.unipv.po.connessioneDB.strategie.IDBreadStrategy;
import it.unipv.po.trasporto.fermata.Fermata;
import it.unipv.po.trasporto.linea.Linea;
import it.unipv.po.trasporto.titolo.Titolo;
import it.unipv.po.trasporto.vehicleModel.Vehicle;
import it.unipv.po.utente.Utente; 


public class DBread {
	private static IDBreadStrategy strategiaDiLettura;
	
	public DBread() {
		strategiaDiLettura = new AccessDBreadStrategy();
	}
	
	public static Linea getLinea(int id) throws SQLException{
		return strategiaDiLettura.getLinea(id);
	}
	
	public static ArrayList<Fermata> getFermate(String IDlinea) throws SQLException{
		return strategiaDiLettura.getFermate(IDlinea);
	}
	
	public static ArrayList<Linea> searchLinea(String IDfermata) throws SQLException {
		return strategiaDiLettura.searchLinea(IDfermata);
		
	}
	
	public static String getSnodi(String partenza, String destinazione) throws SQLException {
		return strategiaDiLettura.getSnodi(partenza, destinazione);
		
	}
	
	public static String[] elencoFermate() throws SQLException {
		
		return strategiaDiLettura.elencoFermate();
		
	}
	
	public double searchTariffaMezzo(Vehicle mezzo) throws SQLException{
		return strategiaDiLettura.searchTariffaMezzo(mezzo);
	}

	public Utente userDownload(String username) throws SQLException{
		
		return strategiaDiLettura.userDownload(username);
		
	}

	public ArrayList<Titolo> scaricaTitoliUtente(String user) throws SQLException {
		return strategiaDiLettura.scaricaTitoliUtente(user);
		
	}
}