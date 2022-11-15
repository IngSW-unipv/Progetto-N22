package it.unipv.po.ticket.titolo;
import java.time.*;
import java.util.ArrayList;

import it.unipv.po.ticket.trasporto.fermata.Fermata;

public class Abbonamento extends Titolo{
	
	private LocalDate dataInizio;
	private int durata;
	
	public Abbonamento(LocalDate dataInizio, int durata, ArrayList<Fermata> percorso) throws Exception {
		this.dataInizio = dataInizio;
		this.durata = durata;
		
		setPercorso(percorso);
		this.calcolatoreID = new CalcolatoreID();
		this.calcolatorePrezzo = new CalcolatorePrezzo();
		// per glii abbonamenti avremo nell'id un prefisso 'a'
		String tempID = "a--"+calcolatoreID.calcolaID(percorso);
		setIdTitolo(tempID);
		//richiedendo l'accesso al DB va gestita l'eccezione
		setPrezzo(calcolatorePrezzo.calcolaPrezzo(percorso));
	}
	

	
	// getter & setter
	

	
	public String getDatainizio() {
		
		return dataInizio.toString();
	}
	
	public void setDataInizio(LocalDate data) {
		
		this.dataInizio = data;
	}
	
	public int getDurata() {
		
		return durata;
	}
	
	public void setDurata(int d) {
		
		this.durata = d;
	}
}
