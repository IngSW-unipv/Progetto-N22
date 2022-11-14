package it.unipv.po.ticket.supporto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import it.unipv.po.ticket.trasporto.fermata.Fermata;
import it.unipv.po.ticket.trasporto.linea.Linea;

public interface IDBconnectionStrategy {
	public Connection getDBConnection() throws Exception;
}
