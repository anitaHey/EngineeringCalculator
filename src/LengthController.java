import java.text.DecimalFormat;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class LengthController {
	@FXML
	ChoiceBox<String> length_box1, length_box2;
	@FXML
	Label length_label1, length_label2;
	@FXML
	Button length_numberCE, length_numberLeft, length_number1, length_number2, length_number3, length_number4,
			length_number5, length_number6, length_number7, length_number8, length_number9, length_number0,
			length_numberp;
	private int time;
	private String showAnswer;
	private double temNumber = 0;
	private double tem;
	DecimalFormat df = new DecimalFormat("#.############");
	private String[] setMemory_arr = new String[3];
	private int memory = 0;
	private String[] short_list= {"nm","£gm","mm","cm","m","km","in","ft","yd","mile","Nm"};

	public void initialize() {
		symbol(1);
		length_number1.setOnAction(e -> number(1));
		length_number2.setOnAction(e -> number(2));
		length_number3.setOnAction(e -> number(3));
		length_number4.setOnAction(e -> number(4));
		length_number5.setOnAction(e -> number(5));
		length_number6.setOnAction(e -> number(6));
		length_number7.setOnAction(e -> number(7));
		length_number8.setOnAction(e -> number(8));
		length_number9.setOnAction(e -> number(9));
		length_number0.setOnAction(e -> number(0));
		length_numberCE.setOnAction(e -> symbol(1));
		length_numberLeft.setOnAction(e -> symbol(2));
		length_numberp.setOnAction(e -> symbol(3));

		length_box1.setOnAction((event) -> {
			change();
			showans();
		});
		length_box2.setOnAction((event) -> {
			change();
			showans();
		});
	}

	public void number(int i) {
		memory = 1;
		time++;
		showAnswer = length_label1.getText() + i;
		temNumber = Double.valueOf(showAnswer);
		length_label1.setText(showAnswer);
		change();
		showans();
	}

	public void change() {
		switch (length_box1.getSelectionModel().getSelectedIndex()) {
		case 0:
			tem = temNumber / 1000000000;
			break;
		case 1:
			tem = temNumber / 1000000;
			break;
		case 2:
			tem = temNumber / 1000;
			break;
		case 3:
			tem = temNumber / 100;
			break;
		case 4:
			tem = temNumber;
			break;
		case 5:
			tem = temNumber / 0.001;
			break;
		case 6:
			tem = temNumber / 39.37008;
			break;
		case 7:
			tem = temNumber / 3.28084;
			break;
		case 8:
			tem = temNumber / 1.093613;
			break;
		case 9:
			tem = temNumber / 0.000621;
			break;
		case 10:
			tem = temNumber / 0.00054;
			break;
		}
	}

	public void showans() {
		double tem2 = 0;
		switch (length_box2.getSelectionModel().getSelectedIndex()) {
		case 0:
			tem2 = tem * 1000000000;
			break;
		case 1:
			tem2 = tem * 1000000;
			break;
		case 2:
			tem2 = tem * 1000;
			break;
		case 3:
			tem2 = tem * 100;
			break;
		case 4:
			tem2 = tem;
			break;
		case 5:
			tem2 = tem * 0.001;
			break;
		case 6:
			tem2 = tem * 39.37008;
			break;
		case 7:
			tem2 = tem * 3.28084;
			break;
		case 8:
			tem2 = tem * 1.093613;
			break;
		case 9:
			tem2 = tem * 0.000621;
			break;
		case 10:
			tem2 = tem * 0.00054;
			break;
		}
		length_label2.setText(String.valueOf(df.format(tem2)));
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
			length_label1.setText("");
			length_label2.setText("");
			length_box1.setValue("nanometer");
			length_box2.setValue("nanometer");
			break;

		case 2:
			showAnswer = showAnswer.substring(0, showAnswer.length() - 1);
			time = time - 1;
			temNumber = Double.valueOf(showAnswer);
			length_label1.setText(showAnswer);
			change();
			showans();
			break;

		case 3:
			showAnswer = length_label1.getText() + ".";
			length_label1.setText(showAnswer);
			break;
		}
	}
	public String[] setMemory() {
		String tem = length_label1.getText();
		String tem2 = length_label2.getText();
		setMemory_arr[0] = tem +" "+short_list[length_box1.getSelectionModel().getSelectedIndex()]+" =";
		setMemory_arr[1] = tem2+" "+short_list[length_box2.getSelectionModel().getSelectedIndex()];
		setMemory_arr[2] = "4";
		MemoryController.setMemory(setMemory_arr);
		return setMemory_arr;
	}
}
