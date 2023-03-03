module com.example.gocircle {
    requires javafx.controls;
    requires javafx.fxml;
    requires  java.sql;


    opens com.teamvoid.gocircle to javafx.fxml;
    exports com.teamvoid.gocircle;
}