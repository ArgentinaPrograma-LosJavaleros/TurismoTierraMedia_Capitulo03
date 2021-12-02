package app;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import controller.*;
import model.Atraccion;
import model.PromoAxB;
import model.Promocion;
import model.Sugerible;
import model.Ticket;
import model.Usuario;

public class Sistema {

    private	static PromocionController pC = new PromocionController();
    private static AtraccionController aC = new AtraccionController();
    private static TicketController tC = new TicketController();
    private static UsuarioController uC = new UsuarioController();
	private static ArrayList<Usuario> usuarios;
	private static ArrayList<Atraccion> atracciones;
	private static ArrayList<Promocion> promociones;
	private static Usuario usuarioActual;
	protected static final String RESPUESTA_SI = "SI";
	private static final String RESPUESTA_NO = "NO";
	
	// Setters
	// --------------------------------------------------------------------------
	public static void setUsuarios(ArrayList<Usuario> _usuarios) {
		usuarios = _usuarios;
	}

	public static void setAtracciones(ArrayList<Atraccion> _atracciones) {
		atracciones = _atracciones;
	}

	public static void setPromociones(ArrayList<Promocion> _promociones) {
		promociones = _promociones;
	}

	public static boolean login(Usuario usuarioLogin) {
		try {
			usuarioActual = getUsuarios().get(getUsuarios().indexOf(usuarioLogin));
		} catch (IndexOutOfBoundsException iobe) {
			System.out.println("El usuario actual no existe");
			return false;
		}
		return true;
	}

	// --------------------------------------------------------------------------

	// Getters
	// --------------------------------------------------------------------------
	public static ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public static ArrayList<Atraccion> getAtracciones() {
		return atracciones;
	}

	public static ArrayList<Promocion> getPromociones() {
		return promociones;
	}

	public static Usuario getUsuarioActual() {
		return usuarioActual;
	}
	// --------------------------------------------------------------------------

	public static void cargarOfertas() throws SQLException, NoExisteTematicaException, FileNotFoundException, IOException {
		Scanner ingreso = new Scanner(System.in);

		Usuario u = Sistema.getUsuarioActual();

		Ticket ticket = new Ticket();

	//	Tematica tematica = u.getPreferencia();
		
		for (Promocion p : Sistema.getPromociones()) {
			if (verificarSugerible(p, ticket)) {
				System.out.println("Le sugerimos la siguiente Promoción:");
				System.out.println(SistemaFront.mostrarSugerible(p));
				System.out.println("¿Desea comprar " + p.getNombre() + "?");
				if (ingreso.next().toUpperCase().equals(RESPUESTA_SI)) {
					System.out.println("Acaba de comprar: " + p.getNombre());
					u.comprar(p, ticket);
					
				}
				System.out.println("¿Desea seguir?");
				if (ingreso.next().toUpperCase().equals(RESPUESTA_NO)) {
					break;
				}
			}
		}
		
		for (Atraccion a : Sistema.getAtracciones()) {
			if (verificarSugerible(a, ticket)) {
				System.out.println("Le sugerimos la siguiente Atracción:");
				System.out.println(SistemaFront.mostrarSugerible(a));
				System.out.println("¿Desea comprar " + a.getNombre() + "?");
				if (ingreso.next().toUpperCase().equals(RESPUESTA_SI)) {
					System.out.println("Acaba de comprar: " + a.getNombre());
					u.comprar(a, ticket);
				}
				System.out.println("¿Desea seguir?");
				if (ingreso.next().toUpperCase().equals(RESPUESTA_NO)) {
					break;
				}
			}
		}
		
		if (ticket.getMonedasGastadas() != 0) {
			System.out.println(ticket);
			crearTicket(ticket);
			actualizarDatos();
		} else {
			System.out.println("");
			System.out.println("No se pudo efectuar la compra... ¡¡¡Gracias por visitar Turismo en la Tierra Media!!!");
		}
		
		ingreso.close();
		
	}

	public static boolean verificarSugerible(Sugerible producto, Ticket ticket) throws SQLException {
		Usuario u = Sistema.getUsuarioActual();
		
		
		if (u.getCantidadMonedas() >= producto.getCosto() && u.getTiempoDisponible() >= producto.getTiempo()) {
			if (producto.getClass().equals(Atraccion.class)) {
				if (((Atraccion) producto).getCupoUsuarios() > 0
						&& !ticket.getAtraccionesReservadas().contains(producto.getNombre()))
					if(!verificarSugeriblesAnteriores(producto))
						return true;
			} else {
				for (Atraccion a : ((Promocion) producto).getAtracciones()) {
					if (a.getCupoUsuarios() > 0 && !ticket.getAtraccionesReservadas().contains(a.getNombre()))
						if(!verificarSugeriblesAnteriores(producto))
							return true;
				}
				if (producto.getClass().equals(PromoAxB.class)) {
					if (((PromoAxB) producto).getAtraccionGratis().getCupoUsuarios() > 0
							&& !ticket.getAtraccionesReservadas()
									.contains(((PromoAxB) producto).getAtraccionGratis().getNombre()))
						if(!verificarSugeriblesAnteriores(producto))
							return true;
				}
			}
		}
		return false;
	}

	private static boolean verificarSugeriblesAnteriores(Sugerible compraActual) throws SQLException {
		Usuario u = Sistema.getUsuarioActual();
		ArrayList<Ticket> comprasAnteriores = (ArrayList<Ticket>) tC.findAllBy("id_usuario", "=", u.getId().toString());
		for (Ticket t: comprasAnteriores) {
			if(t.getAtraccionesReservadas().contains(compraActual.getNombre()) || 
					t.getPromocionesReservadas().contains(compraActual.getNombre()))
				return true;
			
		}
		return false;
	}

	public static void cargarDatos() throws SQLException, NoExisteTematicaException {
		setPromociones((ArrayList<Promocion>) pC.findAll());
		setAtracciones((ArrayList<Atraccion>) aC.findAll());
		setUsuarios((ArrayList<Usuario>) uC.findAll());
	}
	
	public static void actualizarDatos() throws SQLException, NoExisteTematicaException {
		for (Usuario u: getUsuarios())
			uC.update(u);
		cargarDatos();
	}
	
	public static void crearTicket(Ticket t)throws SQLException, FileNotFoundException, IOException {
		t.setId(tC.countAll()+1);
		tC.insert(t);
		Archivo.generarTicket(t, false);
		
	}
}
