package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	
	private static Connection connection;
	private static final String STRING_CONNECTION = "jdbc:sqlite:DB/tierra-media.db";
	
	private ConnectionProvider() {}
	
	public static Connection getConnection() throws SQLException{
		if(connection == null)
			connection = DriverManager.getConnection(STRING_CONNECTION);
		
		return connection;
	}
	
	public static void closeConnection() throws SQLException{
		connection.close();
	}
}
