package server;

import resources.*;
import java.net.*;
import java.io.*;

/**
 * Ein Objekt dieser Klasse ist dafür zuständig, die Verbindung zu jeweils einem
 * Client offenzuhalten und den Datenaustausch zu bewerkstelligen.
 * 
 * @author luescherphi
 * @version 1.0
 * @since 1.8.0
 */
public class ClientHandler extends Thread {
    
    private Socket clientSocket;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    
    public ClientHandler(Socket clientSocket, ObjectInputStream ois, ObjectOutputStream oos) {
        this.clientSocket = clientSocket;
        this.ois = ois;
        this.oos = oos;
    }
    /**
     * Tauscht Nachrichten mit einem Client aus.
     * Diese Methode wartet in einer Endlosschleife auf neue Nachrichten
     * des zugeordneten Clients und gibt diese auf der Konsole aus.
     */
    @Override
    public void run() {
        //TODO weitermachen
        Chatroom chatroom = new Chatroom();
        while(true) {
            try {
                Message message = (Message)ois.readObject();
                chatroom.distributeMessage(message);
                oos.writeUTF("successfully received and Sent");
                System.out.println("----------------------");
                System.out.println(message);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        //TODO dis, dos & clientSocket schliessen
    }
}
