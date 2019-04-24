package client;

import init.Message;

import java.io.*;
import java.io.IOException;
import java.lang.Thread;

public class MessageReceiver implements Runnable {
    
    private ObjectInputStream inConnection;
    
    public MessageReceiver(ObjectInputStream inConnection) {
        this.inConnection = inConnection;
    }
    
    @Override
    public void run() {
        Message message;
        while(!Thread.currentThread().isInterrupted()) {
            try {
                message = (Message) inConnection.readObject();
                System.out.println(message);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
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
