package sample;

import java.io.IOException;
import java.rmi.NotBoundException;

import Client.PrimeCall;
import Client.PrimeCallInteger;
import Client.PrimeCallString;
import Client.PrimeTask;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import util.ui.alerts.NumberAlert;

public class Controller {

	private ToggleGroup group;

	@FXML
	private TextField tfLimit;
	@FXML
	private TextArea taDisplay;
	@FXML
	private RadioButton radioInteger;
	@FXML
	private RadioButton radioString;
	@FXML
	private RadioButton radioObject;
	@FXML
	private Button btnGo;

    /**
     * Even the compiler says this method is never used, I believe it is !
     */
	public void initialize() {
		group = new ToggleGroup();
		radioInteger.setToggleGroup(group);
		radioString.setToggleGroup(group);
		radioObject.setToggleGroup(group);
	}
    /**
     * Depend on which mode is selected by the radios, this method will print integers
     * or strings to the text area. The data come from the server, so a NotBoundException will be thrown
     * if the server can't handle the request.
     *
     * PLEASE DELETE THIS LINE IF YOU ALREADY IMPLEMENTED THE CATCH OF THE EXCEPTION OTHERWISE PLEASE IMPLEMENT IT!:)
     * @throws IOException
     * @throws NotBoundException
     */
	@FXML
	protected void goButtonAction() throws IOException, NotBoundException {

		int max = 0;

		// Lese die Zahl in der TextBox ein
		try {
			max = Integer.parseInt(tfLimit.getText());
			// loese bei Zahlen <= 0 den selben ErrorDialog aus.
			if (max <= 0) {
				throw new NumberFormatException();
			}
		} catch (NumberFormatException e) {
			new NumberAlert().showAndWait();
			return;
		}

		// disable Go-Button
		btnGo.setDisable(true);

		// Strategy Pattern
		// PrimeCall delegiert an die jeweilige Implementierung des RMICalls
		// dadurch müssen keine extra PrimeTasks für die Übertragung als
		// Int-Array, als String bzw als eigenes Objekt erstellt werden.
		PrimeCall primeCall = null;

		if (radioInteger.isSelected()) {
			primeCall = new PrimeCallInteger();

		} else if (radioString.isSelected()) {
			primeCall = new PrimeCallString();
		} else if (radioObject.isSelected()) {
			// TODO: Hier sollte der RMICall als Objekt hinzugefügt werden
			primeCall = null;
			btnGo.setDisable(false);
		} else {
			btnGo.setDisable(false);
		}

		if (primeCall != null) {
			Task<Void> primeTask = new PrimeTask(max, primeCall, taDisplay, btnGo);
			new Thread(primeTask).start();
		}

	}

}
