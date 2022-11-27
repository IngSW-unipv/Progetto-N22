package it.unipv.po.carrello;
import java.sql.SQLException;
import java.time.LocalDateTime;   
import java.util.*;

import it.unipv.po.carrello.pagamento.Pagamento;
import it.unipv.po.carrello.pagamento.supporto.PagamentiM;
import it.unipv.po.connessioneDB.DBwrite;
import it.unipv.po.trasporto.titolo.Titolo; 


public class Carrello implements ICarrello {
	private String user;
	private ArrayList<Titolo> lista; 
	private it.unipv.po.connessioneDB.DBwrite writer;
	private double totale;
	
	//lo usiamo prima della fase supplementi quando ancora non mettiamo i titoli nel carrello
	//ma ci serve conoscere le caratteristiche del titolo
	private Titolo titoloModel;
	
	
	public Carrello() {
		totale=0;
		writer = new DBwrite();
		lista= new ArrayList<Titolo>();	
	}
	public Carrello(String user) {
		totale=0;
		writer = new DBwrite();
		lista= new ArrayList<Titolo>();
		this.user=user;
	}

	@Override
	public void aggiungiTitolo(Titolo t) {
		lista.add(t);
//		incrementaTotale(t);
		
	}

	@Override
	public void rimuoviTitolo(Titolo t) {
		lista.remove(t);
//		decrementaTotale(t);
	}

	@Override
	public List<Titolo> getTitoli() {
		return lista;
	}

	@Override
	public void clearAll() {
		lista.clear();
		this.totale = 0;
		
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
		calcolaTotale();
		return totale;
	}
	
	public void calcolaTotale() {
		totale = 0;
		for(int i = 0; i<lista.size(); i++) {
			totale += lista.get(i).getPrezzo();
		}
	}
	
	@Override
	public Pagamento chiudeEpaga(PagamentiM metodo, double creditoUtilizzato) throws SQLException{
		calcolaTotale();
		Pagamento payment = new Pagamento(totale);
		payment.calcolaPrezzoFinale(creditoUtilizzato);
		payment.payStrategySetter(metodo);
		boolean check = payment.autorizza();
		if (check) 
			aggiornaCronologia(payment.getDataEora(), payment.getImporto(), creditoUtilizzato);
			
		return payment;
		
	}
	  
	@Override
	public void aggiornaCronologia(LocalDateTime date, double importo, double puntiUtilizzati) throws SQLException {
		writer.aggiungiTotaleACronologia(user, date, importo, puntiUtilizzati);
		writer.aggiungiTitoliACronologia(user, date, lista);
	}
	public Titolo getTitoloModel() {
		return titoloModel;
	}
	public void setTitoloModel(Titolo titoloModel) {
		this.titoloModel = titoloModel;
	}
	

	



	
	
	
	
}
