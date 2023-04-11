package com.teamvoid.gocircle.Server;

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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.net.ServerSocket;
import java.net.URL;
import java.util.ResourceBundle;

public class serverScreenController implements Initializable {


    @FXML
    private Button send_btn;
    @FXML
    private VBox vbox_msg;
    @FXML
    private ScrollPane scroll_pane;
    @FXML
    private TextArea write_text;
    @FXML
    private Label username_msg;
    @FXML
    private AnchorPane server_main;
    private Server serverMsg;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            serverMsg = new Server(new ServerSocket(1234));
        }
        catch (Exception e)
        {
e.printStackTrace();
        }
        vbox_msg.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                scroll_pane.setHvalue((double) t1);
            }
        });
        serverMsg.massageFrmClient(vbox_msg);
    }

    public void sendMassage(MouseEvent mouseEvent) {
        String massageSend= write_text.getText();
        if(!massageSend.isEmpty())
        {
            System.out.println("from serve");
            HBox newHbox=new HBox();
            newHbox.setAlignment(Pos.CENTER_RIGHT);
            newHbox.setPadding(new Insets(5,5,5,10));

            Text text =new Text(massageSend);
            TextFlow textFlow=new TextFlow(text);
            textFlow.setStyle("-fx-background-color: rgb(244, 234, 255);" +
                    "-fx-background-radius: 20px;");

            newHbox.getChildren().add(textFlow);
            vbox_msg.getChildren().add(newHbox);
            serverMsg.massageToSend(massageSend);
            write_text.clear();
        }
    }

    public  static void addMassage(String msgFromCLient,VBox vbox)
    {
        System.out.println("in serve");
        HBox newHbox = new HBox();
        newHbox.setAlignment(Pos.CENTER_LEFT);
        newHbox.setPadding(new Insets(5,5,5,10));

        Text text =new Text(msgFromCLient);
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
