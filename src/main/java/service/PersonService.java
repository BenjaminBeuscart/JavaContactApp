package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DatabaseRequest;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Person;

public class PersonService {
	private ObservableList<Person> persons;
	
	public PersonService() {
		try {
			persons = FXCollections.observableArrayList();
			Connection connection = DatabaseService.getInstance().getDataSource().getConnection();
			ResultSet setPerson = DatabaseRequest.listPerson(connection);
			while (setPerson.next()) {
				persons.add(new Person(setPerson.getString(1), setPerson.getString(2), setPerson.getString(3), setPerson.getString(4), setPerson.getString(5), setPerson.getString(6), setPerson.getString(7), setPerson.getString(8)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ObservableList<Person> getPersons() {
		return PersonServiceHolder.INSTANCE.persons;
	}
	
	public static void addPerson(Person person) {
		PersonServiceHolder.INSTANCE.persons.add(person);
	}
	
	private static class PersonServiceHolder {
		private static final PersonService INSTANCE = new PersonService();
	}
}
