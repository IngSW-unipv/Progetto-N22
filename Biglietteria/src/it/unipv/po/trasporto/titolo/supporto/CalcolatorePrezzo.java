package it.unipv.po.trasporto.titolo.supporto;

import java.sql.SQLException;
import java.util.ArrayList;

import it.unipv.po.trasporto.fermata.Fermata; 


/**
 * 
 * @author Giava
 *
 */
public class CalcolatorePrezzo {

	/**
	 * Metodo per il calcolo del prezzo del biglietto
	 * 
	 * @param percorso array di fermate
	 * @return ritorna il prezzo del biglietto
	 * @throws SQLException
	 */
	public double calcolaPrezzo(ArrayList<Fermata> percorso) throws SQLException {
		double prezzo = 0;
		for(int i=0; i<percorso.size(); i++) {
			prezzo += percorso.get(i).getTariffaMezzo();
		}
		return prezzo;
	}
	
	/**
	 * Metodo per il calcolo dell'abbonamento
	 * @param percorso array di fermate
	 * @param durata durata dell'abbonamento
	 * @return ritorna il prezzo dell'abbonamento
	 * @throws SQLException
	 */
	public double calcolaPrezzo(ArrayList<Fermata> percorso, int durata) throws SQLException {
		double prezzo = 0;
		for(int i=0; i<percorso.size(); i++) {
			prezzo += percorso.get(i).getTariffaMezzo();
		}
		prezzo *= durata;
		prezzo -= prezzo*(durata/50);
		return prezzo;
	}
	
	

}
