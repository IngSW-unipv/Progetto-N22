package it.unipv.po.cccp.esterno;

import it.unipv.po.ticket.gui.utente.Utente;

public interface IPaymentStrategy {

	boolean autorizzaRichiesta(double importo) throws Exception;

}
