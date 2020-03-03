package dad.javafx.calendario;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class CalendarioApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		CalendarioController a = new CalendarioController();
		
		Scene scene = new Scene(a.getView());
		
		primaryStage.getIcons().add(new Image(this.getClass().getResource("/images/calendar-16x16.png").toString()));
		primaryStage.setTitle("Calendario");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
