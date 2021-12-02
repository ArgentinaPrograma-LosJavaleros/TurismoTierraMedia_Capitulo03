package model;

import java.sql.SQLException;

import app.NoExisteTematicaException;
import app.Sistema;
import controller.AtraccionController;

public class Usuario implements Comparable<Usuario>{

	private Integer id;
	private String nombre;
	private Integer cantidadMonedas;
	private Double tiempoDisponible;
	private Tematica preferencia;
	
	// Constructores
	//--------------------------------------------------------------------------
	public Usuario(Integer id,String nombre, Integer cantidadMonedas, Double tiempoDisponible,
			Tematica preferencia) {
		setId(id);
		setNombre(nombre);
		setCantidadMonedas(cantidadMonedas);
		setTiempoDisponible(tiempoDisponible);
		setPreferencia(preferencia);
	}
	
	public Usuario(String nombre) {
		this(0, nombre, null, null, null);
	}
	
	// Setters
	//--------------------------------------------------------------------------
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCantidadMonedas(Integer cantidadMonedas) {
		this.cantidadMonedas = cantidadMonedas;
	}
	
	public void setTiempoDisponible(Double tiempoDisponible) {
		this.tiempoDisponible = tiempoDisponible;
	}
	
	public void setPreferencia(Tematica preferencia) {
		this.preferencia = preferencia;
	}
	
	// Getters
	//--------------------------------------------------------------------------
	public Integer getId() {
		return this.id;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public Double getTiempoDisponible() {
		return this.tiempoDisponible;
	}

	public Integer getCantidadMonedas() {
		return this.cantidadMonedas;
	}
	
	public Tematica getPreferencia() {
		return this.preferencia;
	}
	
	// Métodos
	//--------------------------------------------------------------------------
	@Override
	public String toString() {
		System.out.printf("| Nombre = %-12s"
				        + "| Monedas = %-5d"
				        + "| Tiempo = %-5.1f"
				        + "| Preferencia = %-15s |", 
				        getNombre(), 
				        getCantidadMonedas(), 
				        getTiempoDisponible(), 
				        getPreferencia().getNombre());
		return "";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.toLowerCase().equals(other.nombre.toLowerCase()))
			return false;
		return true;
	}

	@Override
	public int compareTo(Usuario o) {
		return this.getNombre().compareTo(o.getNombre());
	}

	
	public void comprar(Sugerible producto, Ticket ticket) throws SQLException, NoExisteTematicaException {
		AtraccionController atraccion = new AtraccionController();
		
		this.setCantidadMonedas(this.cantidadMonedas - producto.getCosto());
		this.setTiempoDisponible(this.tiempoDisponible - producto.getTiempo());

		ticket.setMonedasGastadas(ticket.getMonedasGastadas() + producto.getCosto());
		ticket.setTiempoGastado(ticket.getTiempoGastado() + producto.getTiempo());

		if (producto.getClass().equals(Atraccion.class)) {
			ticket.setAtraccionesReservadas(producto.getNombre());
			((Atraccion) producto).setCupoUsuarios(((Atraccion) producto).getCupoUsuarios() - 1);
			atraccion.update(((Atraccion) producto));
		} else {
			for (Atraccion a : ((Promocion)producto).getAtracciones()) {
					a.setCupoUsuarios(a.getCupoUsuarios() - 1);
					atraccion.update(a);
					ticket.setAtraccionesReservadas(a.getNombre());
			}
			if (producto.getClass().equals(PromoAxB.class)) {
				Atraccion a = ((PromoAxB) producto).getAtraccionGratis();
				a.setCupoUsuarios(a.getCupoUsuarios() - 1);
				atraccion.update(a);
				ticket.setAtraccionesReservadas(a.getNombre());
			}
			ticket.setPromocionesReservadas(producto.getNombre());
		}
		Sistema.actualizarDatos();
	}
	
	
}
