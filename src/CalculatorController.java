import java.text.DecimalFormat;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;

public class CalculatorController {
	@FXML
	private Button calculator_numberxy, calculator_numberx2, calculator_numberSin, calculator_numberCos,
			calculator_numberTan, calculator_numberRoot, calculator_numberUp, calculator_numberPI, calculator_numberN,
			calculator_number10x, calculator_numberExp, calculator_numberLog, calculator_numberMod, calculator_numberCE,
			calculator_numberC, calculator_numberLeft, calculator_numberadd, calculator_number7, calculator_number9,
			calculator_number4, calculator_number8, calculator_numbermul, calculator_number5, calculator_number6,
			calculator_numbermin, calculator_numberplmin, calculator_numberri, calculator_number1, calculator_numberle,
			calculator_number2, calculator_number0, calculator_number3, calculator_numberp, calculator_numberplus,
			calculator_numberequ, calculator_numberMC, calculator_numberMR, calculator_numberMplus,
			calculator_numberMmin, calculator_numberMS, calculator_numberDEG, calculator_numberHYP, calculator_numberFE;
	@FXML
	private Label calculator_answer, calculator_process;
	DecimalFormat df = new DecimalFormat("#.################");
	private String showAnswer = "";
	private String showFormula = "";
	private double answerNumber;
	private double temNumber;
	private String mark = "";
	private int time = 1;
	private int next = 0;
	private int change = 0;
	private int clean = 0;
	private ArrayList<Double> temfnum = new ArrayList<>();
	private ArrayList<String> temfmark = new ArrayList<>();
	private ArrayList<Double> ennum = new ArrayList<>();
	private ArrayList<String> enmark = new ArrayList<>();
	private int lmark = 0;
	private double temennum = 0;
	private String temenmark = "";
	private String[] setMemory_arr = new String[3];
	private int numfir = 1;
	private MemoryController memorycontroller;

	public void initialize() {
		calculator_number1.setOnAction(e -> number(1));
		calculator_number2.setOnAction(e -> number(2));
		calculator_number3.setOnAction(e -> number(3));
		calculator_number4.setOnAction(e -> number(4));
		calculator_number5.setOnAction(e -> number(5));
		calculator_number6.setOnAction(e -> number(6));
		calculator_number7.setOnAction(e -> number(7));
		calculator_number8.setOnAction(e -> number(8));
		calculator_number9.setOnAction(e -> number(9));
		calculator_number0.setOnAction(e -> number(0));
		calculator_numbermul.setOnAction(e -> normal_symbol(7));
		calculator_numberx2.setOnAction(e -> normal_symbol(13));
		calculator_numberxy.setOnAction(e -> normal_symbol(14));
		calculator_numberSin.setOnAction(e -> normal_symbol(15));
		calculator_numberCos.setOnAction(e -> normal_symbol(16));
		calculator_numberTan.setOnAction(e -> normal_symbol(17));
		calculator_numberRoot.setOnAction(e -> normal_symbol(1));
		calculator_numberUp.setOnAction(e -> normal_symbol(0));
		calculator_numberPI.setOnAction(e -> normal_symbol(0));
		calculator_numberN.setOnAction(e -> normal_symbol(0));
		calculator_number10x.setOnAction(e -> normal_symbol(18));
		calculator_numberExp.setOnAction(e -> normal_symbol(0));
		calculator_numberLog.setOnAction(e -> normal_symbol(19));
		calculator_numberMod.setOnAction(e -> normal_symbol(20));
		calculator_numberCE.setOnAction(e -> normal_symbol(3));
		calculator_numberC.setOnAction(e -> normal_symbol(4));
		calculator_numberLeft.setOnAction(e -> normal_symbol(5));
		calculator_numberadd.setOnAction(e -> normal_symbol(6));
		calculator_numbermin.setOnAction(e -> normal_symbol(8));
		calculator_numberplmin.setOnAction(e -> normal_symbol(10));
		calculator_numberri.setOnAction(e -> normal_symbol(21));
		calculator_numberle.setOnAction(e -> normal_symbol(22));
		calculator_numberp.setOnAction(e -> normal_symbol(11));
		calculator_numberplus.setOnAction(e -> normal_symbol(9));
		calculator_numberequ.setOnAction(e -> normal_symbol(12));
		calculator_numberMC.setOnAction(e -> normal_symbol(0));
		calculator_numberMR.setOnAction(e -> normal_symbol(0));
		calculator_numberMplus.setOnAction(e -> normal_symbol(0));
		calculator_numberMmin.setOnAction(e -> normal_symbol(0));
		calculator_numberMS.setOnAction(e -> normal_symbol(0));
		calculator_numberDEG.setOnAction(e -> normal_symbol(0));
		calculator_numberHYP.setOnAction(e -> normal_symbol(0));
		calculator_numberFE.setOnAction(e -> normal_symbol(0));
	}

	public void number(int i) {
		if (next == 1) {
			calculator_answer.setText("");
			next = 0;
		}
		if (clean == 1) {
			normal_symbol(4);
			clean = 0;
		}
		String num = String.valueOf(i);
		showFormula = showFormula + num;
		showAnswer = calculator_answer.getText() + i;
		temNumber = Double.valueOf(showAnswer);
		calculator_process.setText(showFormula);
		calculator_answer.setText(showAnswer);
	}

	public void normal_symbol(int a) {
		switch (a) {
		case 0:
			break;
		// 根號
		case 1:
			showFormula = "√ ( " + showFormula + " )";

			if (mark.equals("/")) {
				answerNumber = answerNumber / temNumber;
			} else if (mark.equals("×")) {
				answerNumber = answerNumber * temNumber;
			} else if (mark.equals("-")) {
				answerNumber = answerNumber - temNumber;
			} else if (mark.equals("+")) {
				answerNumber = answerNumber + temNumber;
			} else if (mark.equals("^") || mark.equals("1/x") || mark.equals("√") || mark.equals("sin")
					|| mark.equals("cos") || mark.equals("tan") || mark.equals("10^") || mark.equals("log")) {
				temNumber = answerNumber;
			} else if (mark.equals("^y")) {
				answerNumber = Math.pow(answerNumber, temNumber);
			} else if (mark.equals("mod")) {
				answerNumber = answerNumber % temNumber;
			} else {
				answerNumber = temNumber;
			}

			answerNumber = Math.pow(answerNumber, 0.5);
			showAnswer = Double.toString(answerNumber);
			if (showAnswer.endsWith("0")) {
				showAnswer = Integer.toString((int) answerNumber);
			}
			if (time == 2) {
				temNumber = 0;
			}
			calculator_process.setText(showFormula);
			calculator_answer.setText(showAnswer);
			time = 2;
			mark = "√";
			break;

		// 1/x
		case 2:
			showFormula = "1 / (" + showFormula + " )";

			if (mark.equals("/")) {
				answerNumber = answerNumber / temNumber;
			} else if (mark.equals("×")) {
				answerNumber = answerNumber * temNumber;
			} else if (mark.equals("-")) {
				answerNumber = answerNumber - temNumber;
			} else if (mark.equals("+")) {
				answerNumber = answerNumber + temNumber;
			} else if (mark.equals("^") || mark.equals("1/x") || mark.equals("√") || mark.equals("sin")
					|| mark.equals("cos") || mark.equals("tan") || mark.equals("10^") || mark.equals("log")) {
				temNumber = answerNumber;
			} else if (mark.equals("^y")) {
				answerNumber = Math.pow(answerNumber, temNumber);
			} else if (mark.equals("mod")) {
				answerNumber = answerNumber % temNumber;
			} else {
				answerNumber = temNumber;
			}

			answerNumber = 1 / answerNumber;

			showAnswer = Double.toString(answerNumber);
			if (showAnswer.endsWith("0")) {
				showAnswer = Integer.toString((int) answerNumber);
			}
			if (time == 2) {
				temNumber = 0;
			}
			calculator_process.setText(showFormula);
			calculator_answer.setText(showAnswer);
			time = 2;
			mark = "1/x";
			break;

		// CE 清除當下的數字
		case 3:
			showFormula = showFormula.replace(showAnswer, "");
			calculator_process.setText(showFormula);
			calculator_answer.setText(" ");
			break;

		// C 清除所有的數字
		case 4:
			showAnswer = "";
			answerNumber = 0;
			showFormula = "";
			temNumber = 0;
			mark = "";
			time = 1;
			next = 0;
			calculator_process.setText(showFormula);
			calculator_answer.setText(showAnswer);
			break;

		// ← 減少一個字
		case 5:
			showAnswer = showAnswer.substring(0, showAnswer.length() - 1);
			showFormula = showFormula.substring(0, showFormula.length() - 1);
			temNumber = Double.valueOf(showAnswer);
			calculator_process.setText(showFormula);
			calculator_answer.setText(showAnswer);
			break;

		// 除號
		case 6:
			if (time == 1) {
				showFormula = showFormula + " ÷ ";
				answerNumber = temNumber;
				showAnswer = Double.toString(answerNumber);
				if (showAnswer.endsWith("0")) {
					showAnswer = Integer.toString((int) answerNumber);
				}
				numfir = 0;
				mark = "/";
				time = 2;
			} else {
				numfir = 1;
				showFormula = showFormula + " ÷ ";
				switch (mark) {
				case "/":
					answerNumber = answerNumber / temNumber;
					break;
				case "×":
					answerNumber = answerNumber * temNumber;
					break;
				case "-":
					enmark.add("-");
					ennum.add(answerNumber);
					answerNumber = temNumber;
					break;
				case "+":
					enmark.add("+");
					ennum.add(answerNumber);
					answerNumber = temNumber;
					break;
				case "^y":
					answerNumber = Math.pow(answerNumber, temNumber);
					break;
				case "mod":
					answerNumber = answerNumber % temNumber;
					break;
				}
				showAnswer = Double.toString(answerNumber);
				if (showAnswer.endsWith("0")) {
					showAnswer = Integer.toString((int) answerNumber);
				}
				mark = "/";

			}
			next = 1;
			calculator_process.setText(showFormula);
			calculator_answer.setText(showAnswer);
			break;

		// 乘號
		case 7:
			if (time == 1) {
				showFormula = showFormula + " × ";
				answerNumber = temNumber;
				showAnswer = Double.toString(answerNumber);
				if (showAnswer.endsWith("0")) {
					showAnswer = Integer.toString((int) answerNumber);
				}
				numfir = 0;
				mark = "×";
				time = 2;
			} else {
				numfir = 1;
				showFormula = showFormula + " × ";
				switch (mark) {
				case "/":
					answerNumber = answerNumber / temNumber;
					break;
				case "×":
					answerNumber = answerNumber * temNumber;
					break;
				case "-":
					enmark.add("-");
					ennum.add(answerNumber);
					answerNumber = temNumber;
					break;
				case "+":
					enmark.add("+");
					ennum.add(answerNumber);
					answerNumber = temNumber;
					break;
				case "^y":
					answerNumber = Math.pow(answerNumber, temNumber);
					break;
				case "mod":
					answerNumber = answerNumber % temNumber;
					break;

				}
				showAnswer = Double.toString(answerNumber);
				if (showAnswer.endsWith("0")) {
					showAnswer = Integer.toString((int) answerNumber);
				}
				mark = "×";

			}
			next = 1;
			calculator_process.setText(showFormula);
			calculator_answer.setText(showAnswer);
			break;

		// 減號
		case 8:
			if (time == 1) {
				showFormula = showFormula + " - ";
				answerNumber = temNumber;
				showAnswer = Double.toString(answerNumber);
				if (showAnswer.endsWith("0")) {
					showAnswer = Integer.toString((int) answerNumber);
				}
				mark = "-";
				time = 2;
			} else {
				if (numfir == 1) {
					if (mark.equals("/") || mark.equals("×") || mark.equals(")")) {
						temennum = ennum.get(ennum.size() - 1);
						temenmark = enmark.get(enmark.size() - 1);
					}
				}
				showFormula = showFormula + " - ";
				switch (mark) {
				case "/":
					if (numfir == 1) {
						if (temenmark.equals("-")) {
							answerNumber = answerNumber / temNumber;
							answerNumber = temennum - answerNumber;
						} else if (temenmark.equals("+")) {
							answerNumber = answerNumber / temNumber;
							answerNumber = temennum + answerNumber;
						}
					} else {
						answerNumber = answerNumber / temNumber;
					}
					break;
				case "×":
					if (numfir == 1) {
						if (temenmark.equals("-")) {
							answerNumber = answerNumber * temNumber;
							answerNumber = temennum - answerNumber;
						} else if (temenmark.equals("+")) {
							answerNumber = answerNumber * temNumber;
							answerNumber = temennum + answerNumber;
						}
					} else {
						answerNumber = answerNumber * temNumber;
					}
					break;
				case "-":
					answerNumber = answerNumber - temNumber;
					break;
				case "+":
					answerNumber = answerNumber + temNumber;
					break;
				case "^y":
					answerNumber = Math.pow(answerNumber, temNumber);
					break;
				case "mod":
					answerNumber = answerNumber % temNumber;
					break;
				case ")":
					if (temenmark.equals("-")) {
						answerNumber = temennum - answerNumber;
					} else if (temenmark.equals("+")) {
						answerNumber = temennum + answerNumber;
					}
					break;
				}
				if (numfir == 1) {
					if (mark.equals("/") || mark.equals("×") || mark.equals(")")) {
						ennum.remove(ennum.size() - 1);
						enmark.remove(enmark.size() - 1);
					}
				}
				showAnswer = Double.toString(answerNumber);
				if (showAnswer.endsWith("0")) {
					showAnswer = Integer.toString((int) answerNumber);
				}
				mark = "-";

			}
			next = 1;
			calculator_process.setText(showFormula);
			calculator_answer.setText(showAnswer);
			break;

		// 加號
		case 9:
			if (time == 1) {
				showFormula = showFormula + " + ";
				answerNumber = temNumber;
				showAnswer = Double.toString(answerNumber);
				if (showAnswer.endsWith(".0")) {
					showAnswer = Integer.toString((int) answerNumber);
				}

				mark = "+";
				time = 2;
			} else {
				if (numfir == 1) {
					if (mark.equals("/") || mark.equals("×") || mark.equals(")")) {
						temennum = ennum.get(ennum.size() - 1);
						temenmark = enmark.get(enmark.size() - 1);
					}
				}
				showFormula = showFormula + " + ";
				switch (mark) {
				case "/":
					if (numfir == 1) {
						if (temenmark.equals("-")) {
							answerNumber = answerNumber / temNumber;
							answerNumber = temennum - answerNumber;
						} else if (temenmark.equals("+")) {
							answerNumber = answerNumber / temNumber;
							answerNumber = temennum + answerNumber;
						}
					} else {
						answerNumber = answerNumber / temNumber;
					}
					break;
				case "×":
					if (numfir == 1) {
						if (temenmark.equals("-")) {
							answerNumber = answerNumber * temNumber;
							answerNumber = temennum - answerNumber;
						} else if (temenmark.equals("+")) {
							answerNumber = answerNumber * temNumber;
							answerNumber = temennum + answerNumber;
						}
					} else {
						answerNumber = answerNumber * temNumber;
					}
					break;
				case "-":
					answerNumber = answerNumber - temNumber;
					break;
				case "+":
					answerNumber = answerNumber + temNumber;
					break;
				case "^y":
					answerNumber = Math.pow(answerNumber, temNumber);
					break;
				case "mod":
					answerNumber = answerNumber % temNumber;
					break;
				case ")":
					if (temenmark.equals("-")) {
						answerNumber = temennum - answerNumber;
					} else if (temenmark.equals("+")) {
						answerNumber = temennum + answerNumber;
					}
					break;
				}
				if (numfir == 1) {
					if (mark.equals("/") || mark.equals("×") || mark.equals(")")) {
						ennum.remove(ennum.size() - 1);
						enmark.remove(enmark.size() - 1);
					}
				}
				showAnswer = Double.toString(answerNumber);
				if (showAnswer.endsWith(".0")) {
					showAnswer = Integer.toString((int) answerNumber);
				}

				mark = "+";

			}
			next = 1;
			calculator_process.setText(showFormula);
			calculator_answer.setText(showAnswer);
			break;

		// 正負號
		case 10:
			showFormula = "- ( " + showFormula + " )";

			if (mark.equals("/")) {
				answerNumber = answerNumber / temNumber;
			} else if (mark.equals("×")) {
				answerNumber = answerNumber * temNumber;
			} else if (mark.equals("-")) {
				answerNumber = answerNumber - temNumber;
			} else if (mark.equals("+")) {
				answerNumber = answerNumber + temNumber;
			} else if (mark.equals("^") || mark.equals("1/x") || mark.equals("√") || mark.equals("sin")
					|| mark.equals("cos") || mark.equals("tan") || mark.equals("10^") || mark.equals("log")) {
				temNumber = answerNumber;
			} else if (mark.equals("^y")) {
				answerNumber = Math.pow(answerNumber, temNumber);
			} else if (mark.equals("mod")) {
				answerNumber = answerNumber % temNumber;
			} else {
				answerNumber = temNumber;
			}
			answerNumber = -(answerNumber);
			showAnswer = Double.toString(answerNumber);
			temNumber = Double.valueOf(showAnswer);
			if (showAnswer.endsWith("0")) {
				showAnswer = Integer.toString((int) answerNumber);
			}

			calculator_process.setText(showFormula);
			calculator_answer.setText(showAnswer);
			mark = "+-";
			break;

		// 增加小數點
		case 11:
			showFormula = showFormula + ".";
			showAnswer = calculator_answer.getText() + ".";
			calculator_process.setText(showFormula);
			calculator_answer.setText(showAnswer);
			break;

		// 按下等於後 即顯示答案 不能再執行運算
		case 12:
			if (numfir == 1) {
				if (mark.equals("/") || mark.equals("×") || mark.equals(")")) {
					temennum = ennum.get(ennum.size() - 1);
					temenmark = enmark.get(enmark.size() - 1);
				}
				switch (mark) {
				case "/":
					if (temenmark.equals("-")) {
						answerNumber = answerNumber / temNumber;
						answerNumber = temennum - answerNumber;
					} else if (temenmark.equals("+")) {
						answerNumber = answerNumber / temNumber;
						answerNumber = temennum + answerNumber;
					} else {
						answerNumber = answerNumber / temNumber;
					}
					break;
				case "×":
					if (temenmark.equals("-")) {
						answerNumber = answerNumber * temNumber;
						answerNumber = temennum - answerNumber;
					} else if (temenmark.equals("+")) {
						answerNumber = answerNumber * temNumber;
						answerNumber = temennum + answerNumber;
					} else {
						answerNumber = answerNumber * temNumber;
					}
					break;
				case "-":
					answerNumber = answerNumber - temNumber;
					break;
				case "+":
					answerNumber = answerNumber + temNumber;
					break;
				case "^y":
					answerNumber = Math.pow(answerNumber, temNumber);
					break;
				case "mod":
					answerNumber = answerNumber % temNumber;
					break;
				case ")":
					if (temenmark.equals("-")) {
						answerNumber = temennum - answerNumber;
					} else if (temenmark.equals("+")) {
						answerNumber = temennum + answerNumber;
					}
					break;
				}
				if (mark.equals("/") || mark.equals("×") || mark.equals(")")) {
					ennum.remove(ennum.size() - 1);
					enmark.remove(enmark.size() - 1);
				}
			} else {
				if (mark.equals("/")) {
					answerNumber = answerNumber / temNumber;
				} else if (mark.equals("×")) {
					answerNumber = answerNumber * temNumber;
				} else if (mark.equals("-")) {
					answerNumber = answerNumber - temNumber;
				} else if (mark.equals("^y")) {
					answerNumber = Math.pow(answerNumber, temNumber);
				} else if (mark.equals("mod")) {
					answerNumber = answerNumber % temNumber;
				} else {
					answerNumber = answerNumber + temNumber;
				}
			}
			showAnswer = Double.toString(answerNumber);
			if (showAnswer.endsWith("0")) {
				showAnswer = Integer.toString((int) answerNumber);
			}
			setMemory();
			calculator_answer.setText(showAnswer);
			calculator_process.setText("");
			mark = "=";
			clean = 1;
			break;

		// x^2
		case 13:
			showFormula = "( " + showFormula + " )\u00b2";

			if (mark.equals("/")) {
				answerNumber = answerNumber / temNumber;
			} else if (mark.equals("×")) {
				answerNumber = answerNumber * temNumber;
			} else if (mark.equals("-")) {
				answerNumber = answerNumber - temNumber;
			} else if (mark.equals("+")) {
				answerNumber = answerNumber + temNumber;
			} else if (mark.equals("^") || mark.equals("1/x") || mark.equals("√") || mark.equals("sin")
					|| mark.equals("cos") || mark.equals("tan") || mark.equals("10^") || mark.equals("log")) {
				temNumber = answerNumber;
			} else if (mark.equals("mod")) {
				answerNumber = answerNumber % temNumber;
			} else if (mark.equals("^y")) {
				answerNumber = Math.pow(answerNumber, temNumber);
			} else {
				answerNumber = temNumber;
			}

			answerNumber = Math.pow(answerNumber, 2);
			showAnswer = Double.toString(answerNumber);
			if (showAnswer.endsWith("0")) {
				showAnswer = Integer.toString((int) answerNumber);
			}
			if (time == 2) {
				temNumber = 0;
			}
			calculator_process.setText(showFormula);
			calculator_answer.setText(showAnswer);
			time = 2;
			mark = "^";
			break;

		case 14:
			if (time == 1) {
				showFormula = showFormula + "^";
				answerNumber = temNumber;
				showAnswer = Double.toString(answerNumber);
				if (showAnswer.endsWith("0")) {
					showAnswer = Integer.toString((int) answerNumber);
				}
				mark = "^y";
				time = 2;
			} else {
				showFormula = showFormula + "^";
				switch (mark) {
				case "/":
					answerNumber = answerNumber / temNumber;
					break;
				case "×":
					answerNumber = answerNumber * temNumber;
					break;
				case "-":
					answerNumber = answerNumber - temNumber;
					break;
				case "+":
					answerNumber = answerNumber + temNumber;
					break;
				case "^y":
					answerNumber = Math.pow(answerNumber, temNumber);
					break;
				case "mod":
					answerNumber = answerNumber % temNumber;
					break;
				}
				showAnswer = Double.toString(answerNumber);
				if (showAnswer.endsWith("0")) {
					showAnswer = Integer.toString((int) answerNumber);
				}
				mark = "^y";

			}
			next = 1;
			calculator_process.setText(showFormula);
			calculator_answer.setText(showAnswer);
			break;

		case 15:
			showFormula = "sin( " + showFormula + " )";

			if (mark.equals("/")) {
				answerNumber = answerNumber / temNumber;
			} else if (mark.equals("×")) {
				answerNumber = answerNumber * temNumber;
			} else if (mark.equals("-")) {
				answerNumber = answerNumber - temNumber;
			} else if (mark.equals("+")) {
				answerNumber = answerNumber + temNumber;
			} else if (mark.equals("^") || mark.equals("1/x") || mark.equals("√") || mark.equals("sin")
					|| mark.equals("cos") || mark.equals("tan") || mark.equals("10^") || mark.equals("log")) {
				temNumber = answerNumber;
			} else if (mark.equals("mod")) {
				answerNumber = answerNumber % temNumber;
			} else if (mark.equals("^y")) {
				answerNumber = Math.pow(answerNumber, temNumber);
			} else {
				answerNumber = temNumber;
			}

			if (answerNumber % 180 == 0 || answerNumber == 0) {
				answerNumber = 0;
				showAnswer = Double.toString(answerNumber);
			} else {
				answerNumber = Math.sin(Math.toRadians(answerNumber));
				showAnswer = Double.toString(answerNumber);
			}

			if (showAnswer.endsWith("0")) {
				showAnswer = Integer.toString((int) answerNumber);
			}
			if (time == 2) {
				temNumber = 0;
			}
			calculator_process.setText(showFormula);
			calculator_answer.setText(showAnswer);
			time = 2;
			mark = "sin";
			break;
		case 16:
			showFormula = "cos( " + showFormula + " )";

			if (mark.equals("/")) {
				answerNumber = answerNumber / temNumber;
			} else if (mark.equals("×")) {
				answerNumber = answerNumber * temNumber;
			} else if (mark.equals("-")) {
				answerNumber = answerNumber - temNumber;
			} else if (mark.equals("+")) {
				answerNumber = answerNumber + temNumber;
			} else if (mark.equals("^") || mark.equals("1/x") || mark.equals("√") || mark.equals("sin")
					|| mark.equals("cos") || mark.equals("tan") || mark.equals("10^") || mark.equals("log")) {
				temNumber = answerNumber;
			} else if (mark.equals("mod")) {
				answerNumber = answerNumber % temNumber;
			} else if (mark.equals("^y")) {
				answerNumber = Math.pow(answerNumber, temNumber);
			} else {
				answerNumber = temNumber;
			}

			if (answerNumber % 180 == 0 || answerNumber == 0) {
				answerNumber = 1;
				showAnswer = Double.toString(answerNumber);
			} else if (answerNumber % 90 == 0) {
				answerNumber = 0;
				showAnswer = Double.toString(answerNumber);
			} else {
				answerNumber = Math.cos(Math.toRadians(answerNumber));
				showAnswer = Double.toString(answerNumber);
			}

			if (showAnswer.endsWith("0")) {
				showAnswer = Integer.toString((int) answerNumber);
			}
			if (time == 2) {
				temNumber = 0;
			}
			calculator_process.setText(showFormula);
			calculator_answer.setText(showAnswer);
			time = 2;
			mark = "cos";
			break;
		case 17:
			showFormula = "tan( " + showFormula + " )";

			if (mark.equals("/")) {
				answerNumber = answerNumber / temNumber;
			} else if (mark.equals("×")) {
				answerNumber = answerNumber * temNumber;
			} else if (mark.equals("-")) {
				answerNumber = answerNumber - temNumber;
			} else if (mark.equals("+")) {
				answerNumber = answerNumber + temNumber;
			} else if (mark.equals("^") || mark.equals("1/x") || mark.equals("√") || mark.equals("sin")
					|| mark.equals("cos") || mark.equals("tan") || mark.equals("10^") || mark.equals("log")) {
				temNumber = answerNumber;
			} else if (mark.equals("mod")) {
				answerNumber = answerNumber % temNumber;
			} else if (mark.equals("^y")) {
				answerNumber = Math.pow(answerNumber, temNumber);
			} else {
				answerNumber = temNumber;
			}
			if (answerNumber % 180 == 0 || answerNumber == 0) {
				answerNumber = 0;
				showAnswer = Double.toString(answerNumber);
			} else if (answerNumber % 90 == 0) {
				showAnswer = "無效的輸入";
				clean = 1;
			} else {
				answerNumber = Math.tan(Math.toRadians(answerNumber));
				showAnswer = Double.toString(answerNumber);
			}

			if (showAnswer.endsWith("0")) {
				showAnswer = Integer.toString((int) answerNumber);
			}
			if (time == 2) {
				temNumber = 0;
			}
			calculator_process.setText(showFormula);
			calculator_answer.setText(showAnswer);
			time = 2;
			mark = "tan";
			break;

		case 18:
			showFormula = "10^( " + showFormula + " )";

			if (mark.equals("/")) {
				answerNumber = answerNumber / temNumber;
			} else if (mark.equals("×")) {
				answerNumber = answerNumber * temNumber;
			} else if (mark.equals("-")) {
				answerNumber = answerNumber - temNumber;
			} else if (mark.equals("+")) {
				answerNumber = answerNumber + temNumber;
			} else if (mark.equals("^") || mark.equals("1/x") || mark.equals("√") || mark.equals("sin")
					|| mark.equals("cos") || mark.equals("tan") || mark.equals("10^") || mark.equals("log")) {
				temNumber = answerNumber;
			} else if (mark.equals("mod")) {
				answerNumber = answerNumber % temNumber;
			} else if (mark.equals("^y")) {
				answerNumber = Math.pow(answerNumber, temNumber);
			} else {
				answerNumber = temNumber;
			}

			answerNumber = Math.pow(10, answerNumber);
			showAnswer = df.format(answerNumber);
			if (showAnswer.endsWith("0")) {
				showAnswer = Integer.toString((int) answerNumber);
			}
			if (time == 2) {
				temNumber = 0;
			}
			calculator_process.setText(showFormula);
			calculator_answer.setText(showAnswer);
			time = 2;
			mark = "10^";
			break;

		case 19:
			showFormula = "log( " + showFormula + " )";

			if (mark.equals("/")) {
				answerNumber = answerNumber / temNumber;
			} else if (mark.equals("×")) {
				answerNumber = answerNumber * temNumber;
			} else if (mark.equals("-")) {
				answerNumber = answerNumber - temNumber;
			} else if (mark.equals("+")) {
				answerNumber = answerNumber + temNumber;
			} else if (mark.equals("^") || mark.equals("1/x") || mark.equals("√") || mark.equals("sin")
					|| mark.equals("cos") || mark.equals("tan") || mark.equals("10^") || mark.equals("log")) {
				temNumber = answerNumber;
			} else if (mark.equals("mod")) {
				answerNumber = answerNumber % temNumber;
			} else if (mark.equals("^y")) {
				answerNumber = Math.pow(answerNumber, temNumber);
			} else {
				answerNumber = temNumber;
			}

			answerNumber = Math.log10(answerNumber);
			showAnswer = Double.toString(answerNumber);
			if (showAnswer.endsWith("0")) {
				showAnswer = Integer.toString((int) answerNumber);
			}
			if (time == 2) {
				temNumber = 0;
			}
			calculator_process.setText(showFormula);
			calculator_answer.setText(showAnswer);
			time = 2;
			mark = "log";
			break;

		case 20:
			if (time == 1) {
				showFormula = showFormula + " Mod ";
				answerNumber = temNumber;
				showAnswer = Double.toString(answerNumber);
				if (showAnswer.endsWith("0")) {
					showAnswer = Integer.toString((int) answerNumber);
				}
				mark = "mod";
				time = 2;
			} else {
				showFormula = showFormula + "Mod";
				switch (mark) {
				case "/":
					answerNumber = answerNumber / temNumber;
					break;
				case "×":
					answerNumber = answerNumber * temNumber;
					break;
				case "-":
					answerNumber = answerNumber - temNumber;
					break;
				case "+":
					answerNumber = answerNumber + temNumber;
					break;
				case "^y":
					answerNumber = Math.pow(answerNumber, temNumber);
					break;
				case "mod":
					answerNumber = answerNumber % temNumber;
					break;
				}
				showAnswer = Double.toString(answerNumber);
				if (showAnswer.endsWith("0")) {
					showAnswer = Integer.toString((int) answerNumber);
				}
				mark = "mod";

			}
			next = 1;
			calculator_process.setText(showFormula);
			calculator_answer.setText(showAnswer);
			break;

		case 21:
			if (time == 1) {
				lmark = 1;
				showFormula = showFormula + "( ";
				mark = "(";
				time = 2;
			} else {
				showFormula = showFormula + "( ";
				temfnum.add(answerNumber);
				temfmark.add(mark);
				lmark++;
				answerNumber = 0;
				time = 1;
				mark = "(";
			}
			calculator_process.setText(showFormula);
			break;
		case 22:
			if (lmark != 0) {
				if (mark.equals("/") || mark.equals("×")) {
					temennum = ennum.get(ennum.size() - 1);
					temenmark = enmark.get(enmark.size() - 1);
				}

				showFormula = showFormula + " )";
				if (mark.equals("/")) {
					if (temenmark.equals("-")) {
						answerNumber = answerNumber / temNumber;
						answerNumber = temennum - answerNumber;
					} else if (temenmark.equals("+")) {
						answerNumber = answerNumber / temNumber;
						answerNumber = temennum + answerNumber;
					} else {
						answerNumber = answerNumber / temNumber;
					}
				} else if (mark.equals("×")) {
					if (temenmark.equals("-")) {
						answerNumber = answerNumber * temNumber;
						answerNumber = temennum - answerNumber;
					} else if (temenmark.equals("+")) {
						answerNumber = answerNumber * temNumber;
						answerNumber = temennum + answerNumber;
					} else {
						answerNumber = answerNumber * temNumber;
					}
				} else if (mark.equals("-")) {
					answerNumber = answerNumber - temNumber;
				} else if (mark.equals("+")) {
					answerNumber = answerNumber + temNumber;
				} else if (mark.equals("^") || mark.equals("1/x") || mark.equals("√") || mark.equals("sin")
						|| mark.equals("cos") || mark.equals("tan") || mark.equals("10^") || mark.equals("log")) {
					temNumber = answerNumber;
				} else if (mark.equals("mod")) {
					answerNumber = answerNumber % temNumber;
				} else if (mark.equals("^y")) {
					answerNumber = Math.pow(answerNumber, temNumber);
				} else {
					answerNumber = temNumber;
				}

				if (mark.equals("/") || mark.equals("×")) {
					ennum.remove(ennum.size() - 1);
					enmark.remove(enmark.size() - 1);
				}

				double temnum = temfnum.get(temfnum.size() - 1);
				String temmark = temfmark.get(temfmark.size() - 1);

				if (temmark.equals("/")) {
					answerNumber = temnum / answerNumber;
				} else if (temmark.equals("×")) {
					answerNumber = temnum * answerNumber;
				} else if (temmark.equals("-")) {
					answerNumber = temnum - answerNumber;
				} else if (temmark.equals("+")) {
					answerNumber = temnum + answerNumber;
				} else if (temmark.equals("^") || temmark.equals("1/x") || temmark.equals("√") || temmark.equals("sin")
						|| temmark.equals("cos") || temmark.equals("tan") || temmark.equals("10^")
						|| temmark.equals("log")) {
					temNumber = temnum;
				} else if (temmark.equals("mod")) {
					answerNumber = temnum % answerNumber;
				} else if (temmark.equals("^y")) {
					answerNumber = Math.pow(temnum, answerNumber);
				}

				temfnum.remove(temfnum.size() - 1);
				temfmark.remove(temfmark.size() - 1);
				showAnswer = Double.toString(answerNumber);
				if (showAnswer.endsWith("0")) {
					showAnswer = Integer.toString((int) answerNumber);
				}
				calculator_process.setText(showFormula);
				calculator_answer.setText(showAnswer);
				lmark--;
				mark = ")";
			}
			break;
		}
	}
	public String[] setMemory() {
		String tem = showAnswer;
		setMemory_arr[0] = showFormula + " =";
		setMemory_arr[1] = tem;
		setMemory_arr[2] = "0";
		MemoryController.setMemory(setMemory_arr);
		return setMemory_arr;
	}
	public void getMemory(String[] get_arr) {
		showFormula = get_arr[0].substring(0, get_arr[0].length() - 2);
		temNumber = Double.valueOf(get_arr[1]);
		showAnswer = Double.toString(temNumber);
		if (showAnswer.endsWith("0")) {
			showAnswer = Integer.toString((int) temNumber);
		}
		calculator_process.setText(showFormula);
		calculator_answer.setText(showAnswer);
		System.out.println(calculator_process.getText());
		System.out.println(calculator_answer.getText());
		time = 1;
		next = 1;
	}
}