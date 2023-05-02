package com.teamvoid.gocircle.Todo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class TodoController implements Initializable {

    @FXML
    private DatePicker datepicker;

    @FXML
    private ListView<LocalEvent> eventlist;

    @FXML
    private TextField todotext;

    ObservableList<LocalEvent> list = FXCollections.observableArrayList();

//    public TodoController(DatePicker datepicker) {
//        this.datepicker = datepicker;
//    }

    @FXML
    void add(ActionEvent event) {
        list.add(new LocalEvent(todotext.getText(), datepicker.getValue()));
        eventlist.setItems(list);
        refreash();
    }

    private void refreash(){
        datepicker.setValue(LocalDate.now());
        todotext.setText(null);
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        datepicker.setValue(LocalDate.now());

    }
}

