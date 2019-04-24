package client;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;

public class Client {

    private Stage primaryStage;
    
    public Client(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    
    public void loadGUI() {
        primaryStage.setScene(new Scene(new Label("Hello")));
    }
    
}
