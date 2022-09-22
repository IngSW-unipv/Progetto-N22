package it.unipv.po.ticket.trasporto.fermata;

public class Fermata {
	
	public String CodiceFermata;
	public String orario;
	
	public Fermata(String orario, String CodiceFermata) {
		this.orario = orario;
		this.CodiceFermata = CodiceFermata;
	}
	
	public Fermata() {
		this.orario = null;
		this.CodiceFermata = "";
	}
	
	//getter e setter
	public String getCodiceFermata() {
		return CodiceFermata;
	}

	public void setCodiceFermata(String codiceFermata) {
		CodiceFermata = codiceFermata;
	}
	
	public String getOrario() {
		return orario;
	}
	
	public void setOrario(String orario) {
		this.orario = orario;
	}
}
