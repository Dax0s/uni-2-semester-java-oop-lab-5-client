package org.example.chatclientjavafx.client;

import javafx.scene.control.TextArea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private final String serverAddress;
    private final int serverPort;

    private final PrintWriter out;
    private final Thread clientThread;
    private final ClientMessageHandler messageHandler;
    private final Socket socket;

    public Client(String serverAddress, int serverPort, TextArea chatArea) throws IOException {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;

        socket = new Socket(serverAddress, serverPort);
        System.out.println("Connected to server!");

        out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        messageHandler = new ClientMessageHandler(in, chatArea);
        clientThread = new Thread(messageHandler);
        clientThread.start();

//        Scanner scanner = new Scanner(System.in);
//        String userInput;

//        while (true) {
//            userInput = scanner.nextLine();
//            out.println(userInput);
//        }
    }

    public PrintWriter getOut() {
        return out;
    }

    public Thread getClientThread() {
        return clientThread;
    }

    public ClientMessageHandler getMessageHandler() {
        return messageHandler;
    }

    public Socket getSocket() {
        return socket;
    }
}
