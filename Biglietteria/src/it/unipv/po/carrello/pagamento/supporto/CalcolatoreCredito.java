package it.unipv.po.carrello.pagamento.supporto;

public class CalcolatoreCredito {
	
	/**
	 * calcola il credito ottenuto in seguito all'acquisto del valore di importoFinale.
	 * @param importoFinale importo pagato
	 * @return il credito ottenuto
	 */
	public double calcolaCredito(double importoFinale) {
		double credito=0;
		credito = importoFinale/15;
		return credito;
	}
}
