package com.teamvoid.gocircle;

import com.teamvoid.gocircle.Timeline.Account;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class PostController implements Initializable {

    @FXML
    private Label caption;

    @FXML
    private ImageView commentclick;

    @FXML
    private Label date;

    @FXML
    private ImageView globe;

    @FXML
    private ImageView mypost;

    @FXML
    private Label postusrname;

    @FXML
    private ImageView profileimage;

    @FXML
    private ImageView save;

    @FXML
    private ImageView saveclick;

    @FXML
    private ImageView starclick;
    @FXML
    private Post post;

    public void setPost(Post post) {
        this.post = post;
    }

    @FXML
    void comment(MouseEvent event) {

    }

    @FXML
    void star(MouseEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        saveclick.setVisible(false);
//        commentclick.setVisible(false);
//        saveclick.setVisible(false);

        Platform.runLater(()->{
            postusrname.setText(post.getUsername());
            caption.setText(post.getContent());
        });


    }

    public void imageUp(MouseEvent mouseEvent) {
    }
}
