import java.text.DecimalFormat;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class AreaController {
	@FXML
	ChoiceBox<String> area_box1, area_box2;
	@FXML
	Label area_label1, area_label2;
	@FXML
	Button area_numberCE, area_numberLeft, area_number1, area_number2, area_number3, area_number4, area_number5,
			area_number6, area_number7, area_number8, area_number9, area_number0, area_numberp;
	private int time;
	private String showAnswer;
	private double temNumber = 0;
	private double tem;
	DecimalFormat df = new DecimalFormat("#.######");
	private String[] setMemory_arr = new String[3];
	private int memory = 0;
	private String[] short_list = {"sq. mm","sq. cm","sq. m","ha","sq. in","sq. ft","sq. yd","acre","sq. mi"}; 

	public void initialize() {
		area_number1.setOnAction(e -> number(1));
		area_number2.setOnAction(e -> number(2));
		area_number3.setOnAction(e -> number(3));
		area_number4.setOnAction(e -> number(4));
		area_number5.setOnAction(e -> number(5));
		area_number6.setOnAction(e -> number(6));
		area_number7.setOnAction(e -> number(7));
		area_number8.setOnAction(e -> number(8));
		area_number9.setOnAction(e -> number(9));
		area_number0.setOnAction(e -> number(0));
		area_numberCE.setOnAction(e -> symbol(1));
		area_numberLeft.setOnAction(e -> symbol(2));
		area_numberp.setOnAction(e -> symbol(3));

		area_box1.setOnAction((event) -> {
			change();
			showans();
		});
		area_box2.setOnAction((event) -> {
			change();
			showans();
		});
	}

	public void number(int i) {
		memory = 1;
		time++;
		showAnswer = area_label1.getText() + i;
		temNumber = Double.valueOf(showAnswer);
		area_label1.setText(showAnswer);
		change();
		showans();
	}

	public void change() {
		switch (area_box1.getSelectionModel().getSelectedIndex()) {
		case 0:
			tem = temNumber / 1000000;
			break;
		case 1:
			tem = temNumber / 10000;
			break;
		case 2:
			tem = temNumber;
			break;
		case 3:
			tem = temNumber / 0.0001;
			break;
		case 4:
			tem = temNumber / 0.000001;
			break;
		case 5:
			tem = temNumber / 1550.003;
			break;
		case 6:
			tem = temNumber / 10.76391;
			break;
		case 7:
			tem = temNumber / 1.19599;
			break;
		case 8:
			tem = temNumber / 0.000247;
			break;
		case 9:
			tem = temNumber / 0.00000038610216;
			break;
		}
	}

	public void showans() {
		double tem2 = 0;
		switch (area_box2.getSelectionModel().getSelectedIndex()) {
		case 0:
			tem2 = tem * 1000000;
			break;
		case 1:
			tem2 = tem * 10000;
			break;
		case 2:
			tem2 = tem;
			break;
		case 3:
			tem2 = tem * 0.0001;
			break;
		case 4:
			tem2 = tem * 0.000001;
			break;
		case 5:
			tem2 = tem * 1550.003;
			break;
		case 6:
			tem2 = tem * 10.76391;
			break;
		case 7:
			tem2 = tem * 1.19599;
			break;
		case 8:
			tem2 = tem * 0.000247;
			break;
		case 9:
			tem2 = tem * 0.00000038610216;
			break;
		}
		area_label2.setText(String.valueOf(df.format(tem2)));
	}

	public void symbol(int i) {
		switch (i) {
		case 1:
			if(memory == 1) {
				setMemory();
				memory = 0;
			}
			temNumber = 0;
			time = 0;
			area_label1.setText("");
			area_label2.setText("");
			area_box1.setValue("sq. millimeter");
			area_box2.setValue("sq. millimeter");
			break;

		case 2:
			showAnswer = showAnswer.substring(0, showAnswer.length() - 1);
			time = time - 1;
			temNumber = Double.valueOf(showAnswer);
			area_label1.setText(showAnswer);
			change();
			showans();
			break;

		case 3:
			showAnswer = area_label1.getText() + ".";
			area_label1.setText(showAnswer);
			break;
		}
	}
	public String[] setMemory() {
		String tem = area_label1.getText();
		String tem2 = area_label2.getText();
		setMemory_arr[0] = tem +" "+short_list[area_box1.getSelectionModel().getSelectedIndex()]+" =";
		setMemory_arr[1] = tem2+" "+short_list[area_box2.getSelectionModel().getSelectedIndex()];
		setMemory_arr[2] = "6";
		MemoryController.setMemory(setMemory_arr);
		return setMemory_arr;
	}
}
