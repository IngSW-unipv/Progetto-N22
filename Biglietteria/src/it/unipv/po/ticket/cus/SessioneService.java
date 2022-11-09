package it.unipv.po.ticket.cus;

import it.unipv.po.ticket.supporto.DBread;
import it.unipv.po.ticket.supporto.DBwrite;

public class SessioneService implements ISessioneService{
	private DBread reader;
	private DBwrite writer;
	
	public SessioneService() {
		reader=new DBread();
	}
	

	

}
