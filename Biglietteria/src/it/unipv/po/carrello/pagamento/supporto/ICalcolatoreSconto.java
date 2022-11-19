package it.unipv.po.carrello.pagamento.supporto;

//pattern protected variation
//facilita la futura variazione delle regole 
//di sconto
public interface ICalcolatoreSconto {
		public double calcolaSconto(double totale, double punti);

		
}
