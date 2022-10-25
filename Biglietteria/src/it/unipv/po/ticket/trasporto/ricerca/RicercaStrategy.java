package it.unipv.po.ticket.trasporto.ricerca;

import java.util.ArrayList;

import it.unipv.po.ticket.supporto.DBread;
import it.unipv.po.ticket.trasporto.fermata.Fermata;
import it.unipv.po.ticket.trasporto.linea.Linea;

public class RicercaStrategy implements InterfaceRicercaStrategy{
	
	public ArrayList<Linea> corsa = new ArrayList<Linea>();
	DBread db = new DBread();
	public int corseAttive = 0;

	//metodi
	@SuppressWarnings("static-access")
	public ArrayList<Fermata> cerca(String a, String b) throws Exception {
		ArrayList<Fermata> ricerca = new ArrayList<Fermata>();
		String  snodo = "";
		
		//controllo se le due fermate appartengono alla stessa linea
		if(db.searchLinea(a) == db.searchLinea(b)) return corsa.get(db.searchLinea(a)-1).ricercaFermate(a, b);
		else {
			//nel caso non appartengano alla medesima linea cerco la fermata di snodo comune
			snodo = db.getSnodi(db.searchLinea(a), db.searchLinea(b));
			
			//calcolo le fermate dalla fermata di partenza fino allo snodo e dallo snodo alla destinazione
			ricerca = corsa.get(db.searchLinea(a)-1).ricercaFermate(a, snodo);
			ricerca.remove(ricerca.size()-1);
			ricerca.addAll(corsa.get(db.searchLinea(b)-1).ricercaFermate(snodo, b));
		}
		
		return ricerca;	
	}
	
	//getter and setter
	public String getPercorsi() {
		String msg = "";
		
		for(Linea n : corsa) msg += n.getLinea() +"\n";
		
		return msg;
	}

	@SuppressWarnings("static-access")
	public void setPercorsi() throws Exception {
		
		for(int i = 0; i < 6; i++) {
			this.corsa.add(db.getLinee(i+1));
			this.corseAttive += 1;
		}
	}
	
	public String getPercorso(int n) {
		
		return this.corsa.get(n-1).getLinea();
	}
	
	//Per inizializzare la comboBox
	public String[] getLinee(){
		
		String[] str = new String[this.corseAttive+1];
		str[0] ="";
		int i = 1;
		
		for(Linea n : corsa) {
			str[i] = n.getIDlinea();
			i++;
		}
		
		return str;
	}
}
