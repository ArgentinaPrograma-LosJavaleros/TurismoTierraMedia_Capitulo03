package app;

import model.Atraccion;
import model.PromoAbsoluta;
import model.PromoAxB;
import model.PromoPorcentual;
import model.Promocion;
import model.Sugerible;
import model.Usuario;

public class SistemaFront {
	
	// LISTAS CARGADAS POR SISTEMA
	//----------------------------------------------------------------------------------

	public static void mostrarUsuarios() {
		double size = (double) ((87 - (double) ("LISTA DE USUARIOS").length()) / 2);
		System.out.println(" " + repiteCaracteres("_", 87) + " ");
		System.out.println("|" + repiteCaracteres(" ", 87) + "|");
		System.out.println("|" + repiteCaracteres(" ", (int)Math.floor(size)) + "LISTA DE USUARIOS" + repiteCaracteres(" ", (int)Math.ceil(size)) + "|");
		System.out.println("|" + repiteCaracteres("_", 87) + "|");		
		for (Usuario usuario : Sistema.getUsuarios()) {
			System.out.println(usuario);
			
			System.out.println("|" + repiteCaracteres("-", 87) + "|");
		}
		System.out.println("!" + repiteCaracteres(".", 87) + "!");
	}
	

	public static void mostrarAtracciones() {
		double size = (double) ((119 - (double) ("LISTA DE ATRACCIONES").length()) / 2);
		System.out.println(" " + repiteCaracteres("_", 119) + " ");
		System.out.println("|" + repiteCaracteres(" ", 119) + "|");
		System.out.println("|" + repiteCaracteres(" ", (int)Math.floor(size)) + "LISTA DE ATRACCIONES" + repiteCaracteres(" ", (int)Math.ceil(size)) + "|");
		System.out.println("|" + repiteCaracteres("_", 119) + "|");
		for (Atraccion atraccion : Sistema.getAtracciones()) {
			System.out.println(atraccion);
			System.out.println("|" + repiteCaracteres("-", 119) + "|");
		}
		System.out.println("!" + repiteCaracteres(".", 207) + "!");
	}

	
	public static void mostrarPromociones() {
		double size = (double) ((207 - (double) ("LISTA DE PROMOCIONES").length()) / 2);
		System.out.println(" " + repiteCaracteres("_", 207) + " ");
		System.out.println("|" + repiteCaracteres(" ", 207) + "|");
		System.out.println("|" + repiteCaracteres(" ", (int)Math.floor(size)) + "LISTA DE PROMOCIONES" + repiteCaracteres(" ", (int)Math.ceil(size)) + "|");
		System.out.println("|" + repiteCaracteres("_", 207) + "|");
		for (Promocion promocion : Sistema.getPromociones()) {
			System.out.println(promocion);
			System.out.println("|" + repiteCaracteres("-", 207) + "|");
		}
		System.out.println("!" + repiteCaracteres(".", 207) + "!");
	}
	
	//----------------------------------------------------------------------------------
	
	// IMPRESION DE SUGERIBLES
	//----------------------------------------------------------------------------------
	
	public static String mostrarSugerible(Sugerible s) {
		double size = (double) ((58 - (double) s.getNombre().length()) / 2);
		System.out.println(" " + repiteCaracteres("_", 58) + " ");
		System.out.println("|" + repiteCaracteres(" ", 58) + "|");
		System.out.println("|" + repiteCaracteres(" ", (int)Math.floor(size)) + s.getNombre() + repiteCaracteres(" ", (int)Math.ceil(size)) + "|");
		System.out.println("|" + repiteCaracteres("_", 58) + "|");
		System.out.println(generarDato("$" + s.getCosto(), "Costo:"));
		System.out.println(generarDato(s.getTiempo() + "Hs", "Tiempo:"));
		System.out.println(generarDato(s.getTematica(), "Temática:"));
		System.out.println("|" + repiteCaracteres("_", 58) + "|");
		if(s.getClass().equals(PromoAbsoluta.class))
			mostrarBeneficio((Promocion) s, "-$" + (((PromoAbsoluta)s).getCostoAnterior() - s.getCosto()));
		if(s.getClass().equals(PromoAxB.class))
			mostrarBeneficio((Promocion) s, (((PromoAxB)s).getAtraccionGratis().getNombre() + " ¡GRATIS! :D"));
		if(s.getClass().equals(PromoPorcentual.class))
			mostrarBeneficio((Promocion) s, "%" + (int)(((PromoPorcentual)s).getPorciento() * 100) + " OFF");		
		return "";
	}
	
	public static String mostrarBeneficio(Promocion p, Object obj) {
		double size = (double) ((58 - (double) ("Incluyen...").length()) / 2);
		System.out.println("|" + repiteCaracteres("x", 58) + "|");
		System.out.println(generarDato(obj, "Beneficio:"));
		System.out.println("|" + repiteCaracteres("x", 58) + "|");
		System.out.println("|" + repiteCaracteres(" ", (int)Math.floor(size)) + "Incluyen..." + repiteCaracteres(" ", (int)Math.ceil(size)) + "|");
		System.out.println("|" + repiteCaracteres("_", 58) + "|");
		for(Atraccion a : p.getAtracciones())
			mostrarAtraccion(a);
		return "";
	}

	public static String mostrarAtraccion(Atraccion atraccion) {
		String costo = "Costo: $" + atraccion.getCosto();		
		String tiempo = "Tiempo: " + atraccion.getTiempo() + "Hs";
		String cupo = "Cupo: " + atraccion.getCupoUsuarios();
		costo = costo.replace(" ", repiteCaracteres(" ", 18 - costo.length()));
		tiempo = tiempo.replace(" ", repiteCaracteres(" ", 19 - tiempo.length()));
		cupo = cupo.replace(" ", repiteCaracteres(" ", 16 - cupo.length()));
		System.out.println(generarDato("", atraccion.getNombre()));
		System.out.println("| " + costo + " | " + tiempo + " | " + cupo + " |");
		System.out.println("|" + repiteCaracteres("_", 58) + "|");
		return "";
	}
	
	//----------------------------------------------------------------------------------
	
	// GENERADOR DE CARACTERES
	//----------------------------------------------------------------------------------
	
	private static String generarDato(Object obj, String str) {
		int size = 58 - (str + obj.toString()).length();
		return "|" + str + repiteCaracteres(" ", (int)size) + obj + "|";
	}	
	
	private static String repiteCaracteres(String str, Integer cantidad) {
		String str2 = "";
		for(int i = 0; i < cantidad; i++) {
			str2 += str;
		}
		return str2;
	}
	
	//----------------------------------------------------------------------------------
	
}
