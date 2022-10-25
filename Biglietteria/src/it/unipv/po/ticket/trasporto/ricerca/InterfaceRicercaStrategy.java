package it.unipv.po.ticket.trasporto.ricerca;

import java.util.ArrayList;
import it.unipv.po.ticket.trasporto.fermata.Fermata;

public interface InterfaceRicercaStrategy {
	public ArrayList<Fermata> cerca(String a, String b) throws Exception;
	public String getPercorsi();
	public void setPercorsi() throws Exception;
	public String getPercorso(int n);
	public String[] getLinee();
}
