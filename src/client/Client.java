package client;

import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Client {
    private Stage primaryStage;
    private ArrayList<Chatroom> rooms;

    /**
     * This class can create socket connections and
     * sets up the specific input and output Stream with that Socket.
     *
     * @author luescherphi
     * @version 1.0
     * @since 1.8.0
     */

    public Client(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    
    public void loadGUI() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("viewClient.fxml"));
        try {
            Parent root = loader.load();
            primaryStage.setScene(new Scene(root));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
