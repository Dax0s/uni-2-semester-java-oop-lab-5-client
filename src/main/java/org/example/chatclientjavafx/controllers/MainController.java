package org.example.chatclientjavafx.controllers;

import javafx.fxml.FXML;
import org.example.chatclientjavafx.Singleton;

public class MainController {
    private final Singleton singleton = Singleton.getInstance();

    @FXML
    protected void onServerConnectButtonClick() {
        singleton.getMainBorderPane().setCenter(singleton.getServerConnectAnchorPane());
    }

    @FXML
    protected void onChatButtonClick() {
        singleton.getMainBorderPane().setCenter(singleton.getChatAnchorPane());
    }
}
