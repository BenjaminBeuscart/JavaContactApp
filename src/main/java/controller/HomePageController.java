package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import database.DatabaseOpen;
import database.DatabaseRequest;
import export.Export;
import factory.AddressValueFactory;
import factory.BirthdateValueFactory;
import factory.EmailValueFactory;
import factory.FirstnameValueFactory;
import factory.IdValueFactory;
import factory.LastnameValueFactory;
import factory.NicknameValueFactory;
import factory.PhonenumberValueFactory;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import main.ContactApp;
import model.Person;
import service.DatabaseService;
import service.PersonService;

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
	private void addDb() throws SQLException {
		Connection connection = DatabaseService.getInstance().getDataSource().getConnection();
		DatabaseRequest.add(connection, lastnameInput.getText(), firstnameInput.getText(), nicknameInput.getText(), phoneInput.getText(), addressInput.getText(), emailInput.getText(), birthdateInput.getText());
		this.resetList();
	}
	/*----- Adding part -----*/
	
	/*----- Deleting part -----*/
	@FXML
	private TextField delLastnameInput;
	@FXML
	private TextField delFirstnameInput;
	@FXML
	private void delDb() throws SQLException {
		Connection connection = DatabaseService.getInstance().getDataSource().getConnection();
		DatabaseRequest.del(connection, delLastnameInput.getText(), delFirstnameInput.getText());
		this.resetList();
	}
	/*----- Deleting part -----*/
	
	/*----- Listing part -----*/
	@FXML
	private TableView<Person> listPerson;
	@FXML
	private TableColumn<Person, String> idColumn;
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
	
	private void populateList() {
		this.listPerson.setItems(PersonService.getPersons());
		this.resetList();
	}
	
	@FXML
	private void initialize() {
		this.addressColumn.setCellValueFactory(new AddressValueFactory());
		this.emailColumn.setCellValueFactory(new EmailValueFactory());
		this.birthdateColumn.setCellValueFactory(new BirthdateValueFactory());
		this.phoneColumn.setCellValueFactory(new PhonenumberValueFactory());
		this.nicknameColumn.setCellValueFactory(new NicknameValueFactory());
		this.lastnameColumn.setCellValueFactory(new LastnameValueFactory());
		this.firstnameColumn.setCellValueFactory(new FirstnameValueFactory());
		this.idColumn.setCellValueFactory(new IdValueFactory());
		this.populateList();
	}
	/*----- Listing part -----*/
	
	/*----- Export part -----*/
	@FXML
	private void vcardExport() throws IOException {
		Export.vcardsCreate(PersonService.getPersons());
	}
	/*----- Export part -----*/
	
	/*----- Refresh part -----*/
	@FXML
	private void refreshView() {
		ContactApp.showHomePage();
		System.out.println("Page refreshed !");
	}
	
	/**
	 * Resets the list of person
	 * i.e. actualize the layout of the list
	 */
	private void resetList() {
		this.listPerson.refresh();
		this.listPerson.getSelectionModel().clearSelection();
	}
	/*----- Refresh part -----*/
	
	/*----- Disconnection part -----*/
	@FXML
	private void onDisconnectClick() throws SQLException {
		DatabaseOpen.close(DatabaseService.getInstance().getDataSource().getConnection());
		ContactApp.showStartPage();
	}
	/*----- Disconnection part -----*/
}
