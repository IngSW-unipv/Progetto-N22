package it.unipv.po.ticket.cus;

import it.unipv.po.cccp.Carrello;

public class Utente implements IUtente {
	private String name;
	private String surname;
	private String username;
	private String password;
	private String email;
	private Carrello cart;
	private double punti;
	
	public Utente() {
		creaCarrello();
	}
	
	@Override
	public void creaCarrello() {
		cart = new Carrello(this);
	}
	
	@Override
	public void cronologiaAcquisti() {
		
		
	}
	@Override
	public void aggiungiPunti(double puntiAdd) {
		punti+=puntiAdd;
	}
	@Override
	public void sottraiPunti(double puntiSub) {
		punti-=puntiSub;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getPunti() {
		return punti;
	}
	public void setPunti(double punti) {
		this.punti = punti;
	}



	
	
}
