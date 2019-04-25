package server;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tab;

public class ControllerServer {

    @FXML
    private Button btnTemp;
    
    @FXML
    private Button btnNewChat;
    
    @FXML
    private Button btnCloseChat;
    
    @FXML
    private TabPane tabPane;
    
    @FXML
    private void newChat() {
        tabPane.getTabs().add(new Tab());
    }
    
    @FXML
    private void closeChat() {
        Tab t = tabPane.getSelectionModel().getSelectedItem();
        if(t.isClosable()) {
            tabPane.getTabs().remove(t);
        }
    }
}
