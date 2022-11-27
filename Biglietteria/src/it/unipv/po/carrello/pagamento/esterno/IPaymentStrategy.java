package it.unipv.po.carrello.pagamento.esterno;


public interface IPaymentStrategy {
	
	/**
	 * la strategia di pagamento autorizza la richiesta di pagamento
	 * @param importo cifra da autorizzare
	 * @return restituisce il valore booleano true se autorizzato, false altrimenti
	 */
	boolean autorizzaRichiesta(double importo);

}
