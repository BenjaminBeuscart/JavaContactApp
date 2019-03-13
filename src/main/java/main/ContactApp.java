package main;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import service.StageService;

public class ContactApp extends Application {
	
	/* TODO Gérer le passage entre deux scene */
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("ContactApp");
		StageService.getInstance().setPrimaryStage(primaryStage);
		showStartPage();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public static void showStartPage() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ContactApp.class.getResource("/view/startPageView.fxml"));
			AnchorPane rootLayout;
			rootLayout = loader.load();
			Scene scene = new Scene(rootLayout);
			Stage st = StageService.getInstance().getPrimaryStage();
			st.setScene(scene);
			st.show();
		} catch (IOException e) {
			System.out.println("No startPageView.xml file existing.");
		}
	}
	
	public static void showHomePage() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ContactApp.class.getResource("/view/homePageView.fxml"));
			AnchorPane rootLayout;
			rootLayout = loader.load();
			Scene scene = new Scene(rootLayout);
			Stage st = StageService.getInstance().getPrimaryStage();
			st.setScene(scene);
			st.show();
		} catch (IOException e) {
			System.out.println("No homePageView.xml file existing.");
		}
	}
}
