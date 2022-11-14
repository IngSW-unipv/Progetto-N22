package it.unipv.po.ticket.trasporto.ricerca;

import java.time.LocalTime;
import java.util.ArrayList;
import it.unipv.po.ticket.trasporto.fermata.Fermata;

public interface InterfaceRicercaStrategy {
	public ArrayList<Fermata> cerca(String a, String b, LocalTime orario) throws Exception;
	public String stampaRicerca(ArrayList<Fermata> ricerca);
}
