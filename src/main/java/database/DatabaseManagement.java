package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DatabaseSource;

public class DatabaseManagement {
	
	/* TODO Séquencer le script en plusieurs fichiers */
	
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
	
	/**
	 * Lists all people in the
	 * database
	 * @param connection The Connection object representing the database
	 * @return A ResultSet object containing the people
	 * @throws SQLException
	 */
	public static ResultSet listPerson(Connection connection) throws SQLException {
		String allPerson = "SELECT * FROM person";
		PreparedStatement statement = connection.prepareStatement(allPerson);
		ResultSet resultSet = statement.executeQuery();
		return resultSet;
	}
	
	/**
	 * Allows to add a person in the database
	 * @param connection The Connection object representing the database
	 * @param lastname Lastname of the person
	 * @param firstname Firstname or the person
	 * @param nickname Nickname of the person
	 * @param phone_number Phone number of the person
	 * @param address Address of the person
	 * @param email_address Email address of the person
	 * @param birth_date Birthdate of the person respecting this format YYYY-MM-DD
	 * @throws SQLException
	 */
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
	
	/**
	 * Allows to delete a person from the database taking her lastname and firstname
	 * @param connection The Connection object representing the database
	 * @param lastname Lastname of the person
	 * @param firstname Firstname of the person
	 * @throws SQLException
	 */
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
