package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * Main is a java class that initializes the stage where the first/main scene of the program is shown.
 * 
 * @author Misael Paxtor(zlx030)
 */
public class Main extends Application {
	
	public static Stage stage;
	
	/**
     * Method: start
     * -------------
     * Main entry point for the application. Initializes the primary stage.
     *
     *      @param primaryStage: The primary stage for this application, onto
     *                           which the application scene can be set.
     *
     * Returns: N/A
     */
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("view/Login.fxml"));
			primaryStage.setScene(new Scene(root, 800, 800));
			primaryStage.show();
			
			stage = primaryStage;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
     * Method: main
     * ------------
     * Launches the application GUI.
     *
     * Returns: N/A
     */
	public static void main(String[] args) {
		launch(args);
	}
}
