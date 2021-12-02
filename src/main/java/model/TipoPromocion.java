package model;

public class TipoPromocion {

	private Integer id;
	private String nombre;
	
	public TipoPromocion(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public TipoPromocion(String nombre) {
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