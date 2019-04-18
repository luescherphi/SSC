package server;

import java.net.*;
import java.io.*;

public class ConnectionReceiver {
    
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    
    public void startListening(int port) throws IOException{
        serverSocket = new ServerSocket(port);
        while(true) {
            try {
                clientSocket = serverSocket.accept();
                DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
                
                Thread t = new ClientHandler(clientSocket, dis, dos);
                t.start();
            } catch (Exception e) {
                clientSocket.close();
                e.printStackTrace();
            }
        }
    }
}
