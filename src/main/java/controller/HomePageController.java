package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DatabaseOpen;
import database.DatabaseRequest;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import main.ContactApp;
import model.Person;

public class HomePageController {

	/*----- Adding part -----*/
	@FXML
	private TextField lastnameInput;
	@FXML
	private TextField firstnameInput;
	@FXML
	private TextField nicknameInput;
	@FXML
	private TextField phoneInput;
	@FXML
	private TextField addressInput;
	@FXML
	private TextField emailInput;
	@FXML
	private TextField birthdateInput;
	@FXML
	private void addDb() {
		Connection connection = DatabaseOpen.start();
		DatabaseRequest.add(connection, lastnameInput.getText(), firstnameInput.getText(), nicknameInput.getText(), phoneInput.getText(), addressInput.getText(), emailInput.getText(), birthdateInput.getText());
		refresh();
	}
	/*----- Adding part -----*/
	
	/*----- Deleting part -----*/
	@FXML
	private TextField delLastnameInput;
	@FXML
	private TextField delFirstnameInput;
	@FXML
	private void delDb() {
		Connection connection = DatabaseOpen.start();
		DatabaseRequest.del(connection, delLastnameInput.getText(), delFirstnameInput.getText());
		refresh();
	}
	/*----- Deleting part -----*/
	
	/*----- Listing part -----*/
	@FXML
	private TableView<Person> listPerson;
	@FXML
	private TableColumn<Person, Integer> idColumn;
	@FXML
	private TableColumn<Person, String> lastnameColumn;
	@FXML
	private TableColumn<Person, String> firstnameColumn;
	@FXML
	private TableColumn<Person, String> nicknameColumn;
	@FXML
	private TableColumn<Person, String> phoneColumn;
	@FXML
	private TableColumn<Person, String> addressColumn;
	@FXML
	private TableColumn<Person, String> emailColumn;
	@FXML
	private TableColumn<Person, String> birthdateColumn;
	@FXML
	private void initialize() {
		try {
			Connection connection = DatabaseOpen.start();
			ResultSet setPerson = DatabaseRequest.listPerson(connection);
			ArrayList<Person> alistPerson = new ArrayList<Person>();
			while (setPerson.next()) {
				alistPerson.add(new Person(setPerson.getInt(1), setPerson.getString(2), setPerson.getString(3), setPerson.getString(4), setPerson.getString(5), setPerson.getString(6), setPerson.getString(7), setPerson.getString(8)));
			}
			ObservableList<Person> olistPerson = FXCollections.observableArrayList(alistPerson);
			listPerson.setItems(olistPerson);
		} catch (SQLException e) {
			System.out.println("Maybe null pointer error ?");
		};
	}
	/*----- Listing part -----*/
	
	/*----- Refresh part -----*/
	@FXML
	private void refresh() {
		ContactApp.showHomePage();
		System.out.println("Page refreshed !");
	}
	/*----- Refresh part -----*/
	
	/*----- Disconnection part -----*/
	@FXML
	private void onDisconnectClick() {
		ContactApp.showStartPage();
	}
	/*----- Disconnection part -----*/
}
