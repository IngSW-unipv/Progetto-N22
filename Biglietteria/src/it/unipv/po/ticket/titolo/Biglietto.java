package it.unipv.po.ticket.titolo;

import java.time.*;

public class Biglietto extends Titolo{
	
	public Biglietto(String idBiglietto, LocalDateTime dataAcquisto){
		
		this.setIDtitolo(idBiglietto);
		this.setDataAcquisto(dataAcquisto);
	}

	public Biglietto() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	public Biglietto() {
		
		this.setIDtitolo("");
		this.setDataAcquisto("");
	}*/
	

	
}
