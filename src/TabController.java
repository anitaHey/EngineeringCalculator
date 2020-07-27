import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import java.io.IOException;

import javafx.beans.value.ObservableValue;

public class TabController{
	@FXML private TabPane menu;
	@FXML private Tab button_calculator,button_date,button_capacity,button_angle,button_length,button_weight,button_area,button_temperature;
	@FXML private AngleController angleController;
	@FXML private AreaController areaController;
	@FXML private CalculatorController calculatorController;
	@FXML private CapacityController capacityController;
	@FXML private DateController dateController;
	@FXML private LengthController lengthController;
	@FXML private MemoryController memoryController;
	@FXML private TemperatureController temperatureController;
	@FXML private WeightController weightController;
	
	public void initialize() {
		menu.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Tab> observable,
                Tab oldValue, Tab newValue) -> {
                	if (newValue == button_calculator) {
                		calculatorController.normal_symbol(4);
                	} else if (newValue == button_date) {
                		dateController.clean();
                	}else if (newValue == button_capacity) {
                		capacityController.symbol(1);
                	}else if (newValue == button_angle) {
                		angleController.symbol(1);
                	}else if (newValue == button_length) {
                		lengthController.symbol(1);
                	}else if (newValue == button_weight) {
                		weightController.symbol(1);
                	}else if (newValue == button_area) {
                		areaController.symbol(1);
                	}else if (newValue == button_temperature) {
                		temperatureController.symbol(1);
                	}
                });
	}
}