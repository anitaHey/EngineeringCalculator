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
		box1.getItems().addAll("�@��","�ߤ褽��","����","�ߤ褽��","����","�j��","�[��","�ߤ�^�T","�ߤ�^��");
		box2.getItems().addAll("�@��","�ߤ褽��","����","�ߤ褽��","����","�j��","�[��","�ߤ�^�T","�ߤ�^��");
		box1.getSelectionModel().select("�@��");
		box2.getSelectionModel().select("�@��");
	}
	
}
