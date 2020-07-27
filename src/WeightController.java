import java.io.IOException;
import java.text.DecimalFormat;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class WeightController {
	@FXML
	ChoiceBox<String> weight_box1, weight_box2;
	@FXML
	Label weight_label1, weight_label2;
	@FXML
	Button weight_numberCE, weight_numberLeft, weight_number1, weight_number2, weight_number3, weight_number4,
			weight_number5, weight_number6, weight_number7, weight_number8, weight_number9, weight_number0,
			weight_numberp;
	private int time;
	private String showAnswer;
	private double temNumber = 0;
	private double tem;
	DecimalFormat df = new DecimalFormat("#.########");
	private String[] setMemory_arr = new String[3];
	private int memory = 0;
	private String[] short_list = {"ct","mg","dg","g","dag.","hg.","kg","t","oz","lb","st"};

	public void initialize() {
		weight_number1.setOnAction(e -> number(1));
		weight_number2.setOnAction(e -> number(2));
		weight_number3.setOnAction(e -> number(3));
		weight_number4.setOnAction(e -> number(4));
		weight_number5.setOnAction(e -> number(5));
		weight_number6.setOnAction(e -> number(6));
		weight_number7.setOnAction(e -> number(7));
		weight_number8.setOnAction(e -> number(8));
		weight_number9.setOnAction(e -> number(9));
		weight_number0.setOnAction(e -> number(0));
		weight_numberCE.setOnAction(e -> symbol(1));
		weight_numberLeft.setOnAction(e -> symbol(2));
		weight_numberp.setOnAction(e -> symbol(3));

		weight_box1.setOnAction((event) -> {
			change();
			showans();
		});
		weight_box2.setOnAction((event) -> {
			change();
			showans();
		});
	}

	public void number(int i) {
		time++;
		memory = 1;
		showAnswer = weight_label1.getText() + i;
		temNumber = Double.valueOf(showAnswer);
		weight_label1.setText(showAnswer);
		change();
		showans();
	}

	public void change() {
		switch (weight_box1.getSelectionModel().getSelectedIndex()) {
		case 0:
			tem = temNumber / 50;
			break;
		case 1:
			tem = temNumber / 10000;
			break;
		case 2:
			tem = temNumber / 100;
			break;
		case 3:
			tem = temNumber / 10;
			break;
		case 4:
			tem = temNumber;
			break;
		case 5:
			tem = temNumber / 0.1;
			break;
		case 6:
			tem = temNumber / 0.01;
			break;
		case 7:
			tem = temNumber / 0.00001;
			break;
		case 8:
			tem = temNumber / 0.35274;
			break;
		case 9:
			tem = temNumber / 0.022046;
			break;
		case 10:
			tem = temNumber / 0.001575;
			break;
		}
	}

	public void showans() {
		double tem2 = 0;
		switch (weight_box2.getSelectionModel().getSelectedIndex()) {
		case 0:
			tem2 = tem * 50;
			break;
		case 1:
			tem2 = tem * 10000;
			break;
		case 2:
			tem2 = tem * 100;
			break;
		case 3:
			tem2 = tem * 10;
			break;
		case 4:
			tem2 = tem;
			break;
		case 5:
			tem2 = tem * 0.1;
			break;
		case 6:
			tem2 = tem * 0.01;
			break;
		case 7:
			tem2 = tem * 0.00001;
			break;
		case 8:
			tem2 = tem * 0.35274;
			break;
		case 9:
			tem2 = tem * 0.022046;
			break;
		case 10:
			tem2 = tem * 0.001575;
			break;
		}
		weight_label2.setText(String.valueOf(df.format(tem2)));
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
			weight_label1.setText("");
			weight_label2.setText("");
			weight_box1.setValue("carat");
			weight_box2.setValue("carat");
			break;

		case 2:
			showAnswer = showAnswer.substring(0, showAnswer.length() - 1);
			time = time - 1;
			temNumber = Double.valueOf(showAnswer);
			weight_label1.setText(showAnswer);
			change();
			showans();
			break;

		case 3:
			showAnswer = weight_label1.getText() + ".";
			weight_label1.setText(showAnswer);
			break;
		}
	}
	public String[] setMemory() {
		String tem = weight_label1.getText();
		String tem2 = weight_label2.getText();
		setMemory_arr[0] = tem +" "+short_list[weight_box1.getSelectionModel().getSelectedIndex()]+" =";
		setMemory_arr[1] = tem2+" "+short_list[weight_box2.getSelectionModel().getSelectedIndex()];
		setMemory_arr[2] = "5";
		MemoryController.setMemory(setMemory_arr);
		return setMemory_arr;
	}
}
