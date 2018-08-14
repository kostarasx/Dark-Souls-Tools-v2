package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
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
			
			//add background photo
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			//Press any key to continue feature go to M
			scene.setOnKeyPressed(e -> System.out.println("Test"));
			scene.setOnMousePressed(e ->System.out.println("Test" ));
			
			//Show the scene 
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);//Cant resized
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
