package it.unipv.po.carrello.pagamento;

import it.unipv.po.carrello.pagamento.supporto.PagamentiM;

public interface IPagamento {
	
	public boolean autorizza() throws Exception;

	void payStrategySetter(PagamentiM metodo);

	void calcolaPrezzoFinale(double punti);
	
	
	
}
