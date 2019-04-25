package resources;
import client.ServerConnection;

import java.util.ArrayList;

/**
 * This class can create socket connections and
 * sets up the specific input and output Stream with that Socket.
 *
 * @author ambergj
 * @version 1.0
 * @since 1.8.0
 */
public class Chatroom {
    private String name;
    private String ipAddress = "127.0.0.1";
    private int port = 70000;
    private ServerConnection serverConnection;
    private ArrayList<Message> messageHistory = new ArrayList<>();
    private ArrayList<String> users = new ArrayList<>();

    /**
     * Initializes Chatroom with id, name and Serverconnection.
     */
    public Chatroom(){
        this.name = "Chatroom";
        //TODO divide server and client, different connections
        serverConnection = new ServerConnection(ipAddress, port);
    }

    public void distributeMessage(Message message){

        addMessage(message);
    }

    public void addMessage(Message message){
        messageHistory.add(message);
    }

    public Message getMessage(int idMessage) {
        return messageHistory.get(idMessage);
    }
}
