package it.unipv.po.carrello.pagamento.supporto;

public class CalcolatorePunti implements ICalcolatorePunti {
	
	
	
	@Override
	public double calcolaPunti(double importoFinale) {
		double punti=0;
		punti = importoFinale/35;
		return punti;
	}
}
