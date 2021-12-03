package services;

import java.sql.SQLException;
import java.util.List;

import app.NoExisteTematicaException;
import model.Promocion;
import persistence.impl.PromocionDAOImp;

public class PromocionService extends PromocionDAOImp {
	@Override
	public List<Promocion> findAll()  throws SQLException, NoExisteTematicaException{
		return super.findAll();
	}
	
	@Override	
	public int countAll() throws SQLException {
		 return super.countAll();	
	}
	
	@Override	
	public int insert(Promocion t) throws SQLException {
		return super.insert(t);
	}

	@Override
	public int update(Promocion t) throws SQLException {
		return super.update(t);
	}

	@Override
	public int delete(Promocion t) throws SQLException {
		return super.delete(t);
	}

	@Override
	public int deleteBy(String campo, String operador, String valor) throws SQLException {
		return super.deleteBy(campo, operador, valor);
	}
	
	@Override
	public Promocion findBy(String campo, String operador, String valor) throws SQLException {
		return super.findBy(campo, operador, valor);
	}

	@Override
	public Promocion findById(int id) throws SQLException {
		return super.findById(id);
	}
	
	@Override
	public List<Promocion> findAllBy(String campo, String operador, String valor)  throws SQLException{
		return super.findAllBy(campo, operador, valor);
	}
}
