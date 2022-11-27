package it.unipv.po.test;

import it.unipv.po.gui.utente.Login;
import it.unipv.po.sessione.Sessione;

public class SystemTest {

	public static void main(String[] args) {
		Sessione s = new Sessione();
		String[] argomenti = new String[] {"",""};
		Login login = new Login(s, argomenti);
		login.main(s, args);
	}

}
