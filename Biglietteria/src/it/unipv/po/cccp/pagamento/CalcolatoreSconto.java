package it.unipv.po.cccp.pagamento;



public class CalcolatoreSconto implements ICalcolatoreSconto{

	@Override
	public double calcolaSconto(double totale, double punti) {
		
		return (punti/100)*totale;
	}
	

}
