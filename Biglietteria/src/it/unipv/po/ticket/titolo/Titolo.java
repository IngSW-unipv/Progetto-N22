package it.unipv.po.ticket.titolo;

import it.unipv.po.ticket.trasporto.ricerca.*;
import it.unipv.po.ticket.trasporto.vehicleModel.Vehicle;
import java.time.*;



public abstract class Titolo {
	
	private String idTitolo;
	private double prezzo;
	private Vehicle mezzo;
	private boolean attivo = true;
	private LocalDateTime dataAcquisto;
	
	/*
	public Titolo (String idTitolo, float prezzo, boolean attivo) {
		
		this.idTitolo = idTitolo;
		this.prezzo = prezzo;
		this.attivo = attivo;
	}*/
	/*
	public Titolo() {
		
		this.idTitolo="";
		this.prezzo = 0;
	}*/
	
	
	// getter setter
	
	public String getId() {
		
		return idTitolo;
	}
	
	public void setIDtitolo(String id) {
		
		idTitolo = id;
		
	}
	public double getPrezzo() {
	
		return prezzo;
	}
	
	public void setPrezzo(double d) {
		
		prezzo=d;
	}
	
	public void setVehicle(Vehicle v) {
		mezzo=v;
	}
	public Vehicle getVehicle() {
		return mezzo;
	}
	
	public void setAttivo(boolean a) {
		attivo=a;
	}
	
	public boolean getAttivo() {
		
		return attivo;
	}

	public String getDataAcquisto() {
		return dataAcquisto.toString();
	}

	public void setDataAcquisto(LocalDateTime dataAcquisto) {
		this.dataAcquisto = dataAcquisto;
	}
	
	public void StampaTitolo(Titolo t) {
		
	}
	


	public String getID() {
		// TODO Auto-generated method stub
		return idTitolo;
	}
}