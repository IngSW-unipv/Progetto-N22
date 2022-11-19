package it.unipv.po.carrello.pagamento.esterno;


public class CreditCardPaymentStrategy implements IPaymentStrategy{

	@Override
	public boolean autorizzaRichiesta(double importo) {
		// TODO Auto-generated method stub
		return true;
	}

}
