package it.unipv.po.ticket.gui.utente;

import java.util.regex.Pattern;

import it.unipv.po.ticket.supporto.DBconnection;

public class Sessione {

	public static boolean CheckLogin(String passdb, String passtext) {
		boolean check=false;
		
		if(passdb.compareTo(passtext) == 0 ) check = true;
		
		return check;
	}

	public static String CheckRegistration(String email, String username,String nome, String cognome, String telefono, String password, String conferma) {
	    String error="";
		
	     if (!CheckEmail(email))   error="Email non valida";
	     if (!(telefono!= null && telefono.matches("[0-9]+")&&telefono.length()==10)) error="Numero di telefono non valido";
	     if((email.isEmpty() || username.isEmpty() || nome.isEmpty()|| cognome.isEmpty()|| telefono.isEmpty())) error = "Tutti i campi devono essere compilati";
	     if(password.compareTo(conferma)!=0) error="Le password non coincidono"; 
		try {
			if(!(DBconnection.searchUsername(username)==0)) error="Username già esistente";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return error;
	}
	
	
	 public static boolean CheckEmail(String email) {
	        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:.[a-zA-Z0-9-]+)*$";
	        Pattern p = Pattern.compile(regex);
	        return p.matcher(email).matches();
	    }
	
}