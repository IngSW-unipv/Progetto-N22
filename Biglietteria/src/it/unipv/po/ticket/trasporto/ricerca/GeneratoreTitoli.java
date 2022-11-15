package it.unipv.po.ticket.trasporto.ricerca;

import java.util.ArrayList;

import it.unipv.po.ticket.titolo.Biglietto;
import it.unipv.po.ticket.titolo.Titolo;
import it.unipv.po.ticket.trasporto.fermata.Fermata;

public class GeneratoreTitoli {

	public ArrayList<Biglietto> generaBiglietti(ArrayList<Fermata> percorsi) throws Exception {
		ArrayList<Biglietto> titoliGenerati = new ArrayList<Biglietto>();
		int i = 0;
		ArrayList<Fermata> temp= new ArrayList<Fermata>();
		for(; i<percorsi.size(); i++) {
			temp.add(percorsi.get(i));
			if(percorsi.get(i).getCodiceFermata().compareTo(percorsi.get(0).getCodiceFermata())==0) {
				// genero il biglietto precedente
				temp.remove(i);
				for(int j = 0; j<temp.size(); j++) {
					System.out.println(temp.get(j).getCodiceFermata());
				}
				//Biglietto titolo = new Biglietto(temp); // genera Exception
				//titoliGenerati.add(titolo);
				// predispongo per la generazione del prossimo biglietto
				temp.clear();
				temp.add(percorsi.get(i));
			}		
		}
		
		return titoliGenerati;
	}

}
