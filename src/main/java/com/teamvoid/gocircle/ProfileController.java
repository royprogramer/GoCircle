package com.teamvoid.gocircle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {

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
    private String username;
    Connection connect;

    @FXML
    void createpost(MouseEvent event) {

    }

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

    @FXML
    void send(ActionEvent event) {

    }

    public void setData(String username) {
        this.username=username;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DatabaseConnection connectNow= new DatabaseConnection();
        connect= connectNow.getConnect();
        try {
            Statement statement= connect.createStatement();
            String query="";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
