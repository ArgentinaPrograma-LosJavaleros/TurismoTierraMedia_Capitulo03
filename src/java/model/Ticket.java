package model;

import java.util.ArrayList;
import java.util.List;

import app.Sistema;

public class Ticket {
	
	private Integer id;
	private String comprador;
	private Integer monedasGastadas;
	private Double tiempoGastado;
	private List<String> atraccionesReservadas, promocionesReservadas;

	public Ticket(Integer id, String comprador, Integer monedasGastadas, Double tiempoGastado, List<String> atraccionesReservadas,
			List<String> promocionesReservadas) {
		setId(id);
		setComprador(comprador);
		setMonedasGastadas(monedasGastadas);
		setTiempoGastado(tiempoGastado);
		setAtraccionesReservadas(atraccionesReservadas);
		setPromocionesReservadas(promocionesReservadas);
	}

	public Ticket() {
		this(0, Sistema.getUsuarioActual().getNombre(), 0, 0.0, new ArrayList<String>(), new ArrayList<String>());
	}

	public Ticket(String comprador) {
		this(0, comprador , 0, 0.0, null , null);
	}

	// Setters
	// --------------------------------------------------------------------------
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setComprador(String comprador) {
		this.comprador = comprador;
	}

	public void setMonedasGastadas(Integer monedasGastadas) {
		this.monedasGastadas = monedasGastadas;
	}

	public void setTiempoGastado(Double tiempoGastado) {
		this.tiempoGastado = tiempoGastado;
	}

	public void setPromocionesReservadas(String promocionesReservadas) {
		this.promocionesReservadas.add(promocionesReservadas);
	}

	public void setPromocionesReservadas(List<String> promocionesReservadas) {
		this.promocionesReservadas = promocionesReservadas;
	}

	public void setAtraccionesReservadas(String atraccionesReservadas) {
		this.atraccionesReservadas.add(atraccionesReservadas);
	}

	public void setAtraccionesReservadas(List<String> atraccionesReservadas) {
		this.atraccionesReservadas = atraccionesReservadas;
	}
	// --------------------------------------------------------------------------

	// Getters
	// --------------------------------------------------------------------------
	public Integer getId() {
		return id;
	}
	
	public String getComprador() {
		return comprador;
	}

	public Integer getMonedasGastadas() {
		return monedasGastadas;
	}

	public Double getTiempoGastado() {
		return tiempoGastado;
	}

	public List<String> getAtraccionesReservadas() {
		return atraccionesReservadas;
	}

	public List<String> getPromocionesReservadas() {
		return promocionesReservadas;
	}
	// --------------------------------------------------------------------------

	@Override
	public String toString() {
		if (getMonedasGastadas() != 0) {
			System.out.println(" ______________________________________________");
			System.out.println("|                                              |");
			System.out.println("|           TURISMO EN LA TIERRA MEDIA         |");
			System.out.println("|               TICKET DE ACCESO               |");
			System.out.println("|______________________________________________|");
			System.out.println("|                                              |");
			System.out.printf("|Comprador/a %34s|\n", getComprador());
			System.out.println("|                                              |");
			System.out.printf("|Monedas Gastadas %29s|\n", getMonedasGastadas());
			System.out.println("|                                              |");
			System.out.printf("|Tiempo Gastado  %30s|\n", getTiempoGastado());
			System.out.println("|                                              |");
			System.out.println("|::::::::::::::::::::::::::::::::::::::::::::::|");
			System.out.println("|Promociones Reservadas:                       |");
			for (String p : getPromocionesReservadas())
				System.out.printf("|%46s|\n", p);
			System.out.println("|Atracciones Reservadas:                       |");
			for (String a : getAtraccionesReservadas())
				System.out.printf("|%46s|\n", a);
			System.out.println("|                                              |");
			System.out.println("|                                              |");
			System.out.println("|        ¡MUCHAS GRACIAS POR SU COMPRA!        |");
			System.out.println("|                                              |");
			System.out.println("|______________________________________________|");

		} else {
			System.out.println("");
			System.out.println("No se pudo efectuar la compra... ¡¡¡Gracias por visitar Turismo en la Tierra Media!!!");
		}
		return "";
	}
}
