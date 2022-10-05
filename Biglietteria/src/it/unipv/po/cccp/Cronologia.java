package it.unipv.po.cccp;
import java.util.List;
import it.unipv.po.ticket.titolo.*;

import it.unipv.po.ticket.cus.Utente;

public class Cronologia implements ICronologia{
	Utente u;
	List<Titolo> cronoList;
	
	@Override
	public void cancella() {
		cronoList.clear();
	}

	@Override
	public void aggiungiCarrello(List<Titolo> l) {
		for(int i=0;i<l.size();i++)
		cronoList.add(l.get(i));
		
	}

	@Override
	public void rimuoviCarrello(Titolo t) {
		cronoList.remove(t);
		
	}
	
}
