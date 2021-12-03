package persistence.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Ticket;
import persistence.TicketDAO;
import persistence.commons.CRUD;

public class TicketDAOImp implements TicketDAO {

	TematicaDAOImp tematica = new TematicaDAOImp();
	TipoPromocionDAOImp tipoPromo = new TipoPromocionDAOImp();
	AtraccionDAOImp atraccion = new AtraccionDAOImp();
	UsuarioDAOImp usuario = new UsuarioDAOImp();
	PromocionDAOImp promocion = new PromocionDAOImp();
	
	@Override
	 public List<Ticket> findAll()  throws SQLException{
		
		
		return findAllBy("", "", "");
	}

	@Override
	public int countAll() throws SQLException {
		Integer contar = 0; 
				
		ResultSet rs = CRUD.select("tickets", "count(*)", "");
		
		contar = rs.getInt(1);
		
		return contar;
	}

	@Override
	public int insert(Ticket t) throws SQLException {
		int contador=0;		
			
		contador += insertOrUpdateTicket(t,1);
		if(!t.getAtraccionesReservadas().isEmpty())
			contador +=	insertOrUpdateTickets_Atracciones(t,1); 
		if(!t.getPromocionesReservadas().isEmpty())
			contador +=	insertOrUpdateTicket_Promociones(t,1);
		
		return contador;		
	}

	private int insertOrUpdateTicket_Promociones(Ticket t, int modificacionTipo) throws SQLException {
		
		int contador = 0;
		String condicion = " where id_ticket = " + t.getId();
		
		
		
		for (String str : t.getPromocionesReservadas()) {
			List<String> columnas = new ArrayList<String> ();
			List<String> tipos = new ArrayList<String> (); 
			List<String> values = new ArrayList<String> (); 
			String idPromo = promocion.findBy("nombre", "=", "'" +  str + "'").getId().toString();
			columnas.add("id_ticket");
			columnas.add("id_promocion");
			
			tipos.add("Int");
			tipos.add("Int");
			
			values.add(t.getId().toString());
			values.add(idPromo);
	
			condicion += " and id_promocion = " + idPromo;
			if(modificacionTipo==1)
				contador += CRUD.insert("tickets_Promociones", columnas, tipos, values);
			
			if(modificacionTipo==2)
				contador += CRUD.update("tickets_Promociones", columnas, tipos, values, condicion);
		}
		
		return contador;
	}

	private int insertOrUpdateTickets_Atracciones(Ticket t,int modificacionTipo) throws SQLException {

		int contador = 0;
		String condicion = " where id_ticket = " + t.getId();
		
		for (String str : t.getAtraccionesReservadas()) {
			List<String> columnas = new ArrayList<String> ();
			List<String> tipos = new ArrayList<String> (); 
			List<String> values = new ArrayList<String> (); 
			String idAtraccion = atraccion.findBy("nombre", "=", "'" + str + "'").getId().toString();
				
			columnas.add("id_ticket");
			columnas.add("id_atraccion");
						
			tipos.add("Int");
			tipos.add("Int");
			
			values.add(t.getId().toString());
			values.add(idAtraccion);
	
			condicion += " and id_atraccion = " + idAtraccion;
			if(modificacionTipo==1)
				contador += CRUD.insert("tickets_atracciones", columnas, tipos, values);
			
			if(modificacionTipo==2)
				contador += CRUD.update("tickets_atracciones", columnas, tipos, values, condicion);
		}
		return contador;
	}

	private int insertOrUpdateTicket(Ticket t, int modificacionTipo) throws SQLException {
		int contador=0;
		String condicion = " where id_ticket = " + t.getId();
		List<String> columnas = new ArrayList<String> ();
		List<String> tipos = new ArrayList<String> (); 
		List<String> values = new ArrayList<String> (); 
		
		if (modificacionTipo==2) { 
			columnas.add("id_ticket");
			tipos.add("Int");
			values.add(t.getId().toString());
		}

		columnas.add("id_usuario");
		columnas.add("tiempo_gastado");
		columnas.add("monedas_gastadas");
		
		tipos.add("Int");
		tipos.add("Double");
		tipos.add("Int");
		
		values.add(usuario.findBy("nombre", "=",  "'" +  t.getComprador() + "'").getId().toString());
		values.add(t.getTiempoGastado().toString());
		values.add(t.getMonedasGastadas().toString());
		if(modificacionTipo==1)
			contador += CRUD.insert("tickets", columnas, tipos, values);
		
		if(modificacionTipo==2)
			contador += CRUD.update("tickets", columnas, tipos, values, condicion);
		
		return contador;
				
	}

	@Override
	public int update(Ticket t) throws SQLException {
		int contador=0;		
		
		contador += insertOrUpdateTicket(t,2);
		contador +=	insertOrUpdateTickets_Atracciones(t,2); 
		contador +=	insertOrUpdateTicket_Promociones(t,2);
		
		return contador;	
	}

	@Override
	public int delete(Ticket t) throws SQLException {
		int contador = 0;
		
		contador += CRUD.delete("Tickets", "id_ticket", "int", t.getId().toString());
		contador += CRUD.delete("Tickets_Atracciones", "id_ticket", "int", t.getId().toString());
		contador += CRUD.delete("Tickets_Promociones", "id_ticket", "int", t.getId().toString());
		
		return contador;
	}

	@Override
	public int deleteBy(String campo, String operador, String valor) throws SQLException {
		return delete(findBy(campo, operador, valor));
	}

	@Override
	public Ticket findBy(String campo, String operador, String valor) throws SQLException {
		
		Ticket ticket = new Ticket("No existe");
		String consulta = campo + " " + operador + " " + valor;
		ResultSet rs = CRUD.select("tickets", "*", consulta);
		if (rs.next()) {
			String comprador = usuario.findById(rs.getInt("id_usuario")).getNombre();
			ResultSet rsAtraccion = CRUD.select("tickets_atracciones", "*", "id_ticket = " + rs.getInt("id_ticket"));	
			List<String> atracciones = new ArrayList<String>();
			while(rsAtraccion.next()) {
				atracciones.add(atraccion.findById(rsAtraccion.getInt("id_atracion")).getNombre());
			}
			
			ResultSet rsPromocion = CRUD.select("tickets_promociones", "*", "id_ticket = " + rs.getInt("id_ticket"));	
			List<String> promociones = new ArrayList<String>();
			while(rsPromocion.next()) {
				promociones.add(promocion.findById(rsPromocion.getInt("id_promocion")).getNombre());
			}
			
			
			ticket.setId(rs.getInt("id_ticket")); 
			ticket.setComprador(comprador);	
			ticket.setMonedasGastadas(rs.getInt("monedas_gastadas"));			
			ticket.setTiempoGastado(rs.getDouble("tiempo_gastado"));			
			ticket.setAtraccionesReservadas(atracciones);
			ticket.setPromocionesReservadas(promociones);	
		}	
		return ticket;

	}

	@Override
	public Ticket findById(int id) throws SQLException {
		return this.findBy("id_ticket", "=", String.valueOf(id));
	}

	@Override
	public List<Ticket> findAllBy(String campo, String operador, String valor) throws SQLException {
		List<Ticket> listaDeTickets = new ArrayList<Ticket>();
		String condicion = "";
		if(!campo.equals("") && !operador.equals("") && !valor.equals("")) 
			condicion = campo + " " + operador + " " + valor;
		ResultSet rs = CRUD.select("tickets", "*", condicion);
		while (rs.next()) {
			String comprador = usuario.findById(rs.getInt("id_usuario")).getNombre();
			ResultSet rsAtraccion = CRUD.select("tickets_atracciones", "*", "id_ticket = " + rs.getInt("id_ticket"));	
			List<String> atracciones = new ArrayList<String>();
			while(rsAtraccion.next()) {
				atracciones.add(atraccion.findById(rsAtraccion.getInt("id_atraccion")).getNombre());
			}
			
			ResultSet rsPromocion = CRUD.select("tickets_promociones", "*", "id_ticket = " + rs.getInt("id_ticket"));	
			List<String> promociones = new ArrayList<String>();
			while(rsPromocion.next()) {
				promociones.add(promocion.findById(rsPromocion.getInt("id_promocion")).getNombre());
			}
			
			
			listaDeTickets.add(new Ticket(rs.getInt("id_ticket"), 
										comprador,
										rs.getInt("monedas_gastadas"),
										rs.getDouble("tiempo_gastado"),
										atracciones,
										promociones));	
		}	
		return listaDeTickets;
	}

}
