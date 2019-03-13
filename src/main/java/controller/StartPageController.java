package controller;

import java.io.IOException;

import export.Export;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import main.ContactApp;

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
	
	/*----- Connection part -----*/
	@FXML
	private TextField dbNameInput;
	@FXML
	private TextField usernameInput;
	@FXML
	private TextField passwordInput;	
	/* TODO onConnectionClick garder en mémoire les Id de la bdd */
	@FXML
	private void onConnectionClick() {
		setDbName(dbNameInput.getText());
		setUsername(usernameInput.getText());
		setPassword(passwordInput.getText());
		
		System.out.println("Database : " + dbName + ", username : " + username + ", password : " + password);
		ContactApp.showHomePage();
	}
	/*----- Connection part -----*/
	
	
	
	
	
	
	
	
}
