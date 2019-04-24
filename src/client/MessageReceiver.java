package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.Thread;

public class MessageReceiver implements Runnable {
    
    private BufferedReader inConnection;
    
    public MessageReceiver(BufferedReader inConnection) {
        this.inConnection = inConnection;
    }
    
    @Override
    public void run() {
        String message = "";
        while(!Thread.currentThread().isInterrupted()) {
            try {
                message = inConnection.readLine();
                System.out.println(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            inConnection.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
