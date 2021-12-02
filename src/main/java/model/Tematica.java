package model;

public class Tematica {
	
	private Integer id;
	private String nombre;
	
	public Tematica(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public Tematica(String nombre) {
		this(0, nombre);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return this.nombre;
	}
	
}