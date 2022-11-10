package it.unipv.po.cccp;
import java.time.LocalDateTime;  
import java.util.*; 
import it.unipv.po.ticket.titolo.*;
import it.unipv.po.cccp.pagamento.PagamentiM;
import it.unipv.po.cccp.pagamento.Pagamento;
import it.unipv.po.ticket.gui.utente.Utente;
import it.unipv.po.ticket.supporto.DBwrite;
import it.unipv.po.ticket.titolo.Titolo;

public class Carrello implements ICarrello {
	private Utente user;
	private LinkedList<Titolo> lista; //scegliamo la linkedlist rispetto all arraylist
	//perchè non sarà di dimensioni elevate e leggerla tutta non impatterà sulle
	//prestazioni
	private DBwrite writer;
	private double totale;
	
	
	public Carrello() {
		totale=0;
		lista= new LinkedList<Titolo>();	
	}
	public Carrello(Utente user) {
		totale=0;
		lista= new LinkedList<Titolo>();
		this.user=user;
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
	public void chiudeEpaga(PagamentiM metodo, double punti) throws Exception {
		Pagamento payment = new Pagamento(totale, user.getPunti());
		payment.calcolaPrezzoFinale(punti);
		payment.payStrategySetter(metodo);
		payment.autorizza();
		user.sottraiPunti(punti);
		aggiornaCronologia(payment.getDataEora(), payment.getImporto());
		user.aggiungiPunti(payment.getPuntiOttenuti());
	}
	  
	@Override
	public void aggiornaCronologia(LocalDateTime date, double importo) throws Exception {
		writer.aggiungiTotaleACronologia(user, date, importo);
		writer.aggiungiTitoliACronologia(user, date, lista);
	}

	



	public Utente getUser() {
		return user;
	}

	public void setUser(Utente user) {
		this.user = user;
	}
	
	
	
	
}
