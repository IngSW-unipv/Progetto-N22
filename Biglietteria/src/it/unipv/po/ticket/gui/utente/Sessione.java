package it.unipv.po.ticket.gui.utente;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

import it.unipv.po.ticket.supporto.DBconnection;
import it.unipv.po.ticket.supporto.DBread;

public class Sessione {

	

	public static boolean UserLogin(String user, String passtext) {
		boolean check=false;
		String passdb="";
		DBread db = new DBread();
		
		try {
			passdb=db.searchPassword(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if(passdb.compareTo(sha1(passtext)) == 0 ) check = true;
		
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Utente utente = CreateUser(user);
		
		return check;
	}

	private static Utente CreateUser(String user) {
		DBread db = new DBread();
		
      Utente utente = null;
	try {
		utente = db.userDownload(user);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		return utente;
	}

	public static String CheckRegistration(String email, String username,String nome, String cognome, String telefono, String password, String conferma) {
	    String error="";
		DBread db = new DBread();
		
	     if (!CheckEmail(email))   error="Email non valida";
	     if (!(telefono!= null && telefono.matches("[0-9]+")&&telefono.length()==10)) error="Numero di telefono non valido";
	     if((email.isEmpty() || username.isEmpty() || nome.isEmpty()|| cognome.isEmpty()|| telefono.isEmpty())) error = "Tutti i campi devono essere compilati";
	     if(password.compareTo(conferma)!=0) error="Le password non coincidono"; 
		try {
			if(!(db.searchUsername(username)==0)) error="Username già esistente";
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
	 
	 
	   public static String sha1(String input) throws NoSuchAlgorithmException {
	        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
	        byte[] result = mDigest.digest(input.getBytes());
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < result.length; i++) {
	            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
	        }
	         
	        return sb.toString();
	    }

	
}