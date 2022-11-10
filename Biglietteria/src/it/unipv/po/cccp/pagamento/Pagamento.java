package it.unipv.po.cccp.pagamento;
import java.time.*;

import it.unipv.po.cccp.Carrello;
import it.unipv.po.cccp.esterno.CreditCardPaymentStrategy;
import it.unipv.po.cccp.esterno.IPaymentStrategy;
import it.unipv.po.cccp.esterno.PayPalPaymentStrategy;
import it.unipv.po.cccp.esterno.PostePayPaymentStrategy;
import it.unipv.po.cccp.esterno.VisaPaymentStrategy;
import it.unipv.po.ticket.gui.utente.Utente;

public class Pagamento implements IPagamento{
	private LocalDateTime dataEora;
	private double importo;
	private double puntiMax;
	private CalcolatoreSconto calcolatoreSconto;
	private IPaymentStrategy paymentMethod;
	private CalcolatorePunti calcolatorePunti;
	
	
	

	

	public Pagamento(double costo, double puntiMax) {
		dataEora= LocalDateTime.now();
		importo=costo;
		payStrategySetter(PagamentiM.creditcard); //settiamo di default questo
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
		if (metodo==PagamentiM.paypal)
			paymentMethod= new PayPalPaymentStrategy();
		if (metodo==PagamentiM.creditcard)
			paymentMethod= new CreditCardPaymentStrategy();
		if (metodo==PagamentiM.postepay)
			paymentMethod= new PostePayPaymentStrategy();
		if (metodo==PagamentiM.visa)
			paymentMethod= new VisaPaymentStrategy();
	}
	
	@Override
	public void autorizza() throws Exception {
		try {
			paymentMethod.autorizzaRichiesta(importo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	

	

}
