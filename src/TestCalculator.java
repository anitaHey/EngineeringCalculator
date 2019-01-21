import java.io.IOException;
import java.util.Locale;

import javax.swing.event.ChangeListener;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;

public class TestCalculator extends Application{
	TabPane tab;
	Scene scene;
	Tab capacity;
	public static void main(String[] args) {
		launch(args);
	}
 
    @Override
    public void start(Stage primaryStage) throws IOException{

    Locale.setDefault(Locale.ENGLISH);
	Parent root = FXMLLoader.load(getClass().getResource("Gui.fxml"));
 
	//用讀進來FXML的作為Scene的root node
	scene = new Scene(root, 780,550);
	primaryStage.setScene(scene);
	scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Orbitron");
	scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Play");
	//顯示Stage
	ControlledStage controll = new ControlledStage();
	controll.addtrans(scene);
	primaryStage.setResizable(false);
	primaryStage.setTitle("Calculator");
	primaryStage.show();
	System.out.print("1111111");
	
	tab = (TabPane) scene.lookup("#menu");
	capacity = tab.getTabs().get(2);
	tab.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
        if (newValue ==capacity) {
            System.out.print("111111111");
            try {
				Capacity cap = new Capacity();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
        }
    });
    }
}