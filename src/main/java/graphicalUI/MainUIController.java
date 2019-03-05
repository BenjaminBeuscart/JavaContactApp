package graphicalUI;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import database.DatabaseManagement;
import javafx.fxml.FXML;
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
		
		Connection connection = DatabaseManagement.start();
		
		System.out.println("Database : " + dbName + ", username : " + username + ", password ? No :p");
	}
	
	@FXML
	private void addDb() throws SQLException {
		Connection connection = DatabaseManagement.start();
		DatabaseManagement.add(connection, lastnameInput.getText(), firstnameInput.getText(), nicknameInput.getText(), phoneInput.getText(), addressInput.getText(), emailInput.getText(), birthdateInput.getText());
	}
}
