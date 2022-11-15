package it.unipv.po.ticket.titolo;

import java.time.LocalDateTime;
import java.util.ArrayList;

import it.unipv.po.ticket.trasporto.fermata.Fermata;

public class CalcolatoreID {

	public String calcolaID(ArrayList<Fermata> percorso) {
		String id = percorso.get(0).getCodiceFermata() 
				    +"--"+percorso.get(percorso.size()-1).getCodiceFermata()
				    +"--"+ LocalDateTime.now();
		
		return id;
	}

}
