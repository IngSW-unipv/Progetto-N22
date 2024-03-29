package it.unipv.po.trasporto.titolo;

import java.sql.SQLException;
import java.time.*; 
import java.util.ArrayList;

import it.unipv.po.trasporto.fermata.Fermata;
import it.unipv.po.trasporto.titolo.supporto.CalcolatoreID;
import it.unipv.po.trasporto.titolo.supporto.CalcolatorePrezzo;

/**
 * 
 * @author Luca
 *
 */
public class Abbonamento extends Titolo{
	private LocalDate dataInizio;
	private int durataAbbonamento;
	
	/**
	 * Costruttore di abbonamento 
	 * 
	 * @param dataInizio 
	 * @param durata 
	 * @param percorso  
	 * @throws SQLException 
	 */
	public Abbonamento(LocalDate dataInizio, int durata, ArrayList<Fermata> percorso) throws SQLException{
		this.dataInizio = dataInizio;
		this.durataAbbonamento = durata;
		
		setPercorso(percorso);
		this.calcolatoreID = new CalcolatoreID();
		this.calcolatorePrezzo = new CalcolatorePrezzo();
		// per gli abbonamenti avremo nell'id un prefisso 'a'
		String tempID = "a--"+calcolatoreID.calcolaID(percorso)+"--"
						+dataInizio.toString()+"--"+durata;
		setIdTitolo(tempID);
		//richiedendo l'accesso al DB va gestita l'eccezione
		setPrezzo(calcolatorePrezzo.calcolaPrezzo(percorso, durata));
	}
	
	//usato quando si riprendono le informazioni dal DB

	public Abbonamento(String idTitolo,double prezzo, String percorso, String dataInizio, int durata, String dataAcquisto){
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

	@Override
	public void oblitera() {
		// doNothing
		
	}

	@Override
	public void scadi() {
		// doNothing
		
	}


}
