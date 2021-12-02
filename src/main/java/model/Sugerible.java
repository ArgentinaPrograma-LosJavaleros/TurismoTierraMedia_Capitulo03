package model;

public abstract class Sugerible implements Comparable<Sugerible> {
	
	protected Integer id;
	protected String nombre;
	protected Integer costo;
	protected Double tiempo;
	protected Tematica tematica; 
	
	
	public Integer getId() {
		return id;
	}
		
	public String getNombre() {
		return nombre;
	}

	public Integer getCosto() {
		return costo;
	}

	public Double getTiempo() {
		return tiempo;
	}
	
	public Tematica getTematica() {
		return tematica;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCosto(Integer costo) {
		this.costo = costo;
	}

	public void setTiempo(Double tiempo) {
		this.tiempo = tiempo;
	}

	public void setTematica(Tematica tematica) {
		this.tematica = tematica;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((tematica == null) ? 0 : tematica.hashCode());
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
		Sugerible other = (Sugerible) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (tematica != other.tematica)
			return false;
		return true;
	}
	
}
