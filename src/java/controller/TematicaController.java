package controller;

import java.sql.SQLException;
import java.util.List;

import app.NoExisteTematicaException;
import dao.TematicaDAOImp;
import model.Tematica;

public class TematicaController extends TematicaDAOImp {
	@Override
	public List<Tematica> findAll()  throws SQLException, NoExisteTematicaException{
		return super.findAll();
	}
	
	@Override	
	public int countAll() throws SQLException {
		 return super.countAll();	
	}
	
	@Override	
	public int insert(Tematica t) throws SQLException {
		return super.insert(t);
	}

	@Override
	public int update(Tematica t) throws SQLException {
		return super.update(t);
	}

	@Override
	public int delete(Tematica t) throws SQLException {
		return super.delete(t);
	}

	@Override
	public int deleteBy(String campo, String operador, String valor) throws SQLException {
		return super.deleteBy(campo, operador, valor);
	}
	
	@Override
	public Tematica findBy(String campo, String operador, String valor) throws SQLException {
		return super.findBy(campo, operador, valor);
	}

	@Override
	public Tematica findById(int id) throws SQLException {
		return super.findById(id);
	}
	
	@Override
	public List<Tematica> findAllBy(String campo, String operador, String valor)  throws SQLException{
		return super.findAllBy(campo, operador, valor);
	}
}
