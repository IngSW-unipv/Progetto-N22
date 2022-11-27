package it.unipv.po.test;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import it.unipv.po.gui.utente.Login;
import it.unipv.po.sessione.Sessione;
import it.unipv.po.utente.Utente;



public class TestLogin {

	public static void main(String[] args) throws NoSuchAlgorithmException, SQLException, Exception {
		Sessione s = new Sessione();
		Utente utente = s.UserLogin("rose@unipv.it", "Password1");
		System.out.println("nome: " + utente.getName());
		System.out.println("cognome: " + utente.getCognome());
		System.out.println("email: " + utente.getEmail());
		System.out.println("credito: "+ utente.getCredito());
		for(int i = 0; i < utente.getTitoliAcquistati().size(); i++)
			System.out.println("Titolo "+ i + ": "+ utente.getTitoliAcquistati().get(i).getIdTitolo());
		
	}

}
