package it.unipv.po.cccp;
import java.time.*;

public class Pagamento implements IPagamento{
	private LocalDateTime dataEora;
	private double importo;
	

	public Pagamento(double costo) {
		dataEora= LocalDateTime.now();
		importo=costo;
		
	}
	@Override
	public boolean checkPagamento(PagamentiM p) {
		
		//check dei dati inseriti e connessione coi servizi di pagamento
		//non gestiti/simulati per semplicità
		return true;
	}
	

}
