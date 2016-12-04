package sample;
import Client.PrimeClient;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TextArea;


import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.List;

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

    /**
     * Even the compiler says this method is never used, I believe it is !
     */
	public void initialize() {
		group = new ToggleGroup();
		radio_Integer.setToggleGroup(group);
		radio_String.setToggleGroup(group);
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
