package com.teamvoid.gocircle;

import com.jfoenix.controls.JFXButton;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class DboardController implements Initializable {
    Connection connect;
    @FXML
    private StackPane changepane;

    @FXML
    private JFXButton circlebtn;

    @FXML
    private JFXButton homebtn;

    @FXML
    private JFXButton keepbtn;

    @FXML
    private VBox pane1;

    @FXML
    private VBox pane2;

    @FXML
    private ImageView menueicon2;

    @FXML
    private JFXButton profilebtn;

    @FXML
    private JFXButton studybtn;
    @FXML
    private ImageView menueicon;
    private String username;

    @FXML
    void logout(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/dfg.fxml"));
        Scene scene1 = new Scene(root);
        Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage1.setScene(scene1);
        stage1.show();

    }
    @FXML
    void chaticon(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader=FXMLLoader.load(getClass().getResource("fxml/chatbox.fxml"));
        Parent fxml = fxmlLoader.load();
        ChatboxController chatboxController =fxmlLoader.getController();
        chatboxController.setData(username);

        changepane.getChildren().removeAll();
        changepane.getChildren().setAll(fxml);

    }

    @FXML
    void createpost(MouseEvent event) {

    }
    @FXML
    void circlebutton(ActionEvent event) {

    }

    @FXML
    void homebutton(ActionEvent event) {

    }

    @FXML
    void keepbutton(ActionEvent event) {

    }


    @FXML
    void profilebutton(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/profile.fxml"));
        Parent fxml = loader.load();
        ProfileController profileController =loader.load();
        profileController.setData(username);
        changepane.getChildren().removeAll();
        changepane.getChildren().setAll(fxml);

    }

    @FXML
    void studybutton(ActionEvent event) {

    }
    @FXML
    void close(MouseEvent event) {
        System.exit(0);
    }
    @FXML
    void minimize(MouseEvent event) {
        Main.stage.setIconified(true);
    }

    @FXML
    void menue(MouseEvent event) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.5));
        slide.setNode(pane2);
        slide.setToX(68);
        slide.play();

        pane2.setVisible(true);
        homebtn.setVisible(true);
        circlebtn.setVisible(true);
        profilebtn.setVisible(true);
        studybtn.setVisible(true);
        keepbtn.setVisible(true);

        menueicon.setVisible(false);
        menueicon2.setVisible(true);
        DatabaseConnection connectNow= new DatabaseConnection();
        connect= connectNow.getConnect();


    }

    @FXML
    void menue2(MouseEvent event) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.5));
        slide.setNode(pane2);
        slide.setToX(-68);
        slide.play();

        pane2.setVisible(false);
        homebtn.setVisible(false);
        circlebtn.setVisible(false);
        profilebtn.setVisible(false);
        studybtn.setVisible(false);
        keepbtn.setVisible(false);

        menueicon.setVisible(true);
        menueicon2.setVisible(false);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        pane2.setVisible(false);
        homebtn.setVisible(false);
        circlebtn.setVisible(false);
        profilebtn.setVisible(false);
        studybtn.setVisible(false);
        keepbtn.setVisible(false);
        menueicon2.setVisible(false);

        DatabaseConnection connectNow= new DatabaseConnection();
        connect= connectNow.getConnect();


    }

    public void setData(String username) {
        this.username=username;
    }
}


