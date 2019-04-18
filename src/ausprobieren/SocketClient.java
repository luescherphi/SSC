package ausprobieren;

import java.net.*;
import java.io.*;
import java.nio.Buffer;
import java.util.Scanner;

public class SocketClient {

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    Scanner inputConsole;

    public static void main(String[] args) {
        SocketClient instance = new SocketClient();
        instance.startConnection("172.16.2.155", 6666);
        while (true) {
            instance.sendMessage("hello server");
        }
        //instance.stopConnection();
    }

    public void startConnection(String ip, int port){
        try {
            clientSocket = new Socket(ip, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            inputConsole = new Scanner(System.in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String sendMessage(String msg){
        System.out.println("Gib eine Nachricht ein.");
        String resp = "";
        try {
            String inputMessage = inputConsole.nextLine();
            out.println(msg);
            out.println(inputMessage);
            resp = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(resp);
        return resp;
    }

    public void stopConnection(){
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String inputMessage(){
        System.out.println("suepre");
        return "wefawqef";
    }
}

