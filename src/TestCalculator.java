import java.io.IOException;
import java.util.Locale;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class TestCalculator extends Application{
	public static void main(String[] args) {
		launch(args);
	}
 
    @Override
    public void start(Stage primaryStage) throws IOException{
    	   Scene scene = new Scene(new StackPane());
    	   Locale.setDefault(Locale.ENGLISH);
           FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
           scene.setRoot(loader.load());
           scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Orbitron");
       		scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Play");

           primaryStage.setScene(scene);
           primaryStage.show();
    }
}