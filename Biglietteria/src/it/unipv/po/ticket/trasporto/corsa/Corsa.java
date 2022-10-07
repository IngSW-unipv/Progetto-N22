package it.unipv.po.ticket.trasporto.corsa;

import java.util.ArrayList; 


import it.unipv.po.ticket.supporto.DBread;
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
		if(DBread.searchLinea(a) == DBread.searchLinea(b)) return corsa.get(DBread.searchLinea(a)-1).ricercaFermate(a, b) + "Fermata: "+ b;
		else {
			//nel caso non appartengano alla medesima linea cerco la fermata di snodo comune
			snodo = DBread.getSnodi(DBread.searchLinea(a), DBread.searchLinea(b));
			
			//calcolo le fermate dalla fermata di partenza fino allo snodo e dallo snodo alla destinazione
			msg += corsa.get(DBread.searchLinea(a)-1).ricercaFermate(a, snodo);
			msg += "Snodo con ";
			msg += corsa.get(DBread.searchLinea(b)-1).ricercaFermate(snodo, b) + "Fermata: "+ b;
		}
		
		return msg;	
	}
	
	//getter and setter
	public String getCorsa() {
		String msg = "";
		
		for(Linea n : corsa) msg += n.getLinea() +"\n";
		
		return msg;
	}

	public void setCorsa() throws Exception {
		//this.corsa.add(linea);
		
		
		for(int i = 0; i < 6; i++) {
			this.corsa.add(DBread.getLinee(i+1));
			this.corseAttive += 1;
		}
	}
	
	public String getLinea(int n) {
		
		return this.corsa.get(n-1).getLinea();
	}
	
	//Per inizializzare la comboBox
	public String[] getLinee(){
		
		String[] str = new String[this.corseAttive];
		int i = 0;
		
		for(Linea n : corsa) {
			str[i] = n.getIDlinea();
			i++;
		}
		
		return str;
	}
	
}
