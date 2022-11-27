package it.unipv.po.trasporto.ricerca;

import java.time.LocalDate; 
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import it.unipv.po.trasporto.fermata.Fermata;
import it.unipv.po.trasporto.ricerca.strategie.InterfaceRicercaStrategy;
import it.unipv.po.trasporto.ricerca.strategie.RicercaStrategy;
import it.unipv.po.trasporto.titolo.Abbonamento;
import it.unipv.po.trasporto.titolo.Biglietto;


/**
 * 
 * @author Giava
 *
 */
public class Ricerca{
	private InterfaceRicercaStrategy ricercaStrategy;
	
	public Ricerca() {
		ricercaStrategy = new RicercaStrategy();
	}
	
	
	public ArrayList<ArrayList<Fermata>>  cerca(String a, String b, LocalTime orario) throws Exception {
		return ricercaStrategy.cerca(a, b, orario);
	}
	
	/**
	 * Metodo per la ricerca delle fermate e conseguente generazione del titolo di viaggio
	 * @param a partenza
	 * @param b arrivo
	 * @param orario orario della partenza
	 * @return restiruisce i biglietti trovati
	 * @throws Exception
	 */
	public ArrayList<Biglietto> cercaEGenera(String a, String b, LocalTime orario) throws Exception {
		ArrayList<Biglietto> bigliettiTrovati= new ArrayList<Biglietto>();
		ArrayList<ArrayList<Fermata>> percorsi = ricercaStrategy.cerca(a, b, orario);
		for(int i = 0; i<percorsi.size(); i++) {
			bigliettiTrovati.add(new Biglietto(percorsi.get(i)));	
		}
		return bigliettiTrovati;
	}
	
	/**
	 * Metodo per la ricerca delle fermate e conseguente generazione dell'abbonamento
	 * @param a partenza
	 * @param b arrivo
	 * @param inizio 
	 * @param giorniDurata 
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Abbonamento> cercaEGenera(String a, String b, LocalDate inizio, int giorniDurata) throws Exception{
		ArrayList<Abbonamento> abbonamentiTrovati= new ArrayList<Abbonamento>();
		ArrayList<ArrayList<Fermata>> percorsi = ricercaStrategy.cerca(a, b, LocalTime.NOON);
		for(int i = 0; i<percorsi.size(); i++) {
			abbonamentiTrovati.add(new Abbonamento(inizio, giorniDurata, percorsi.get(i)));	
		}
		return abbonamentiTrovati;
	}
	
	public String stampaRicerca(ArrayList<Fermata> cerca) {
		return ricercaStrategy.stampaRicerca(cerca);
		
	}
	
}
