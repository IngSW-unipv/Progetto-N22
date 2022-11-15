package it.unipv.po.ticket.titolo;

import java.util.ArrayList;

import it.unipv.po.ticket.trasporto.fermata.Fermata;

public class CalcolatorePrezzo {

	public double calcolaPrezzo(ArrayList<Fermata> percorso) throws Exception {
		double prezzo = 0;
		for(int i=0; i<percorso.size(); i++) {
			prezzo += percorso.get(i).getTariffaMezzo();
		}
		return prezzo;
	}

}
