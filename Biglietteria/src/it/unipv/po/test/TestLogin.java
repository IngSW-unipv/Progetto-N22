package it.unipv.po.test;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import it.unipv.po.sessione.CredenzialiErrateException;
import it.unipv.po.sessione.Sessione;
import it.unipv.po.utente.Utente;

public class TestLogin {

	public static void main(String[] args){
		Sessione s = new Sessione();
		Utente utente;
		
		try {
			utente = s.UserLogin("rose@unipv.it", "Password1");
			
			System.out.println("nome: " + utente.getName());
			System.out.println("cognome: " + utente.getCognome());
			System.out.println("email: " + utente.getEmail());
			System.out.println("credito: "+ utente.getCredito());
			for(int i = 0; i < utente.getTitoliAcquistati().size(); i++)
				System.out.println("Titolo "+ i + ": "+ utente.getTitoliAcquistati().get(i).getIdTitolo());
			
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Errore: crittografia fallita");
		} catch (SQLException e) {
			System.out.println("Errore: connesione db fallita");
		} catch (CredenzialiErrateException e) {
			System.out.println("Errore: credenziali errate");
		}
		
	}

}
