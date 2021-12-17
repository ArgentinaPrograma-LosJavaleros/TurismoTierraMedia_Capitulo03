package utils;

import java.util.Comparator;

import model.Sugerible;
import model.Tematica;

public class OrdenadorPorTematica implements Comparator<Sugerible> {

	@Override
	public int compare(Sugerible s1, Sugerible s2) {
		Tematica tematicaUsuario = Sistema.getUsuarioActual().getPreferencia();
		
		if(s1.getTematica().getNombre().equals(tematicaUsuario.getNombre()) &&
		  !s2.getTematica().getNombre().equals(tematicaUsuario.getNombre()))
			return -1;
		
		if(!s1.getTematica().getNombre().equals(tematicaUsuario.getNombre()) && 
			s2.getTematica().getNombre().equals(tematicaUsuario.getNombre()))
			return 1;
		
		return s1.compareTo(s2);
	}

}
