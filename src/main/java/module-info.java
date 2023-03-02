module com.example.gocircle {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.teamvoid.gocircle to javafx.fxml;
    exports com.teamvoid.gocircle;
}