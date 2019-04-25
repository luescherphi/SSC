package server;

import java.net.*;
import java.io.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
     * @throws Exception when forming new Objects from connection fail.
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

    public void loadGUI() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("viewServer.fxml"));
        try {
            Parent root = loader.load();
            primaryStage.setScene(new Scene(root));
            ControllerServer ctrl = loader.getController();
            ctrl.initController(this);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method reads the IP-Address of the Server Machine
     * and returns it as a string
     * @return String: IP-Address of Server
     */
    public String getIpAddress() {
        try(final DatagramSocket socket = new DatagramSocket()){
            //try to connect to 8.8.8.8 to locate the running Adapter
            socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
            String ipAddress = socket.getLocalAddress().getHostAddress();
            socket.close();
            return ipAddress;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
