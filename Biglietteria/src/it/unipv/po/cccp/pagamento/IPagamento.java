package it.unipv.po.cccp.pagamento;

public interface IPagamento {
	
	public boolean autorizza() throws Exception;

	void payStrategySetter(PagamentiM metodo);

	void calcolaPrezzoFinale(double punti);
	
	
	
}
