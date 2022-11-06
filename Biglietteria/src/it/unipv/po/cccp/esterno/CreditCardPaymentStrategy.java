package it.unipv.po.cccp.esterno;

import it.unipv.po.ticket.cus.Utente;

public class CreditCardPaymentStrategy implements IPaymentStrategy{

	@Override
	public boolean autorizzaRichiesta(double importo) {
		// TODO Auto-generated method stub
		return true;
	}

}
