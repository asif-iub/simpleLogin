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

    @FXML
    void onHelloButtonClick(ActionEvent event) {
        String username = username_tf.getText();
        String password = password_tf.getText();
        System.out.println(username + " " + password);

        if (username.equals("admin") && password.equals("1234")) {
            message_lbl.setText("Log in successful!");
            // switch to dashboard
        }
        else {
            message_lbl.setText("Invalid username or password!");
        }
    }

}
