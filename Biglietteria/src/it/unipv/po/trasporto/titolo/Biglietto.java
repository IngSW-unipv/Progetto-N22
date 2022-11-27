package it.unipv.po.trasporto.titolo;

import java.sql.SQLException;
import java.time.*; 
import java.util.ArrayList;

import it.unipv.po.connessioneDB.DBwrite;
import it.unipv.po.trasporto.fermata.Fermata;
import it.unipv.po.trasporto.titolo.supporto.CalcolatoreID;
import it.unipv.po.trasporto.titolo.supporto.CalcolatorePrezzo;


/**
 * 
 * @author Giava
 *
 */
public class Biglietto extends Titolo{
	private boolean disponibile;
	private boolean attivo;
	private String passeggero;
	
	//metodi
	
	public Biglietto(ArrayList<Fermata> percorso) throws SQLException {
		setPercorso(percorso);
		this.calcolatoreID = new CalcolatoreID();
		this.calcolatorePrezzo = new CalcolatorePrezzo();
		// per i biglietti avremo nell'id un prefisso 'b'
		String tempID = "b--"+calcolatoreID.calcolaID(percorso);
		setIdTitolo(tempID);
		setPrezzo(calcolatorePrezzo.calcolaPrezzo(percorso));
		disponibile = true;
		attivo = false;
	}
	
	public Biglietto(String idTitolo, Double prezzo, String percorso, boolean disponibile, boolean attivo, String dataAcquisto) {
		this.setIdTitolo(idTitolo);
		this.setPrezzo(prezzo);
		this.setPercorso(percorso);
		this.setDisponibile(disponibile);
		this.setAttivo(attivo);
		this.setDataAcquisto(dataAcquisto);
	}
	
	private void setAttivo(boolean attivo) {
		this.attivo = attivo;
		
	}
	private void setDisponibile(boolean disponibile) {
		this.disponibile = disponibile;
		
	}
	
	@Override
	public void oblitera() throws SQLException {
		
		if(disponibile && !(attivo)) {
			disponibile = false;
			attivo = true;
		}
		DBwrite writer = new DBwrite();
		writer.oblitera(getIdTitolo());
		//start del timer dal server
		// al termine verrÃ  chiamata il metodo scadi() 
	}
	
	@Override
	public void scadi() {
		attivo = false;
		// server rimuove da db le info del titolo
	}

	@Override
	public boolean isAttivo() {
		return attivo;
	}

	@Override
	public boolean isDisponibile() {
		return disponibile;
	}

	@Override
	public String getDataInizio() {
		return "";
	}
	
	@Override
	public int getDurataAbbonamento() {
		return 0;
	}
	
	@Override
	public LocalTime getDurataViaggio(ArrayList<Fermata> percorso) {
		//estraggo le ore e i minuti della prima fermata e dell'ultima e li sottraggo per trovare la differenza
		int ore = percorso.get(percorso.size()-1).getOrario().getHour() - percorso.get(0).getOrario().getHour();
		int minuti = percorso.get(percorso.size()-1).getOrario().getMinute() - percorso.get(0).getOrario().getMinute();
		int tempo = minuti + ore*60;
		
		ore = tempo/60;
		minuti = tempo%60;
		return LocalTime.of(ore, minuti);
	}

	public String getPasseggero() {
		return passeggero;
	}

	public void setPasseggero(String passeggero) {
		this.passeggero = passeggero;
	}
	
}
