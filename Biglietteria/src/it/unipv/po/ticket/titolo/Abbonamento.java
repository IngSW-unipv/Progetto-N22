package it.unipv.po.ticket.titolo;

public class Abbonamento {
	private String idAbbonamento;
	private String dataInizio;
	private int durata;
	
	public Abbonamento(String idAbbonamento, String dataInizio, int durata) {
		
		this.idAbbonamento = idAbbonamento;
		this.dataInizio = dataInizio;
		this.durata = durata;
	}
	
	public Abbonamento() {
		
		this.idAbbonamento = "";
		this.dataInizio = "";
		this.durata = 0;
	}
	
	// getter & setter
	
	public String getIdAbbonamento() {
		
		return idAbbonamento;
	}
	
	public void setIdAbbonamento(String id) {
		
		this.idAbbonamento = id;
	}
	
	public String getDatainizio() {
		
		return dataInizio;
	}
	
	public void setDataInizio(String data) {
		
		this.dataInizio = data;
	}
	
	public int getDurata() {
		
		return durata;
	}
	
	public void setDurata(int d) {
		
		this.durata = d;
	}
}
