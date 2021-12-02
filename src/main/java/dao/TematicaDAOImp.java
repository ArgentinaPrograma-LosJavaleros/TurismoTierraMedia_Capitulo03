package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.NoExisteTematicaException;
import model.Tematica;

public class TematicaDAOImp implements TematicaDAO {

	@Override
	 public List<Tematica> findAll()  throws SQLException, NoExisteTematicaException{
		
		
		
		return findAllBy("", "", "");
	}

	@Override
	public int countAll() throws SQLException {
		Integer contar = 0; 
				
		ResultSet rs = CRUD.select("tematicas", "count(*)", "");
		
		contar = rs.getInt(1);
		
		return contar;
	}

	@Override
	public int insert(Tematica t) throws SQLException {
		
		List<String> columnas= new ArrayList<String> ();
		List<String> tipos= new ArrayList<String> (); 
		List<String> values= new ArrayList<String> (); 
		
		columnas.add("nombre");

		tipos.add("String");
		
		values.add(t.getNombre());

				
		return CRUD.insert("tematicas", columnas, tipos, values);
	}

	@Override
	public int update(Tematica t) throws SQLException {
		String condicion = " where id_tematica = " + t.getId();
		List<String> columnas= new ArrayList<String> ();
		List<String> tipos= new ArrayList<String> (); 
		List<String> values= new ArrayList<String> (); 
		
		columnas.add("id_tematica");
		columnas.add("nombre");
		
		tipos.add("Int");
		tipos.add("String");
		
		values.add(t.getId().toString());
		values.add(t.getNombre());
				
		return CRUD.update("tematicas", columnas, tipos, values, condicion);
	}

	@Override
	public int delete(Tematica t) throws SQLException {
		return CRUD.delete("tematicas", "id_tematica", t.getId().toString(), "int");
	}

	@Override
	public int deleteBy(String campo, String operador, String valor) throws SQLException {
		return delete(findBy(campo, operador, valor));
	}

	@Override
	public Tematica findBy(String campo, String operador, String valor) throws SQLException {
		String condicion = campo + " " + operador + " " + valor;
		Tematica tematica = new Tematica("No existe");
		ResultSet rs = CRUD.select("tematicas", "*", condicion);
		if(rs.next()) {
			tematica.setId(rs.getInt("id_tematica"));
			tematica.setNombre(rs.getString("nombre"));
		}
		return tematica;
	}

	@Override
	public Tematica findById(int id) throws SQLException {
		return this.findBy("id_tematica", "=", String.valueOf(id));
	}

	@Override
	public List<Tematica> findAllBy(String campo, String operador, String valor) throws SQLException {
		List<Tematica> listaDeTematicas = new ArrayList<Tematica>();
		String condicion = "";
		if(!campo.equals("") && !operador.equals("") && !valor.equals("")) 
			condicion = campo + " " + operador + " " + valor;
		ResultSet rs = CRUD.select("tematicas", "*", condicion);
		while (rs.next())
		listaDeTematicas.add(new Tematica(rs.getInt("id_tematica"), 
										rs.getString("nombre")));	
		return listaDeTematicas;
	}

}
