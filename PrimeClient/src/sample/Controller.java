package sample;
import Client.PrimeClient;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;


import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.List;

public class Controller {


    private final ToggleGroup group = new ToggleGroup();


    @FXML
    private TextField tf_Limit;
    @FXML
    private TextArea ta_display;
    @FXML
    private RadioButton radio_Integer;
    @FXML
    private RadioButton radio_String;

    /**
     * Even the compiler says this method is never used, I believe it is !
     */
    public void initialize() {
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
    if(radio_Integer.isSelected())
    {
        int max = Integer.parseInt(tf_Limit.getText());
        List<Integer> primes= PrimeClient.getPrimeInteger(max);
        String out = "";
        for(Integer prime : primes)
        {
            out = out + String.valueOf(prime) + "\n";
        }

        ta_display.setText(out);

    }else if(radio_String.isSelected())
    {
        int max = Integer.parseInt(tf_Limit.getText());
        String primes= PrimeClient.getPrimeString(max);

        ta_display.setText(primes);
    }


    }




}
