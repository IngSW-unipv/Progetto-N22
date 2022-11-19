package it.unipv.po.trasporto.titolo.supporto;

import java.time.LocalDateTime; 
import java.util.ArrayList;

import it.unipv.po.trasporto.fermata.Fermata;

public class CalcolatoreID {

	public String calcolaID(ArrayList<Fermata> percorso) {
		String id = percorso.get(0).getCodiceFermata() 
				    +"--"+percorso.get(percorso.size()-1).getCodiceFermata()
				    +"--"+ LocalDateTime.now();
		
		return id;
	}

}
