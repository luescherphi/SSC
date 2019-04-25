package client;

import resources.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tab;

import java.util.ArrayList;

public class ControllerClient {
    private ArrayList<Chatroom> chatroomsList = new ArrayList<>();

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

    public void createChatroom(){
        Chatroom newChatroom = new Chatroom();
        chatroomsList.add(newChatroom);
    }
}
