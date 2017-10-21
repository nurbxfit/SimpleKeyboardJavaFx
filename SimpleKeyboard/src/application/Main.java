package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;


public class Main extends Application {
	@Override
	//in Main we just setup our Stage, check other code for control and event handler.
	public void start(Stage primaryStage) {
		try {
			
			//Dia create satu kotak untuk UI.
			// details dalam kotak untuk UI kita tu dia ambik dri sample.fxml
			//to use KeyLayout.java uncomment code below.
			//BorderPane root = new BorderPane();
			//KeyLayout key = new KeyLayout();
			//root.getChildren().addAll(key.view());
			//root.setAlignment(key.view(), Pos.CENTER);
			
			//then comment this code below that load resource from "sample.fxml"
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			
			//set size untuk kotak yang nk handle UI
			Scene scene = new Scene(root,520,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Simple Keyboard");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
