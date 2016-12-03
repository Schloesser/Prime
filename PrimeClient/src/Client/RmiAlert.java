package Client;

import javafx.scene.control.Alert;

public class RmiAlert extends Alert {

	public RmiAlert() {
		super(AlertType.ERROR);
		setTitle("Server nicht erreichbar!");
		setHeaderText("Konnte keine Verbindung zum Server herstellen!");
		setContentText("Bitte versuchen Sie es später erneut.");
	}

}
