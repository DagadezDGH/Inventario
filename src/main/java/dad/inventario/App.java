package dad.inventario;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("Inventario");
		Controller controller = new Controller();
		Scene scene = new Scene(controller.getView(), 500, 320);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		
		launch(args);
	}

}
