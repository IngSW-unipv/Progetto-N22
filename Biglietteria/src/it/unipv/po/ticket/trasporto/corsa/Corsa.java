package it.unipv.po.ticket.trasporto.corsa;

import java.util.ArrayList;

import it.unipv.po.ticket.supporto.DBconnection;
import it.unipv.po.ticket.trasporto.dataModel.Percorso;
import it.unipv.po.ticket.trasporto.linea.Linea;

public class Corsa implements Percorso{
	public ArrayList<Linea> corsa = new ArrayList<Linea>();
	public int corseAttive = 0;

	public Corsa() {
		this.corseAttive = 0;
	}

	//metodi
	public String cerca(String a, String b) throws Exception {
		String msg = "";
		String  snodo = "";
		
		//controllo se le due fermate appartengono alla stessa linea
		if(DBconnection.searchLinea(a) == DBconnection.searchLinea(b)) return corsa.get(DBconnection.searchLinea(a)-1).ricercaFermate(a, b) + "Fermata: "+ b;
		else {
			//nel caso non appartengano alla medesima linea cerco la fermata di snodo comune
			snodo = DBconnection.getSnodi(DBconnection.searchLinea(a), DBconnection.searchLinea(b));
			
			//calcolo le fermate dalla fermata di partenza fino allo snodo e dallo snodo alla destinazione
			msg += corsa.get(DBconnection.searchLinea(a)-1).ricercaFermate(a, snodo);
			msg += "Snodo con ";
			msg += corsa.get(DBconnection.searchLinea(b)-1).ricercaFermate(snodo, b) + "Fermata: "+ b;
		}
		
		return msg;	
	}
	
	//getter and setter
	public String getCorsa() {
		String msg = "";
		
		for(Linea n : corsa) msg += n.getLinea() +"\n";
		
		return msg;
	}

	public void setCorsa(Linea linea) {
		this.corsa.add(linea);
		this.corseAttive += 1;
	}
	
}
