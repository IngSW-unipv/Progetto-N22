package it.unipv.po.trasporto.ricerca.strategie;

import java.time.LocalTime; 
import java.util.ArrayList;

import it.unipv.po.trasporto.fermata.Fermata;


public interface InterfaceRicercaStrategy {
	/**
	 *  Metodo per la ricerca delle fermate
	 *  
	 * @param a 
	 * @param b
	 * @param orario
	 * @return
	 * @throws Exception
	 */
	public ArrayList<ArrayList<Fermata>> cerca(String a, String b, LocalTime orario) throws Exception;
	
	/**
	 * 
	 * @param ricerca
	 * @return
	 */
	public String stampaRicerca(ArrayList<Fermata> ricerca);
}
