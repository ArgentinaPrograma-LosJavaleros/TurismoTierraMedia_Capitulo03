package persistence.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.NoExisteTematicaException;
import model.Atraccion;
import model.PromoAbsoluta;
import model.PromoAxB;
import model.PromoPorcentual;
import model.Promocion;
import model.TipoPromocion;
import persistence.PromocionDAO;
import persistence.commons.CRUD;

public class PromocionDAOImp implements PromocionDAO {
	
	TematicaDAOImp tematica = new TematicaDAOImp();
	TipoPromocionDAOImp tipoPromo = new TipoPromocionDAOImp();
	AtraccionDAOImp atraccion = new AtraccionDAOImp();

	@Override
	public List<Promocion> findAll()  throws SQLException, NoExisteTematicaException{
		
		
		return findAllBy("", "", "");
	}

	@Override
	public int countAll() throws SQLException {
		Integer contar = 0; 	
		ResultSet rs = CRUD.select("Promociones", "count(*)", "");
		contar = rs.getInt(1);
		return contar;
	}

	@Override
	public int insert(Promocion t) throws SQLException {
		int contador = 0;
		contador += insertOrUpdatePromociones(t,1); 
		contador += insertOrUpdatePromo_Atracciones(t,1); 
		contador += insertOrUpdatePromoDatoExtra(t,1);
		
		return contador;
	}

	private int insertOrUpdatePromoDatoExtra(Promocion t, int modificacionTipo) throws SQLException {
		List<String> columnas3 = new ArrayList <String> ();
		List<String> tipos3 = new ArrayList <String> (); 
		List<String> values3 = new ArrayList <String> (); 
		int contador=0;
		String condicion = " where id_promocion = " + t.getId();
		
		if(t.getTipoPromocion().getId() == 2) {
			
			Atraccion atraccion1 = atraccion.findBy(
					"nombre", "=", "\"" + ((PromoAxB)t).getAtraccionGratis().getNombre() + "\"");
			
	
			columnas3.add("id_promocion");
			tipos3.add("Int");
			values3.add(t.getId().toString());

			columnas3.add("gratis");
			columnas3.add("id_atraccion");
			
			tipos3.add("Int");
			tipos3.add("Int");
			
			values3.add(String.valueOf(1));
			values3.add(atraccion1.getId().toString());

			condicion += " and id_atraccion = " + atraccion1.getId();
			
		if(modificacionTipo==1)
			contador += CRUD.insert("promo_atracciones", columnas3, tipos3, values3);
		if(modificacionTipo==2)
			contador += CRUD.update("promo_atracciones", columnas3, tipos3, values3, condicion);
		}
		
		if(t.getTipoPromocion().getId() == 3) {
			
			columnas3.add("id_promocion");
			columnas3.add("descuento");
			
			tipos3.add("Int");
			tipos3.add("Double");
			
			values3.add(t.getId().toString());
			values3.add(((PromoPorcentual)t).getPorciento().toString());
			
			if(modificacionTipo==1)
				contador += CRUD.insert("promo_descuento", columnas3, tipos3, values3);
			if(modificacionTipo==2)
				contador += CRUD.update("promo_descuento", columnas3, tipos3, values3, condicion);
		}
		
		return contador;
	}

	private int insertOrUpdatePromo_Atracciones(Promocion t,int modificacionTipo) throws SQLException {
			int contador = 0;
			String condicion = " where id_promocion = '" + t.getId() + "' and id_atraccion = '";
			Atraccion atraccion1 = atraccion.findBy(
					"nombre", "=", "\"" + t.getAtracciones().get(0).getNombre() + "\"");
			Atraccion atraccion2 = atraccion.findBy(
					"nombre", "=", "\"" + t.getAtracciones().get(1).getNombre() + "\"");
		
			List<String> columnas = new ArrayList <String> ();
			List<String> tipos = new ArrayList <String> (); 
			List<String> values = new ArrayList <String> ();
			
			List<String> columnas2 = new ArrayList <String> ();
			List<String> tipos2 = new ArrayList <String> (); 
			List<String> values2 = new ArrayList <String> ();	
			
			columnas.add("id_promocion");
			columnas.add("id_atraccion");
			columnas.add("gratis");
			
			columnas2.add("id_promocion");
			columnas2.add("id_atraccion");
			columnas2.add("gratis");
			
			tipos.add("Int");
			tipos.add("Int");
			tipos.add("Int");
			
			tipos2.add("Int");
			tipos2.add("Int");
			tipos2.add("Int");
			
			values.add(t.getId().toString());
			values.add(atraccion1.getId().toString());
			values.add(String.valueOf(0));
			
			values2.add(t.getId().toString());
			values2.add(atraccion2.getId().toString());
			values2.add(String.valueOf(0));
		if (modificacionTipo==1) {
			contador += CRUD.insert("promo_atracciones", columnas, tipos, values); 
		    contador += CRUD.insert("promo_atracciones", columnas2, tipos2, values2);
		}
		if (modificacionTipo==2){
			contador += CRUD.update("promo_atracciones", columnas, tipos, values, condicion + atraccion1.getId() + "'"); 
		    contador += CRUD.update("promo_atracciones", columnas2, tipos2, values2, condicion + atraccion2.getId() + "'");
		}
		return contador;
	}

	private int insertOrUpdatePromociones(Promocion t, int modificacionTipo) throws SQLException {
		int contador = 0;
		String condicion = " where id_promocion = " + t.getId();
		List<String> columnas = new ArrayList <String> ();
		List<String> tipos = new ArrayList <String> (); 
		List<String> values = new ArrayList <String> (); 

		if(modificacionTipo==2) {
			columnas.add("id_promocion");
			tipos.add("Int");
			values.add(t.getId().toString());
		}
		columnas.add("nombre");
		columnas.add("costo");
		columnas.add("id_tipo_promocion");
		columnas.add("activo");
		
		tipos.add("String");
		tipos.add("Int");
		tipos.add("Int");
		tipos.add("Int");
		
		values.add(t.getNombre());
		values.add(t.getCosto().toString());
		values.add(t.getTipoPromocion().getId().toString());
		if (t.getActivo())
			values.add(String.valueOf(1));
		else
			values.add(String.valueOf(0));

		if(modificacionTipo==1)
			contador += CRUD.insert("Promociones", columnas, tipos, values);
		if(modificacionTipo==2)
			contador += CRUD.update("Promociones", columnas, tipos, values, condicion);
		
		return contador;
	}

	@Override
	public int update(Promocion t) throws SQLException {

		int contador = 0;
		contador += insertOrUpdatePromociones(t,2); 
		contador += insertOrUpdatePromo_Atracciones(t,2); 
		contador += insertOrUpdatePromoDatoExtra(t,2);
		
		return contador;
	}

	@Override
	public int delete(Promocion t) throws SQLException {
		
		int contador = 0;
		
		contador += CRUD.delete("Promo_atracciones", "id_Promocion", "int", t.getId().toString());
		contador += CRUD.delete("Promo_descuentos", "id_Promocion", "int", t.getId().toString());
		contador += CRUD.delete("Promociones", "id_Promocion", "int", t.getId().toString());
		
		return contador;
	}

	@Override
	public int deleteBy(String campo, String operador, String valor) throws SQLException {
		
		return delete(findBy(campo, operador, valor));
	}

	@SuppressWarnings("null")
	@Override
	public Promocion findBy(String campo, String operador, String valor) throws SQLException {
		
	
		String consulta = campo + " " + operador + " " + valor;
		
		ResultSet rs = CRUD.select("Promociones", "*", consulta);
				
		if (rs.next()) {
			
			int id = rs.getInt("id_Promocion");
			int idFree = 0;
			String nombre = rs.getString("nombre");
			int costo = rs.getInt("costo");
			Boolean activo = rs.getBoolean("activo");
			
			ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
			TipoPromocion tipoPromocion = tipoPromo.findById(rs.getInt("id_tipo_promocion"));
			ResultSet rs2 = CRUD.select("promo_atracciones", "*", "id_promocion = " + id);

			while(rs2.next()) {
				if(rs2.getInt("gratis") != 1) {
					atracciones.add(atraccion.findById(rs2.getInt("id_atraccion")));					
				} else {
					idFree = rs2.getInt("id_atraccion");
				}
			}
			
			if(tipoPromocion.getId() == 1) {
				return new PromoAbsoluta(id, nombre, costo, atracciones, tipoPromocion, activo); 
			}
			
			if(tipoPromocion.getId() == 2) {
				return new PromoAxB(id, nombre, atraccion.findById(idFree), atracciones, tipoPromocion, activo); 
			}
			
			if(tipoPromocion.getId() == 3) {
				double oferton = 0.0;
				ResultSet rs3 = CRUD.select("promo_descuento", "descuento", "id_promocion = " + id);
				
				if(rs3.next())
					oferton = rs3.getDouble("descuento");
					
				return new PromoPorcentual(id, nombre, oferton, atracciones, tipoPromocion, activo); 
			}
		}
		
		return null;
	}

	@Override
	public Promocion findById(int id) throws SQLException {
		return findBy("id_promocion", "=", String.valueOf(id));
	}

	@Override
	public List<Promocion> findAllBy(String campo, String operador, String valor) throws SQLException {
		List<Promocion> listaDePromociones = new ArrayList<Promocion>();
		String condicion = "";
		if(!campo.equals("") && !operador.equals("") && !valor.equals("")) 
			condicion = campo + " " + operador + " " + valor;
		ResultSet rs = CRUD.select("Promociones", "*", condicion);
		
		while (rs.next()) {
			int id = rs.getInt("id_Promocion");
			int idFree = 0;
			ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
			TipoPromocion tipoPromocion = tipoPromo.findById(rs.getInt("id_tipo_promocion"));
			ResultSet rs2 = CRUD.select("promo_atracciones", "*", "id_promocion = " + id);
			while(rs2.next()) {
				if(rs2.getInt(3) != 1) {
					atracciones.add(atraccion.findById(rs2.getInt("id_atraccion")));					
				} else {
					idFree = rs2.getInt("id_atraccion");
				}
			}
			if(tipoPromocion.getId() == 1) {
				listaDePromociones.add(new PromoAbsoluta(
															id, 
															rs.getString("nombre"),
															rs.getInt("costo"),
															atracciones,
															tipoPromocion,
															rs.getBoolean("activo")));
			}
			if(tipoPromocion.getId() == 2) {
				listaDePromociones.add(new PromoAxB(
															id, 
															rs.getString("nombre"),
															atraccion.findById(idFree),
															atracciones,
															tipoPromocion,
															rs.getBoolean("activo")));
			}
			if(tipoPromocion.getId() == 3) {
				double oferton = 0.0;
				ResultSet rs3 = CRUD.select("promo_descuento", "descuento", "id_promocion = " + id);
				
				if(rs3.next())
					oferton = rs3.getDouble("descuento");
					
				listaDePromociones.add(new PromoPorcentual(
															id, 
															rs.getString("nombre"),
															oferton,
															atracciones,
															tipoPromocion,
															rs.getBoolean("activo")));
			}
		}
		return listaDePromociones;
	}

}