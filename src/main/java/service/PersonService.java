package service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Person;

public class PersonService {
	private ObservableList<Person> persons;
	
	public PersonService() {
		persons = FXCollections.observableArrayList();
		// Constructeur ou on remplis la liste persons avec les objets Person récup du resultset de la requete dans la bdd
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
