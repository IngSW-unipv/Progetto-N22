package it.unipv.po.ticket.supporto;

import java.util.ArrayList;

import it.unipv.po.ticket.gui.utente.Utente;
import it.unipv.po.ticket.supporto.strategie.AccessDBreadStrategy;
import it.unipv.po.ticket.supporto.strategie.IDBreadStrategy;
import it.unipv.po.ticket.trasporto.fermata.Fermata;
import it.unipv.po.ticket.trasporto.linea.Linea;
import it.unipv.po.ticket.trasporto.vehicleModel.Vehicle;

public class DBread {
	private static IDBreadStrategy strategiaDiLettura;
	
	public DBread() {
		strategiaDiLettura = new AccessDBreadStrategy();
	}
	
	public static Linea getLinea(int id) throws Exception{
		return strategiaDiLettura.getLinea(id);
	}
	
	public static ArrayList<Fermata> getFermate(String IDlinea) throws Exception{
		return strategiaDiLettura.getFermate(IDlinea);
	}
	
	public static ArrayList<Linea> searchLinea(String IDfermata) throws Exception {
		return strategiaDiLettura.searchLinea(IDfermata);
		
	}
	
	public static String getSnodi(String partenza, String destinazione) throws Exception {
		return strategiaDiLettura.getSnodi(partenza, destinazione);
		
	}
	
	public static String[] elencoFermate() throws Exception {
		
		return strategiaDiLettura.elencoFermate();
		
	}
	
	public String searchPassword(String user) throws Exception{
		return strategiaDiLettura.searchPassword(user);
	}
	

	public int searchUsername(String user) throws Exception {
		return strategiaDiLettura.searchUsername(user);
	}
	
	public double searchTariffaMezzo(Vehicle mezzo) throws Exception{
		return strategiaDiLettura.searchTariffaMezzo(mezzo);
	}

	public Utente userDownload(String username) throws Exception {
		
		return strategiaDiLettura.userDownload(username);
		
	}
}
