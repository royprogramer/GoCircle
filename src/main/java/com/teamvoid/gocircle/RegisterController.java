package com.teamvoid.gocircle;

import io.github.cdimascio.dotenv.Dotenv;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    @FXML
    private PasswordField confirmPassword;

    @FXML
    private PasswordField createPassword;

    @FXML
    private TextField email;

    @FXML
    private TextField signupUsername;
    private Connection connect;
   private  static String verificationCode="";
    //from verification
    @FXML
    private Rectangle massagebox1;

    @FXML
    private TextField verify_code;

    @FXML
    private Label warnningMassage;
    @FXML
    public  Label user_email_show;
    static String userName;
    static String versityMail;
    static String password;
    EmailVerification emailVerification;


    @FXML
    void signUpButton(ActionEvent event) {

        try {

            if(!signupUsername.getText().isBlank() && !email.getText().isBlank()) {
                if(createPassword.getText().equals(confirmPassword.getText())) {
                    String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";


                    if (email.getText().matches(emailRegex)) {
                        userName=signupUsername.getText();
                        versityMail=email.getText();
                        password=createPassword.getText();
//                        verificationCode= generateCode();
//                        System.out.println("1:"+verificationCode);

                        emailVerification =new EmailVerification(versityMail,userName);
                        verificationCode = emailVerification.verificationCode;


                        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/verification.fxml"));
                        Parent root = loader.load();
                        Scene scene = new Scene(root);
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        stage.setScene(scene);
//                        sendVerificationCode(email.getText(),verificationCode);
//                        System.out.println("Email send");
                        stage.show();




                    } else {
                        System.out.println("Invalid email address");
                    }
                } else {
                    System.out.println("Password miss match");
                }
            } else {
                System.out.println("Please enter values");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        DatabaseConnection connectNow= new DatabaseConnection();
        connect = connectNow.getConnect();


    }

    public void varify(MouseEvent mouseEvent) {
        try{

            if(verify_code.getText().equals(verificationCode))
            {
                Statement statement = connect.createStatement();
                String inputInfo = "INSERT INTO `students_info` (`Username`, `Versity_mail`, `Password`) VALUES ('" + userName + "', '" + versityMail + "', '" + password + "')";
                statement.executeUpdate(inputInfo);
                System.out.println("Successful Insert");
                Parent root = FXMLLoader.load(getClass().getResource("fxml/home.fxml"));
                Scene scene1 = new Scene(root);
                Stage stage1 = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
                stage1.setScene(scene1);
                stage1.show();

            }
            else{
                warnningMassage.setText("Wrong Verification Code");
            }


        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("From verify mouse event");
        }


    }

    public void resend(MouseEvent mouseEvent) {
        emailVerification =new EmailVerification(versityMail,userName);
        verificationCode= emailVerification.verificationCode;


        warnningMassage.setText("Code resend");
    }
}

