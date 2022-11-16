package it.unipv.po.ticket.trasporto.ricerca;

import java.time.LocalTime;
import java.util.ArrayList;

import it.unipv.po.ticket.supporto.DBread;
import it.unipv.po.ticket.trasporto.fermata.Fermata;
import it.unipv.po.ticket.trasporto.linea.Linea;

public class RicercaStrategy implements InterfaceRicercaStrategy{
	
	private DBread db = new DBread();
	
	//metodi
	@SuppressWarnings("static-access")
	public ArrayList<ArrayList<Fermata>> cerca(String a, String b, LocalTime orario) throws Exception {
		
		ArrayList<ArrayList<Fermata>> ricerca = new ArrayList<>();
		ArrayList<Linea> LineeA = db.searchLinea(a);
		ArrayList<Linea> LineeB = db.searchLinea(b);
		String  snodo;
		int ricercheAttive = 0;
		int dimtmp;
		
		//controllo se le due fermate appartengono alla stessa linea
		
		for(int i = 0; i < LineeA.size(); i++) 
			for(int j = 0; j < LineeB.size(); j++) 
				if(LineeA.get(i).getIDlinea().compareTo(LineeB.get(j).getIDlinea()) == 0) {
					
					ricerca.add(new ArrayList<Fermata>());
					ricerca.get(ricercheAttive).addAll(LineeA.get(i).ricercaFermate(a, b, orario));
					ricercheAttive++;
					
					return ricerca;
				}
		
		//nel caso non appartengano alla medesima linea cerco la fermata di snodo comune
		for(int i = 0; i < LineeA.size(); i++) 
			for(int j = 0; j < LineeB.size(); j++) {
				snodo = db.getSnodi(LineeA.get(i).getIDlinea(), LineeB.get(j).getIDlinea());
				
				if(snodo != "") {
					ricerca.add(new ArrayList<Fermata>());
					
					//calcolo le fermate dalla fermata di partenza fino allo snodo e dallo snodo alla destinazione
					ricerca.get(ricercheAttive).addAll(LineeA.get(i).ricercaFermate(a, snodo, orario));
					
					//salvo la posizione dello snodo da cancellare poi successivamente
					dimtmp = ricerca.get(ricercheAttive).size();
					
					ricerca.get(ricercheAttive).addAll(LineeB.get(j).ricercaFermate(snodo, b, ricerca.get(ricercheAttive).get(ricerca.size()-1).getOrario()));
					
					//rimozione snodo doppio e set dello snodo a true per agevolare il riconoscimento in stampa
					ricerca.get(ricercheAttive).remove(dimtmp-1);
					ricerca.get(ricercheAttive).get(dimtmp-1).setSnodo(true);
					ricercheAttive++;
				}
			}
		
		return ricerca;
		
	}
	
	public String stampaRicerca(ArrayList<Fermata> ricerca) {
		Fermata snodo = ricerca.get(0);
		String str = "";
		str += "⦿ "+ricerca.get(0).getMezzo() +" "+ ricerca.get(0).getCodiceLinea() +"\n";
		
		for(Fermata n : ricerca) {	
			str += " ¦\n";
			str += "⦿ "+n.getCodiceFermata() +" "+ n.getOrario() +"\n";
			
			if(n.isSnodo()) {
				str += " ¦\n";
				str += " ¦ Snodo con "+ n.getMezzo() +" "+ n.getCodiceLinea() +"\n";
				
				int minuti = n.getOrario().getMinute() - snodo.getOrario().getMinute();
		        int ore = n.getOrario().getHour() - snodo.getOrario().getHour();
		        int attesa = minuti + ore*60;

				str += "⭕ tempo di attesa coincidenza: " + attesa +" minuti\n";
				str += " ¦\n";
			}
			
			snodo = n;
			
		}
		
		return str;
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
