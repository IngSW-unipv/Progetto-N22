package it.unipv.po.connessioneDB;

import java.time.LocalDate; 
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;

import it.unipv.po.trasporto.fermata.Fermata;
import it.unipv.po.trasporto.ricerca.Ricerca;
import it.unipv.po.trasporto.titolo.Biglietto;
import it.unipv.po.utente.Utente;


public class Main {
	
	public static void main(String[] args) throws Exception {
		
		//------------------------------- parte di Alessandro -------------------------------------------
		
		Ricerca corsa = new Ricerca();
        
        String partenza = "F004";
        String  destinazione = "F023";
        Utente u = new Utente("Nome","Cognome","mail@mail.com","Password0");
        
        
        ArrayList<ArrayList<Fermata>> elenco = corsa.cerca(partenza, destinazione, LocalTime.parse("12:00:00"));
        System.out.println(elenco.size());
        
        ArrayList<Biglietto> biglietti = corsa.cercaEGenera(partenza, destinazione, LocalTime.parse("12:00:00"));
        for(int i = 0; i<biglietti.size(); i++) {
        	//u.aggiungiTitolo(biglietti.get(i));        	
        	System.out.println(biglietti.get(i).getIdTitolo());
        	System.out.println(biglietti.get(i).getPrezzo());
       	
        
        }
        /*u.acquistaCarrello(PagamentiM.creditcard, 0);
        Biglietto biglietto = new Biglietto(elenco);
        System.out.println(biglietto.getIdTitolo());
        System.out.println(biglietto.getPrezzo());
        
        ArrayList<Biglietto> biglietti = corsa.cercaEGenera(partenza, destinazione, LocalTime.parse("12:00:00"));
        for(int i=0; i<biglietti.size();i++) {
        	System.out.println("id biglietto "+i+": "+biglietti.get(i).getIdTitolo());
        }*/
        
        for(int i = 0; i < elenco.size(); i++) for(Fermata n : elenco.get(i)) System.out.println(n.getCodiceFermata() +" "+n.getOrario());
        
        /*ArrayList<ArrayList<Fermata>> p = new ArrayList<>();
        p.add(new ArrayList<Fermata>());
        p.get(0).add(elenco.get(0).get(0));
        p.get(0).add(elenco.get(0).get(2));
        p.get(0).add(elenco.get(0).get(1));
        
        p.add(new ArrayList<Fermata>());
        p.get(1).add(elenco.get(0).get(4));
        
        System.out.println(p.size());
        System.out.println(p.get(0));
        System.out.println(p.get(1));*/
        
        
        
        //----------------------------------------------------------------------------------------------------
        
        // ---------------------------------------- rose Prove Ronce ----------
        /*Utente u = new Utente();
        u.setUsername("Alessandro");
        DBwrite scrittore = new DBwrite();
       //scrittore.aggiungiACronologia(u, LocalDateTime.now(), 200);
        LinkedList<Titolo> lista = new LinkedList<Titolo>();
        Titolo t1 = new Biglietto();
        t1.setIDtitolo("T-linea-1");
        t1.setPrezzo(2.80);
        Titolo t2 = new Biglietto();
        t2.setIDtitolo("T-linea-2");
        t2.setPrezzo(1.80);
        Titolo t3 = new Biglietto();
        t3.setIDtitolo("T-linea-3");
        t3.setPrezzo(0.80);
        
        lista.add(t1);
        lista.add(t2);
        lista.add(t3);
         scrittore.aggiungiTitoliACronologia(u, LocalDateTime.now(), lista);
        
        
        //Prove per la rimozione di utente da carrello
        Utente u = new Utente("Alessandro");
      
        u.setPunti(20);
        //DBwrite scrittore = new DBwrite();
        Titolo t1 = new Biglietto();
        t1.setIDtitolo("T-linea-1");
        t1.setPrezzo(2.80);
        Titolo t2 = new Biglietto();
        t2.setIDtitolo("T-linea-2");
        t2.setPrezzo(1.80);
        Titolo t3 = new Biglietto();
        t3.setIDtitolo("T-linea-3");
        t3.setPrezzo(0.80);
        
        u.aggiungiTitolo(t1);
        u.aggiungiTitolo(t2);
        u.aggiungiTitolo(t3);
        u.acquistaCarrello(PagamentiM.creditcard, 20);
        
        System.out.println("punti :" + u.getPunti());
        System.out.println("username :" + u.getUsername());*/
        
      
        
	}

}
