package application;


import java.nio.file.Paths;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;



public class Main extends Application {

	static final double VOLUME = 0.07;
	ToggleGroup gameGroup;
	MediaPlayer mediaPlayer;
	Media hit;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			// Welcome Menu

			// 0.Creating the Welcome Menu scene
			BorderPane welcomePane = new BorderPane();
			Scene welocmeScene = new Scene(welcomePane, 800, 800);

			// 1.Select tool scene
			BorderPane toolPane = new BorderPane();
			Scene toolScene = new Scene(toolPane, 800, 800);

			// 2.Class optimizer Scene
			BorderPane optimizerPane = new BorderPane();
			Scene optimizerScene = new Scene(optimizerPane, 800, 800);
			
			// 2.a DS3 select stats scene
			BorderPane selectPane = new BorderPane();
			Scene selectScene = new Scene(selectPane, 800,800);

			// =======================================================================================================================================================

			// Welcome Menu scene

			// Soundtrack Main Menu
			playSonudtrack("Music/welcomemenu.mp3");

			// Press any key to continue feature go to Main Menu
			StackPane firstLayout = new StackPane();
			Label startingText = new Label("PRESS ANY BUTTON TO CONTINUE");
			firstLayout.getChildren().add(startingText);
			welcomePane.setCenter(firstLayout);
			BorderPane.setMargin(firstLayout, new Insets(120, 80, 80, 120));
			welocmeScene.setOnKeyPressed(e -> primaryStage.setScene(toolScene));
			welocmeScene.setOnMousePressed(e -> primaryStage.setScene(toolScene));

			// =======================================================================================================================================================

			// Tools scene

			// Button for tools
			Button optimizerPaneButton = new Button("Class Optimizer");

			// Buttons for back and exit
			Button backButton = new Button("Back");
			Button exitButton = new Button("Exit");

			// Tools layout
			VBox toolsLayout = new VBox();
			Label selectToolText = new Label("Select Tool");
			toolsLayout.setSpacing(8);
			toolsLayout.getChildren().addAll(selectToolText, optimizerPaneButton);
			toolPane.setCenter(toolsLayout);
			BorderPane.setMargin(toolsLayout, new Insets(300, 80, 80, 330));

			// Event handling tools buttons
			optimizerPaneButton.setOnAction(e -> {
				// Change the soundtrack
				mediaPlayer.stop();
				playSonudtrack("Music/ds3optimizer.mp3");
				primaryStage.setScene(optimizerScene);
			});

			// Back and exit layout
			HBox backExit = new HBox();
			backExit.getChildren().addAll(backButton, exitButton);
			backExit.setSpacing(8);
			toolPane.setBottom(backExit);
			BorderPane.setMargin(backExit, new Insets(120, 80, 80, 600));

			// Handling the back and exit buttons
			backButton.setOnAction(e -> primaryStage.setScene(welocmeScene));
			exitButton.setOnAction(e -> Platform.exit());

			// ======================================================================================================================================================

			// Class Optimizer scene

			// Games layout

			// Create radio buttons for games
			RadioButton ds1Button = new RadioButton("Dark Souls");
			RadioButton ds2Button = new RadioButton("Dark Souls II");
			RadioButton ds3Button = new RadioButton("Dark Souls III");

			// Creating radiobutton group and layout
			gameGroup = new ToggleGroup();
			gameGroup.getToggles().addAll(ds1Button, ds2Button, ds3Button);
			ds1Button.setSelected(true);
			Label selectGameText = new Label("                  Select game");
			HBox gameButtons = new HBox();
			gameButtons.getChildren().addAll(ds1Button, ds2Button, ds3Button);
			gameButtons.setSpacing(30);
			VBox selectGame = new VBox();
			selectGame.getChildren().addAll(selectGameText, gameButtons);
			selectGame.setPadding(new Insets(40, 80, 80, 200));
			selectGame.setSpacing(15);
			optimizerPane.setTop(selectGame);

			// Buttons for optimizer tool
			Button selectStatsButton = new Button("Select your prefered stats");
			Button editStatsButton = new Button("Edit stats");
			Button showStartButton = new Button("Select class and show starting stat");

			// Handling radio buttons
			gameGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
				public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
					VBox gameBox = new VBox();
					selectGame.setSpacing(15);
					if (gameGroup.getSelectedToggle() == ds3Button) {
						gameBox = gameTools(selectStatsButton, editStatsButton, showStartButton);
						optimizerPane.setCenter(gameBox);
						BorderPane.setMargin(gameBox, new Insets(80, 80, 80, 290));
					}
				}
			});
			
			// Handling DS3 buttons features
			selectStatsButton.setOnAction(e -> primaryStage.setScene(selectScene));
			
			
			// Back exit layout
			Button backButton2 = new Button("Back");
			Button exitButton2 = new Button("Exit");
			HBox backExit2 = new HBox();
			backExit2.getChildren().addAll(backButton2, exitButton2);
			backExit2.setSpacing(8);
			optimizerPane.setBottom(backExit2);
			BorderPane.setMargin(backExit2, new Insets(120, 80, 80, 600));

			// Handling back and exit buttons
			backButton2.setOnAction(e -> {
				mediaPlayer.stop();
				playSonudtrack("Music/welcomemenu.mp3");
				primaryStage.setScene(toolScene);
			});
			exitButton2.setOnAction(e -> Platform.exit());

			// =======================================================================================================================================================

			//Show a message for the feature
			
			Label fetureText = new Label("Enter your stats (0 if you dont care)");
			fetureText.getStyleClass().add("label1");
			HBox featureBox = new HBox();
			featureBox.getChildren().add(fetureText);
			selectPane.setTop(featureBox);
			BorderPane.setMargin(featureBox, new Insets(50, 80, 80, 30));
			
			//Showing the name of the skills
			
			//Labels for skills
			Label vgrText = new Label ("Vigor");
			Label attuText = new Label ("Attunement");
			Label endText = new Label ("Endurance");
			Label vitText = new Label ("Vitality");
			Label stgText = new Label ("Strength");
			Label dexText = new Label ("Dexterity");
			Label inteText = new Label ("Intelligence");
			Label fthText = new Label ("Faith");
			Label lckTect = new Label ("Luck");
			
			
			//Textfiled for stats
			TextField vgrField = new TextField();
			TextField attuField = new TextField();
			TextField endField = new TextField();
			TextField vitField = new TextField();
			TextField stgField = new TextField();
			TextField dexField = new TextField();
			TextField inteField = new TextField();
			TextField fthField = new TextField();
			TextField lckField = new TextField();
			
			//Layout for name of the skill and  for textfield of the stats user input here
			GridPane enterGPane = new GridPane();
			enterGPane.setVgap(10);
			enterGPane.setHgap(10);
			enterGPane.add(vgrText, 0, 0);
			enterGPane.add(vgrField, 1, 0);
			vgrField.setPrefSize(40, 0);
			vgrField.setMaxWidth(40);
			selectPane.setLeft(enterGPane);

			// Back exit layout
			Button backButton3 = new Button("Back");
			Button exitButton3 = new Button("Exit");
			HBox backExit3 = new HBox();
			backExit3.getChildren().addAll(backButton3, exitButton3);
			backExit3.setSpacing(8);
			selectPane.setBottom(backExit3);
			BorderPane.setMargin(backExit3, new Insets(120, 80, 80, 600));

			// Handling back and exit buttons
			backButton3.setOnAction(e -> primaryStage.setScene(optimizerScene));
			exitButton3.setOnAction(e -> Platform.exit());
			
			
			// ======================================================================================================================================================

			
			// add custom styles
			welocmeScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			toolScene.getStylesheets().add(getClass().getResource("MainMenu.css").toExternalForm());
			optimizerScene.getStylesheets().add(getClass().getResource("MainMenu.css").toExternalForm());
			selectScene.getStylesheets().add(getClass().getResource("Optimizer.css").toExternalForm());
			
			
			// Set and showing the Welocme Menu scene
			primaryStage.setTitle("Dark Souls Tools");
			primaryStage.setScene(welocmeScene);
			primaryStage.setResizable(false);// Cant resized
			primaryStage.show();

			
			
		} catch (Exception e) {
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

	// Event handling radio button fuction
	public VBox gameTools(Button selectButton, Button editButton, Button showButton) {
		VBox tempBox = new VBox();
		tempBox.getChildren().addAll(selectButton, editButton, showButton);
		tempBox.setSpacing(15);
		return tempBox;
	}
}
