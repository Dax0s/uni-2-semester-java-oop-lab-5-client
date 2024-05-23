package org.example.chatclientjavafx.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.example.chatclientjavafx.client.Client;

public class ChatController {

    @FXML
    private TextField messageField;
    @FXML
    private TextArea chatArea;

    private Client client;

    @FXML
    protected void onSendButtonClick() {
        if (client == null || messageField.getText().isBlank()) return;

        client.getOut().println(messageField.getText());
        messageField.setText("");
    }

    @FXML
    protected void onEnterButtonClick(ActionEvent event) {
        onSendButtonClick();
    }

    public TextArea getChatArea() {
        return chatArea;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
