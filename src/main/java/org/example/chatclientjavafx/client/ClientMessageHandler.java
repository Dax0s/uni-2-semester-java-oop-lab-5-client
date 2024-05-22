package org.example.chatclientjavafx.client;

import javafx.scene.control.TextArea;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.SocketException;

public class ClientMessageHandler implements Runnable {
    private final BufferedReader in;
    private final TextArea chatArea;

    public ClientMessageHandler(BufferedReader in, TextArea chatArea) {
        this.in = in;
        this.chatArea = chatArea;
    }

    @Override
    public void run() {
        try {
            String serverResponse;
            while ((serverResponse = in.readLine()) != null) {
//                System.out.println(serverResponse);
                chatArea.setText(chatArea.getText() + "\n" + serverResponse);
            }
        } catch (SocketException e) {
            System.out.println("Socket is already closed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
