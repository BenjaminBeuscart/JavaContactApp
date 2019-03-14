package database;

import java.sql.Connection;
import java.sql.SQLException;
import service.DatabaseService;

public class DatabaseOpen {
	
	/**
	 * Sets MySQLDatasource object's parameters
	 * @param dbName database name
	 * @param user	username
	 * @param password	password
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
