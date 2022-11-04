package it.unipv.po.ticket.trasporto.ricerca;

import java.util.ArrayList;

import it.unipv.po.ticket.supporto.DBread;
import it.unipv.po.ticket.trasporto.fermata.Fermata;
import it.unipv.po.ticket.trasporto.linea.Linea;

public class RicercaStrategy implements InterfaceRicercaStrategy{
	
	DBread db = new DBread();

	//metodi
	@SuppressWarnings("static-access")
	public ArrayList<Fermata> cerca(String a, String b) throws Exception {
		
		ArrayList<Fermata> ricerca = new ArrayList<Fermata>();
		ArrayList<Linea> LineeA = db.searchLinea(a);
		ArrayList<Linea> LineeB = db.searchLinea(b);
		String  snodo = "";
		
		//controllo se le due fermate appartengono alla stessa linea
		
		for(int i = 0; i < LineeA.size(); i++) 
			for(int j = 0; j < LineeB.size(); j++) 
				if(LineeA.get(i).getIDlinea().compareTo(LineeB.get(j).getIDlinea()) == 0) return LineeA.get(i).ricercaFermate(a, b);
		
		//nel caso non appartengano alla medesima linea cerco la fermata di snodo comune
		for(int i = 0; i < LineeA.size(); i++) 
			for(int j = 0; j < LineeB.size(); j++) {
				snodo = db.getSnodi(LineeA.get(i).getIDlinea(), LineeB.get(j).getIDlinea());
				
				if(snodo != "") {
					//calcolo le fermate dalla fermata di partenza fino allo snodo e dallo snodo alla destinazione
					ricerca = LineeA.get(i).ricercaFermate(a, snodo);
					ricerca.remove(ricerca.size()-1);
					ricerca.addAll(LineeB.get(j).ricercaFermate(snodo, b));
					return ricerca;	
				}
			}
		
		return null;
		
	}
	
	
	//Per inizializzare la comboBox
	/*public String[] getLinee(){
		
		String[] str = new String[this.corseAttive+1];
		str[0] ="";
		int i = 1;
		
		for(Linea n : corsa) {
			str[i] = n.getIDlinea();
			i++;
		}
		
		return str;
	}*/
}
