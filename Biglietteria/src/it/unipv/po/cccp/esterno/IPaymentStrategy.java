package it.unipv.po.cccp.esterno;

import it.unipv.po.ticket.cus.Utente;

public interface IPaymentStrategy {

	boolean autorizzaRichiesta(double importo) throws Exception;

}
