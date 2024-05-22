package org.example.chatclientjavafx.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import org.example.chatclientjavafx.client.Client;

public class ChatController {

    @FXML
    private TextField messageField;
    @FXML
    private TextArea chatArea;

    private Client client;

    @FXML
    private void initialize() {
        messageField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                onSendButtonClick();
            }
        });
    }

    @FXML
    protected void onSendButtonClick() {
        if (client == null || messageField.getText().isBlank()) return;

        client.getOut().println(messageField.getText());
        messageField.setText("");
    }

    public TextArea getChatArea() {
        return chatArea;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
