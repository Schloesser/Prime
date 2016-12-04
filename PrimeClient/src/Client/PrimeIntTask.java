package Client;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.List;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class PrimeIntTask extends Task<Void> {

	private int max;
	private TextArea ta_display;
	private Button btn_go;

	public PrimeIntTask(int max, TextArea ta_display, Button btn_go) {
		this.max = max;
		this.ta_display = ta_display;
		this.btn_go = btn_go;
	}

	@Override
	protected Void call() throws Exception {
		try {
			List<Integer> primes = PrimeClient.getPrimeInteger(max);
			String out = "";
			for (Integer prime : primes) {
				out = out + String.valueOf(prime) + "\n";
			}
			final String output = out;
			Platform.runLater(() -> ta_display.setText(output));
		} catch (IOException | NotBoundException e) {
			// zeige ErrorDialog an
			// "Bitte versuchen Sie es erneut"
			
			// anzeigen der ErrorNachricht muss auf dem GUIThread erfolgen,
			// deshalb wird mit Platform.runLater ein Runnable in die
			// EventSchleife des GUIThreads hinterlegt
			Platform.runLater(() -> new RmiAlert().showAndWait());
		} finally {
			// reenable Button
			Platform.runLater(() -> btn_go.setDisable(false));
		}
		return null;
	}

}
