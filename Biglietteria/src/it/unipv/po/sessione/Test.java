package it.unipv.po.sessione;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import it.unipv.po.utente.Utente;

public class Test {

	public static void main(String[] args) throws NoSuchAlgorithmException, SQLException, Exception {
		// TODO Auto-generated method stub
		Sessione s = new Sessione();
		Utente u = s.UserLogin("rose@unipv.it", "Password1");
		System.out.println(""+ u.getCredito());
		
	}

}
