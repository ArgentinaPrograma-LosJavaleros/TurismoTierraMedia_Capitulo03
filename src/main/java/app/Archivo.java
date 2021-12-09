package app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import model.Atraccion;
import model.PromoAbsoluta;
import model.PromoAxB;
import model.PromoPorcentual;
import model.Promocion;
import model.Ticket;
import model.TipoPromocion;
import model.Usuario;
import persistence.impl.TematicaDAOImp;

public class Archivo {

	private static TematicaDAOImp tematica = new TematicaDAOImp();
	
	private static final String DIRECCION_PRINCIPAL = System.getProperty("user.dir");
	private static final String DIRECCION_ARCHIVO = DIRECCION_PRINCIPAL  + "\\archivos\\";

	public static ArrayList<Usuario> cargarUsuarios() throws NumberFormatException, SQLException {

		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		Scanner sc = null;

		try {

			sc = iniciarScanner("usuarios.txt");

			while (sc.hasNext()) {

				String line = sc.nextLine();

				// Crea una array con cada palabra separada por un espacio.
				String valores[] = line.split(" ");

				// Reemplaza el gui�n bajo en el nombre del usuario por un espacio.
				valores[0] = valores[0].replace('_', ' ');

				int monedas = Integer.parseInt(valores[1]);
				double tiempo = Double.parseDouble(valores[2]);

				// A�ade al usuario al arraylist de usuarios con su nombre, monedas, tiempo y
				// tem�tica preferida.
//				usuarios.add(new Usuario(0,valores[0], monedas, tiempo, tematica.
//						findBy("nombre", "=", "\"" + (valores[3]) + "\"")));
				//new Tematica(Integer.valueOf(valores[3]))
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}

		return usuarios;
	}

	public static ArrayList<Atraccion> cargarAtracciones() throws NumberFormatException, SQLException {

		ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();

		Scanner sc = null;

		try {

			sc = iniciarScanner("atracciones.txt");

			while (sc.hasNext()) {

				String line = sc.nextLine();
				String valores[] = line.split(" ");
				valores[0] = valores[0].replace('_', ' ');

				int costo = Integer.parseInt(valores[1]);
				double tiempo = Double.parseDouble(valores[2]);
				int cupos = Integer.parseInt(valores[3]);

				//atracciones.add(new Atraccion(0,valores[0], costo, tiempo, cupos,tematica.findBy("nombre", "=", "\"" + (valores[4]) + "\"")));

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}

		return atracciones;
	}

	public static ArrayList<Promocion> cargarPromociones() {

		ArrayList<Promocion> promociones = new ArrayList<Promocion>();

		Scanner sc = null;

		try {

			sc = iniciarScanner("promociones.txt");

			while (sc.hasNext()) {

				String line = sc.nextLine();
				String valores[] = line.split(" ");
				valores[0] = valores[0].replace('_', ' ');

				TipoPromocion promo = new TipoPromocion(valores[1]);
				ArrayList<Atraccion> atraccionesPromocion = new ArrayList<Atraccion>();

				atraccionesPromocion.add(getAtraccion(valores[3].replace('_', ' ')));
				atraccionesPromocion.add(getAtraccion(valores[4].replace('_', ' ')));
				
				if (promo.getNombre().toLowerCase().equals("absoluta")) {
					promo.setId(1);
					int beneficio = Integer.parseInt(valores[2]);
					promociones.add(new PromoAbsoluta(0, valores[0], beneficio, atraccionesPromocion, promo));
				}
				
				if (promo.getNombre().toLowerCase().equals("axb")) {
					promo.setId(2);
					Atraccion atraccionGratis = getAtraccion(valores[2]);
					promociones.add(new PromoAxB(0,valores[0], atraccionGratis, atraccionesPromocion, promo));
				}

				if (promo.getNombre().toLowerCase().equals("porcentual")) {
					promo.setId(3);
					double porcentaje = Double.parseDouble(valores[2]);
					promociones.add(new PromoPorcentual(0,valores[0], porcentaje, atraccionesPromocion, promo));
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NoExisteAtraccionException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}

		return promociones;
	}

	private static Scanner iniciarScanner(String nombre) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(DIRECCION_ARCHIVO + nombre));
		sc.useLocale(Locale.ENGLISH);
		return sc;
	}

	private static Atraccion getAtraccion(String nombre) throws NoExisteAtraccionException {
		for (Atraccion a : Sistema.getAtracciones()) {
			String s = (a).getNombre();
			if (s.toLowerCase().equals(nombre.replace("_", " ").toLowerCase()))
				return a;
		}
		throw new NoExisteAtraccionException("NO existe la atraccion \"" + nombre + "\"");
	}
	
	private static void crearArchivo(String nombreArchivo) {
        try {
            File file = new File(DIRECCION_ARCHIVO + nombreArchivo);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("");
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	public static Ticket generarTicket(Ticket ticket, boolean noSobrescribir)
			throws IOException, FileNotFoundException {
		
		String archivo = LocalDate.now() + "_" + ticket.getComprador() + ".txt";
		crearArchivo(archivo);
		PrintWriter pw = new PrintWriter(new FileWriter(DIRECCION_ARCHIVO + archivo, noSobrescribir));
		
		pw.println(" ______________________________________________");
		pw.println("|                                              |");
		pw.println("|           TURISMO EN LA TIERRA MEDIA         |");
		pw.println("|               TICKET DE ACCESO               |");
		pw.println("|______________________________________________|");
		pw.println("|                                              |");
		pw.printf( "|Comprador/a %34s|\n", ticket.getComprador());
		pw.println("|                                              |");
		pw.printf( "|Monedas Gastadas %29s|\n", ticket.getMonedasGastadas());
		pw.println("|                                              |");
		pw.printf( "|Tiempo Gastado  %30s|\n", ticket.getTiempoGastado());
		pw.println("|                                              |");
		pw.println("|::::::::::::::::::::::::::::::::::::::::::::::|");
		pw.println("|Promociones Reservadas:                       |");
		for (String p : ticket.getPromocionesReservadas())
			pw.printf( "|%46s|\n", p);
		pw.println("|Atracciones Reservadas:                       |");
		for (String a : ticket.getAtraccionesReservadas())
			pw.printf( "|%46s|\n", a);
		pw.println("|                                              |");
		pw.println("|                                              |");
		pw.println("|        �MUCHAS GRACIAS POR SU COMPRA!        |");
		pw.println("|                                              |");
		pw.println("|______________________________________________|");
		
		pw.close();

		return ticket;
	}
	
}