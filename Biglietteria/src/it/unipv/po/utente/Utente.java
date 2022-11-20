package it.unipv.po.utente;

import java.util.ArrayList;

import it.unipv.po.carrello.Carrello;
import it.unipv.po.carrello.pagamento.Pagamento;
import it.unipv.po.carrello.pagamento.supporto.PagamentiM;
import it.unipv.po.trasporto.titolo.Titolo; 


public class Utente {
    private String username, name, cognome, email,password;
	private double punti;
	private Carrello carrello;
	private ArrayList<Titolo> titoliAcquistati;
	
	public Utente(String username, String name, String cognome, String email, String password) {
		this.username = username;
		this.name = name;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
		carrello = new Carrello(username);
		titoliAcquistati = new ArrayList<Titolo>();
	}
	
	public Utente(String username) {
		this.username = username;
		carrello = new Carrello(username);
	}
	
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
	
	public void setTitoliAcquistati(ArrayList<Titolo> titoli) {
		this.titoliAcquistati = titoli;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
	
    
    
}
