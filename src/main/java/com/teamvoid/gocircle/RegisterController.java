package com.teamvoid.gocircle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    @FXML
    private PasswordField confirmPassword;

    @FXML
    private PasswordField createPassword;

    @FXML
    private TextField email;

    @FXML
    private TextField signupUsername;

    @FXML
    void signUpButton(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        confirmPassword.setFocusTraversable(false);
        createPassword.setFocusTraversable(false);
        email.setFocusTraversable(false);
        signupUsername.setFocusTraversable(false);
        
    }
}

