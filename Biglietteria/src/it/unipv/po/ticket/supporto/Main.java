package it.unipv.po.ticket.supporto;

import org.apache.commons.lang3.math.NumberUtils;

import it.unipv.po.ticket.trasporto.corsa.Corsa;
import it.unipv.po.ticket.trasporto.linea.Linea;

public class Main {

	public static void main(String[] args) throws Exception {
		
		//------------------------------- parte di Alessandro -------------------------------------------
		//dichiarazione delle linee esistenti
		Linea prova1 = DBconnection.getLinee(1);
		Linea prova2 = DBconnection.getLinee(2);
		Linea prova3 = DBconnection.getLinee(3);
		Linea prova4 = DBconnection.getLinee(4);
		Linea prova5 = DBconnection.getLinee(5);
		Linea prova6 = DBconnection.getLinee(6);
        
        Corsa corsa = new Corsa();
        
        corsa.setCorsa(prova1);
        corsa.setCorsa(prova2);
        corsa.setCorsa(prova3);
        corsa.setCorsa(prova4);
        corsa.setCorsa(prova5);
        corsa.setCorsa(prova6);
        
        
        String partenza = "F004";
        String  destinazione = "F067";
        
        //System.out.println(corsa.cerca(partenza, destinazione));
        
        String str = corsa.cerca(partenza, destinazione);
        
        System.out.println(str +"\n");
        
        System.out.println(str.length());
        
        int i = 0;
        int conta = 0;
        while(i < str.length()) {
        	
        	if(str.charAt(i) == 'F' && NumberUtils.isDigits((String) str.subSequence(i+1, i+4))) conta++;
        	
        	i++;
        }
        
        System.out.println(conta);
   
        
        //----------------------------------------------------------------------------------------------------
             
	}

}
