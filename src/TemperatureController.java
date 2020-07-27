import java.io.IOException;
import java.text.DecimalFormat;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class TemperatureController {
	@FXML
	ChoiceBox<String> temperature_box1, temperature_box2;
	@FXML
	Label temperature_label1, temperature_label2;
	@FXML
	Button temperature_numberCE, temperature_numberLeft, temperature_number1, temperature_number2, temperature_number3,
			temperature_number4, temperature_number5, temperature_number6, temperature_number7, temperature_number8,
			temperature_number9, temperature_number0, temperature_numberp, temperature_numplmin;
	private int time;
	private String showAnswer;
	private double temNumber = 0;
	private double tem;
	DecimalFormat df = new DecimalFormat("#.######");
	private String[] setMemory_arr = new String[3];
	private int memory = 0;
	private String[] short_list= {"¢XC","¢XF","K"};

	public void initialize() {
		symbol(1);
		temperature_number1.setOnAction(e -> number(1));
		temperature_number2.setOnAction(e -> number(2));
		temperature_number3.setOnAction(e -> number(3));
		temperature_number4.setOnAction(e -> number(4));
		temperature_number5.setOnAction(e -> number(5));
		temperature_number6.setOnAction(e -> number(6));
		temperature_number7.setOnAction(e -> number(7));
		temperature_number8.setOnAction(e -> number(8));
		temperature_number9.setOnAction(e -> number(9));
		temperature_number0.setOnAction(e -> number(0));
		temperature_numberCE.setOnAction(e -> symbol(1));
		temperature_numberLeft.setOnAction(e -> symbol(2));
		temperature_numberp.setOnAction(e -> symbol(3));
		temperature_numplmin.setOnAction(e -> symbol(4));

		temperature_box1.setOnAction((event) -> {
			change();
			showans();
		});
		temperature_box2.setOnAction((event) -> {
			change();
			showans();
		});
	}

	public void number(int i) {
		time++;
		memory = 1;
		showAnswer = temperature_label1.getText() + i;
		temNumber = Double.valueOf(showAnswer);
		temperature_label1.setText(showAnswer);
		change();
		showans();
	}

	public void change() {
		switch (temperature_box1.getSelectionModel().getSelectedIndex()) {
		case 0:
			tem = temNumber;
			break;
		case 1:
			tem = (temNumber - 32) * ((double) 5 / 9);
			break;
		case 2:
			tem = temNumber - 273.15;
			break;
		}
	}

	public void showans() {
		double tem2 = 0;
		switch (temperature_box2.getSelectionModel().getSelectedIndex()) {
		case 0:
			tem2 = tem;
			break;
		case 1:
			tem2 = tem * ((double) 9 / 5) + 32;
			break;
		case 2:
			tem2 = tem + 273.15;
			break;

		}
		temperature_label2.setText(String.valueOf(df.format(tem2)));
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
			temperature_label1.setText("");
			temperature_label2.setText("");
			temperature_box1.setValue("Celsius");
			temperature_box2.setValue("Celsius");
			break;

		case 2:
			showAnswer = showAnswer.substring(0, showAnswer.length() - 1);
			time = time - 1;
			temNumber = Double.valueOf(showAnswer);
			temperature_label1.setText(showAnswer);
			change();
			showans();
			break;

		case 3:
			showAnswer = "-" + temperature_label1.getText();
			temNumber = Double.valueOf(showAnswer);
			temperature_label1.setText(showAnswer);
			change();
			showans();
			break;

		case 4:
			showAnswer = temperature_label1.getText() + ".";
			temperature_label1.setText(showAnswer);
			break;
		}
	}
	public String[] setMemory() {
		String tem = temperature_label1.getText();
		String tem2 = temperature_label2.getText();
		setMemory_arr[0] = tem +" "+short_list[temperature_box1.getSelectionModel().getSelectedIndex()]+" =";
		setMemory_arr[1] = tem2+" "+short_list[temperature_box2.getSelectionModel().getSelectedIndex()];
		setMemory_arr[2] = "7";
		MemoryController.setMemory(setMemory_arr);
		return setMemory_arr;
	}
}
