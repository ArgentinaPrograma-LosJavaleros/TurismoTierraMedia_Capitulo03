package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.NoExisteTematicaException;
import model.Atraccion;

public class AtraccionDAOImp implements AtraccionDAO {
	
	TematicaDAOImp tematica = new TematicaDAOImp();

	@Override
	 public List<Atraccion> findAll()  throws SQLException, NoExisteTematicaException{
		
		
		return findAllBy("", "", "");
	}

	@Override
	public int countAll() throws SQLException {
		Integer contar=0; 
				
		ResultSet rs= CRUD.select("atracciones", "count(*)", "");
		
		contar=rs.getInt(1);
		
		return contar;
	}

	@Override
	public int insert(Atraccion t) throws SQLException {
		
		List<String> columnas= new ArrayList <String> ();
		List<String> tipos= new ArrayList <String> (); 
		List<String> values= new ArrayList <String> (); 
		
		columnas.add("nombre");
		columnas.add("cupos");
		columnas.add("tiempo");
		columnas.add("costo");
		columnas.add("id_tematica");
		
		tipos.add("String");
		tipos.add("Int");
		tipos.add("Double");
		tipos.add("Int");
		tipos.add("Int");
		
		values.add(t.getNombre());
		values.add(t.getCupoUsuarios().toString());
		values.add(t.getTiempo().toString());
		values.add(t.getCosto().toString());
		values.add(t.getTematica().getId().toString());
				
		return CRUD.insert("atracciones", columnas, tipos, values);
	}

	@Override
	public int update(Atraccion t) throws SQLException {
		String condicion = " where id_atraccion = " + t.getId();
		List<String> columnas= new ArrayList<String> ();
		List<String> tipos= new ArrayList<String> (); 
		List<String> values= new ArrayList<String> (); 
		
		columnas.add("id_atraccion");
		columnas.add("nombre");
		columnas.add("cupos");
		columnas.add("tiempo");
		columnas.add("costo");
		columnas.add("id_tematica");
		
		tipos.add("Int");
		tipos.add("String");
		tipos.add("Int");
		tipos.add("Double");
		tipos.add("Int");
		tipos.add("Int");
		
		values.add(t.getId().toString());
		values.add(t.getNombre());
		values.add(t.getCupoUsuarios().toString());
		values.add(t.getTiempo().toString());
		values.add(t.getCosto().toString());
		values.add(t.getTematica().getId().toString());
		
		return CRUD.update("atracciones", columnas, tipos, values, condicion);
	}

	@Override
	public int delete(Atraccion t) throws SQLException {
		return CRUD.delete("atracciones", "id_atraccion", t.getId().toString(), "int");
	}

	@Override
	public int deleteBy(String campo, String operador, String valor) throws SQLException {
		return delete(findBy(campo, operador, valor));
	}

	@Override
	public Atraccion findBy(String campo, String operador, String valor) throws SQLException {
		String condicion = campo + " " + operador + " " + valor;
		Atraccion atraccion = new Atraccion("No existe");
		ResultSet rs = CRUD.select("atracciones", "*", condicion);
		if(rs.next()) {
			atraccion.setId(rs.getInt("id_atraccion"));
			atraccion.setNombre(rs.getString("nombre"));
			atraccion.setCupoUsuarios(rs.getInt("cupos"));
			atraccion.setCosto(rs.getInt("costo"));
			atraccion.setTiempo(rs.getDouble("tiempo"));
			atraccion.setTematica(tematica.findById(rs.getInt("id_tematica")));		
		}
		return atraccion;
	}

	@Override
	public Atraccion findById(int id) throws SQLException {
		return this.findBy("id_atraccion", "=", String.valueOf(id));
	}

	@Override
	public List<Atraccion> findAllBy(String campo, String operador, String valor) throws SQLException {
		List<Atraccion> listaDeAtraccions = new ArrayList<Atraccion>();
		String condicion = "";
		if(!campo.equals("") && !operador.equals("") && !valor.equals("")) 
			condicion = campo + " " + operador + " " + valor;
		ResultSet rs = CRUD.select("atracciones", "*", condicion);
		while (rs.next())
		listaDeAtraccions.add(new Atraccion(rs.getInt("id_Atraccion"), 
										rs.getString("nombre"),
										rs.getInt("costo"),
										rs.getDouble("tiempo"),
										rs.getInt("cupos"),
										tematica.findById(rs.getInt("id_tematica"))));			
		
		
		return listaDeAtraccions;
	}

}
