package it.unipv.po.connessioneDB;

import java.sql.Connection; 



public interface IDBconnectionStrategy {
	public Connection getDBConnection() throws Exception;
}
