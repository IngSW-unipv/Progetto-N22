package it.unipv.po.utente;

import java.util.ArrayList;

import it.unipv.po.carrello.Carrello;
import it.unipv.po.carrello.pagamento.Pagamento;
import it.unipv.po.carrello.pagamento.supporto.PagamentiM;
import it.unipv.po.trasporto.titolo.Titolo; 


public class Utente {
    private String name;
    private String cognome;
    private String email;
    private String password;
	private double credito;
	private Carrello carrello;
	private ArrayList<Titolo> titoliAcquistati;
	
	//per la registrazione
	public Utente(String name, String cognome, String email, String password) {
		this.name = name;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
		this.credito = 0;
		carrello = new Carrello(email);
		titoliAcquistati = new ArrayList<Titolo>();
	}
	
	//per il login
	public Utente(String name, String cognome, String email, String password, double credito) {
		this.name = name;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
		this.credito = credito;
		titoliAcquistati = new ArrayList<Titolo>();
		carrello = new Carrello(email);
	}
	
//	public Utente() {
//		this.name = "";
//		this.cognome = "";
//		this.email = "";
//		this.password = "";
//		
//	}
	
	public void aggiungiCredito(double creditoAdd) {
		credito+=creditoAdd;
	}

	public void sottraiCredito(double creditoSub) {
		credito-=creditoSub;
	}
	
	public void aggiungiTitolo(Titolo t) {
		carrello.aggiungiTitolo(t);
	}
    
	public void rimuoviTitolo(Titolo t) {
		carrello.rimuoviTitolo(t);
	}
	
	public boolean acquistaCarrello(PagamentiM metodo, double creditoUtilizzato) throws Exception {
		if(creditoUtilizzato > credito)
			creditoUtilizzato = credito;
		if(creditoUtilizzato >= carrello.getTotale())
			creditoUtilizzato = carrello.getTotale();
		Pagamento payment = carrello.chiudeEpaga(metodo, creditoUtilizzato);
		if(payment.isAutorizzato()) {
			sottraiCredito(creditoUtilizzato);
			aggiungiCredito(payment.getCreditoOttenuto());
		}
		return payment.isAutorizzato();
	}
	public ArrayList<Titolo> getTitoliInCarrello(){
		return (ArrayList<Titolo>) carrello.getTitoli();
	}
	public Titolo getUltimoTitoloInCarrello() {
		return carrello.getTitoli().get(carrello.getTitoli().size()-1);
	}
	public void cancellaCarrello() {
		carrello.clearAll();
	}
	
	public void setTitoliAcquistati(ArrayList<Titolo> titoli) {
		this.titoliAcquistati = titoli;
	}
	
	public ArrayList<Titolo> getTitoliAcquistati() {
		return this.titoliAcquistati;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public double getCredito() {
		return credito;
	}
	public void setCredito(double credito) {
		this.credito = credito;
	}
	
	public Carrello getCarrello() {
		return carrello;
	}
	
    
    
}
