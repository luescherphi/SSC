package init;

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
        client.Client clt = new client.Client(primaryStage);
        clt.loadGUI();
    }
    
    @FXML
    private void launchServer() {
        server.Server srv = new server.Server(primaryStage);
        srv.loadGUI();
    }
    
    public void setStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}
