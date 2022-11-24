package it.unipv.po.carrello.pagamento.supporto;

public class CalcolatoreCredito {
	
	
	public double calcolaCredito(double importoFinale) {
		double credito=0;
		credito = importoFinale/15;
		return credito;
	}
}
