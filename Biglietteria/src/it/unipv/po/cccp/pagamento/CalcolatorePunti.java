package it.unipv.po.cccp.pagamento;

public class CalcolatorePunti implements ICalcolatorePunti {
	
	
	
	@Override
	public double calcolaPunti(double importoFinale) {
		double punti=0;
		punti = importoFinale/35;
		return punti;
	}
}
