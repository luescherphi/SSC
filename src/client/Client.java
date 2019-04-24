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
    
    public Client(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    
    public void loadGUI() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("viewClient.fxml"));
        try {
            Parent root = (Parent)loader.load();
            primaryStage.setScene(new Scene(root));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
