package it.unipv.po.cccp.pagamento;
import java.time.*;
//pattern protected variation
//facilita la futura variazione delle regole 
//di sconto
public interface ICalcolatoreSconto {
		public double calcolaSconto(double totale, int punti);

		
}
