package client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.nio.Buffer;

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
    private PrintWriter outConnection;
    private BufferedReader inConnection;

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
            outConnection = new PrintWriter(clientSocket.getOutputStream(), true);
            inConnection = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //TODO startListening class for creating recieveMessage Thread



    public String recieveMessage(){
        String message = "";
        try {
            message = inConnection.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return message;
    }

    public boolean sendMessage(String message){
        try {
            outConnection.println(message);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * A simple method, that sends a ping to the Server.
     * This method might get deleted later on in the Project
     * @return true if ping was successful
     */
    public boolean pingConnection(){
        boolean pingSuccess = false;
        System.out.println("Sende Ping an " + ip + ":" + port);
        outConnection.println("ping");
        try {
            String answer = inConnection.readLine();
            System.out.println(answer);
            pingSuccess = true;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(".... no answer");
        }
        return pingSuccess;
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
