package it.unipv.po.ticket.titolo;



public class Titolo {
	
	private String idTitolo;
	private float prezzo;
	boolean attivo;
	
	public Titolo (String idTitolo, float prezzo, boolean attivo) {
		
		this.idTitolo = idTitolo;
		this.prezzo = prezzo;
		this.attivo = attivo;
	}
	
	public Titolo() {
		
		this.idTitolo="";
		this.prezzo = 0;
	}
	
	
	// getter setter
	
	public String getId() {
		
		return idTitolo;
	}
	
	public void setIDtitolo(String id) {
		
		idTitolo = id;
		
	}
	public float getPrezzo() {
	
		return prezzo;
	}
	
	public void setPrezzo(float p) {
		
		prezzo=p;
	}
	
	public void setAttivo(boolean a) {
		attivo=a;
	}
	
	public boolean getAttivo() {
		
		if(attivo=true) {
			
			return true;
		}
		return false;
	}
	
	
	
	
	
}