package server;

import java.net.*;
import java.io.*;

import javafx.stage.Stage;

/**
 * Diese Klasse enthält die Logik zum Erstellen und Verwalten von Verbindungen
 * mit Clients. Die Verarbeitung erfolgreich erstellter Verbindugnen wird dabei
 * an generierte Objekte der ClientHandler-Klasse weitergeleitet.
 * 
 * @author luescherphi
 * @version 1.0
 * @since 1.8.0
 */

public class Server {
    
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private Stage primaryStage;
    private PrintWriter out;
    private BufferedReader in;
    
    /**
     * Constructor to instantiate a new Server
     * @param primaryStage Hand over the previously used stage to the Server
     */
    public Server(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    
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
            try {
                clientSocket = serverSocket.accept();
                ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
                ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
                
                Thread t = new ClientHandler(clientSocket, ois, oos);
                t.start();
            } catch (Exception e) {
                clientSocket.close();
                e.printStackTrace();
            }
        }
    }
}
