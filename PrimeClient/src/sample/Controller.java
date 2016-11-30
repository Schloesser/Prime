package sample;
import Client.PrimeClient;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TextArea;


import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.List;

public class Controller {


    final ToggleGroup group = new ToggleGroup();

    @FXML
    Button button_go;
    @FXML
    TextField tf_Limit;
    @FXML
    TextArea ta_display;
    @FXML
    RadioButton radio_Integer;
    @FXML
    RadioButton radio_String;


    public void initialize() {
        radio_Integer.setToggleGroup(group);
        radio_String.setToggleGroup(group);
    }
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
