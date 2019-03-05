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
	private void onConnectionClick() throws IOException {
		setDbName(dbNameInput.getText());
		setUsername(usernameInput.getText());
		setPassword(passwordInput.getText());
		
		System.out.println("Database : " + dbName + ", username : " + username + ", password ? No :p");
	}
	
	@FXML
	private void addDb() throws SQLException {
		Connection connection = DatabaseManagement.start();
		DatabaseManagement.add(connection, "Beuscart", "Benjamin", "Ben", "0680053192", "16 clos des aquarelles 59211 Santes", "benjamin.beuscart@isen.yncrea.fr", "1996-09-02");
	}
}
