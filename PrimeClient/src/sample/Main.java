package sample;

import Client.PrimeClient;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * This class starts the Fx-Application. It uses the sample.fxml to place Fx-Components on a scene
 * and a controller to handle actions from the user. Both are connected to each other by annotations.
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            primaryStage.setTitle("Prime");
            primaryStage.setMinHeight(400);
            primaryStage.setMinWidth(750);

            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(true);
            primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }



}
