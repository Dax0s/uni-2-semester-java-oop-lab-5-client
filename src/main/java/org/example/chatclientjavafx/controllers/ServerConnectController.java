package org.example.chatclientjavafx.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.example.chatclientjavafx.client.Client;

import java.io.IOException;

public class ServerConnectController {
    @FXML
    private TextField serverAddressField;
    @FXML
    private TextField serverPortField;

    @FXML
    private TextField messageField;
    @FXML
    private TextArea chatArea;

    private Client client;

    @FXML
    protected void onConnectButtonClick() {
        String serverAddress = serverAddressField.getText();
        String serverPortString = serverPortField.getText();
        int serverPort;

        if (serverAddress.isBlank()) {
            System.out.println("Server address cannot be empty");
            return;
        }

        if (serverPortString.isBlank()) {
            System.out.println("Server port cannot be empty");
            return;
        }

        try {
            serverPort = Integer.parseInt(serverPortString);
        } catch (NumberFormatException e) {
            System.out.println("Server port field must be a number");
            return;
        }

        try {
            if (client != null && client.getClientThread().isAlive()) {
                client.getClientThread().interrupt();
                client.getSocket().close();
            }
            serverAddressField.setText("");
            serverPortField.setText("");

            chatArea.setText("");

            client = new Client(serverAddress, serverPort, chatArea);
        } catch (IOException e) {
            System.out.println("Cannot connect to host");
        }
    }

    @FXML
    protected void onSendButtonClick() {
        if (client == null || messageField.getText().isBlank()) return;

        client.getOut().println(messageField.getText());
        messageField.setText("");
    }
}