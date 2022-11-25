package it.unipv.po.carrello.pagamento.esterno;


public interface IPaymentStrategy {

	boolean autorizzaRichiesta(double importo);

}
