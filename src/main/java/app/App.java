package app;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Scanner;

import model.Usuario;
import persistence.commons.ConnectionProvider;

public class App {

	public static void main(String[] args) throws FileNotFoundException, IOException, SQLException, NoExisteTematicaException {
		
		Sistema.cargarDatos();
		
		boolean existe = false;
		Scanner input = new Scanner(System.in);

		Collections.sort(Sistema.getUsuarios());
		SistemaFront.mostrarUsuarios();
		
		do {
			System.out.println("");
			System.out.print("Ingrese su Nombre de Usuario: ");
			String nombre = input.nextLine();
			//existe = Sistema.login(new Usuario(nombre));
		} while (!existe);

		System.out.println("");
		Collections.sort(Sistema.getAtracciones(), new OrdenadorPorTematica());
		SistemaFront.mostrarAtracciones();

		System.out.println("");
		Collections.sort(Sistema.getPromociones(), new OrdenadorPorTematica());
		SistemaFront.mostrarPromociones();

		System.out.println("");
		Sistema.cargarOfertas();

		input.close();
		
		System.out.println("Gracias por utilizar nuestro Sistema :) � JAVALEROS");
	}
}