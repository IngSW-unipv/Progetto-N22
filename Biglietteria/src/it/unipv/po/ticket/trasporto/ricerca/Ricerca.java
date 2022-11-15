package it.unipv.po.ticket.trasporto.ricerca;

import java.time.LocalTime;
import java.util.ArrayList;

import it.unipv.po.ticket.titolo.Biglietto;
import it.unipv.po.ticket.titolo.Titolo;
import it.unipv.po.ticket.trasporto.fermata.Fermata;

public class Ricerca{
	private InterfaceRicercaStrategy ricercaStrategy;
	private GeneratoreTitoli generatoreTitoli;
	
	public Ricerca() {
		ricercaStrategy = new RicercaStrategy();
		generatoreTitoli = new GeneratoreTitoli();
	}
	
	public ArrayList<Fermata>  cerca(String a, String b, LocalTime orario) throws Exception {
		return ricercaStrategy.cerca(a, b, orario);
	}
	
	public ArrayList<Biglietto> cercaEGenera(String a, String b, LocalTime orario) throws Exception {
		ArrayList<Fermata> percorsi = ricercaStrategy.cerca(a, b, orario);
		return generatoreTitoli.generaBiglietti(percorsi);
	}
	

	
	public String stampaRicerca(ArrayList<Fermata> cerca) {
		return ricercaStrategy.stampaRicerca(cerca);
		
	}
	
}
