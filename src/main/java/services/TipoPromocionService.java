package services;

import java.sql.SQLException;
import java.util.List;

import model.TipoPromocion;
import persistence.impl.TipoPromocionDAOImp;

public class TipoPromocionService extends TipoPromocionDAOImp {
	@Override
	public List<TipoPromocion> findAll()  throws SQLException {
		return super.findAll();
	}
	
	@Override	
	public int countAll() throws SQLException {
		 return super.countAll();	
	}
	
	@Override	
	public int insert(TipoPromocion t) throws SQLException {
		return super.insert(t);
	}

	@Override
	public int update(TipoPromocion t) throws SQLException {
		return super.update(t);
	}

	@Override
	public int delete(TipoPromocion t) throws SQLException {
		return super.delete(t);
	}

	@Override
	public int deleteBy(String campo, String operador, String valor) throws SQLException {
		return super.deleteBy(campo, operador, valor);
	}
	
	@Override
	public TipoPromocion findBy(String campo, String operador, String valor) throws SQLException {
		return super.findBy(campo, operador, valor);
	}

	@Override
	public TipoPromocion findById(int id) throws SQLException {
		return super.findById(id);
	}
	@Override
	public List<TipoPromocion> findAllBy(String campo, String operador, String valor)  throws SQLException{
		return super.findAllBy(campo, operador, valor);
	}
}
