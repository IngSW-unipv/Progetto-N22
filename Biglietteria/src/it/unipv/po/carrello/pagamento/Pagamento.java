package it.unipv.po.carrello.pagamento;
import java.time.*;

import it.unipv.po.carrello.pagamento.esterno.CreditCardPaymentStrategy;
import it.unipv.po.carrello.pagamento.esterno.IPaymentStrategy;
import it.unipv.po.carrello.pagamento.esterno.PayPalPaymentStrategy;
import it.unipv.po.carrello.pagamento.esterno.PostePayPaymentStrategy;
import it.unipv.po.carrello.pagamento.esterno.VisaPaymentStrategy;
import it.unipv.po.carrello.pagamento.supporto.CalcolatorePunti;
import it.unipv.po.carrello.pagamento.supporto.CalcolatoreSconto;
import it.unipv.po.carrello.pagamento.supporto.PagamentiM; 



public class Pagamento implements IPagamento{
	private LocalDateTime dataEora;
	private double importo;
	private double puntiMax;
	private CalcolatoreSconto calcolatoreSconto;
	private IPaymentStrategy paymentMethod;
	private CalcolatorePunti calcolatorePunti;
	private boolean autorizzato;

	public Pagamento(double costo, double puntiMax) {
		autorizzato = false;
		dataEora= LocalDateTime.now();
		importo=costo;
		payStrategySetter(PagamentiM.Creditcard); //settiamo di default questo
		calcolatoreSconto = new CalcolatoreSconto();
		calcolatorePunti = new CalcolatorePunti();
		this.puntiMax=puntiMax;
		//qua ci va un pure fabrication che mi crea una classe 
		//che rappresenti il contesto di pagamento
				
	}
	
	@Override
	public void calcolaPrezzoFinale(double punti) {
		if(punti >= puntiMax)
			punti = puntiMax;
		importo -= calcolatoreSconto.calcolaSconto(importo, punti);
		
	}
	
	@Override
	public void payStrategySetter(PagamentiM metodo) {
		if (metodo==PagamentiM.Paypal)
			paymentMethod= new PayPalPaymentStrategy();
		if (metodo==PagamentiM.Creditcard)
			paymentMethod= new CreditCardPaymentStrategy();
		if (metodo==PagamentiM.Postepay)
			paymentMethod= new PostePayPaymentStrategy();
		if (metodo==PagamentiM.Visa)
			paymentMethod= new VisaPaymentStrategy();
	}
	
	@Override
	public boolean autorizza() throws Exception {
		try {
			boolean check = paymentMethod.autorizzaRichiesta(importo);
			this.autorizzato = check;
			return check;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public double getPuntiOttenuti() {
		return calcolatorePunti.calcolaPunti(importo);
	}

	public LocalDateTime getDataEora() {
		return dataEora;
	}

	public void setDataEora(LocalDateTime dataEora) {
		this.dataEora = dataEora;
	}

	public double getImporto() {
		return importo;
	}

	public void setImporto(double importo) {
		this.importo = importo;
	}

	public boolean isAutorizzato() {
		return autorizzato;
	}

	public void setAutorizzato(boolean autorizzato) {
		this.autorizzato = autorizzato;
	}
	

	

}