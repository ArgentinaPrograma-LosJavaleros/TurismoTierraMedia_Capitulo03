package controller.sugerible;

public class Mensaje {
	Integer tipo;
	String mensaje;
	
	public Mensaje(Integer tipo, String mensaje){
		this.setMensaje(mensaje);
		this.setTipo(tipo);
	}
	
	protected Integer getTipo() {
		return tipo;
	}
	protected String getMensaje() {
		return mensaje;
	}
	protected void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	protected void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}