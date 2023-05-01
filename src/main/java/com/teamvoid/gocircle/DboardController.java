package com.teamvoid.gocircle;

import com.jfoenix.controls.JFXButton;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class DboardController implements Initializable {
    @FXML
    private Circle profilePic;
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
        FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("fxml/chatbox.fxml"));
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

        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/profile-page.fxml"));
        Parent fxml = loader.load();
        ProfileController profileController =loader.getController();

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

        Platform.runLater(()->{
            DatabaseConnection connectNow= new DatabaseConnection();
            connect= connectNow.getConnect();
            try {
                Statement statement= connect.createStatement();
                String query=" SELECT * FROM `students_info` WHERE `Username` LIKE " +"\""+username+"\"";
                ResultSet resultSet= statement.executeQuery(query);
                while (resultSet.next())
                {
                    Blob profileBlob= resultSet.getBlob(7);
                    if(profileBlob!=null){
                        String path = "temp/"+username+".png";
                        byte byteArray[] = profileBlob.getBytes(1, (int) profileBlob.length());
                        FileOutputStream outPutStream = new FileOutputStream(path);
                        outPutStream.write(byteArray);
                        outPutStream.close();
                        FileInputStream imgStream = new FileInputStream(path);
                        profilePic.setFill(new ImagePattern(new Image(imgStream)));
                    }
                    else{
                        String path="temp/default-profile-photo.jpg";
                        FileInputStream imgStream = new FileInputStream(path);
                        profilePic.setFill(new ImagePattern(new Image(imgStream)));
                    }


                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });


    }

    public void setData(String username) {
        this.username=username;
    }
}


