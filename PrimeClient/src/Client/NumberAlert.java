package Client;

import javafx.scene.control.Alert;

public class NumberAlert extends Alert {

	public NumberAlert() {
		super(AlertType.WARNING);
		setTitle("Fehlerhafte Eingabe");
		setHeaderText("Bitte prüfen Sie Ihre Eingabe");
		setContentText("Bitte prüfen Sie die Eingabe der zu errechnenden Primzahlen.");
	}

}
