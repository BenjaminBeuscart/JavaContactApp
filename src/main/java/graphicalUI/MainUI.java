package graphicalUI;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainUI extends Application {
	
	/* TODO Gérer le passage entre deux scene */
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		primaryStage.setTitle("ContactApp");
		showStartPage(primaryStage);
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public static void showStartPage(Stage stage) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainUI.class.getResource("/view/homePageView.fxml"));
		AnchorPane rootLayout = loader.load();
		Scene scene = new Scene(rootLayout);
		stage.setScene(scene);
		stage.show();
	}
}
