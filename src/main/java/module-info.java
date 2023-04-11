module com.example.gocircle {
    requires javafx.controls;
    requires javafx.fxml;
    requires io.github.cdimascio.dotenv.java;
    requires java.mail;
    requires java.sql;


    opens com.teamvoid.gocircle to javafx.fxml;
    exports com.teamvoid.gocircle;
    exports com.teamvoid.gocircle.Server;
    opens com.teamvoid.gocircle.Server to javafx.fxml;
    exports com.teamvoid.gocircle.Client;
    opens com.teamvoid.gocircle.Client to javafx.fxml;
}