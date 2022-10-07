package it.unipv.po.ticket.cus;

public class Sessione implements ISessione {
	private String IDsessione;
	//dobbiamo vedere come generare automaticamente questi IDsessione
	//io personalmente vedo la sessione come il primo accesso
	//all'applicativo (magari memorizza IP e data&ora dell'accesso)
	//anche se sei sloggato stai in una sessione

	@Override
	public boolean login() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean register() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getIDsessione() {
		return IDsessione;
	}

	public void setIDsessione(String iDsessione) {
		IDsessione = iDsessione;
	}

}
