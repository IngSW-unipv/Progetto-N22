package it.unipv.po.test;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import it.unipv.po.connessioneDB.DBwrite;
import it.unipv.po.sessione.Sessione;
import it.unipv.po.utente.Utente;

public class TestRegistrazione {

	public static void main(String[] args) {
		String email = "Prova@Email";
		String nome = "ProvaNome";
		String cognome = "ProvaCognome";
		String password = "ProvaPassword1";
		String errore = "";
		
		Sessione s = new Sessione();
		try {
			errore = s.CheckRegistration(email, nome, cognome, password);
		} catch (SQLException e) {
			System.out.println("errore di connessione!");
		}
		
		if(errore.compareTo("")==0) {
			DBwrite scrittore = new DBwrite();
			Utente utente = new Utente(nome, cognome, email, password);
			try {
				scrittore.aggiungiUtente(utente);
			} catch (NoSuchAlgorithmException e) {
				System.out.println("errore di crittografia");
			} catch (SQLException e) {
				System.out.println("errore di connessione");
			}
			
			System.out.println("nome: " + utente.getName());
			System.out.println("cognome: " + utente.getCognome());
			System.out.println("email: " + utente.getEmail());
			System.out.println("credito: "+ utente.getCredito());
		}else {
			System.out.println("errore di registrazione");
		}
		
		
		

	}

}
