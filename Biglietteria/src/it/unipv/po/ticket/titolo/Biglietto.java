package it.unipv.po.ticket.titolo;

import java.time.*;
import java.util.ArrayList;

import it.unipv.po.ticket.trasporto.fermata.Fermata;

public class Biglietto extends Titolo{
	private boolean disponibile;
	private boolean attivo;
	public Biglietto(ArrayList<Fermata> percorso) throws Exception {
		setPercorso(percorso);
		this.calcolatoreID = new CalcolatoreID();
		this.calcolatorePrezzo = new CalcolatorePrezzo();
		// per i biglietti avremo nell'id un prefisso 'b'
		String tempID = "b--"+calcolatoreID.calcolaID(percorso);
		setIdTitolo(tempID);
		setPrezzo(calcolatorePrezzo.calcolaPrezzo(percorso));
		disponibile = true;
		attivo = false;
	}
	public Biglietto(String idTitolo, Double prezzo, String percorso, boolean disponibile, boolean attivo, String dataAcquisto) {
		this.setIdTitolo(idTitolo);
		this.setPrezzo(prezzo);
		this.setPercorso(percorso);
		this.setDisponibile(disponibile);
		this.setAttivo(attivo);
		this.setDataAcquisto(dataAcquisto);
	}
	
	private void setAttivo(boolean attivo) {
		this.attivo = attivo;
		
	}
	private void setDisponibile(boolean disponibile) {
		this.disponibile = disponibile;
		
	}
	public void oblitera() {
		
		if(disponibile && !(attivo)) {
			disponibile = false;
			attivo = true;
		}
		//start del timer dal server
		// al termine verrÃ  chiamata il metodo scadi() 
	}
	
	
	public void scadi() {
		attivo = false;
		// server rimuove da db le info del titolo
	}

	@Override
	public boolean isAttivo() {
		return attivo;
	}

	@Override
	public boolean isDisponibile() {
		return disponibile;
	}

	@Override
	public String getDataInizio() {
		return "";
	}

	@Override
	public int getDurata() {
		return 0;
	}

	

	
}
