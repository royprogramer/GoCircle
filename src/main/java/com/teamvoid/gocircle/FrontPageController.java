package com.teamvoid.gocircle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class FrontPageController implements Initializable {

    @FXML
    private Circle ball1;

    @FXML
    private Circle ball2;

    @FXML
    private Circle ball3;

    @FXML
    private Circle ball4;

    @FXML
    private Circle ball5;

    @FXML
    private Circle ball6;

    @FXML
    private Circle ball7;

    @FXML
    private Circle ball8;

    @FXML
    private PasswordField confirmPassword;

    @FXML
    private PasswordField createPassword;

    @FXML
    private TextField email;

    @FXML
    private ImageView gif;

    @FXML
    private AnchorPane layer1;

    @FXML
    private AnchorPane layer2;

    @FXML
    private ImageView locklogo;

    @FXML
    private Label loginLabel;

    @FXML
    private Button loginbtn;

    @FXML
    private Label loginpageLabel;

    @FXML
    private PasswordField password;

    @FXML
    private ImageView profilelogo;

    @FXML
    private AnchorPane scene;

    @FXML
    private Text signinLabel;

    @FXML
    private Text signupLabel;

    @FXML
    private Label signupPageswitch;

    @FXML
    private TextField signupUsername;

    @FXML
    private Button signupbtn;

    @FXML
    private Label singuppageLabel;

    @FXML
    private TextField userName;

    @FXML
    void loginButton(ActionEvent event) {

    }

    @FXML
    void loginLable(MouseEvent event) {
        TranslateTransition slide = new TranslateTransition();
        TranslateTransition slide2 = new TranslateTransition();
        TranslateTransition slide3 = new TranslateTransition();

        slide2.setDuration(Duration.seconds(1));
        slide2.setNode(layer2);

        slide2.setToX(0);
        slide2.play();

        layer2.setTranslateX(-452);

        slide3.setDuration(Duration.seconds(1));
        slide3.setNode(gif);

        slide3.setToX(0);
        slide3.play();

        gif.setTranslateX(-452);

        slide.setDuration(Duration.seconds(1));
        slide.setNode(layer1);

        slide.setToX(0);
        slide.play();

        layer1.setTranslateX(452);
        slide2.setOnFinished((e ->{

        }));

        signinLabel.setVisible(true);
        userName.setVisible(true);
        password.setVisible(true);
        profilelogo.setVisible(true);
        locklogo.setVisible(true);
        loginbtn.setVisible(true);
        loginpageLabel.setVisible(true);
        signupPageswitch.setVisible(true);

        userName.setFocusTraversable(false);
        password.setFocusTraversable(false);

        signupLabel.setVisible(false);
        signupUsername.setVisible(false);
        email.setVisible(false);
        createPassword.setVisible(false);
        confirmPassword.setVisible(false);
        singuppageLabel.setVisible(false);
        loginLabel.setVisible(false);
        signupbtn.setVisible(false);

        signupUsername.setFocusTraversable(false);
        email.setFocusTraversable(false);
        confirmPassword.setFocusTraversable(false);
        createPassword.setFocusTraversable(false);


    }

    @FXML
    void signUpButton(ActionEvent event) {

    }

    @FXML
    void signUpLable(MouseEvent event) {
        TranslateTransition slide = new TranslateTransition();
        TranslateTransition slide2 = new TranslateTransition();
        TranslateTransition slide3 = new TranslateTransition();
        slide.setDuration(Duration.seconds(1));
        slide.setNode(layer1);

        slide.setToX(452);
        slide.play();

        layer1.setTranslateX(-452);

        slide2.setDuration(Duration.seconds(1));
        slide2.setNode(layer2);

        slide2.setToX(-452);
        slide2.play();

        layer2.setTranslateX(452);

        slide3.setDuration(Duration.seconds(1));
        slide3.setNode(gif);

        slide3.setToX(-452);
        slide3.play();

        gif.setTranslateX(452);

        slide2.setOnFinished((e ->{

        }));

        signinLabel.setVisible(false);
        userName.setVisible(false);
        password.setVisible(false);
        profilelogo.setVisible(false);
        locklogo.setVisible(false);
        loginbtn.setVisible(false);
        loginpageLabel.setVisible(false);
        signupPageswitch.setVisible(false);

        signupLabel.setVisible(true);
        signupUsername.setVisible(true);
        email.setVisible(true);
        createPassword.setVisible(true);
        confirmPassword.setVisible(true);
        singuppageLabel.setVisible(true);
        loginLabel.setVisible(true);
        signupbtn.setVisible(true);


    }

    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(15), new EventHandler<ActionEvent>() {

        double deltaX = 2;
        double deltaY = 2;

        double deltaX2 = 2.5;
        double deltaY2 = 2.5;

        double deltaX3 = 1;
        double deltaY3 = 1;

        double deltaX4 = 1.5;
        double deltaY4 = 1.5;

        double deltaX5 = 1.25;
        double deltaY5 = 1.25;

        double deltaX6 = 2.25;
        double deltaY6 = 2.25;

        double deltaX7 = 1.3;
        double deltaY7 = 1.3;

        double deltaX8 = 1.75;
        double deltaY8 = 1.75;

        @Override
        public void handle(ActionEvent actionEvent) {
            ball1.setLayoutX(ball1.getLayoutX() + deltaX);
            ball1.setLayoutY(ball1.getLayoutY() + deltaY);

            ball2.setLayoutX(ball2.getLayoutX() + deltaX2);
            ball2.setLayoutY(ball2.getLayoutY() + deltaY2);

            ball3.setLayoutX(ball3.getLayoutX() + deltaX3);
            ball3.setLayoutY(ball3.getLayoutY() + deltaY3);

            ball4.setLayoutX(ball4.getLayoutX() + deltaX3);
            ball4.setLayoutY(ball4.getLayoutY() + deltaY3);

            ball5.setLayoutX(ball5.getLayoutX() + deltaX5);
            ball5.setLayoutY(ball5.getLayoutY() + deltaY5);

            ball6.setLayoutX(ball6.getLayoutX() + deltaX6);
            ball6.setLayoutY(ball6.getLayoutY() + deltaY6);

            ball7.setLayoutX(ball7.getLayoutX() + deltaX7);
            ball7.setLayoutY(ball7.getLayoutY() + deltaY7);

            ball8.setLayoutX(ball8.getLayoutX() + deltaX8);
            ball8.setLayoutY(ball8.getLayoutY() + deltaY8);

            Bounds bounds = scene.getBoundsInLocal();
            boolean rightBorder = ball1.getLayoutX() >= (bounds.getMaxX() - ball1.getRadius());
            boolean leftBorder = ball1.getLayoutX() <= (bounds.getMinX() + ball1.getRadius());
            boolean bottomBorder = ball1.getLayoutY() >= (bounds.getMaxY() - ball1.getRadius());
            boolean topBorder = ball1.getLayoutY() <= (bounds.getMinY() + ball1.getRadius());

            boolean rightBorder2 = ball2.getLayoutX() >= (bounds.getMaxX() - ball2.getRadius());
            boolean leftBorder2 = ball2.getLayoutX() <= (bounds.getMinX() + ball2.getRadius());
            boolean bottomBorder2 = ball2.getLayoutY() >= (bounds.getMaxY() - ball2.getRadius());
            boolean topBorder2 = ball2.getLayoutY() <= (bounds.getMinY() + ball2.getRadius());

            boolean rightBorder3 = ball3.getLayoutX() >= (bounds.getMaxX() - ball3.getRadius());
            boolean leftBorder3 = ball3.getLayoutX() <= (bounds.getMinX() + ball3.getRadius());
            boolean bottomBorder3 = ball3.getLayoutY() >= (bounds.getMaxY() - ball3.getRadius());
            boolean topBorder3 = ball3.getLayoutY() <= (bounds.getMinY() + ball3.getRadius());

            boolean rightBorder4 = ball4.getLayoutX() >= (bounds.getMaxX() - ball4.getRadius());
            boolean leftBorder4 = ball4.getLayoutX() <= (bounds.getMinX() + ball4.getRadius());
            boolean bottomBorder4 = ball4.getLayoutY() >= (bounds.getMaxY() - ball4.getRadius());
            boolean topBorder4 = ball4.getLayoutY() <= (bounds.getMinY() + ball4.getRadius());

            boolean rightBorder5 = ball5.getLayoutX() >= (bounds.getMaxX() - ball5.getRadius());
            boolean leftBorder5 = ball5.getLayoutX() <= (bounds.getMinX() + ball5.getRadius());
            boolean bottomBorder5 = ball5.getLayoutY() >= (bounds.getMaxY() - ball5.getRadius());
            boolean topBorder5 = ball5.getLayoutY() <= (bounds.getMinY() + ball5.getRadius());

            boolean rightBorder6 = ball6.getLayoutX() >= (bounds.getMaxX() - ball6.getRadius());
            boolean leftBorder6 = ball6.getLayoutX() <= (bounds.getMinX() + ball6.getRadius());
            boolean bottomBorder6 = ball6.getLayoutY() >= (bounds.getMaxY() - ball6.getRadius());
            boolean topBorder6 = ball6.getLayoutY() <= (bounds.getMinY() + ball6.getRadius());

            boolean rightBorder7 = ball7.getLayoutX() >= (bounds.getMaxX() - ball7.getRadius());
            boolean leftBorder7 = ball7.getLayoutX() <= (bounds.getMinX() + ball7.getRadius());
            boolean bottomBorder7 = ball7.getLayoutY() >= (bounds.getMaxY() - ball7.getRadius());
            boolean topBorder7 = ball7.getLayoutY() <= (bounds.getMinY() + ball7.getRadius());

            boolean rightBorder8 = ball8.getLayoutX() >= (bounds.getMaxX() - ball8.getRadius());
            boolean leftBorder8 = ball8.getLayoutX() <= (bounds.getMinX() + ball8.getRadius());
            boolean bottomBorder8 = ball8.getLayoutY() >= (bounds.getMaxY() - ball8.getRadius());
            boolean topBorder8 = ball8.getLayoutY() <= (bounds.getMinY() + ball8.getRadius());

            if (rightBorder || leftBorder) {
                deltaX *= -1;
            }
            if (bottomBorder || topBorder) {
                deltaY *= -1;
            }

            if (rightBorder2 || leftBorder2) {
                deltaX2 *= -1;
            }
            if (bottomBorder2 || topBorder2) {
                deltaY2 *= -1;
            }

            if (rightBorder3 || leftBorder3) {
                deltaX3 *= -1;
            }
            if (bottomBorder3 || topBorder3) {
                deltaY3 *= -1;
            }
            if (rightBorder4 || leftBorder4) {
                deltaX4 *= -1;
            }
            if (bottomBorder4 || topBorder4) {
                deltaY4 *= -1;
            }
            if (rightBorder5 || leftBorder5) {
                deltaX5 *= -1;
            }
            if (bottomBorder5 || topBorder5) {
                deltaY5 *= -1;
            }

            if (rightBorder6 || leftBorder6) {
                deltaX6 *= -1;
            }
            if (bottomBorder6 || topBorder6) {
                deltaY6 *= -1;
            }

            if (rightBorder7 || leftBorder7) {
                deltaX7 *= -1;
            }
            if (bottomBorder7 || topBorder7) {
                deltaY7 *= -1;
            }
            if (rightBorder8 || leftBorder8) {
                deltaX8 *= -1;
            }
            if (bottomBorder8 || topBorder8) {
                deltaY8 *= -1;
            }
        }
    }));


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        userName.setFocusTraversable(false);
        password.setFocusTraversable(false);

        signupUsername.setFocusTraversable(false);
        email.setFocusTraversable(false);
        confirmPassword.setFocusTraversable(false);
        createPassword.setFocusTraversable(false);

        signupLabel.setVisible(false);
        signupUsername.setVisible(false);
        email.setVisible(false);
        createPassword.setVisible(false);
        confirmPassword.setVisible(false);
        singuppageLabel.setVisible(false);
        loginLabel.setVisible(false);
        signupbtn.setVisible(false);

    }

}
