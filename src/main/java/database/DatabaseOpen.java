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
	public static Connection start() throws SQLException {
		Connection connection = DatabaseSource.getDataSource().getConnection();
		return connection;
	}
	
	/**
	 * Closes the connection to a database
	 * @param connection The Connection object representing the database
	 * @throws SQLException
	 */
	public static void close(Connection connection) throws SQLException {
		connection.close();
	}
}
