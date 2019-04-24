package client;

import javafx.stage.Stage;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

public class Client {

    private Stage primaryStage;
    
    public Client(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    
    public void loadGUI() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view.fxml"));
        try {
            Parent root = (Parent)loader.load();
            primaryStage.setScene(new Scene(root));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
