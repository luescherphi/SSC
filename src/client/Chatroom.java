package client;
import init.Message;
import java.util.ArrayList;

public class Chatroom {
    private String name;
    private ArrayList<Message> messageHistory = new ArrayList<Message>();
    private ArrayList<String> users = new ArrayList<String>();

    public Chatroom(String name){
        this.name = name;
    }

    public void addUser(String nameUser){
        users.add(nameUser);
    }

    public void addMessage(Message message){
        messageHistory.add(message);
        //TODO chatroom update or also add message graphic item
    }

    public ArrayList<String> getUsers() {
        return users;
    }
}
