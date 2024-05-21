package org.example.chatclientjavafx.client;

import javafx.scene.control.TextArea;

import java.io.BufferedReader;
import java.io.IOException;

public class ClientMessageHandler implements Runnable {
    private final BufferedReader in;
    private final TextArea chatArea;
    private boolean stopThread = false;

    public ClientMessageHandler(BufferedReader in, TextArea chatArea) {
        this.in = in;
        this.chatArea = chatArea;
    }

    public void stopThread() {
        stopThread = true;
    }

    @Override
    public void run() {
        try {
            String serverResponse;
            while ((serverResponse = in.readLine()) != null) {
//                System.out.println(serverResponse);
                chatArea.setText(chatArea.getText() + "\n" + serverResponse);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
