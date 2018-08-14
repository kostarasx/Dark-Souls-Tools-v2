package application;

import java.nio.file.Paths;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Main extends Application {
		
	MediaPlayer mediaPlayer;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			//Welcome Menu 
			
			//Creating the layout
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,800,800);

			//Soundtrack
			String bip = "Music/welcomemenu.mp3";
			Media hit = new Media(Paths.get(bip).toUri().toString());
			mediaPlayer = new MediaPlayer(hit);
			mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
			mediaPlayer.setVolume(0.07);
			mediaPlayer.play();
			
			
			//Press any key to continue feature go to Main Menu
			StackPane stack = new StackPane();
			Label  startingText = new Label("PRESS ANY BUTTON TO CONTINUE");
			root.setCenter(stack);
			BorderPane.setMargin(stack, new Insets(120,80,80,120));
			stack.getChildren().add(startingText);

			scene.setOnKeyPressed(e -> System.out.println("Test"));
			scene.setOnMousePressed(e ->System.out.println("Test" ));

			//add custom styles 
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			//Set and showing the scene
			primaryStage.setTitle("Dark Souls Tools");
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);//Cant resized
			primaryStage.show();


		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}


