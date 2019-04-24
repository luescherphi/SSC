package server;

import java.net.*;
import java.io.*;

/**
 * Diese Klasse enthält die Logik zum Erstellen und Verwalten von Verbindungen
 * mit Clients. Die Verarbeitung erfolgreich erstellter Verbindugnen wird dabei
 * an generierte Objekte der ClientHandler-Klasse weitergeleitet.
 * 
 * @author luescherphi
 * @version 1.0
 * @since 1.8.0
 */

public class ConnectionReceiver {
    
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    
    /**
     * Diese Methode erstellt den Server-Socket und leitet eingehende Verbindungen
     * an jeweils ein Thread-Objekt der ClientHandler-Klasse weiter, um anschliessend
     * wieder auf weitere eingehende Verbindungen reagieren zu können.
     * 
     * @param port int, Port-Nummer, auf der der Server hören soll
     * @throws IOException
     */
    public void startListening(int port) throws IOException{
        serverSocket = new ServerSocket(port);
        while(true) {
            System.out.println("1234");
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
