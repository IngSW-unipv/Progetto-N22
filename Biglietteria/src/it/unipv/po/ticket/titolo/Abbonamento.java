package it.unipv.po.ticket.titolo;
import java.time.*;

public class Abbonamento extends Titolo{
	
	private LocalDate dataInizio;
	private int durata;
	
	public Abbonamento(String idAbbonamento, LocalDate dataInizio, int durata) {
		
		this.setIDtitolo(idAbbonamento);
		this.dataInizio = dataInizio;
		this.durata = durata;
	}
	
	public Abbonamento() {
		
		this.setIDtitolo("");
		this.dataInizio = null;
		this.durata = 0;
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
