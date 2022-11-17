package it.unipv.po.ticket.trasporto.fermata;

import java.time.LocalTime;

import it.unipv.po.ticket.supporto.DBread;
import it.unipv.po.ticket.trasporto.vehicleModel.Vehicle;

public class Fermata {
	
	private String CodiceFermata;
	private boolean snodo;
	private LocalTime orario;
	private String CodiceLinea;
	private Vehicle mezzo;
	
	public Fermata(String codiceFermata, boolean snodo, LocalTime orario, String codiceLinea, Vehicle mezzo) {
		CodiceFermata = codiceFermata;
		this.snodo = snodo;
		this.orario = orario;
		CodiceLinea = codiceLinea;
		this.mezzo = mezzo;
	}
	
	//usiamo questo costruttore per il ricaricamento dell'array di fermate (in forma non verbosa)
	//in Biglietto 
	public Fermata(String codiceFermata, LocalTime orario) {
		this.CodiceFermata = codiceFermata;
		this.orario = orario;
		this.snodo = false;
		this.CodiceLinea = "";
		this.mezzo = null;
	}
	
	public Fermata() {
		this.orario = null;
		this.snodo = false;
		this.CodiceFermata = "";
		this.CodiceLinea = "";
		this.mezzo = null;
	}
	
	//getter e setter
	public String getCodiceFermata() {
		return CodiceFermata;
	}

	public void setCodiceFermata(String codiceFermata) {
		CodiceFermata = codiceFermata;
	}
	
	public LocalTime getOrario() {
		return orario;
	}
	
	public void setOrario(LocalTime orario) {
		this.orario = orario;
	}
	
	public void setSnodo(boolean snodo) {
		this.snodo = snodo;
	}

	public String getCodiceLinea() {
		return CodiceLinea;
	}

	public void setCodiceLinea(String codiceLinea) {
		CodiceLinea = codiceLinea;
	}

	public Vehicle getMezzo() {
		return mezzo;
	}

	public void setMezzo(Vehicle mezzo) {
		this.mezzo = mezzo;
	}

	public boolean isSnodo() {
		return snodo;
	}

	@Override
	public String toString() {
		return "Fermata [CodiceFermata=" + CodiceFermata + ", snodo=" + snodo + ", orario=" + orario + ", CodiceLinea="
				+ CodiceLinea + ", mezzo=" + mezzo + "]";
	}

	public double getTariffaMezzo() throws Exception {
		DBread reader = new DBread();
		return reader.searchTariffaMezzo(mezzo);
	}

	
	
}
