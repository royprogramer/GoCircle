package com.teamvoid.gocircle.Server;

import com.teamvoid.gocircle.Main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class mainServer extends Application {
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/serverScreen.fxml"));
      //  FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/serverScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);


        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
