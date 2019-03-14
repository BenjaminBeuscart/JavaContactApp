package controller;

import database.DatabaseOpen;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import main.ContactApp;

public class StartPageController {
	
	/*----- Connection part -----*/
	@FXML
	private TextField dbNameInput;
	@FXML
	private TextField usernameInput;
	@FXML
	private TextField passwordInput;
	@FXML
	private void onConnectionClick() {
			DatabaseOpen.start(dbNameInput.getText(), usernameInput.getText(), passwordInput.getText());
			ContactApp.showHomePage();
	}
	/*----- Connection part -----*/
	
	
	
	
	
	
	
	
}
