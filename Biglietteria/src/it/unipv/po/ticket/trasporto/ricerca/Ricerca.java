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
	
}
