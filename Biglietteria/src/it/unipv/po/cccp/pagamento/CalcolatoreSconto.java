package it.unipv.po.cccp.pagamento;

import java.time.LocalDateTime;
import java.time.Month;

public class CalcolatoreSconto implements ICalcolatoreSconto{

	@Override
	public double calcolaSconto(double totale, int punti) {
		
		return (punti/100)*totale;
	}
	

}
