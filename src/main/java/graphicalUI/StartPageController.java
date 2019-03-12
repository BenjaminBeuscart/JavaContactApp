package graphicalUI;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import database.DatabaseOpen;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javafx.stage.Stage;


public class StartPageController {
	
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
	
	
	/* TODO onConnectionClick changer de scene et garder en mémoire les Id de la bdd */
	@FXML
	private void onConnectionClick() throws IOException, SQLException {
		setDbName(dbNameInput.getText());
		setUsername(usernameInput.getText());
		setPassword(passwordInput.getText());
		
		Connection connection = DatabaseOpen.start();
		
		System.out.println("Database : " + dbName + ", username : " + username + ", password : " + password);
		MainUI.showHomePage();
	}
	
	
	
	
	
	
	
	
}
