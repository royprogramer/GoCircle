package com.teamvoid.gocircle.ProfileRelated;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class ProfileController {

    @FXML
    private Circle Circle1;

    @FXML
    private Label Name;

    @FXML
    private Circle ball1;

    @FXML
    private Circle ball2;

    @FXML
    private Circle ball3;

    @FXML
    private Circle ball4;

    @FXML
    private Label circleName;

    @FXML
    private Label departmentnameshow;

    @FXML
    private ImageView profilepic;

    @FXML
    private StackPane stackpane;

    @FXML
    private Label uniNameshow;


    @FXML
    void editbtn(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("fxml/edit.fxml"));
        stackpane.getChildren().removeAll();
        stackpane.getChildren().setAll(fxml);

    }

    @FXML
    void goback(MouseEvent event) {

    }

    @FXML
    void imageset(MouseEvent event) {

    }


}
