package org.example.chatclientjavafx;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import org.example.chatclientjavafx.controllers.ChatController;
import org.example.chatclientjavafx.controllers.ServerConnectController;

import java.util.Optional;

public class Singleton {
    private static Optional<Singleton> instance = Optional.empty();

    private BorderPane mainBorderPane;
    private AnchorPane serverConnectAnchorPane;
    private AnchorPane chatAnchorPane;

    private ServerConnectController serverConnectController;
    private ChatController chatController;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance.isEmpty()) {
            instance = Optional.of(new Singleton());
        }

        return instance.get();
    }

    public BorderPane getMainBorderPane() {
        return mainBorderPane;
    }

    public void setMainBorderPane(BorderPane mainBorderPane) {
        this.mainBorderPane = mainBorderPane;
    }

    public AnchorPane getServerConnectAnchorPane() {
        return serverConnectAnchorPane;
    }

    public void setServerConnectAnchorPane(AnchorPane serverConnectAnchorPane) {
        this.serverConnectAnchorPane = serverConnectAnchorPane;
    }

    public ServerConnectController getServerConnectController() {
        return serverConnectController;
    }

    public void setServerConnectController(ServerConnectController serverConnectController) {
        this.serverConnectController = serverConnectController;
    }

    public ChatController getChatController() {
        return chatController;
    }

    public void setChatController(ChatController chatController) {
        this.chatController = chatController;
    }

    public AnchorPane getChatAnchorPane() {
        return chatAnchorPane;
    }

    public void setChatAnchorPane(AnchorPane chatAnchorPane) {
        this.chatAnchorPane = chatAnchorPane;
    }
}
