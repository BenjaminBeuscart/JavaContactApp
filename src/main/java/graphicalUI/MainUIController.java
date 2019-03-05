package graphicalUI;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DatabaseOpen;
import database.DatabaseRequest;
import database.Person;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MainUIController {
	
	private String dbName;
	private String username;
	private String password;
	
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@FXML
	private TextField dbNameInput;
	@FXML
	private TextField usernameInput;
	@FXML
	private TextField passwordInput;
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
	
	/* TODO onConnectionClick changer de scene et garder en mémoire les Id de la bdd */
	@FXML
	private void onConnectionClick() throws IOException, SQLException {
		setDbName(dbNameInput.getText());
		setUsername(usernameInput.getText());
		setPassword(passwordInput.getText());
		
		Connection connection = DatabaseOpen.start();
		
		System.out.println("Database : " + dbName + ", username : " + username + ", password ? No :p");
		
		ResultSet setPerson = DatabaseRequest.listPerson(connection);
		ArrayList<Person> alistPerson = new ArrayList<Person>();
		int i = 0;
		while (setPerson.next()) {
			alistPerson.set(i, new Person(setPerson.getInt(1), setPerson.getString(2), setPerson.getString(3), setPerson.getString(4), setPerson.getString(5), setPerson.getString(6), setPerson.getString(7), setPerson.getString(8)));
			System.out.println(alistPerson.get(i).getEmail());
			i++;
		};
	}
	
	@FXML
	private void addDb() throws SQLException {
		Connection connection = DatabaseOpen.start();
		DatabaseRequest.add(connection, lastnameInput.getText(), firstnameInput.getText(), nicknameInput.getText(), phoneInput.getText(), addressInput.getText(), emailInput.getText(), birthdateInput.getText());
	}
	
	
	
	
	
	@FXML
	private TableView<Person> listPerson;
	
	@FXML
	private void initialize() {
		
	}
}
