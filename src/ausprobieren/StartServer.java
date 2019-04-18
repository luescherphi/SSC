package ausprobieren;

import java.net.*;
import java.io.*;

public class StartServer {
    public static void main(String[] args) {
        SocketServer server = new SocketServer();
        try {            
            server.start(6666);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
