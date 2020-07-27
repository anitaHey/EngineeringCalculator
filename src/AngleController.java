import java.text.DecimalFormat;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class AngleController {
	@FXML
	private Label angle_label2, angle_label1;
	@FXML
	private ChoiceBox<String> angle_box1, angle_box2;
	@FXML
	private Button angle_numberCE, angle_numberLeft, angle_number1, angle_number2, angle_number3, angle_number4,
			angle_number5, angle_number6, angle_number7, angle_number8, angle_number9, angle_number0, angle_numberp;
	private int time;
	private String showAnswer;
	private double temNumber = 0;
	private double tem;
	DecimalFormat df = new DecimalFormat("#.########");
	private String[] setMemory_arr = new String[3];
	private int memory = 0;

	public void initialize() {
		symbol(1);
		angle_number1.setOnAction(e -> number(1));
		angle_number2.setOnAction(e -> number(2));
		angle_number3.setOnAction(e -> number(3));
		angle_number4.setOnAction(e -> number(4));
		angle_number5.setOnAction(e -> number(5));
		angle_number6.setOnAction(e -> number(6));
		angle_number7.setOnAction(e -> number(7));
		angle_number8.setOnAction(e -> number(8));
		angle_number9.setOnAction(e -> number(9));
		angle_number0.setOnAction(e -> number(0));
		angle_numberCE.setOnAction(e -> symbol(1));
		angle_numberLeft.setOnAction(e -> symbol(2));
		angle_numberp.setOnAction(e -> symbol(3));

		angle_box1.setOnAction((event) -> {
			change();
			showans();
		});
		angle_box2.setOnAction((event) -> {
			change();
			showans();
		});
	}

	public void number(int i) {
		memory = 1;
		time++;
		showAnswer = angle_label1.getText() + i;
		temNumber = Double.valueOf(showAnswer);
		angle_label1.setText(showAnswer);
		change();
		showans();
	}

	public void change() {
		switch (angle_box1.getSelectionModel().getSelectedIndex()) {
		case 0:
			tem = temNumber;
			break;
		case 1:
			tem = temNumber * ((double) 180 / Math.PI);
			break;
		case 2:
			tem = temNumber / 1.111111;
			break;
		}
	}

	public void showans() {
		double tem2 = 0;
		switch (angle_box2.getSelectionModel().getSelectedIndex()) {
		case 0:
			tem2 = tem;
			break;
		case 1:
			tem2 = tem / ((double) 180 / Math.PI);
			break;
		case 2:
			tem2 = tem * 1.111111;
			break;
		}
		angle_label2.setText(String.valueOf(df.format(tem2)));
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
			angle_label1.setText("");
			angle_label2.setText("");
			angle_box1.setValue("degree");
			angle_box2.setValue("degree");
			break;

		case 2:
			showAnswer = showAnswer.substring(0, showAnswer.length() - 1);
			time = time - 1;
			temNumber = Double.valueOf(showAnswer);
			angle_label1.setText(showAnswer);
			change();
			showans();
			break;

		case 3:
			showAnswer = angle_label1.getText() + ".";
			angle_label1.setText(showAnswer);
			break;
		}
	}
	public String[] setMemory() {
		String tem = angle_label1.getText();
		String tem2 = angle_label2.getText();
		setMemory_arr[0] = tem +" "+angle_box1.getSelectionModel().getSelectedItem()+" =";
		setMemory_arr[1] = tem2+" "+angle_box2.getSelectionModel().getSelectedItem();
		setMemory_arr[2] = "3";
		MemoryController.setMemory(setMemory_arr);
		return setMemory_arr;
	}
}