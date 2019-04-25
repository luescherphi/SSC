package client;
import init.Message;
import java.util.ArrayList;

public class Chatroom {
    private String name;
    private int id;
    private ServerConnection serverConnection;
    private ArrayList<Message> messageHistory = new ArrayList<Message>();
    private ArrayList<String> users = new ArrayList<String>();

    /**
     * This class can create socket connections and
     * sets up the specific input and output Stream with that Socket.
     *
     * @author ambergj
     * @version 1.0
     * @since 1.8.0
     */

    /**
     * Initializes Chatroom with id, name and Serverconnection.
     * @param id
     * @param name
     */
    public Chatroom(int id, String name){
        this.id = id;
        this.name = name;
        serverConnection = new ServerConnection("127.0.0.1", 70000);
    }

    public void addUser(String nameUser){
        users.add(nameUser);
    }

    public void addMessage(Message message){
        messageHistory.add(message);
        //TODO chat-room update or also add message graphic item
    }

    public String getUsers(int id) {
        return users.get(id);
    }

    public Message getMessageHistory(int id) {
        return messageHistory.get(id);
    }
}
