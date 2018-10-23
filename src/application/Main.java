package application;


import java.net.URISyntaxException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;



public class Main extends Application {

	static final double VOLUME = 1.07;
	ToggleGroup gameGroup;
	MediaPlayer mediaPlayer;
	Media hit;
	static ds3ClassOptimizer ds3class;

	public static void main(String[] args) {
		// Setting the ds3 optimizer object
		ds3class = new ds3ClassOptimizer();
		ds3class.setBasicStats();
		ds3class.storeTheBaseStats();
		ds3class.newLevelCreate();
		ds3class.newLevelSohrt();
		
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
			playSonudtrack("/Music/welcomemenu.mp3");

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
				playSonudtrack("/Music/ds3optimizer.mp3");
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
						//Addig feature buutons
						gameBox = gameTools(selectStatsButton, editStatsButton, showStartButton);
						optimizerPane.setCenter(gameBox);
						BorderPane.setMargin(gameBox, new Insets(80, 80, 80, 290));
					}
				}
			});

			// Handling DS3 buttons features
			selectStatsButton.setOnAction(e ->{
				
				primaryStage.setScene(selectScene);
			});


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
				playSonudtrack("/Music/welcomemenu.mp3");
				primaryStage.setScene(toolScene);
			});
			exitButton2.setOnAction(e -> Platform.exit());

			// =======================================================================================================================================================

			// Show a message for the feature

			Label fetureText = new Label("Enter your stats (0 if you dont care)");
			fetureText.getStyleClass().add("label1");
			HBox featureBox = new HBox();
			featureBox.getChildren().add(fetureText);
			selectPane.setTop(featureBox);
			BorderPane.setMargin(featureBox, new Insets(50, 80, 80, 30));

			// Showing the sorted classes bases on level

			// Cattegories  Class Name and Level Labels
			Label classText = new Label("Class");
			classText.getStyleClass().add("label2");
			Label levelText =new Label("Level");
			levelText.getStyleClass().add("label2");

			//Labels for showing class and level
			Label[] classArrayLabel;
			Label[] levelArrayLabel;

			// Setting the class pane grid
			GridPane showPane = new GridPane();
			showPane.setVgap(10);
			showPane.setHgap(35);			
			
			// Initialize the array of the labels
			classArrayLabel = new Label[ds3ClassOptimizer.NUMBER_OF_CLASSES];
			levelArrayLabel = new Label[ds3ClassOptimizer.NUMBER_OF_CLASSES];
			for(int j = 0 ; j < ds3ClassOptimizer.NUMBER_OF_CLASSES; j++) {
				classArrayLabel[j] = new Label(ds3class.getspecificAllClasses(ds3class.getSpecificClassPointer(j)).getName());
				levelArrayLabel[j] = new Label(String.valueOf(ds3class.getspecificAllClasses(ds3class.getSpecificClassPointer(j)).getSpecificStat(0))); 
				showPane.add(classArrayLabel[j], 0, j + 1);
				showPane.add(levelArrayLabel[j], 1, j + 1);
			}
			
			// Adding labels to grid
			showPane.add(classText, 0, 0);
			showPane.add(levelText, 1, 0);
			
			// Showing the name of the skills

			// Labels for skills
			Label statText = new Label("Stat");
			statText.getStyleClass().add("label2");
			Label currentText = new Label("Current");
			currentText.getStyleClass().add("label2");
			Label vgrText = new Label ("Vigor");
			Label attuText = new Label ("Attunement");
			Label endText = new Label ("Endurance");
			Label vitText = new Label ("Vitality");
			Label stgText = new Label ("Strength");
			Label dexText = new Label ("Dexterity");
			Label inteText = new Label ("Intelligence");
			Label fthText = new Label ("Faith");
			Label lckTect = new Label ("Luck");


			// Textfiled for stats
			TextField vgrField = new TextField();
			TextField attuField = new TextField();
			TextField endField = new TextField();
			TextField vitField = new TextField();
			TextField stgField = new TextField();
			TextField dexField = new TextField();
			TextField inteField = new TextField();
			TextField fthField = new TextField();
			TextField lckField = new TextField();

			// Layout for name of the skill and  for textfield of the stats user input here

			// Setting the Grid
			GridPane enterGPane = new GridPane();
			enterGPane.setVgap(10);
			enterGPane.setHgap(35);

			// Name of the cattegories
			enterGPane.add(statText, 0, 0);
			enterGPane.add(currentText, 1, 0);

			// Vigor 
			enterGPane.add(vgrText, 0, 1);
			enterGPane.add(vgrField, 1, 1);
			textFieldSettings(vgrField);
			// Extract and edit  user input
			vgrField.textProperty().addListener((observable, oldValue, newValue) -> {
				try{
					int vgr = Integer.parseInt(newValue);
					ds3class.newVigor(vgr);
					showShortStats(showPane, classArrayLabel, levelArrayLabel);
				}catch(NumberFormatException e) {
				}

			});

			// Attunement
			enterGPane.add(attuText, 0, 2);
			enterGPane.add(attuField, 1, 2);
			textFieldSettings(attuField);
			// Extract and edit  user input
			attuField.textProperty().addListener((observable, oldValue, newValue) -> {
				try{	
					int att = Integer.parseInt(newValue);;
					ds3class.newAttunemen(att);
					showShortStats(showPane, classArrayLabel, levelArrayLabel);
				}catch(NumberFormatException e) {
				}

			});

			// Endurance
			enterGPane.add(endText, 0, 3);
			enterGPane.add(endField, 1, 3);
			textFieldSettings(endField);
			// Extract and edit  user input
			endField.textProperty().addListener((observable, oldValue, newValue) -> {
				try{
					int end = Integer.parseInt(newValue);
					ds3class.newEndurance(end);
					showShortStats(showPane, classArrayLabel, levelArrayLabel);
				}catch(NumberFormatException e) {
				}
			});

			// Vitality
			enterGPane.add(vitText, 0, 4);
			enterGPane.add(vitField, 1, 4);
			textFieldSettings(vitField);
			// Extract and edit  user input
			vitField.textProperty().addListener((observable, oldValue, newValue) -> {
				try{	
					int vit = Integer.parseInt(newValue);
					ds3class.newVitality(vit);
					showShortStats(showPane, classArrayLabel, levelArrayLabel);
				}catch(NumberFormatException e) {
				}
			});

			// Strength
			enterGPane.add(stgText, 0, 5);
			enterGPane.add(stgField, 1, 5);
			textFieldSettings(stgField);
			// Extract and edit  user input
			stgField.textProperty().addListener((observable, oldValue, newValue) -> {
				try{	
					int stg = Integer.parseInt(newValue);
					ds3class.newStrentgh(stg);
					showShortStats(showPane, classArrayLabel, levelArrayLabel);
				}catch(NumberFormatException e) {
				}

			});

			// Dexterity	
			enterGPane.add(dexText, 0, 6);
			enterGPane.add(dexField, 1, 6);
			textFieldSettings(dexField);
			// Extract and edit  user input
			dexField.textProperty().addListener((observable, oldValue, newValue) -> {
				try{	
					int dex = Integer.parseInt(newValue);
					ds3class.newDexterity(dex);
					showShortStats(showPane, classArrayLabel, levelArrayLabel);
				}catch(NumberFormatException e) {
				}	
			});

			// Intelligence
			enterGPane.add(inteText, 0, 7);
			enterGPane.add(inteField, 1, 7);
			textFieldSettings(inteField);
			// Extract and edit  user input
			inteField.textProperty().addListener((observable, oldValue, newValue) -> {
				try{	
					int inte = Integer.parseInt(newValue);
					ds3class.newIntelligence(inte);
					showShortStats(showPane, classArrayLabel, levelArrayLabel);
				}catch(NumberFormatException e) {
				}	
			});

			// Faith
			enterGPane.add(fthText, 0, 8);
			enterGPane.add(fthField, 1, 8);
			textFieldSettings(fthField);
			// Extract and edit  user input
			fthField.textProperty().addListener((observable, oldValue, newValue) -> {
				try{	
					int fth = Integer.parseInt(newValue);
					ds3class.newFaith(fth);
					showShortStats(showPane, classArrayLabel, levelArrayLabel);
				}catch(NumberFormatException e) {
				}
			});

			// Luck
			enterGPane.add(lckTect, 0, 9);
			enterGPane.add(lckField, 1, 9);
			textFieldSettings(lckField);
			// Extract and edit  user input
			lckField.textProperty().addListener((observable, oldValue, newValue) -> {
				try{	
					int lck = Integer.parseInt(newValue);
					ds3class.newLuck(lck);
					showShortStats(showPane, classArrayLabel, levelArrayLabel);
				}catch(NumberFormatException e) {
				}
			});

			// Adding the gridPane
			selectPane.setLeft(enterGPane);
			BorderPane.setMargin(enterGPane, new Insets(0, 80, 80, 30));

			

			//Adding the grid
			selectPane.setCenter(showPane);


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


			// Add custom styles
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


	// Soundtrack function
	public void playSonudtrack(String bip) {
		try {
			hit= new Media(getClass().getResource(bip).toURI().toString());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
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

	// Size of textfields
	public  void textFieldSettings(TextField field) {
		field.setMaxWidth(33);
		field.setSnapToPixel(false);// The textfield dont resize and hide and the user input
		field.setOnKeyTyped(event ->{
			// Only nunbers inmput 0-9
			char input = event.getCharacter().charAt(0);
			if (Character.isDigit(input) != true) {
				event.consume();
			}

			// Only 2 numbers
			int maxCharacters = 1;
			if(field.getText().length() > maxCharacters) {
				event.consume();
			}
		});
	}
	
	public void showShortStats(GridPane showPane,Label[] classArrayLabel, Label[] levelArrayLabel) {
		ds3class.newLevelCreate();
		ds3class.newLevelSohrt();
		for(int j = 0 ; j < ds3ClassOptimizer.NUMBER_OF_CLASSES; j++) {
			int pointer = ds3class.getSpecificClassPointer(j);
			showPane.getChildren().remove(classArrayLabel[j]);
			showPane.getChildren().remove(levelArrayLabel[j]);
			classArrayLabel[j] = new Label(ds3class.getspecificAllClasses(pointer).getName());
			levelArrayLabel[j] = new Label(String.valueOf(ds3class.getspecificAllClasses(pointer).getSpecificStat(0)));
			showPane.add(classArrayLabel[j], 0, j + 1);
			showPane.add(levelArrayLabel[j], 1, j + 1);
	
		}
	}	
}
