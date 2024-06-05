package com.cse.oop.myprojects.simplelogin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private PasswordField password_tf;

    @FXML
    private TextField username_tf;

    @FXML
    private Label message_lbl;

    private final Authenticator auth = new Authenticator();

    @FXML
    void onLoginButtonClick(ActionEvent event) {
        String username = username_tf.getText();
        String password = password_tf.getText();

        User login_user = new User(username, password);

        if (auth.checkLogIn(login_user)) {
            message_lbl.setText("Log in successful!");
        }
        else {
            message_lbl.setText("Invalid username or password!");
        }
    }
    @FXML
    void onRegisterButtonClick(ActionEvent event) {
//        auth = new Authenticator();

        String username = username_tf.getText();
        String password = password_tf.getText();

        User login_user = new User(username, password);
        auth.addNewUser(login_user);
    }

}
