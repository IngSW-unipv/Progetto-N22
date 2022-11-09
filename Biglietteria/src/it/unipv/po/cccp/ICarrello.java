package it.unipv.po.cccp;
import java.time.LocalDateTime; 
import java.util.List;
import it.unipv.po.ticket.titolo.*;
import it.unipv.po.cccp.pagamento.PagamentiM;
import it.unipv.po.ticket.titolo.Titolo;

public interface ICarrello {
	public void aggiungiTitolo(Titolo t);
	public void rimuoviTitolo(Titolo t);
	public List<Titolo> getTitoli();
	public void clearAll();
	public double getTotale();
	public void aggiornaCronologia(LocalDateTime d, double importo) throws Exception;
	void incrementaTotale(Titolo t);
	void decrementaTotale(Titolo t);
	void chiudeEpaga(PagamentiM m, double punti) throws Exception;
	
}
