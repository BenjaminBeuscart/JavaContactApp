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
		StageService.getInstance().setPrimaryStage(primaryStage);
		showStartPage();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public static void showStartPage() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainUI.class.getResource("/view/startPageView.fxml"));
		AnchorPane rootLayout = loader.load();
		Scene scene = new Scene(rootLayout);
		Stage st = StageService.getInstance().getPrimaryStage();
		st.setScene(scene);
		st.show();
	}
	
	public static void showHomePage() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainUI.class.getResource("/view/homePageView.fxml"));
		AnchorPane rootLayout = loader.load();
		Scene scene = new Scene(rootLayout);
		Stage st = StageService.getInstance().getPrimaryStage();
		st.setScene(scene);
		st.show();
	}
}
