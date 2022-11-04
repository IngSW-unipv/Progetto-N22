package it.unipv.po.ticket.trasporto.linea;


import java.util.ArrayList;

import it.unipv.po.ticket.trasporto.dataModel.Tappe;
import it.unipv.po.ticket.trasporto.fermata.Fermata;
import it.unipv.po.ticket.trasporto.vehicleModel.Vehicle;
import it.unipv.po.ticket.trasporto.zonaModel.Zona;

public class Linea implements Tappe{
	
	public ArrayList<Fermata> linea = new ArrayList<>();
	public int linieAttive = 0;
	public String IDlinea;
	public float km;
	public Vehicle mezzo;
	public Zona zona;
	
	public Linea(String iDlinea, float km, Vehicle mezzo, Zona zona) {
		this.IDlinea = iDlinea;
		this.km = km;
		this.mezzo = mezzo;
		this.zona = zona;
	}
	
	public Linea() {
		this.IDlinea = "";
		this.km = 0;
		this.mezzo = null;
		this.zona = null;
	}
	
	//metodi
	
	public ArrayList<Fermata> ricercaFermate(String partenza, String destinazione) {
		ArrayList<Fermata> ricerca = new ArrayList<Fermata>();
		int trovato = 0;
		
		//ciclo per ricercare le fermate da elencare 
		for(Fermata n : linea) {
			
			//quando trovo la fermata di partenza incomincio a salvare le fermate e 
			//metto la variabile trovato a 1 per continuare a scrivere quelle dopo
			if((n.getCodiceFermata().compareTo(partenza) == 0 || trovato == 1)) {
				ricerca.add(n);
				trovato = 1;
			}
			
			//quando trovo la fermata di destinazione posso smettere di salvare le fermate e uscire dal for
			if(n.getCodiceFermata().compareTo(destinazione) == 0 && trovato == 1) break;
		}
		
		return ricerca;
	}
	
	//getter and setter
	
	//stampa dell'intera linea di fermate raccolte nel vettore
	public String getLinea() {
		String msg = "";
		
		for(Fermata n : linea) msg += " Fermata: " + n.getCodiceFermata() + "               " + n.getOrario() + "\n";
		
		
		return msg;
	}

	//crezione dell'elenco di fermate in base alla zona 
	public void addLinea(Fermata fermata) {
		this.linea.add(fermata);
		this.linieAttive += 1;
	}
	
	public void setLinea(ArrayList<Fermata> linea) {
		this.linea = linea;
	}
	
	public int getLinieAttive() {
		return linieAttive;
	}

	public void setLinieAttive(int linieAttive) {
		this.linieAttive = linieAttive;
	}
	
	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	public String getIDlinea() {
		return IDlinea;
	}

	public void setIDlinea(String iDlinea) {
		IDlinea = iDlinea;
	}

	public float getKm() {
		return km;
	}

	public void setKm(float km) {
		this.km = km;
	}

	public Vehicle getMezzo() {
		return mezzo;
	}

	public void setMezzo(Vehicle mezzo) {
		this.mezzo = mezzo;
	}
	
}
