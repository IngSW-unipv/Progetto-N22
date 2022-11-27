package it.unipv.po.carrello.pagamento.supporto;

import it.unipv.po.carrello.pagamento.esterno.CreditCardPaymentStrategy;
import it.unipv.po.carrello.pagamento.esterno.IPaymentStrategy;
import it.unipv.po.carrello.pagamento.esterno.PayPalPaymentStrategy;
import it.unipv.po.carrello.pagamento.esterno.PostePayPaymentStrategy;
import it.unipv.po.carrello.pagamento.esterno.VisaPaymentStrategy;

public class PayStrategyFactory {
	
	public IPaymentStrategy createPayStrategy(PagamentiM metodo) {
		IPaymentStrategy paymentMethod = null;
		
		if (metodo==PagamentiM.Paypal)
			paymentMethod= new PayPalPaymentStrategy();
		if (metodo==PagamentiM.Creditcard)
			paymentMethod= new CreditCardPaymentStrategy();
		if (metodo==PagamentiM.Postepay)
			paymentMethod= new PostePayPaymentStrategy();
		if (metodo==PagamentiM.Visa)
			paymentMethod= new VisaPaymentStrategy();
		
		return paymentMethod;
	}
}
