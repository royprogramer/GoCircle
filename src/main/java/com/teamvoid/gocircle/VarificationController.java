package com.teamvoid.gocircle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class VarificationController implements Initializable {

    @FXML
    private Label email;

    @FXML
    private Rectangle massagebox1;

    @FXML
    private TextField opt;

    @FXML
    private Label warnningMassage;

    @FXML
    void resend(MouseEvent event) {

    }

    @FXML
    void varify(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            opt.setFocusTraversable(false);
    }
}

