package init;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class ControllerInit {
    
    private Stage primaryStage;
    
    @FXML
    private Button btnLaunchClient;
    
    @FXML
    private Button btnLaunchServer;
    
    @FXML
    private void launchClient() {
        System.out.println("Launch Client");
        client.Client clt = new client.Client(primaryStage);
        clt.loadGUI();
    }
    
    @FXML
    private void launchServer() {
        System.out.println("Launch Server");
        server.Server srv = new server.Server(primaryStage);
        try {
            srv.startListening(6666);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void setStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}
