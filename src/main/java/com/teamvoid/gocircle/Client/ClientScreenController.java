package com.teamvoid.gocircle.Client;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientScreenController implements Initializable {
    @FXML
    private Button send_btn;
    @FXML
    private TextArea write_text;
    @FXML
    private ScrollPane scroll_pane;
    @FXML
    private VBox vbox_msg;
    @FXML
    private Label username_msg;
    private Client client;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            client =new Client(new Socket("localhost",1234));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        vbox_msg.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                scroll_pane.setHvalue((double) t1);
            }
        });
        client.massageFrmServer(vbox_msg);
}
public void sendMassage(MouseEvent mouseEvent) {

    String massageSendFromCL= write_text.getText();
    if(!massageSendFromCL.isEmpty())
    {
        System.out.println("frm cl");
        HBox newHbox=new HBox();
        newHbox.setAlignment(Pos.CENTER_RIGHT);
        newHbox.setPadding(new Insets(5,5,5,10));

        Text text =new Text(massageSendFromCL);
        TextFlow textFlow=new TextFlow(text);
        textFlow.setStyle("-fx-background-color: rgb(244, 234, 255);" +
                "-fx-background-radius: 20px;");

        newHbox.getChildren().add(textFlow);
        vbox_msg.getChildren().add(newHbox);
        client.massageToSend(massageSendFromCL);
        write_text.clear();
    }

    }
    public  static void addMassage(String msgFromServer,VBox vbox)
    {
        System.out.println("in cl");
        HBox newHbox = new HBox();
        newHbox.setAlignment(Pos.CENTER_LEFT);
        newHbox.setPadding(new Insets(5,5,5,10));

        Text text =new Text(msgFromServer);
        TextFlow textFlow=new TextFlow(text);
        textFlow.setStyle("-fx-background-color: rgb(233, 233, 235);" +
                "-fx-background-radius: 20px;");
        newHbox.getChildren().add(textFlow);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                vbox.getChildren().add(newHbox);
            }
        });


    }
}
