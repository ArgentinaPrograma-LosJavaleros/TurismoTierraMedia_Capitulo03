package services;

import java.sql.SQLException;
import java.util.List;

import app.NoExisteTematicaException;
import model.Atraccion;
import persistence.impl.AtraccionDAOImp;

public class AtraccionService extends AtraccionDAOImp {
	@Override
	public List<Atraccion> findAll()  throws SQLException, NoExisteTematicaException{
		return super.findAll();
	}
	
	@Override	
	public int countAll() throws SQLException {
		 return super.countAll();	
	}
	
	@Override	
	public int insert(Atraccion t) throws SQLException {
		return super.insert(t);
	}

	@Override
	public int update(Atraccion t) throws SQLException {
		return super.update(t);
	}

	@Override
	public int delete(Atraccion t) throws SQLException {
		return super.delete(t);
	}

	@Override
	public int deleteBy(String campo, String operador, String valor) throws SQLException {
		return super.deleteBy(campo, operador, valor);
	}
	
	@Override
	public Atraccion findBy(String campo, String operador, String valor) throws SQLException {
		return super.findBy(campo, operador, valor);
	}

	@Override
	public Atraccion findById(int id) throws SQLException {
		return super.findById(id);
	}
	
	@Override
	public List<Atraccion> findAllBy(String campo, String operador, String valor)  throws SQLException{
		return super.findAllBy(campo, operador, valor);
	}
	
}
