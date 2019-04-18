package ausprobieren;

import java.net.*;
import java.io.*;

public class SocketServer {
    
    
    
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    
    public void start(int port) throws IOException{
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        while(true) {
            try {
                String greeting = in.readLine();
                if("hello server".contentEquals(greeting)) {
                    out.println("hello client");
                } else {
                    out.println("unrecognised greeting");
                }
                System.out.println("---------------------------------");
                System.out.println(greeting);
            } catch (Exception e) {
                System.out.println("VERBINDUNG VERLOREN");
                System.out.println(e.getClass());
                clientSocket = serverSocket.accept();
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            }
            
        }
    }
    
    public void stop() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
    
}
