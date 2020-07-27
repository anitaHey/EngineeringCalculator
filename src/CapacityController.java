import java.text.DecimalFormat;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class CapacityController {
	@FXML
	ChoiceBox<String> capacity_box1, capacity_box2;
	@FXML
	Label capacity_label1, capacity_label2;
	@FXML
	Button capacity_numberCE, capacity_numberLeft, capacity_number1, capacity_number2, capacity_number3,
			capacity_number4, capacity_number5, capacity_number6, capacity_number7, capacity_number8, capacity_number9,
			capacity_number0, capacity_numberp;
	private int time;
	private String showAnswer;
	private double temNumber = 0;
	private double tem;
	DecimalFormat df = new DecimalFormat("#.########");
	private String[] setMemory_arr = new String[3];
	private int memory = 0;
	private String[] short_list = {"ml","c.c.","L","cu. m","t.","T.","gal","cu. in","cu. ft"};

	public void initialize() {
		symbol(1);
		capacity_number1.setOnAction(e -> number(1));
		capacity_number2.setOnAction(e -> number(2));
		capacity_number3.setOnAction(e -> number(3));
		capacity_number4.setOnAction(e -> number(4));
		capacity_number5.setOnAction(e -> number(5));
		capacity_number6.setOnAction(e -> number(6));
		capacity_number7.setOnAction(e -> number(7));
		capacity_number8.setOnAction(e -> number(8));
		capacity_number9.setOnAction(e -> number(9));
		capacity_number0.setOnAction(e -> number(0));
		capacity_numberCE.setOnAction(e -> symbol(1));
		capacity_numberLeft.setOnAction(e -> symbol(2));
		capacity_numberp.setOnAction(e -> symbol(3));

		capacity_box1.setOnAction((event) -> {
			change();
			showans();
		});
		capacity_box2.setOnAction((event) -> {
			change();
			showans();
		});
	}

	public void number(int i) {
		memory = 1;
		time++;
		showAnswer = capacity_label1.getText() + i;
		temNumber = Double.valueOf(showAnswer);
		capacity_label1.setText(showAnswer);
		change();
		showans();
	}

	public void change() {
		switch (capacity_box1.getSelectionModel().getSelectedIndex()) {
		case 0:
			tem = temNumber;
			break;
		case 1:
			tem = temNumber;
			break;
		case 2:
			tem = temNumber / 0.001;
			break;
		case 3:
			tem = temNumber / 0.000001;
			break;
		case 4:
			tem = temNumber / 0.202884;
			break;
		case 5:
			tem = temNumber / 0.067628;
			break;
		case 6:
			tem = temNumber / 0.000264;
			break;
		case 7:
			tem = temNumber / 0.061024;
			break;
		case 8:
			tem = temNumber / 0.000035;
			break;
		}
	}

	public void showans() {
		double tem2 = 0;
		switch (capacity_box2.getSelectionModel().getSelectedIndex()) {
		case 0:
			tem2 = tem;
			break;
		case 1:
			tem2 = tem;
			break;
		case 2:
			tem2 = tem * 0.001;
			break;
		case 3:
			tem2 = tem * 0.000001;
			break;
		case 4:
			tem2 = tem * 0.202884;
			break;
		case 5:
			tem2 = tem * 0.067628;
			break;
		case 6:
			tem2 = tem * 0.000264;
			break;
		case 7:
			tem2 = tem * 0.061024;
			break;
		case 8:
			tem2 = tem * 0.000035;
			break;
		}
		capacity_label2.setText(String.valueOf(df.format(tem2)));
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
			capacity_label1.setText("");
			capacity_label2.setText("");
			capacity_box1.setValue("millilitre");
			capacity_box2.setValue("millilitre");
			break;

		case 2:
			showAnswer = showAnswer.substring(0, showAnswer.length() - 1);
			time = time - 1;
			temNumber = Double.valueOf(showAnswer);
			capacity_label1.setText(showAnswer);
			change();
			showans();
			break;

		case 3:
			showAnswer = capacity_label1.getText() + ".";
			capacity_label1.setText(showAnswer);
			break;
		}
	}
	public String[] setMemory() {
		String tem = capacity_label1.getText();
		String tem2 = capacity_label2.getText();
		setMemory_arr[0] = tem +" "+short_list[capacity_box1.getSelectionModel().getSelectedIndex()]+" =";
		setMemory_arr[1] = tem2+" "+short_list[capacity_box2.getSelectionModel().getSelectedIndex()];
		setMemory_arr[2] = "2";
		MemoryController.setMemory(setMemory_arr);
		return setMemory_arr;
	}
}
