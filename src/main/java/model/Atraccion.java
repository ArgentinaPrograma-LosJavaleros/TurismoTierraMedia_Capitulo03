package model;

public class Atraccion extends Sugerible {

	private Integer cupoUsuarios;
	private String descripcion;
	
	public Atraccion(Integer idAtraccion,String nombreAtraccion, Integer costoAtraccion, Double tiempoAtraccion, Integer cupoUsuarios,
			Tematica tematicaAtraccion, String descripcion, Boolean activo) {
		super.setId(idAtraccion);
		super.setNombre(nombreAtraccion);
		super.setCosto(costoAtraccion);
		super.setTiempo(tiempoAtraccion);
		super.setTematica(tematicaAtraccion);
		this.setCupoUsuarios(cupoUsuarios);
		this.setDescripcion(descripcion);
		this.setActivo(activo);
	}
	
	public Atraccion(Integer idAtraccion,String nombreAtraccion, Integer costoAtraccion, Double tiempoAtraccion, Integer cupoUsuarios,
			Tematica tematicaAtraccion, String descripcion) {
		this(idAtraccion, nombreAtraccion, costoAtraccion, tiempoAtraccion, cupoUsuarios, tematicaAtraccion, descripcion, true);
	}

	public Atraccion(String nombreAtraccion) {
		this(0, nombreAtraccion, null, null, null, null, null);
	}

	public void setCupoUsuarios(Integer cupoUsuarios) {
		this.cupoUsuarios = cupoUsuarios;
	}
	
	public Integer getCupoUsuarios() {
		return cupoUsuarios; 
	}

	@Override
	public String toString() {
		System.out.printf(
				"| Nombre = %-35s" + "| Costo = %-5d" + "| Tiempo = %-5.1f" + "| Cupo = %-5d" + "| Tem�tica = %-15s |" + "| Descripcion = %-15s |",
				super.getNombre(), super.getCosto(), super.getTiempo(), getCupoUsuarios(),
				getTematica(), this.getDescripcion());
		return "";
	}

	@Override
	public int compareTo(Sugerible s) {
		Atraccion a = (Atraccion) s;

		if (this.costo < a.costo)
			return 1;
		
		if (this.costo > a.costo) {
			return -1;
		}
		
		if(this.tiempo > a.tiempo)
			return -1;
		
		if(this.tiempo < a.tiempo)
			return 1;
		
		return 0;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}