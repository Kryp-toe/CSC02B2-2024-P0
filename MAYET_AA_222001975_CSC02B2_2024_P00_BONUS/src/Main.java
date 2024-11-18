import acsse.csc2b.gui.ConnectionPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		//Create pane instance
		ConnectionPane pane = new ConnectionPane();

		// Create the Scene
		Scene scene = new Scene(pane);

		// Set the Scene
		primaryStage.setScene(scene);
		primaryStage.setTitle("Port Connections");
		
		//set stage width and height
		primaryStage.setWidth(1250);
		primaryStage.setHeight(800);
		
		//show the stage
		primaryStage.show();
	}
}
