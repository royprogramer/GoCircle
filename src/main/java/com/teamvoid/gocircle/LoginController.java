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


    @FXML
    void loginButton(ActionEvent event) throws SQLException{
        DatabaseConnection connectNow= new DatabaseConnection();

        Connection connect= connectNow.getConnect();


        Statement statement = connect.createStatement();
        String strSql="select * from customer_info";
        ResultSet resultSet= statement.executeQuery(strSql);

              while (resultSet.next()) {
                  System.out.printf(resultSet.getString("Username"));
              }


//           if(resultSet.getString("Username").equals(userName.getText())&&resultSet.getString("Password").equals(password.getText()))
//           {
//               System.out.println("Successful");
//           }


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
    }
}

