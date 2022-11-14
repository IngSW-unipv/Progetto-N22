package it.unipv.po.ticket.trasporto.dataModel;

import java.time.LocalTime;
import java.util.ArrayList;

import it.unipv.po.ticket.trasporto.fermata.Fermata;

public interface Tappe {
	public ArrayList<Fermata> ricercaFermate(String partenza, String destinazione, LocalTime orario);
}
