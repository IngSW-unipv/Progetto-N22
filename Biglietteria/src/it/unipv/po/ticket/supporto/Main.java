package it.unipv.po.ticket.supporto;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;

import it.unipv.po.cccp.pagamento.PagamentiM;
import it.unipv.po.ticket.gui.utente.Utente;
import it.unipv.po.ticket.titolo.Biglietto;
import it.unipv.po.ticket.titolo.Titolo;
import it.unipv.po.ticket.trasporto.fermata.Fermata;
import it.unipv.po.ticket.trasporto.ricerca.Ricerca;
import it.unipv.po.ticket.trasporto.vehicleModel.Vehicle;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		//------------------------------- parte di Alessandro -------------------------------------------
		
		Ricerca corsa = new Ricerca();
        
        String partenza = "F004";
        String  destinazione = "F026";
        
        ArrayList<Fermata> elenco = corsa.cerca(partenza, destinazione, LocalTime.parse("12:00:00"));
        
        System.out.println(corsa.stampaRicerca(elenco));
        
        
        LocalTime a = LocalTime.parse("12:30:00");
        LocalTime b = LocalTime.parse("14:00:00");
        
        Biglietto biglietto = new Biglietto(elenco);
        System.out.println(biglietto.getIdTitolo());
        System.out.println(biglietto.getPrezzo());
        
        ArrayList<Biglietto> biglietti = corsa.cercaEGenera(partenza, destinazione, LocalTime.parse("12:00:00"));
        for(int i=0; i<biglietti.size();i++) {
        	System.out.println("id biglietto "+i+": "+biglietti.get(i).getIdTitolo());
        }
        
        
        //----------------------------------------------------------------------------------------------------
        
        // ---------------------------------------- rose Prove Ronce ----------
//        Utente u = new Utente();
//        u.setUsername("Alessandro");
//        DBwrite scrittore = new DBwrite();
//        //scrittore.aggiungiACronologia(u, LocalDateTime.now(), 200);
//        LinkedList<Titolo> lista = new LinkedList<Titolo>();
//        Titolo t1 = new Biglietto();
//        t1.setIDtitolo("T-linea-1");
//        t1.setPrezzo(2.80);
//        Titolo t2 = new Biglietto();
//        t2.setIDtitolo("T-linea-2");
//        t2.setPrezzo(1.80);
//        Titolo t3 = new Biglietto();
//        t3.setIDtitolo("T-linea-3");
//        t3.setPrezzo(0.80);
//        
//        lista.add(t1);
//        lista.add(t2);
//        lista.add(t3);
   //     scrittore.aggiungiTitoliACronologia(u, LocalDateTime.now(), lista);
        
        
        //Prove per la rimozione di utente da carrello
        /*Utente u = new Utente("Alessandro");
      
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
