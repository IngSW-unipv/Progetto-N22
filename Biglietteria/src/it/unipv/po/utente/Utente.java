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
	private double punti;
	private Carrello carrello;
	private ArrayList<Titolo> titoliAcquistati;
	
	public Utente(String name, String cognome, String email, String password) {
		this.name = name;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
		carrello = new Carrello(email);
		titoliAcquistati = new ArrayList<Titolo>();
	}
	
//	public Utente() {
//		this.name = "";
//		this.cognome = "";
//		this.email = "";
//		this.password = "";
//		
//	}
	
	public void aggiungiTitolo(Titolo t) {
		carrello.aggiungiTitolo(t);
	}
    
	public void rimuoviTitolo(Titolo t) {
		carrello.rimuoviTitolo(t);
	}
	
	public void acquistaCarrello(PagamentiM metodo, double puntiUtilizzati) throws Exception {
		if(puntiUtilizzati >= punti)
			puntiUtilizzati = punti;
		Pagamento payment = carrello.chiudeEpaga(metodo, puntiUtilizzati);
		if(payment.isAutorizzato()) {
			sottraiPunti(puntiUtilizzati);
			aggiungiPunti(payment.getPuntiOttenuti());
		}
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
	
	public double getPunti() {
		return punti;
	}
	public void setPunti(double punti) {
		this.punti = punti;
	}
	

	public void aggiungiPunti(double puntiAdd) {
		punti+=puntiAdd;
	}

	public void sottraiPunti(double puntiSub) {
		punti-=puntiSub;
	}
	public Carrello getCarrello() {
		return carrello;
	}
	
    
    
}