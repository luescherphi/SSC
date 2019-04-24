package init;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {
    
    @FXML
    private Button btnLaunchClient;
    
    @FXML
    private Button btnLaunchServer;
    
    @FXML
    private void launchClient() {
        System.out.println("Launch Client");
    }
    
    @FXML
    private void launchServer() {
        System.out.println("Launch Server");
    }
}
