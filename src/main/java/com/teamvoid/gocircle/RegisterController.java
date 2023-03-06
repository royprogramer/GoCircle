package com.teamvoid.gocircle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
        DatabaseConnection connectNow= new DatabaseConnection();
        try {

            Connection connect = connectNow.getConnect();
            Statement statement = connect.createStatement();

            if(!signupUsername.getText().isBlank() && !email.getText().isBlank()) {
                if(createPassword.getText().equals(confirmPassword.getText())) {
                    String inputInfo = "INSERT INTO `students_info` (`Username`, `Versity_mail`, `Password`) VALUES ('" + signupUsername.getText() + "', '" + email.getText() + "', '" + createPassword.getText() + "')";
                    statement.executeUpdate(inputInfo);
                    System.out.println("Successful Insert");
                    Parent root = FXMLLoader.load(getClass().getResource("fxml/home.fxml"));
                    Scene scene1 = new Scene(root);

                    Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();

                    stage1.setScene(scene1);
                    stage1.show();
                }
               else System.out.println("Password miss match");
            }
            else System.out.println("please enter values");




        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        confirmPassword.setFocusTraversable(false);
        createPassword.setFocusTraversable(false);
        email.setFocusTraversable(false);
        signupUsername.setFocusTraversable(false);
        
    }
}

