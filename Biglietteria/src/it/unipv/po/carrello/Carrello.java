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
	
	/**
	 * Costruttore di Carrello
	 * @param user eMail dell'utente che lo ha generato
	 */
	public Carrello(String user) {
		totale=0;
		writer = new DBwrite();
		lista= new ArrayList<Titolo>();
		this.user=user;
	}

	@Override
	public void aggiungiTitolo(Titolo t) {
		lista.add(t);

		
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
	public double getTotale() {
		calcolaTotale();
		return totale;
	}
	
	/**
	 * calcola e aggiorna il totale in base ai titoli
	 * presenti nella lista di titoli del carrello.
	 */
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
	public void aggiornaCronologia(LocalDateTime date, double importo, double creditoUtilizzato) throws SQLException {
		writer.aggiungiTotaleACronologia(user, date, importo, creditoUtilizzato);
		writer.aggiungiTitoliACronologia(user, date, lista);
	}
	
	/**
	 * getter di titoloModel
	 * @return restituisce il titolo "titoloModel"
	 */
	public Titolo getTitoloModel() {
		return titoloModel;
	}
	
	/**
	 * setter di titoloModel
	 * @param titoloModel setta l'attributo titoloModel con il parametro ononimo
	 */
	public void setTitoloModel(Titolo titoloModel) {
		this.titoloModel = titoloModel;
	}
	

	



	
	
	
	
}
