import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MemoryController{
	@FXML VBox vbox;
	private static VBox tem;
	private static String[] image = {"..//..//image//calculator.png","..//..//image//calendar.png","..//..//image//measuring-cup.png","..//..//image//protractor.png","..//..//image//ruler-in-diagonal-position.png","..//..//image//scale.png","..//..//image//shape.png","..//..//image//thermometer.png"};
	public void initialize() {
		tem = vbox;
	}
	public static void setMemory(String[] setMemory_arr) {
		Button memory = new Button();
		memory.getStyleClass().add("button_memory");
		VBox line = new VBox();
		HBox line1 = new HBox();
		ImageView pic= new ImageView(new Image("file:"+image[Integer.parseInt(setMemory_arr[2])],20,20,false,false));

		Label first = new Label(" "+setMemory_arr[0]);
		Label second= new Label("    "+setMemory_arr[1]);
		first.getStyleClass().addAll("button_memory_small");
		if(setMemory_arr[1].length()>12){
			second.getStyleClass().addAll("button_memory_small");
		}else{
			second.getStyleClass().addAll("button_memory_big");
		}
		line1.getChildren().addAll(pic,first);
		line1.setAlignment(Pos.CENTER_LEFT);
		line.getChildren().addAll(line1,second);
		memory.setGraphic(line);
		tem.getChildren().add(0,memory);
	}
}