package it.unipv.po.trasporto.fermata;

import java.sql.SQLException;
import java.time.LocalTime;

import it.unipv.po.connessioneDB.DBread;
import it.unipv.po.trasporto.vehicleModel.Vehicle; 


public class Fermata {
	
	private String CodiceFermata;
	private boolean snodo;
	private LocalTime orario;
	private String CodiceLinea;
	private Vehicle mezzo;
	
	/**
	 * Costruttore di Fermata completo (utilizzato in ricerca).
	 * @param codiceFermata
	 * @param snodo			valore booleano che serve a riconoscere se la fermata è uno snodo (incrocia più linee)
	 * @param orario		orario di passaggio della corsa
	 * @param codiceLinea	codice della linea a cui appartiene la fermata
	 * @param mezzo			mezzo della corsa
	 */
	public Fermata(String codiceFermata, boolean snodo, LocalTime orario, String codiceLinea, Vehicle mezzo) {
		CodiceFermata = codiceFermata;
		this.snodo = snodo;
		this.orario = orario;
		CodiceLinea = codiceLinea;
		this.mezzo = mezzo;
	}
	 
	/**
	 * Usiamo questo costruttore per il ricaricamento dell'array di fermate (in forma non verbosa)
	 * in Biglietto.
	 * @param codiceFermata	
	 * @param orario		orario di passaggio della corsa
	 */
	public Fermata(String codiceFermata, LocalTime orario) {
		this.CodiceFermata = codiceFermata;
		this.orario = orario;
		this.snodo = false;
		this.CodiceLinea = "";
		this.mezzo = null;
	}
	
	/**
	 * Costruttore basico  che richiede il set degli attributi attraverso i setter della classe.
	 * Utilizzato in AccessDBreadStrategy.getFermate().
	 */
	public Fermata() {
		this.orario = null;
		this.snodo = false;
		this.CodiceFermata = "";
		this.CodiceLinea = "";
		this.mezzo = null;
	}
	
	//getter e setter
	public String getCodiceFermata() {
		return CodiceFermata;
	}

	public void setCodiceFermata(String codiceFermata) {
		CodiceFermata = codiceFermata;
	}
	
	public LocalTime getOrario() {
		return orario;
	}
	
	public void setOrario(LocalTime orario) {
		this.orario = orario;
	}
	
	public void setSnodo(boolean snodo) {
		this.snodo = snodo;
	}

	public String getCodiceLinea() {
		return CodiceLinea;
	}

	public void setCodiceLinea(String codiceLinea) {
		CodiceLinea = codiceLinea;
	}

	public Vehicle getMezzo() {
		return mezzo;
	}

	public void setMezzo(Vehicle mezzo) {
		this.mezzo = mezzo;
	}

	public boolean isSnodo() {
		return snodo;
	}

	@Override
	public String toString() {
		return "Fermata [CodiceFermata=" + CodiceFermata + ", snodo=" + snodo + ", orario=" + orario + ", CodiceLinea="
				+ CodiceLinea + ", mezzo=" + mezzo + "]";
	}
	
	/**
	 * Ottiene la tariffa del mezzo che passa per la fermata.
	 * @return				tariffa del mezzo
	 * @throws SQLException	dovuta alla lettura della tariffa dal dataBase
	 */
	public double getTariffaMezzo() throws SQLException {
		DBread reader = new DBread();
		return reader.searchTariffaMezzo(mezzo);
	}

	
	
}
