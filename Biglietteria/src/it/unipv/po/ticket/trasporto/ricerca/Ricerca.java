package it.unipv.po.ticket.trasporto.ricerca;

import java.util.ArrayList;

import it.unipv.po.ticket.trasporto.fermata.Fermata;

public class Ricerca{
	private InterfaceRicercaStrategy ricercaStrategy;
	
	public Ricerca() {
		ricercaStrategy = new RicercaStrategy();
	}
	
	public ArrayList<Fermata> cerca(String a, String b) throws Exception {
		return ricercaStrategy.cerca(a, b);
	}
	
}
