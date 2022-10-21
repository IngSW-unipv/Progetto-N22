package it.unipv.po.ticket.titolo;

import it.unipv.po.ticket.trasporto.vehicleModel.Vehicle;
import java.time.*;
import it.unipv.po.ticket.trasporto.corsa.*;



public abstract class Titolo {
	
	private String idTitolo;
	private float prezzo;
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
	public float getPrezzo() {
	
		return prezzo;
	}
	
	public void setPrezzo(float p) {
		
		prezzo=p;
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
	
	
	public float getPrezzoTitolo(String idTitolo, String partenza, String destinazione ) {
		
		Corsa corsa = new Corsa();
        
        corsa.setCorsa();
        String str = corsa.cerca(partenza, destinazione);  
        
        //probabilmente c'è un modo più carino per farlo
        str= str.replace("Fermata: ", "");
        str= str.replace("numero:", "");
        str= str.replace("Snodo con ", "");
        
        //dovrebbe togliere gli spazi vuoti ma non ho potuto testarlo
        str.trim();
        
        float prezzo=0;
        
        int i = 0;
        
        
        while(i < str.length()) {
        	
        	//conta il numero di fermate che devo moltiplicare per il supplemento
        	if(str.charAt(i) == 'F' && NumberUtils.isDigits((String) str.subSequence(i+1, i+4))) {
        		prezzo++;
        		
        	}
        	//il supplemento va in base al mezzo utilizzato 
        	//non va bene perchè così non moltiplico il numero di fermate per il supplemento
        	else if( str.contains("Autobus")) {
        		
        		prezzo *=  0.1;
        		
        	}else if( str.contains("Tram")) {
        		
        		prezzo *=  0.2;
        		
        	}else if( str.contains("Treno")) {
        		
        		prezzo *=  0.3;
        	}
        	
        	i++;
        }
        
        return prezzo;	
	}
}