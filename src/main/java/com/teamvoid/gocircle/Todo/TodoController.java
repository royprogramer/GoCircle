package com.teamvoid.gocircle.Todo;

import com.teamvoid.gocircle.DatabaseConnection;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class TodoController implements Initializable {
    Connection connect;

    @FXML
    private DatePicker datepicker;

    @FXML
    private ListView<LocalEvent> eventlist;

    @FXML
    private TextField todotext;

    ObservableList<LocalEvent> list = FXCollections.observableArrayList();
    private String username;

//    public TodoController(DatePicker datepicker) {
//        this.datepicker = datepicker;
//    }

    @FXML
    void add(ActionEvent event) throws SQLException {
        list.add(new LocalEvent(todotext.getText(), datepicker.getValue()));
        eventlist.setItems(list);
        String query = "INSERT INTO `todo` (`Username`, `Date`, `Event`) VALUES ('" + username + "', '" + datepicker.getValue() + "', '" + todotext.getText() + "')";
        Statement statement=connect.createStatement();
        statement.executeUpdate(query);
        refreash();
    }

    private void refreash(){
        datepicker.setValue(LocalDate.now());
        todotext.setText(null);
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(()->{
            DatabaseConnection connectNow= new DatabaseConnection();
            connect= connectNow.getConnect();
            datepicker.setValue(LocalDate.now());
            System.out.println(username);
//            String query=" SELECT * FROM `todo` WHERE `Username` LIKE " +"\""+username+"\"";
//            System.out.println(username);
//            try {
//                Statement statement =connect.createStatement();
//                ResultSet resultSet= statement.executeQuery(query);
//                String date=resultSet.getString(2);
//                String event=resultSet.getString(3);
//                todotext.setText(event);
//                String [] trim=date.split("/");
//                Integer int1= Integer.parseInt(trim[0]);
//                Integer int2= Integer.parseInt(trim[1]);
//                Integer int3= Integer.parseInt(trim[2]);
//
//                LocalDate localDate = LocalDate.of(int1,int2,int3);
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }

        });



    }

    public void setData(String username) {
        this.username=username;
    }
}

