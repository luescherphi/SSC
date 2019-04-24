package client;
import init.Message;
import java.util.ArrayList;

public class Chatroom {
    private String name;
    private int id;
    private ServerConnection serverConnection;
    private ArrayList<Message> messageHistory = new ArrayList<Message>();
    private ArrayList<String> users = new ArrayList<String>();

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

    public ArrayList<String> getUsers() {
        return users;
    }
}
