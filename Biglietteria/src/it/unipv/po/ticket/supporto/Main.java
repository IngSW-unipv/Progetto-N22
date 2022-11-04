package it.unipv.po.ticket.supporto;

import java.util.ArrayList;
import it.unipv.po.ticket.trasporto.fermata.Fermata;
import it.unipv.po.ticket.trasporto.ricerca.Ricerca;

public class Main {

	public static void main(String[] args) throws Exception {
		
		//------------------------------- parte di Alessandro -------------------------------------------
	
		Ricerca corsa = new Ricerca();
        
        String partenza = "F001";
        String  destinazione = "F022";
        
        ArrayList<Fermata> elenco = corsa.cerca(partenza, destinazione);
        
        for(Fermata n : elenco) System.out.println(n.CodiceFermata);
 
        //----------------------------------------------------------------------------------------------------
             
	}

}
