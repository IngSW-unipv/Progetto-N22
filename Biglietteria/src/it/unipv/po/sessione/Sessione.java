package it.unipv.po.sessione;

import java.security.MessageDigest;   
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.regex.Pattern;
import it.unipv.po.connessioneDB.DBread;
import it.unipv.po.utente.Utente;


public class Sessione {
	
	/**
	 * Metodo per il login dell'utente.
	 * @param email							email inserita
	 * @param passtext						password inserita
	 * @return								restituisce l'utente trovato su DB
	 * @throws NoSuchAlgorithmException		
	 * @throws SQLException					dovuta alla connessione con il DB
	 * @throws CredenzialiErrateException	viene generata se le credenziali non corrispondono
	 */
	public static Utente UserLogin(String email, String passtext) throws NoSuchAlgorithmException, SQLException, CredenzialiErrateException{
		DBread db = new DBread();
		Utente utente = new Utente();
		if(db.userDownload(email) != null) {
		if(sha1(passtext).compareTo(db.userDownload(email).getPassword()) == 0) 
			utente = CreateUser(email);
		} else 
			throw new CredenzialiErrateException();
		return utente;
	}
	
	/**
	 * Metodo per la costruzione dell'utente a seguito del login.
	 * @param email			email dell'utente
	 * @return				restituisce l'utente costruito
	 * @throws SQLException	dovuta alla connessione col DB
	 */
	private static Utente CreateUser(String email) throws SQLException {
		DBread db = new DBread();
		
		Utente utente = db.userDownload(email);
		utente.setTitoliAcquistati(db.scaricaTitoliUtente(email));
		
		return utente;
	}
	
	/**
	 * Metodo per il controllo della registrazione.
	 * @param email			email inserita
	 * @param nome			nome inserito
	 * @param cognome		cognome inserito
	 * @param password		password inserita
	 * @return				restituisce il messaggio di errore, vuoto se la registrazione andata a buon fine
	 * @throws SQLException	dovuta alla connessione col DB
	 */
	public static String CheckRegistration(String email,String nome, String cognome, String password) throws SQLException {
		DBread db = new DBread();
		Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:.[a-zA-Z0-9-]+)*$");
		Pattern passwordPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$");
		String error="";
		
	    if (!emailPattern.matcher(email).matches()) error = "Email non valida";
	    else if(!password.matches(".*\\d.*") || !(password.length() <= 21 && password.length() >= 8) || !passwordPattern.matcher(password).matches()) error = "Password non valida";
	    else if(email.isEmpty() || nome.isEmpty()|| cognome.isEmpty()) error = "Tutti i campi devono essere compilati";
	    else if(db.userDownload(email) != null) { 
	    	if(db.userDownload(email).getEmail().compareTo(email) ==0)
	    		error = "Username già esistente";
	    }
		
		return error;
	}
	 
	/**
	 * Per la crittografia della password.
	 * @param input						stringa in input
	 * @return							stringa criptata
	 * @throws NoSuchAlgorithmException
	 */
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