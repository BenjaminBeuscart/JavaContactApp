package database;

import java.sql.Connection;
import java.sql.SQLException;
import service.DatabaseService;

public class DatabaseOpen {
	
	/**
	 * Opens the connection to
	 * the database using datas from a MysqlDataSource
	 * object
	 * @return A Connection object
	 * @throws SQLException
	 */
	public static void start(String dbName, String user, String password) {
		DatabaseService.getInstance().getDataSource().setDatabaseName(dbName);
		DatabaseService.getInstance().getDataSource().setUser(user);
		DatabaseService.getInstance().getDataSource().setPassword(password);
		System.out.println("Connection to database established.");
	}
	
	/**
	 * Closes the connection to a database
	 * @param connection The Connection object representing the database
	 * @throws SQLException
	 */
	public static void close(Connection connection) {
		try {
			connection.close();
			System.out.println("Connexion to database closed.");
			
		} catch (SQLException e) {
			System.out.println("No database to close.");
		}
	}
}
