package it.unipv.po.cccp;

import java.util.LinkedList;

import it.unipv.po.ticket.cus.Sessione;
import it.unipv.po.ticket.cus.Utente;
import it.unipv.po.ticket.titolo.Titolo;

//pure fabrication, sarà la classe che si occupa della comunicazione
//col Data Base per evitare che se ne occupi Carrello, diminuendone la coesione
public class Cronologia implements ICronologia{
	Sessione s;
	Utente u;
	LinkedList<Titolo> lista;
	
	public Cronologia(Sessione s, Utente u, LinkedList<Titolo> lista) {
		this.s=s;
		this.u=u;
		this.lista=new LinkedList<Titolo>();
		this.lista=lista;
	}
	
	@Override
	public void aggiornaDB() {
		
		
	}
	
}
