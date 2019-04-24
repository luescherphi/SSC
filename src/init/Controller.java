package init;

import java.io.IOException;

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
        server.ConnectionReceiver srv = new server.ConnectionReceiver();
        try {
            srv.startListening(6666);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
