package server;

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
    private DataInputStream dis;
    private DataOutputStream dos;
    
    public ClientHandler(Socket clientSocket, DataInputStream dis, DataOutputStream dos) {
        this.clientSocket = clientSocket;
        this.dis = dis;
        this.dos = dos;
    }
    /**
     * Tauscht Nachrichten mit einem Client aus.
     * Diese Methode wartet in einer Endlosschleife auf neue Nachrichten
     * des zugeordneten Clients und gibt diese auf der Konsole aus.
     */
    @Override
    public void run() {
        while(true) {
            try {
                String message = dis.readUTF();
                dos.writeUTF("successfully received");
                System.out.println("----------------------");
                System.out.println(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //TODO dis, dos & clientSocket schliessen
    }
}
