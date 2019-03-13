package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseRequest {

	/**
	 * Lists all people in the
	 * database
	 * @param connection The Connection object representing the database
	 * @return A ResultSet object containing the people
	 * @throws SQLException
	 */
	public static ResultSet listPerson(Connection connection) {
		ResultSet resultSet = null;
		try {
			String allPerson = "SELECT * FROM person";
			PreparedStatement statement = connection.prepareStatement(allPerson);
			resultSet = statement.executeQuery();
		} catch (SQLException e) {
			System.out.println("No connection instance existing.");
		}
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
			String address, String email_address, String birth_date) {
		try {
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
		} catch (SQLException e) {
			System.out.println("Form not completely filled.");
		}
	}
	
	/* TODO Méthode pour modifier une ligne de la table person */
	
	/**
	 * Allows to delete a person from the database taking her lastname and firstname
	 * @param connection The Connection object representing the database
	 * @param lastname Lastname of the person
	 * @param firstname Firstname of the person
	 * @throws SQLException
	 */
	public static void del(Connection connection, String lastname, String firstname) {
		try {
			String delPerson = "DELETE FROM person WHERE lastname = ? AND firstname = ?";
			PreparedStatement statement = connection.prepareStatement(delPerson);
			statement.setString(1, lastname);
			statement.setString(2, firstname);
			int nbLines = statement.executeUpdate();
			statement.close();
			System.out.println(nbLines + " line(s) have been modified.");
		} catch (SQLException e) {
			System.out.println("No connection instance existing.");
		}
	}
}
