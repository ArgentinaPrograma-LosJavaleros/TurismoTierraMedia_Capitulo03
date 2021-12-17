package services;

import java.sql.SQLException;
import java.util.List;

import app.NoExisteTematicaException;
import model.Usuario;
import persistence.commons.CRUD;
import persistence.impl.UsuarioDAOImp;

public class UsuarioService extends UsuarioDAOImp {
	@Override
	public List<Usuario> findAll()  throws SQLException, NoExisteTematicaException{
		return super.findAll();
	}
	
	@Override	
	public int countAll() throws SQLException {
		 return super.countAll();	
	}
	
	@Override	
	public int insert(Usuario t) throws SQLException {
		return super.insert(t);
	}

	@Override
	public int update(Usuario t) throws SQLException {
		return super.update(t);
	}
	
	@Override
	public int delete(Usuario t) throws SQLException {
		return super.delete(t);
	}

	@Override
	public int deleteBy(String campo, String operador, String valor) throws SQLException {
		return super.deleteBy(campo, operador, valor);
	}
	
	@Override
	public Usuario findBy(String campo, String operador, String valor) throws SQLException {
		return super.findBy(campo, operador, valor);
	}

	@Override
	public Usuario findById(int id) throws SQLException {
		return super.findById(id);
	}
	
	@Override
	public List<Usuario> findAllBy(String campo, String operador, String valor)  throws SQLException{
		return super.findAllBy(campo, operador, valor);
	}
	
	@Override
	public int actualizarActivo(Integer id, Integer valor) throws SQLException {
		return super.actualizarActivo(id, valor);
	}
}
