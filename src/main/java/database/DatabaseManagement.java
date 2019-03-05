package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DatabaseSource;

public class DatabaseManagement {
	
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection start() throws SQLException {
		Connection connection = DatabaseSource.getDataSource().getConnection();
		return connection;
	}
	
	
	public static void close(Connection connection) throws SQLException {
		connection.close();
	}
	
	public static ResultSet listPerson(Connection connection) throws SQLException {
		String allPerson = "SELECT * FROM person";
		PreparedStatement statement = connection.prepareStatement(allPerson);
		ResultSet resultSet = statement.executeQuery();
		return resultSet;
	}
	
	public static void add(Connection connection, String lastname, String firstname, String nickname, String phone_number, 
			String address, String email_address, String birth_date) throws SQLException {
		String addPerson = "INSERT INTO person(lastname, firstname, nickname, phone_number, address, email_address, birth_date) VALUES(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement statement = connection.prepareStatement(addPerson);
		statement.setString(1, lastname);
		statement.setString(2, firstname);
		statement.setString(3, nickname);
		statement.setString(4, phone_number);
		statement.setString(5, address);
		statement.setString(6, email_address);
		statement.setString(7, birth_date);
		int nbLines = statement.executeUpdate();
		System.out.println(nbLines + " line(s) have been modified.");
		statement.close();
	}
	
	public static void del(Connection connection, String lastname, String firstname) throws SQLException {
		String delPerson = "DELETE FROM person WHERE lastname = ? AND firstname = ?";
		PreparedStatement statement = connection.prepareStatement(delPerson);
		statement.setString(1, lastname);
		statement.setString(2, firstname);
		int nbLines = statement.executeUpdate();
		statement.close();
		System.out.println(nbLines + " line(s) have been modified.");
	}
}
