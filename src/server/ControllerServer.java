package server;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerServer {
    
    private Server server;
    
    @FXML
    private Label lblIP;
    
    @FXML
    private TextField tfPort;
    
    @FXML
    private Button btnLaunch;
    
    /**
     * This method serves for displaying the server IP-Address on the User Interface
     * @param server Server-Object which loads this GUI
     */
    public void initController(Server server) {
        this.server = server;
        lblIP.setText(server.getIpAddress());
    }
    
    @FXML
    private void launchServer() {
        Stage stage = (Stage)btnLaunch.getScene().getWindow();
        stage.close();
        int port = 0;
        try {
            port = Integer.parseInt(tfPort.getText());
            server.startListening(port);
        } catch (NumberFormatException e) {
            //TODO Falsche Benutzereingabe abfangen
            e.printStackTrace();
        } catch (IOException e) {
            //TODO Fehler bei Server-Startup abfangen
            e.printStackTrace();
        }
    }
}
