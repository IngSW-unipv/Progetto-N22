package it.unipv.po.ticket.supporto;

import java.util.ArrayList;

import it.unipv.po.ticket.supporto.strategie.AccessDBreadStrategy;
import it.unipv.po.ticket.supporto.strategie.IDBreadStrategy;
import it.unipv.po.ticket.trasporto.fermata.Fermata;
import it.unipv.po.ticket.trasporto.linea.Linea;

public class DBread {
	private static IDBreadStrategy strategiaDiLettura;
	
	public DBread() {
		strategiaDiLettura= new AccessDBreadStrategy();
	}
	
	public static Linea getLinee(int id) throws Exception{
		return strategiaDiLettura.getLinee(id);
	}
	
	public static ArrayList<Fermata> getFermate(String IDlinea) throws Exception{
		return strategiaDiLettura.getFermate(IDlinea);
	}
	
	public static int searchLinea(String IDfermata) throws Exception {
		return strategiaDiLettura.searchLinea(IDfermata);
		
	}
	
	public static String getSnodi(int partenza, int destinazione) throws Exception {
		return strategiaDiLettura.getSnodi(partenza, destinazione);
		
	}
	
	public static String[] elencoFermate() throws Exception {
		
		return strategiaDiLettura.elencoFermate();
		
	}
	
	/*
	public static Titolo getPrezzo(String id) throws Exception{
		String sql = "SELECT Prezzo FROM Titolo WHERE ID = "+ id;
		Connection connection = null;
		Statement statement = null;
		
		Titolo titoloDB = new Titolo();
		
		connection = getDBConnection();
		statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        
        result.next();
			
        //inserisco gli elementi della tabella
	    titoloDB.setIDtitolo(result.getString("IDtitolo"));
	    titoloDB.setPrezzo(result.getFloat("Prezzo"));
	    titoloDB.setAttivo(result.getBoolean("Attivo"));
	    
       
        
		// Chiudo la connessione
		if(statement != null) {
			statement.close();
				}
		if(connection != null) {
			connection.close();
		}		
		
		
		
				
		return titoloDB;
	}*/

}
