package it.unipv.po.ticket.cus;

public class Utente implements IUtente {
	
	String username;
	String password;
	String nome;
	String cognome;
	String eMail;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	
	
	
	
	
	//questi metodi (registrazione e login ) penso stiano meglio in sessione,
	//quando approfondiremo la classe sessione dovremo
	//occuparci della gestione dei metodi qui commentati !!!
	/*
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
	*/

}
