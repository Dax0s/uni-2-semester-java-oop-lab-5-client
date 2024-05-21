module org.example.chatclientjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.chatclientjavafx to javafx.fxml;
    exports org.example.chatclientjavafx;
    opens org.example.chatclientjavafx.client to javafx.fxml;
    exports org.example.chatclientjavafx.client;
    opens org.example.chatclientjavafx.controllers to javafx.fxml;
    exports org.example.chatclientjavafx.controllers;
}