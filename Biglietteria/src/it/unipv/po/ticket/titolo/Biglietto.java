package it.unipv.po.ticket.titolo;

public class Biglietto {
	
	private String idBiglietto;
	private String dataAcquisto;
	
	public Biglietto(String idBiglietto, String dataAcquisto){
		
		this.idBiglietto = idBiglietto;
		this.dataAcquisto = dataAcquisto;
	}
	
	public Biglietto() {
		
		this.idBiglietto = "";
		this.dataAcquisto = "";
	}
	
	public String getIdBiglietto() {
		
		return idBiglietto;
	}
	
	public void setIdBiglietto(String id) {
		
		this.idBiglietto=id;
		
	}
	
	public String getDataAcquito() {
		
		return dataAcquisto;
	}
	
	public void setDataAcquisto(String data) {
		
		this.dataAcquisto = data;
	}
	
}
