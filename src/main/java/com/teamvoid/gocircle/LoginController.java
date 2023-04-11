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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class LoginController implements Initializable {


    @FXML
    private PasswordField password;

    @FXML
    private TextField userName;
    Connection connect;


    @FXML
    void loginButton(ActionEvent event) throws SQLException, IOException {



        Statement statement = connect.createStatement();
        String verify = "SELECT count(1) FROM students_info WHERE Username = " + "\"" + userName.getText() + "\"" + " AND Password =  " + "\"" + password.getText() + "\"";


        ResultSet resultSet= statement.executeQuery(verify);
        while (resultSet.next()) {
            if (resultSet.getInt(1) == 1) {
                Parent root = FXMLLoader.load(getClass().getResource("fxml/dashboard.fxml"));
                Scene scene3 = new Scene(root);

                Stage stage3 = (Stage) ((Node) event.getSource()).getScene().getWindow();

                stage3.setScene(scene3);
                stage3.show();

            } else System.out.println("Not successful");

        }


    }
    @FXML
    void signupLable(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/register.fxml"));
        Scene scene2 = new Scene(root);

        Stage stage2 = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage2.setScene(scene2);
        stage2.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userName.setFocusTraversable(false);
        password.setFocusTraversable(false);
        DatabaseConnection connectNow= new DatabaseConnection();

        connect= connectNow.getConnect();
    }
}

