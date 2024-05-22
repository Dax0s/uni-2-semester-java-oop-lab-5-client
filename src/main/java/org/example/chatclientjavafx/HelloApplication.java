package org.example.chatclientjavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader mainBorderPaneLoader = new FXMLLoader(HelloApplication.class.getResource("main-view.fxml"));
        BorderPane mainBorderPane = mainBorderPaneLoader.load();

        FXMLLoader serverConnectAnchorPaneLoader = new FXMLLoader(HelloApplication.class.getResource("server-connect-view.fxml"));
        AnchorPane serverConnectAnchorPane = serverConnectAnchorPaneLoader.load();

        FXMLLoader chatAnchorPaneLoader = new FXMLLoader(HelloApplication.class.getResource("chat-view.fxml"));
        AnchorPane chatAnchorPane = chatAnchorPaneLoader.load();

        Singleton.getInstance().setMainBorderPane(mainBorderPane);
        Singleton.getInstance().setServerConnectAnchorPane(serverConnectAnchorPane);
        Singleton.getInstance().setChatAnchorPane(chatAnchorPane);

        Singleton.getInstance().setServerConnectController(serverConnectAnchorPaneLoader.getController());
        Singleton.getInstance().setChatController(chatAnchorPaneLoader.getController());

        mainBorderPane.setCenter(serverConnectAnchorPane);

        Scene scene = new Scene(mainBorderPane, 600, 500);
        stage.setTitle("Chat application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}