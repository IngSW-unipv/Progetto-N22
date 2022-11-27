package it.unipv.po.carrello.pagamento;
import java.time.*; 

import it.unipv.po.carrello.pagamento.esterno.CreditCardPaymentStrategy;
import it.unipv.po.carrello.pagamento.esterno.IPaymentStrategy;
import it.unipv.po.carrello.pagamento.esterno.PayPalPaymentStrategy;
import it.unipv.po.carrello.pagamento.esterno.PostePayPaymentStrategy;
import it.unipv.po.carrello.pagamento.esterno.VisaPaymentStrategy;
import it.unipv.po.carrello.pagamento.supporto.CalcolatoreCredito;
import it.unipv.po.carrello.pagamento.supporto.PagamentiM;
import it.unipv.po.carrello.pagamento.supporto.PayStrategyFactory; 



public class Pagamento implements IPagamento{
	private LocalDateTime dataEora;
	private double importo;
	private IPaymentStrategy paymentMethod;
	private CalcolatoreCredito calcolatoreCredito;
	private boolean autorizzato;
	private PayStrategyFactory payStrategyFactory;
	
	/**
	 * Costruttore di Pagamento.
	 * @param costo importo iniziale da pagare
	 */
	public Pagamento(double costo) {
		autorizzato = false;
		dataEora= LocalDateTime.now();
		importo=costo;
		//payStrategySetter(PagamentiM.Creditcard); //settiamo di default questo
		payStrategyFactory = new PayStrategyFactory();
		paymentMethod = payStrategyFactory.createPayStrategy(PagamentiM.Creditcard);
		calcolatoreCredito = new CalcolatoreCredito();
		//qua ci va un pure fabrication che mi crea una classe 
		//che rappresenti il contesto di pagamento
				
	}
	
	@Override
	public void calcolaPrezzoFinale(double credito) {
		importo -= credito;
		
	}
	
//	@Override
//	public void payStrategySetter(PagamentiM metodo) {
//		if (metodo==PagamentiM.Paypal)
//			paymentMethod= new PayPalPaymentStrategy();
//		if (metodo==PagamentiM.Creditcard)
//			paymentMethod= new CreditCardPaymentStrategy();
//		if (metodo==PagamentiM.Postepay)
//			paymentMethod= new PostePayPaymentStrategy();
//		if (metodo==PagamentiM.Visa)
//			paymentMethod= new VisaPaymentStrategy();
//	}
	
	@Override
	public void payStrategySetter(PagamentiM metodo) {
		paymentMethod = payStrategyFactory.createPayStrategy(metodo);
	}
	
	
	
	@Override
	public boolean autorizza(){
			boolean check = paymentMethod.autorizzaRichiesta(importo);
			this.autorizzato = check;
			return check;
	}
	
	@Override
	public double getCreditoOttenuto() {
		return calcolatoreCredito.calcolaCredito(importo);
	}
	
	/**
	 * getter data e ora pagamento
	 * @return restituisce la data e ora pagamento
	 */
	public LocalDateTime getDataEora() {
		return dataEora;
	}

	/**
	 * 
	 * @return restituisce l'importo pagato
	 */
	public double getImporto() {
		return importo;
	}

	/**
	 * 
	 * @return restituisce lo stato di autorizzazione del pagamento
	 */
	public boolean isAutorizzato() {
		return autorizzato;
	}

	

	

}
