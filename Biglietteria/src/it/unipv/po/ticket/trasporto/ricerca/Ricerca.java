package it.unipv.po.ticket.trasporto.ricerca;

import java.util.ArrayList;

import it.unipv.po.ticket.trasporto.fermata.Fermata;

public class Ricerca{
	InterfaceRicercaStrategy ricerca;
	
	public Ricerca() {
		ricerca = new RicercaStrategy();
	}
	
	public ArrayList<Fermata> cerca(String a, String b) throws Exception {
		return ricerca.cerca(a, b);
	}
	
	public String getPercorsi() {
		return ricerca.getPercorsi();
	}

	public void setPercorsi() throws Exception {
		ricerca.setPercorsi();
	}
	
	public String getPercorso(int n) {
		return ricerca.getPercorso(n);
	}
	
	public String[] getLinee(){
		return ricerca.getLinee();
	}
}
