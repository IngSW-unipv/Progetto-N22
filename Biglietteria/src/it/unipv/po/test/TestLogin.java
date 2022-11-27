package it.unipv.po.test;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import it.unipv.po.sessione.Sessione;



public class TestLogin {

	public static void main(String[] args) throws NoSuchAlgorithmException, SQLException, Exception {
		// TODO Auto-generated method stub
		Sessione s = new Sessione();
		s.UserLogin("rose@unipv.it", "Password1");
		
		
		
	}

}
