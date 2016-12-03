package sample;

import java.io.IOException;
import java.rmi.NotBoundException;

import Client.NumberAlert;
import Client.PrimeIntTask;
import Client.PrimeStringTask;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class Controller {

	private ToggleGroup group;

	@FXML
	private TextField tf_Limit;
	@FXML
	private TextArea ta_display;
	@FXML
	private RadioButton radio_Integer;
	@FXML
	private RadioButton radio_String;
	@FXML
	private Button btn_go;

	public void initialize() {
		group = new ToggleGroup();
		radio_Integer.setToggleGroup(group);
		radio_String.setToggleGroup(group);
	}

	@FXML
	protected void goButtonAction() throws IOException, NotBoundException {

		int max = 0;

		// Lese die Zahl in der TextBox ein
		try {
			max = Integer.parseInt(tf_Limit.getText());
			// loese bei Zahlen <= 0 den selben ErrorDialog aus.
			if (max <= 0) {
				throw new NumberFormatException();
			}
		} catch (NumberFormatException e) {
			new NumberAlert().showAndWait();
			return;
		}
		
		// disable Go_Button
		btn_go.setDisable(true);

		if (radio_Integer.isSelected()) {
			Task<Void> primeIntTask = new PrimeIntTask(max, ta_display, btn_go);
			new Thread(primeIntTask).start();

		} else if (radio_String.isSelected()) {

			Task<Void> primeStringTask = new PrimeStringTask(max, ta_display, btn_go);
			new Thread(primeStringTask).start();
		} else {
			btn_go.setDisable(false);
		}

	}

}
