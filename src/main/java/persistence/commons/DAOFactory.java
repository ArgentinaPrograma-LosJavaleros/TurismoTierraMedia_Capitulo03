package persistence.commons;

import persistence.AtraccionDAO;
import persistence.impl.AtraccionDAOImp;

public class DAOFactory {
	
	public static AtraccionDAO getDAOAtraccion() {
		return new AtraccionDAOImp();
	}
}
