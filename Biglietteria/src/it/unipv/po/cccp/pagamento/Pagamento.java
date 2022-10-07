package it.unipv.po.cccp.pagamento;
import java.time.*;

public class Pagamento implements IPagamento{
	private LocalDateTime dataEora;
	private double importo;
	private PagamentiM metodo;
	

	

	public Pagamento(double costo, PagamentiM metodo) {
		dataEora= LocalDateTime.now();
		importo=costo;
		this.metodo=metodo;
		//qua ci va un pure fabrication che mi crea una classe 
		//che rappresenti il contesto di pagamento
		
		
	}
	@Override
	public void autorizza() {
		
	}

	

}
