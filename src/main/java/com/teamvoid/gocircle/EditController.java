package com.teamvoid.gocircle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class EditController implements Initializable {

    Connection connect;
    @FXML
    private Label Name;

    @FXML
    private TextField department;

    @FXML
    private Label givencirclename;

    @FXML
    private TextField uniMail;

    @FXML
    private TextField university;

    @FXML
    private TextField user_name;
    private String username;

    @FXML
    void send(ActionEvent event) {

    }

    @FXML
    void submitbtn(ActionEvent event) {

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
            String query=" SELECT * FROM `students_info` WHERE `Username` LIKE " +"\""+username+"\"";
            ResultSet resultSet= statement.executeQuery(query);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    }
