package it.unipv.po.sessione;

import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import it.unipv.po.connessioneDB.DBread;
import it.unipv.po.trasporto.titolo.Titolo;
import it.unipv.po.utente.Utente;


public class Sessione {
	
	public static boolean UserLogin(String email, String passtext) throws Exception {
		DBread db = new DBread();
		
		if(passtext.compareTo(db.userDownload(email).getPassword()) == 0) {
			Utente utente = CreateUser(email);
			utente.setTitoliAcquistati(scaricaTitoliUtente(email));
			
			return true;
		}
		
		return false;
	}

	private static Utente CreateUser(String email) throws Exception {
		DBread db = new DBread();

		return db.userDownload(email);
	}
	
	private static ArrayList<Titolo> scaricaTitoliUtente(String email) throws Exception {
		DBread db = new DBread();
		
		return db.scaricaTitoliUtente(email);
	}

	public static String CheckRegistration(String email,String nome, String cognome, String password) throws Exception {
	    String error="";
		DBread db = new DBread();
		
	    if (!CheckEmail(email)) error="Email non valida";
	    else if(email.isEmpty() || nome.isEmpty()|| cognome.isEmpty()) error = "Tutti i campi devono essere compilati";
	    else if(db.userDownload(email).getEmail().compareTo(email) ==0) error="Username già esistente";
		
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