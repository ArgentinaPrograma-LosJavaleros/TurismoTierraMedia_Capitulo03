package persistence.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.NoExisteTematicaException;
import model.Usuario;
import persistence.UsuarioDAO;
import persistence.commons.CRUD;

public class UsuarioDAOImp implements UsuarioDAO {
	
	TematicaDAOImp tematica = new TematicaDAOImp();

	@Override
	 public List<Usuario> findAll()  throws SQLException, NoExisteTematicaException{
		
		return findAllBy("", "", "");
	}

	@Override
	public int countAll() throws SQLException {
		Integer contar = 0; 
				
		ResultSet rs = CRUD.select("usuarios", "count(*)", "");
		
		contar = rs.getInt(1);
		
		return contar;
	}

	@Override
	public int insert(Usuario t) throws SQLException {
		
		List<String> columnas= new ArrayList<String> ();
		List<String> tipos= new ArrayList<String> (); 
		List<String> values= new ArrayList<String> (); 
		
		columnas.add("nombre");
		columnas.add("pass");
		columnas.add("monedas");
		columnas.add("tiempo");
		columnas.add("id_tematica");
		columnas.add("isAdmin");
		columnas.add("activo");
		
		tipos.add("String");
		tipos.add("String");
		tipos.add("Int");
		tipos.add("Double");
		tipos.add("Int");
		tipos.add("Int");
		tipos.add("Int");
		
		values.add(t.getNombre());
		values.add(t.getPass());
		values.add(t.getCantidadMonedas().toString());
		values.add(t.getTiempoDisponible().toString());
		values.add(t.getPreferencia().getId().toString());

		if (t.getIsAdmin())
			values.add(String.valueOf(1));
		else
			values.add(String.valueOf(0));
		
		if (t.getActivo())
			values.add(String.valueOf(1));
		else
			values.add(String.valueOf(0));
				
		return CRUD.insert("usuarios", columnas, tipos, values);
	}

	@Override
	public int update(Usuario t) throws SQLException {
		String condicion = " where id_usuario = " + t.getId();
		List<String> columnas= new ArrayList<String> ();
		List<String> tipos= new ArrayList<String> (); 
		List<String> values= new ArrayList<String> (); 
		
		columnas.add("id_usuario");
		columnas.add("nombre");
		columnas.add("monedas");
		columnas.add("tiempo");
		columnas.add("id_tematica");
		columnas.add("pass");
		columnas.add("isAdmin");
		columnas.add("activo");
		
		tipos.add("Int");
		tipos.add("String");
		tipos.add("Int");
		tipos.add("Double");
		tipos.add("Int");
		tipos.add("String");
		tipos.add("Int");
		tipos.add("Int");
		
		values.add(t.getId().toString());
		values.add(t.getNombre());
		values.add(t.getCantidadMonedas().toString());
		values.add(t.getTiempoDisponible().toString());
		values.add(t.getPreferencia().getId().toString());
		values.add(t.getPass());
		if (t.getIsAdmin())
			values.add(String.valueOf(1));
		else
			values.add(String.valueOf(0));
		
		if (t.getActivo())
			values.add(String.valueOf(1));
		else
			values.add(String.valueOf(0));
		
				
		return CRUD.update("usuarios", columnas, tipos, values, condicion);
	}

	@Override
	public int delete(Usuario t) throws SQLException {
		return CRUD.delete("usuarios", "id_usuario", t.getId().toString(), "int");
	}

	@Override
	public int deleteBy(String campo, String operador, String valor) throws SQLException {
		return delete(findBy(campo, operador, valor));
	}

	@Override
	public Usuario findBy(String campo, String operador, String valor) throws SQLException {
		String condicion = campo + " " + operador + " " + valor;
		Usuario usuario = new Usuario("No existe");
		ResultSet rs = CRUD.select("usuarios", "*", condicion);
		if(rs.next()) {
			usuario.setId(rs.getInt("id_usuario"));
			usuario.setNombre(rs.getString("nombre"));
			usuario.setPass(rs.getString("pass"));
			usuario.setCantidadMonedas(rs.getInt("monedas"));
			usuario.setTiempoDisponible(rs.getDouble("tiempo"));
			usuario.setPreferencia(tematica.findById(rs.getInt("id_tematica")));
			usuario.setIsAdmin(rs.getBoolean("isAdmin"));
			usuario.setActivo(rs.getBoolean("activo"));
		}
		return usuario;
	}

	@Override
	public Usuario findById(int id) throws SQLException {
		return this.findBy("id_usuario", "=", String.valueOf(id));
	}

	@Override
	public List<Usuario> findAllBy(String campo, String operador, String valor) throws SQLException {
		List<Usuario> listaDeUsuarios = new ArrayList<Usuario>();
		String condicion = "";
		
		if(!campo.equals("") && !operador.equals("") && !valor.equals("")) 
			condicion = campo + " " + operador + " " + valor;
		
		ResultSet rs = CRUD.select("usuarios", "*", condicion);
		
		while (rs.next())
			listaDeUsuarios.add(new Usuario(rs.getInt("id_usuario"), 
										rs.getString("nombre"),
										rs.getString("pass"),
										rs.getInt("monedas"),
										rs.getDouble("tiempo"),
										tematica.findById(rs.getInt("id_tematica")),
										rs.getBoolean("isAdmin"),
										rs.getBoolean("activo")));		
		
		return listaDeUsuarios;
	}
	
	public int actualizarActivo(Integer id, Integer valor) throws SQLException {
		return CRUD.actualizarActivo("usuarios", valor, "id_usuario", id);
	}
	
}
