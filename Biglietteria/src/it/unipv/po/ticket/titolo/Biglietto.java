package it.unipv.po.ticket.titolo;

import java.time.*;
import java.util.ArrayList;

import it.unipv.po.ticket.trasporto.fermata.Fermata;

public class Biglietto extends Titolo{
	
	public Biglietto(ArrayList<Fermata> percorso) throws Exception {
		setPercorso(percorso);
		this.calcolatoreID = new CalcolatoreID();
		this.calcolatorePrezzo = new CalcolatorePrezzo();
		// per i biglietti avremo nell'id un prefisso 'b'
		String tempID = "b--"+calcolatoreID.calcolaID(percorso);
		setIdTitolo(tempID);
		setPrezzo(calcolatorePrezzo.calcolaPrezzo(percorso));	
	}
	
	

	
}
