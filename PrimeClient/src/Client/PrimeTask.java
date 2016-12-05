package Client;

import java.io.IOException;
import java.rmi.NotBoundException;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import util.ui.alerts.RmiAlert;

public class PrimeTask extends Task<Void> {

	private int max;
	private TextArea taDisplay;
	private Button btnGo;
	private PrimeCall primeCall;

	public PrimeTask(int max, PrimeCall primeCall ,TextArea taDisplay, Button btnToEnable) {
		this.max = max;
		this.taDisplay = taDisplay;
		this.btnGo = btnToEnable;
		this.primeCall = primeCall;
	}

	@Override
	protected Void call() throws Exception {
		try {
			
			final String output = primeCall.getPrime(max);
			Platform.runLater(() -> taDisplay.setText(output));
		} catch (IOException | NotBoundException e) {
			// zeige ErrorDialog an
			// "Bitte versuchen Sie es erneut"
			
			// anzeigen der ErrorNachricht muss auf dem GUIThread erfolgen,
			// deshalb wird mit Platform.runLater ein Runnable in die
			// EventSchleife des GUIThreads hinterlegt
			Platform.runLater(() -> new RmiAlert().showAndWait());
		} finally {
			// reenable Button
			Platform.runLater(() -> btnGo.setDisable(false));
		}
		return null;
	}

}
