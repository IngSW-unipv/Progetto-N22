package it.unipv.po.carrello.pagamento.supporto;



public class CalcolatoreSconto implements ICalcolatoreSconto{

	@Override
	public double calcolaSconto(double totale, double punti) {
		
		return (punti/100)*totale;
	}
	

}
