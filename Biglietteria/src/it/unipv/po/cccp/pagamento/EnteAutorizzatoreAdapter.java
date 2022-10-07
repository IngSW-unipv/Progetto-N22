package it.unipv.po.cccp.pagamento;

import it.unipv.po.cccp.esterno.EnteBancario;

public class EnteAutorizzatoreAdapter implements EnteAutorizzatore{
	EnteBancario enteBancario;
	
	public EnteAutorizzatoreAdapter(EnteBancario enteBancario) {
		this.enteBancario=enteBancario;
	}
	
	@Override
	public boolean autorizzaRichiesta() {
		return enteBancario.autorizzaRichiesta();
		
	}

}
