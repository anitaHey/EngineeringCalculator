import java.io.IOException;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class Capacity {
	Label answer1,answer2;
	ChoiceBox<String> box1,box2;
	Button num_CE,num_left,num_1,num_2,num_3,num_4,num_5,num_6,num_7,num_8,num_9,num_0,num_point;
	Scene scene;
	@SuppressWarnings("unchecked")
	public Capacity() throws IOException {
		System.out.print("1111111");
		ControlledStage test = new ControlledStage();
		scene=test.pressTrans();
		box1=(ChoiceBox<String>)scene.lookup("#capacity_box1");
		box2=(ChoiceBox<String>)scene.lookup("#capacity_box2");
		box1.getItems().addAll("毫升","立方公分","公升","立方公尺","茶匙","大匙","加侖","立方英吋","立方英尺");
		box2.getItems().addAll("毫升","立方公分","公升","立方公尺","茶匙","大匙","加侖","立方英吋","立方英尺");
		box1.getSelectionModel().select("毫升");
		box2.getSelectionModel().select("毫升");
	}
	
}
