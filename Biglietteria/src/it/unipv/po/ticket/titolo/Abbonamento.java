package it.unipv.po.ticket.titolo;
import java.time.*;
import java.util.ArrayList;

import it.unipv.po.ticket.trasporto.fermata.Fermata;

public class Abbonamento extends Titolo{
	private LocalDate dataInizio;
	private int durataAbbonamento;
	
	public Abbonamento(LocalDate dataInizio, int durata, ArrayList<Fermata> percorso) throws Exception {
		this.dataInizio = dataInizio;
		this.durataAbbonamento = durata;
		
		setPercorso(percorso);
		this.calcolatoreID = new CalcolatoreID();
		this.calcolatorePrezzo = new CalcolatorePrezzo();
		// per glii abbonamenti avremo nell'id un prefisso 'a'
		String tempID = "a--"+calcolatoreID.calcolaID(percorso)+"--"
						+dataInizio.toString()+"--"+durata;
		setIdTitolo(tempID);
		//richiedendo l'accesso al DB va gestita l'eccezione
		setPrezzo(calcolatorePrezzo.calcolaPrezzo(percorso));
	}
	
	//usato quando si riprendono le informazioni dal DB
	public Abbonamento(String idTitolo,double prezzo, String percorso, String dataInizio, int durata, String dataAcquisto) throws Exception {
		this.setIdTitolo(idTitolo);
		this.setPrezzo(prezzo);
		this.setPercorso(percorso);
		this.setDataInizio(dataInizio);
		this.durataAbbonamento = durata;
		this.setDataAcquisto(dataAcquisto);
	}
	

	

	private void setDataInizio(String dataInizio) {
		this.dataInizio = LocalDate.parse(dataInizio);
		
	}

	@Override
	public boolean isAttivo() {
		//essendo una caratteristica di biglietto returno false
		return false;
	}



	@Override
	public boolean isDisponibile() {
		//essendo una caratteristica di biglietto returno false
		return false;
	}



	@Override
	public String getDataInizio() {
		return dataInizio.toString();
	}


	@Override
	public int getDurataAbbonamento() {
		return durataAbbonamento;
	}

	@Override
	public LocalTime getDurataViaggio(ArrayList<Fermata> percorso) {
		// TODO Auto-generated method stub
		return null;
	}
}
