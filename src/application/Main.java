package application;

import java.nio.file.Paths;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Main extends Application {

	static final double VOLUME = 0.07;
	MediaPlayer mediaPlayer;
	Media hit;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			//Welcome Menu 

			//Creating the Welcome Menu scene
			BorderPane welcomeMenu = new BorderPane();
			Scene welocmeScene = new Scene(welcomeMenu,800,800);

			//Select tool scene
			BorderPane toolMenu = new BorderPane();
			Scene toolScene =new Scene(toolMenu,800,800);

			//Class optimizer Scene
			BorderPane classoptimizer = new BorderPane();
			Scene optimizerScene =new Scene(classoptimizer,800,800);

			//Welcome Menu scene

			//Soundtrack Main Menu
			playSonudtrack("Music/welcomemenu.mp3");
			
			//Press any key to continue feature go to Main Menu
			StackPane firstLayout = new StackPane();
			Label  startingText = new Label("PRESS ANY BUTTON TO CONTINUE");
			firstLayout.getChildren().add(startingText);
			welcomeMenu.setCenter(firstLayout);
			BorderPane.setMargin(firstLayout, new Insets(120,80,80,120));
			welocmeScene.setOnKeyPressed(e -> primaryStage.setScene(toolScene));
			welocmeScene.setOnMousePressed(e -> primaryStage.setScene(toolScene));


			//Tools scene

			//Button for tools
			Button classOptimizerButton  = new Button("Class Optimizer");
			Button backButton = new Button("Back");
			Button exitButton = new Button("Exit");

			//Tools menu
			VBox toolsLayout = new VBox();
			Label selectToolText = new Label("Select Tool");
			toolsLayout.setSpacing(8);
			toolsLayout.getChildren().addAll(selectToolText,classOptimizerButton);
			toolMenu.setCenter(toolsLayout);
			BorderPane.setMargin(toolsLayout, new Insets(300,80,80,330));

			//Exit and back layout
			HBox backExit = new HBox();
			backExit.getChildren().addAll(backButton, exitButton);
			backExit.setSpacing(8);
			toolMenu.setBottom(backExit);
			BorderPane.setMargin(backExit, new Insets(120,80,80,600));

			//Event handling buttons
			classOptimizerButton.setOnAction(e -> {
				//Change the soundtrack
				mediaPlayer.pause();
				playSonudtrack("Music/ds3optimizer.mp3");
				primaryStage.setScene(optimizerScene);
			});
			backButton.setOnAction(e -> primaryStage.setScene(welocmeScene));
			exitButton.setOnAction(e -> Platform.exit());

			//Class Optimizer scene
			
			//Games Menu
			
			
			
			//add custom styles 
			welocmeScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			toolScene.getStylesheets().add(getClass().getResource("MainMenu.css").toExternalForm());
			optimizerScene.getStylesheets().add(getClass().getResource("MainMenu.css").toExternalForm());

			//Set and showing the Welocme Menu scene
			primaryStage.setTitle("Dark Souls Tools");
			primaryStage.setScene(welocmeScene);
			primaryStage.setResizable(false);//Cant resized
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}


	}
	
	public void playSonudtrack(String bip) {
		hit = new Media(Paths.get(bip).toUri().toString());
		mediaPlayer = new MediaPlayer(hit);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		mediaPlayer.setVolume(VOLUME);
		mediaPlayer.play();
	}
	
}


