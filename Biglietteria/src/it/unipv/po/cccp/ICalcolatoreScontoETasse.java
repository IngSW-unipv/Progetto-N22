package it.unipv.po.cccp;
import java.time.*;
//pattern protected variation
//facilita la futura variazione delle regole 
//di sconto
public interface ICalcolatoreScontoETasse {
		public double calcolaSconto(double totale, int punti);
		public double calcolaSconto(double totale,LocalDateTime date);
		//public double calcolaScontoCategorie(Categoria persona...);
		//public double calcolaTasse(double iva);
}
