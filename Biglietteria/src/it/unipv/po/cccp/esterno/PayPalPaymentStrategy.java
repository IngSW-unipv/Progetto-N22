package it.unipv.po.cccp.esterno;

import it.unipv.po.ticket.gui.utente.Utente;

public class PayPalPaymentStrategy implements IPaymentStrategy{

	@Override
	public boolean autorizzaRichiesta(double importo) {
		// TODO Auto-generated method stub
		return true;
	}

}
