package it.unipv.po.ticket.cus;

public class Utente implements IUtente {
	
	String nome;
	String cognome;
	String eMail;
	String idUtente;
	String password;
	
	@Override
	public void registrazione(String nome, String cognome, String eMail, String userName, String password) {
		this.nome=nome;
		this.cognome=cognome;
		eMailCheck(eMail);
		this.eMail=eMail;
		idUtenteCheck(userName);
		idUtente=userName;
		this.password=password;
		
		
	}

	@Override
	public void login(String us_em, String password) {
		
		
	}
	
	private void eMailCheck (String em) {
		
	}
	
	private void idUtenteCheck (String un) {
		
	}
	
	private void us_emCheck (String ue) {
		
	}
	

}
