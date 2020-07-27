import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

public class DateController {
	@FXML
	private DatePicker date_picker1, date_picker2;
	@FXML
	private Label date_answer;
	private int[] list = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public void initialize() {
		date_picker1.valueProperty().addListener((ov, oldValue, newValue) -> {
			if (date_picker2.getValue() != null) {
				change();
			}
		});
		date_picker2.valueProperty().addListener((ov, oldValue, newValue) -> {
			if (date_picker1.getValue() != null) {
				change();
			}
		});
	}

	public void clean() {
		date_picker1.setValue(null);
		date_picker2.setValue(null);
		date_answer.setText("");
	}

	public void change() {
		LocalDate day1 = date_picker1.getValue();
		LocalDate day2 = date_picker2.getValue();

		int year1 = day1.getYear();
		int year2 = day2.getYear();
		int month1 = day1.getMonthValue();
		int month2 = day2.getMonthValue();
		int date1 = day1.getDayOfMonth();
		int date2 = day2.getDayOfMonth();
		int ans_day = 0;
		int ans_month = 0;
		int ans_year = 0;
		int a = 0;
		String output_day = "";
		String output_month = "";
		String output_year = "";
		if (year1 == year2 && date1 == date2&&month1 ==month2) {
			date_answer.setText("Same Day");
		} else {
			if (year1 == year2) {
				if (month1 == month2) {
					if (date1 > date2) {
						ans_day = date1 - date2;
					} else {
						ans_day = date2 - date1;
					}
				} else if(month1>month2){
					ans_month = month1-month2-1;
					ans_day = 	date1 + 30 - date2;
					if (ans_day >= 30) {
						ans_day = ans_day - 30;
						ans_month++;
					}
				}else {
					ans_month = month2-month1-1;
					ans_day = 30 - date1 + date2;
					if (ans_day >= 30) {
						ans_day = ans_day - 30;
						ans_month++;
					}
				}

			} else if (year1 > year2) {
				ans_year = year1 - year2 - 1;
				if (month1 == month2) {
					if (date1 > date2) {
						ans_day = date1 - date2;
					} else {
						ans_day = date2 - date1;
						ans_year = year1 - year2;
					}
				} else if(month1>month2){
					ans_month = month1-month2-1;
					ans_day = 	date1 + 30 - date2;
					if (ans_day >= 30) {
						ans_day = ans_day - 30;
						ans_month++;
					}
				}else {
					ans_month = month2-month1-1;
					ans_day = 30 - date1 + date2;
					if (ans_day >= 30) {
						ans_day = ans_day - 30;
						ans_month++;
					}
				}
				if (ans_month >= 12) {
					ans_month = ans_month - 12;
					ans_year++;
				}
				
			} else {
				ans_year = year2 - year1 - 1;
				if (month1 == month2) {
					if (date1 > date2) {
						ans_day = date1 - date2;
					} else {
						ans_day = date2 - date1;
						ans_year = year2 - year1;
					}
				} else if(month1>month2){
					ans_month = month1-month2-1;
					ans_day = 	date1 + 30 - date2;
					if (ans_day >= 30) {
						ans_day = ans_day - 30;
						ans_month++;
					}
				}else {
					ans_month = month2-month1-1;
					ans_day = 30 - date1 + date2;
					if (ans_day >= 30) {
						ans_day = ans_day - 30;
						ans_month++;
					}
				}
				if (ans_month >= 12) {
					ans_month = ans_month - 12;
					ans_year++;
				}
				
			}
			if (ans_year != 0) {
				output_year = String.valueOf(ans_year) + "Year ";
			}
			if (ans_month != 0) {
				output_month = String.valueOf(ans_month) + "Month ";
			}
			if (ans_day != 0) {
				output_day = String.valueOf(ans_day) + "Day ";
			}

			date_answer.setText(output_year + output_month + output_day);
		}
	}

	public int yearOfDay(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
			return 366;
		} else {
			return 365;
		}
	}
}