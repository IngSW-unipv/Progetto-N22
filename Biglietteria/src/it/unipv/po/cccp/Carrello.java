package it.unipv.po.cccp;
import java.util.*;
import it.unipv.po.ticket.titolo.*;

import it.unipv.po.ticket.cus.Sessione;
import it.unipv.po.ticket.cus.Utente;
import it.unipv.po.ticket.titolo.Titolo;

public class Carrello implements ICarrello {
	Sessione s;
	Utente u;
	LinkedList<Titolo> lista; //scegliamo la linkedlist rispetto all arraylist
	//perchè non sarà di dimensioni elevate e leggerla tutta non impatterà sulle
	//prestazioni
	CalcolatoreScontoETasse calcolatore;
	
	public Carrello(Sessione s, Utente u) {
		this.u=u;
		this.s=s;
		lista= new LinkedList<Titolo>();
		calcolatore = new CalcolatoreScontoETasse();
		
	}
	
	@Override
	public void inizializza(Sessione s) {
		this.s=s;
		
	}

	@Override
	public void aggiungiTitolo(Titolo t) {
		lista.add(t);
		
	}

	@Override
	public void rimuoviTitolo(Titolo t) {
		lista.remove(t);
		
	}

	@Override
	public List<Titolo> getTitoli() {
		return lista;
	}

	@Override
	public void clearAll() {
		lista.clear();
		
	}

	@Override
	public double getTotale(int punti) {
		double tot=0;
		for(int i=0; i<lista.size();i++)
			tot += lista.get(i).getPrezzo();
		double sconto=calcolatore.calcolaSconto(tot,punti);
		tot=tot-sconto;
		
		return tot;
	}
	
	

	
	//in input vuole il boolean che deriva dal check del pagamento 
	//se è true contabilizza se no non salva niente su DB
	@Override
	public void aggiornaCronologia(boolean check) {
		if (check)
		/*connessione e scrittura su DB*/;
		
	}

	
	
	
}
