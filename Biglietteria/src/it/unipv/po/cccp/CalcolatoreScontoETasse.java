package it.unipv.po.cccp;

import java.time.LocalDateTime;
import java.time.Month;

public class CalcolatoreScontoETasse implements ICalcolatoreScontoETasse{

	@Override
	public double calcolaSconto(double totale, int punti) {
		
		return (punti/100)*totale;
	}
	
	//ipotizziamo di applicare uno sconto mensile 
	//limitato al mese di agosto per incentivare
	//la mobilità turistica
	@Override
	public double calcolaSconto(double totale, LocalDateTime date) {
		if(date.getMonth()==Month.AUGUST)
			return (40/100)*totale;
		else
		return 0;
	}

}
