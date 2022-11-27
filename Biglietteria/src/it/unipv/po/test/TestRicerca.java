package it.unipv.po.test;

import java.time.LocalTime;
import java.util.ArrayList;

import it.unipv.po.trasporto.fermata.Fermata;
import it.unipv.po.trasporto.ricerca.Ricerca;

public class TestRicerca {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Ricerca corsa = new Ricerca();
        
        String partenza = "F004";
        String  destinazione = "F023";     
        
        ArrayList<ArrayList<Fermata>> elenco = corsa.cerca(partenza, destinazione, LocalTime.parse("12:00:00"));
        System.out.println("percorsi trovati: " + elenco.size());
        for(int i = 0; i < elenco.size(); i++) {
        	System.out.println("\npercorso "+i);
        	for(Fermata n : elenco.get(i)) System.out.println(n.getCodiceFermata() +" "+n.getOrario());
        }
	}

}
