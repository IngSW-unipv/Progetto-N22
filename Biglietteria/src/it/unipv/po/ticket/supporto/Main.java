package it.unipv.po.ticket.supporto;

import java.time.LocalDateTime; 
import java.util.ArrayList;
import java.util.LinkedList;

import it.unipv.po.ticket.cus.Utente;
import it.unipv.po.ticket.titolo.Biglietto;
import it.unipv.po.ticket.titolo.Titolo;
import it.unipv.po.ticket.trasporto.fermata.Fermata;
import it.unipv.po.ticket.trasporto.ricerca.Ricerca;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		//------------------------------- parte di Alessandro -------------------------------------------
		
		Ricerca corsa = new Ricerca();
        
        String partenza = "F004";
        String  destinazione = "F026";
        
        ArrayList<Fermata> elenco = corsa.cerca(partenza, destinazione);
        
        for(Fermata n : elenco) System.out.println(n.CodiceFermata);
        
        //----------------------------------------------------------------------------------------------------
        
        // ---------------------------------------- rose Prove Ronce ----------
        Utente u = new Utente();
        u.setUsername("Utente");
        DBwrite scrittore = new DBwrite();
        //scrittore.aggiungiACronologia(u, LocalDateTime.now(), 200);
        LinkedList<Titolo> lista = new LinkedList<Titolo>();
        Titolo t1 = new Biglietto();
        t1.setIDtitolo("T-linea-1");
        t1.setPrezzo(2.80);
        Titolo t2 = new Biglietto();
        t1.setIDtitolo("T-linea-2");
        t1.setPrezzo(1.80);
        Titolo t3 = new Biglietto();
        t1.setIDtitolo("T-linea-3");
        t1.setPrezzo(0.80);
        lista.add(t1);
        lista.add(t2);
        lista.add(t3);
        scrittore.aggiungiTitoliACronologia(u, LocalDateTime.now(), lista);
        
	}

}
