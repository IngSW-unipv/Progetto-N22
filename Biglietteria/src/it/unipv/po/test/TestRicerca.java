package it.unipv.po.test;

import java.text.DecimalFormat;
import java.time.LocalTime;
import java.util.ArrayList;

import it.unipv.po.carrello.pagamento.supporto.PagamentiM;
import it.unipv.po.trasporto.fermata.Fermata;
import it.unipv.po.trasporto.ricerca.Ricerca;
import it.unipv.po.trasporto.titolo.Biglietto;
import it.unipv.po.trasporto.titolo.Titolo;
import it.unipv.po.utente.Utente;

public class TestRicerca {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Ricerca corsa = new Ricerca();
		Utente utente = new Utente();
		DecimalFormat df = new DecimalFormat("0.00");
        
        String partenza = "F004";
        String  destinazione = "F023";     
        
        ArrayList<ArrayList<Fermata>> elenco = corsa.cerca(partenza, destinazione, LocalTime.parse("12:00:00"));
        System.out.println("percorsi trovati: " + elenco.size());
        for(int i = 0; i < elenco.size(); i++) {
        	System.out.println("\npercorso "+i);
        	for(Fermata n : elenco.get(i)) System.out.println(n.getCodiceFermata() +" "+n.getOrario());
        }
        
        Biglietto biglietto = new Biglietto(elenco.get(0));
        System.out.println("\nbiglietto percorso 0 prezzo: "+ df.format(biglietto.getPrezzo()));
        utente.aggiungiTitolo(biglietto);
        biglietto = new Biglietto(elenco.get(1));
        System.out.println("biglietto percorso 1 prezzo: "+ df.format(biglietto.getPrezzo()));
        utente.aggiungiTitolo(biglietto);
        biglietto = new Biglietto(elenco.get(2));
        System.out.println("biglietto percorso 2 prezzo: "+ df.format(biglietto.getPrezzo()));
        utente.aggiungiTitolo(biglietto);
        
    	System.out.println("lista carrello: ");
    	for(Titolo n: utente.getTitoliInCarrello()) System.out.println(n.getIdTitolo());
    	
    	System.out.println("totale carrello: "+ df.format(utente.getCarrello().getTotale()));
    	utente.acquistaCarrello(PagamentiM.Creditcard, 0);
    	System.out.println("titoli acquistati: ");
    	for(Titolo n: utente.getTitoliAcquistati()) System.out.println(n.getIdTitolo());
    
	}

}
