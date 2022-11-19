package it.unipv.po.carrello;

import java.time.LocalDateTime;  
import java.util.List;
import it.unipv.po.carrello.pagamento.Pagamento;
import it.unipv.po.carrello.pagamento.supporto.PagamentiM;
import it.unipv.po.trasporto.titolo.Titolo;


public interface ICarrello {
	public void aggiungiTitolo(Titolo t);
	public void rimuoviTitolo(Titolo t);
	public List<Titolo> getTitoli();
	public void clearAll();
	public double getTotale();
	public void aggiornaCronologia(LocalDateTime d, double importo, double puntiUtilizzati) throws Exception;
	void incrementaTotale(Titolo t);
	void decrementaTotale(Titolo t);
	Pagamento chiudeEpaga(PagamentiM m, double punti) throws Exception;
	
}
