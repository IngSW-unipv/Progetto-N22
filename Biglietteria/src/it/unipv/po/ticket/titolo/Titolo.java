package it.unipv.po.ticket.titolo;

import it.unipv.po.ticket.trasporto.fermata.Fermata;
import it.unipv.po.ticket.trasporto.ricerca.*;
import it.unipv.po.ticket.trasporto.vehicleModel.Vehicle;
import java.time.*;
import java.util.ArrayList;



public abstract class Titolo {
	
	private String idTitolo;
	private double prezzo;
	private ArrayList<Fermata> percorso;
	private boolean attivo;
	private LocalDateTime dataAcquisto;
	protected CalcolatorePrezzo calcolatorePrezzo;
	protected CalcolatoreID calcolatoreID;
	
	public Titolo(ArrayList<Fermata> percorso) {
		this.percorso = percorso;
	}
	
	public Titolo() {
		this.idTitolo = "?????";
		this.prezzo = 0;
		this.attivo = false;
	}

	public String getIdTitolo() {
		return idTitolo;
	}

	public void setIdTitolo(String idTitolo) {
		this.idTitolo = idTitolo;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public ArrayList<Fermata> getPercorso() {
		return percorso;
	}

	public void setPercorso(ArrayList<Fermata> percorso) {
		this.percorso = percorso;
	}

	public boolean isAttivo() {
		return attivo;
	}

	public void setAttivo(boolean attivo) {
		this.attivo = attivo;
	}

	public LocalDateTime getDataAcquisto() {
		return dataAcquisto;
	}

	public void setDataAcquisto(LocalDateTime dataAcquisto) {
		this.dataAcquisto = dataAcquisto;
	}
	
	
	
	
	
	

}