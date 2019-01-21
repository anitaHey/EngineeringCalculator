import java.io.IOException;
import java.util.Locale;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
 
public class Calculator implements ControlledStage{
	private Parent root;
	public Calculator() throws IOException{
		root = FXMLLoader.load(getClass().getResource("calculator_gui.fxml"));
		Scene scene = new Scene(root);
	}
	 @Override
	    public Parent getContent() {
	        return root;
	    }
	
}