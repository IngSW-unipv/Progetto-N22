package it.unipv.po.ticket.gui.utente;

import it.unipv.po.ticket.supporto.DBconnection;

public class Utente {
    String username, name, cognome, email,password = "";
	private double punti;
   

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
