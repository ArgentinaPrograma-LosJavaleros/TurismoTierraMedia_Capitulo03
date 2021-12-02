package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import jdbc.ConnectionProvider;

public class CRUD {

	public static ResultSet select(String tabla, String campos, String condicion) throws SQLException {	
		
		String query = "SELECT " + campos + " FROM " + tabla;
		
		if(!condicion.equals(""))
			query += " WHERE " + condicion;
		
		Connection connection = ConnectionProvider.getConnection();
		PreparedStatement datos = connection.prepareStatement(query);
		return datos.executeQuery();
		
	}
	
	public static int insert(String tabla, List<String> columna, List<String> tipo, List<String> valor) throws SQLException {
		
		int contador = 0;
		String rows = "";
		String values = "";
		String query = "";
		
		query = "INSERT INTO " + tabla + " (";
		
		for (int i = 0; i < columna.size(); i++) {
			rows += columna.get(i)+ ", ";
			values += "?, ";
		}
						
		query += rows.substring(0, rows.length()-2) + ") VALUES (" + values.substring(0, values.length()-2) + ")"; 			
		contador += actualizarTabla(tipo, valor, query);
		return contador;
	}

	public static int delete(String tabla, String columna, String tipo, String valor) throws SQLException {
		
		String query = "DELETE FROM " + tabla + " WHERE " + columna + " = ?";
		
		return actualizarTabla(tipo, valor, query);
	}

	public static int update(String tabla, List<String> columna, List<String> tipo, List<String> valor, String condicion) throws SQLException {
		 
		String rows = "";
	//	String values = "";
		String query = "";
		
		query = "UPDATE " + tabla + " SET ";
				
		for(int i = 1; i < columna.size(); i++) {
			rows += columna.get(i) + " = ?, ";
		}
				
	//	values = " WHERE " + columna.get(0) + " = " + valor.get(0);
		query += rows.substring(0, rows.length()-2) + condicion; 
		columna.remove(0);
		tipo.remove(0);
		valor.remove(0);
		
		return actualizarTabla(tipo, valor, query);
	}	
	
	private static int actualizarTabla(String tipo, String valor, String query) throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		PreparedStatement datos = connection.prepareStatement(query);
		
		if (tipo.toLowerCase().equals("int"))
			datos.setInt(1, Integer.parseInt(valor));
		
		if (tipo.toLowerCase().equals("double"))
			datos.setDouble(1, Double.parseDouble(valor));
		
		if (tipo.toLowerCase().equals("string"))
			datos.setString(1, valor);
		
		return datos.executeUpdate();
	}
	
	private static int actualizarTabla(List<String> tipos, List<String> valores, String query) throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		PreparedStatement datos = connection.prepareStatement(query);
		
		for (int i = 0; i < tipos.size(); i++) {
			if (tipos.get(i).toLowerCase().equals("int"))
				datos.setInt(i+1, Integer.parseInt(valores.get(i)));
		
			if (tipos.get(i).toLowerCase().equals("double"))
				datos.setDouble(i+1, Double.parseDouble(valores.get(i)));
		
			if (tipos.get(i).toLowerCase().equals("string"))
				datos.setString(i+1, valores.get(i));
		}
		return datos.executeUpdate();
	}
}
