package com.teamvoid.gocircle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

public class Main extends Application {
    public static Stage stage = null;
    @Override
    public void start(Stage stage) throws IOException {

        this.stage = stage;
       // FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/dboard.fxml"));
    // FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/clientScreen.fxml"));
      // FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/dfg.fxml"));
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/test.fxml"));
        Parent root = fxmlLoader.load();
        TestController controller = fxmlLoader.getController();
        controller.setPrimaryStage(stage);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);


        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    public static void enableMove(Scene scene, Stage primaryStage) {
        AtomicReference<Double> xOffset = new AtomicReference<>((double) 0);
        AtomicReference<Double> yOffset = new AtomicReference<>((double) 0);
        scene.setOnMousePressed(event -> {
            xOffset.set(primaryStage.getX() - event.getScreenX());
            yOffset.set(primaryStage.getY() - event.getScreenY());
            scene.setCursor(Cursor.CLOSED_HAND);
        });
        //Lambda mouse event handler
        scene.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() + xOffset.get());
            primaryStage.setY(event.getScreenY() + yOffset.get());
        });


        scene.setOnMouseReleased(event -> {
            scene.setCursor(Cursor.DEFAULT);
        });
    }
}