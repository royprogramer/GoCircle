module com.example.gocircle {
    requires javafx.controls;
    requires javafx.fxml;
    requires io.github.cdimascio.dotenv.java;
    requires java.mail;
    requires java.sql;
    requires com.jfoenix;


    opens com.teamvoid.gocircle to javafx.fxml;
    exports com.teamvoid.gocircle;
    exports com.teamvoid.gocircle.Server;
    opens com.teamvoid.gocircle.Server to javafx.fxml;
    exports com.teamvoid.gocircle.Client;
    opens com.teamvoid.gocircle.Client to javafx.fxml;

    opens  com.teamvoid.gocircle.chat.chat.controller to javafx.fxml;
    exports com.teamvoid.gocircle.chat.chat.controller;
    opens  com.teamvoid.gocircle.chat.chat to javafx.fxml;
    exports com.teamvoid.gocircle.chat.chat;

    exports com.teamvoid.gocircle.Todo;
    opens com.teamvoid.gocircle.Todo to javafx.fxml;

}