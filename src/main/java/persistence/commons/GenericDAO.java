package persistence.commons;

import java.sql.SQLException;
import java.util.List;

import app.NoExisteTematicaException;

public interface GenericDAO<T> {

	public List<T> findAll() throws SQLException, NoExisteTematicaException;
	
	public int countAll() throws SQLException;
	
	public int insert(T t) throws SQLException;
	
	public int update(T t) throws SQLException;
	
	public int delete(T t) throws SQLException;
	
	public int deleteBy(String campo, String tipo, String valor) throws SQLException;
	
	public T findBy (String campo, String operador, String valor) throws SQLException;
	
	public List<T> findAllBy (String campo, String operador, String valor) throws SQLException;

	public T findById (int id) throws SQLException;
	
}
