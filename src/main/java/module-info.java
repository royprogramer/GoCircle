module com.example.gocircle {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gocircle to javafx.fxml;
    exports com.example.gocircle;
}