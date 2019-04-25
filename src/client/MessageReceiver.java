package client;

import init.Message;

import java.io.*;
import java.io.IOException;
import java.lang.Thread;

/**
 * This Class handels the receiveMessage in an extra Thread
 * with the implements Runnable method.
 * When the While loop breaks it closes the Connection in the catch.
 *
 * @author luescherphi
 * @version 1.0
 * @since 1.8.0
 */

public class MessageReceiver implements Runnable {
    
    private ObjectInputStream inConnection;

    /**
     * Constructor
     * @param inConnection to be outsourced
     */
    public MessageReceiver(ObjectInputStream inConnection) {
        this.inConnection = inConnection;
    }

    /**
     * Runnable run method to create new Thread.
     */
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
