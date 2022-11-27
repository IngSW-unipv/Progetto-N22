package it.unipv.po.carrello;

import java.sql.SQLException;
import java.time.LocalDateTime;  
import java.util.List;
import it.unipv.po.carrello.pagamento.Pagamento;
import it.unipv.po.carrello.pagamento.supporto.PagamentiM;
import it.unipv.po.trasporto.titolo.Titolo;


public interface ICarrello {
	/**
	 * aggiunge un nuovo titolo al carrello
	 * @param t titolo da aggiungere
	 */
	public void aggiungiTitolo(Titolo t);
	
	/**
	 * rimuove un titolo dal carrello
	 * @param t titolo da rimuovere 
	 */
	public void rimuoviTitolo(Titolo t);
	
	/**
	 * 
	 * @return	ritorna la lista di titoli nel carrello
	 */
	public List<Titolo> getTitoli();
	
	/**
	 * cancella la lista di titoli nel carrello e lo svuota
	 */
	public void clearAll();
	
	/**
	 * calcola il totale dei prezzi dei titoli
	 * @return	ritorna il totale
	 */
	public double getTotale();
	
	/**
	 * 
	 * @param d		data del pagamento
	 * @param importo	importo pagato
	 * @param creditoUtilizzato	credito usato per pagare l'importo	  
	 * @throws SQLException	dovuta alla scrittura su DataBase			
	 */
	public void aggiornaCronologia(LocalDateTime d, double importo, double creditoUtilizzato) throws SQLException;
	
	/**
	 * 
	 * @param m	metodo di pagamento
	 * @param credito credito da utilizzare
	 * @return ritorna il pagamento
	 * @throws SQLException dovuta al richiamo di aggiorna cronologia
	 */
	public Pagamento chiudeEpaga(PagamentiM m, double credito) throws SQLException;
	
}
