package it.unipv.po.carrello.pagamento;

import it.unipv.po.carrello.pagamento.supporto.PagamentiM;

public interface IPagamento {
	
	/**
	 * metodo per l'autorizzazione del pagamento.
	 * Delega l'autorizzazione alle strategie di pagamento.
	 * @return restituisce il valore booleano di autorizzato: true / non autorizzato: false
	 */
	public boolean autorizza();
	
	/**
	 * imposta la strategia di pagamento in base all' enumeration PagamentiM.
	 * @param metodo enumeration di tipologie di pagamento
	 */
	void payStrategySetter(PagamentiM metodo);
	
	/**
	 * sottrae il credito utilizzato dall'utente per il pagamento dall'importo da pagare.
	 * @param credito credito da sottrarre
	 */
	void calcolaPrezzoFinale(double credito);

	double getCreditoOttenuto();
	
	
	
}
