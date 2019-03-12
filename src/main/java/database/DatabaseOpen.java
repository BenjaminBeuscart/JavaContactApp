package database;

import java.sql.Connection;
import java.sql.SQLException;
import database.DatabaseSource;

public class DatabaseOpen {
	
	/**
	 * Opens the connection to
	 * the database using datas from a MysqlDataSource
	 * object
	 * @return A Connection object
	 * @throws SQLException
	 */
	public static Connection start() {
		Connection connection = null;
		try {
			connection = DatabaseSource.getDataSource().getConnection();
			System.out.println("Connection to database established.");
		} catch (SQLException e) {
			System.out.println("Wrong name, user or password.");
		}
		return connection;
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
