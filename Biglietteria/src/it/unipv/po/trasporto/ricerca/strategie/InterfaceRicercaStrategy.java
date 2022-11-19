package it.unipv.po.trasporto.ricerca.strategie;

import java.time.LocalTime; 
import java.util.ArrayList;

import it.unipv.po.trasporto.fermata.Fermata;


public interface InterfaceRicercaStrategy {
	public ArrayList<ArrayList<Fermata>> cerca(String a, String b, LocalTime orario) throws Exception;
	public String stampaRicerca(ArrayList<Fermata> ricerca);
}
