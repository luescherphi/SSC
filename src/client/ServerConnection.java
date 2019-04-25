package client;
import java.io.*;
import java.net.*;
import resources.Message;


/**
 * This class can create socket connections and
 * sets up the specific input and output Stream with that Socket.
 *
 * @author ambergj
 * @version 1.0
 * @since 1.8.0
 */

public class ServerConnection {
    private String ip;
    private int port;
    private Socket clientSocket;
    private ObjectOutputStream outConnection;
    private ObjectInputStream inConnection;
    private MessageReceiver messageReceiver;

    /**
     * defines ip and port
     * @param ip to where the client should connect
     * @param port that is specified to connect over
     */
    public ServerConnection(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    /**
     * Method that tries to set up a new Socket and set up
     * it specific input and output-stream.
     */
    public void startConnection(){
        try {
            clientSocket = new Socket(ip, port);
            outConnection = new ObjectOutputStream(clientSocket.getOutputStream());
            inConnection = new ObjectInputStream(clientSocket.getInputStream());
            this.messageReceiver = new MessageReceiver(inConnection);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Deprecated
    public Message receiveMessage(){
        Message message = null;
        try {
            message = (Message) inConnection.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return message;
    }

    public boolean sendMessage(String message){
        try {
            outConnection.writeObject(message);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Tries to close input, output stream and closes clientSocket.
     */
    public void stopConnection(){
        try {
            inConnection.close();
            outConnection.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
