package it.unipv.po.cccp;
import java.time.LocalDateTime;
import java.util.*; 
import it.unipv.po.ticket.titolo.*;
import it.unipv.po.cccp.pagamento.Pagamento;
import it.unipv.po.ticket.cus.Sessione;
import it.unipv.po.ticket.cus.Utente;
import it.unipv.po.ticket.supporto.DBwrite;
import it.unipv.po.ticket.titolo.Titolo;

public class Carrello implements ICarrello {
	private Sessione sessione;
	private Utente user;
	private LinkedList<Titolo> lista; //scegliamo la linkedlist rispetto all arraylist
	//perchè non sarà di dimensioni elevate e leggerla tutta non impatterà sulle
	//prestazioni
	private DBwrite writer;
	private double totale;
	
	public Carrello(Sessione s) {
		totale=0;
		this.sessione=s;
		lista= new LinkedList<Titolo>();	
	}
	
	@Override
	public void aggiungiTitolo(Titolo t) {
		lista.add(t);
		incrementaTotale(t);
	}

	@Override
	public void rimuoviTitolo(Titolo t) {
		lista.remove(t);
		decrementaTotale(t);
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
	public void incrementaTotale(Titolo t) {
		totale += t.getPrezzo();
	}
	
	@Override
	public void decrementaTotale(Titolo t) {
		totale -= t.getPrezzo();
	}
	@Override
	public double getTotale() {
		return totale;
	}
	
	@Override
	public void chiudeEpaga() throws Exception {
		Pagamento payment = new Pagamento(totale, user.getPunti());
		aggiornaCronologia(payment.getDataEora(), payment.getImporto());
	}
	  
	//in input vuole il boolean che deriva dal check del pagamento 
	//se è true contabilizza se no non salva niente su DB
	@Override
	public void aggiornaCronologia(LocalDateTime date, double importo) throws Exception {
		writer.aggiungiACronologia(user, sessione, date, importo);
		
	}

	public Sessione getSessione() {
		return sessione;
	}

	public void setSessione(Sessione sessione) {
		this.sessione = sessione;
	}

	public Utente getUser() {
		return user;
	}

	public void setUser(Utente user) {
		this.user = user;
	}
	
	
	
	
}
