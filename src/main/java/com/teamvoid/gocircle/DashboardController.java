package com.teamvoid.gocircle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    @FXML
    private Circle activeStatus;

    @FXML
    private Circle activeStatus1;

    @FXML
    private Circle batch1;

    @FXML
    private Circle batch2;

    @FXML
    private Circle batch3;

    @FXML
    private Circle batch4;

    @FXML
    private ImageView minmaxbar;

    @FXML
    private ImageView notification;

    @FXML
    private Circle profilePic;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
