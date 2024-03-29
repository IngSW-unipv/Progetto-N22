package it.unipv.po.trasporto.titolo;

import java.sql.SQLException;
import java.time.*;
import java.util.ArrayList;
import java.util.Scanner;

import it.unipv.po.trasporto.fermata.Fermata;
import it.unipv.po.trasporto.titolo.supporto.CalcolatoreID;
import it.unipv.po.trasporto.titolo.supporto.CalcolatorePrezzo;

/**
 * 
 * @author Giava
 *
 */
public abstract class Titolo {
	
	private String idTitolo;
	private double prezzo;
	private ArrayList<Fermata> percorso;
	private LocalDateTime dataAcquisto;
	protected CalcolatorePrezzo calcolatorePrezzo;
	protected CalcolatoreID calcolatoreID;


	public Titolo(ArrayList<Fermata> percorso) {
		this.percorso = percorso;
	}

	public Titolo() {
		this.idTitolo = "?????";
		this.prezzo = 0;
		
	}
	
	/** trasforma l'array di fermate in una stringa di fermate con id e orario
	 * 
	 * @return ottengo la string di fermate
	 */
	public String getStringPercorso() {
		StringBuilder stringPercorso = new StringBuilder("");
		for(int i = 0; i<percorso.size(); i++) {
			stringPercorso.append(percorso.get(i).getCodiceFermata());
			stringPercorso.append("T");
			stringPercorso.append(percorso.get(i).getOrario().toString());
			stringPercorso.append("-");
		}
		stringPercorso.deleteCharAt(stringPercorso.length()-1);
		return stringPercorso.toString();
	}
	
	/**ricostruisce l'array di fermate in forma non verbosa a partire dalla stringa generata dalla funzione precedente
	 * 
	 * @param percorso parametro
	 */
	public void setPercorso(String percorso) {
		this.percorso = new ArrayList<Fermata>();
		Scanner scanner = new Scanner(percorso);
		scanner.useDelimiter("-|T");
		while(scanner.hasNext()) {
			Fermata fermata = new Fermata(scanner.next(),LocalTime.parse(scanner.next()));
			this.percorso.add(fermata);
		}		
	}
	
	public void setDataAcquisto(String dataAcquisto) {
		this.dataAcquisto = LocalDateTime.parse(dataAcquisto);
	}

	public String getIdTitolo() {
		return idTitolo;
	}

	public void setIdTitolo(String idTitolo) {
		this.idTitolo = idTitolo;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public ArrayList<Fermata> getPercorso() {
		return percorso;
	}

	public void setPercorso(ArrayList<Fermata> percorso) {
		this.percorso = percorso;
	}


	public LocalDateTime getDataAcquisto() {
		return dataAcquisto;
	}

	
	public void setDataAcquisto(LocalDateTime dataAcquisto) {
		this.dataAcquisto = dataAcquisto;
	}

	public abstract boolean isAttivo();	
	public abstract boolean isDisponibile();	
	public abstract String getDataInizio();	
	public abstract LocalTime getDurataViaggio(ArrayList<Fermata> percorso);
	public  abstract int getDurataAbbonamento();
	public abstract void oblitera() throws SQLException;
	public abstract void scadi();
	
	
	
	
	
	

}