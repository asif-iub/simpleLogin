package com.cse.oop.myprojects.simplelogin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class HelloController {

    @FXML
    private PasswordField password_tf;

    @FXML
    private TextField username_tf;

    @FXML
    private Label message_lbl;

    @FXML
    void onHelloButtonClick(ActionEvent event) {
        List<User> userlist = new ArrayList<>();
        userlist.add(new User("admin", "1234"));
        userlist.add(new User("hr", "0987"));
        userlist.add(new User("engineer", "qwerty"));
        userlist.add(new User("customer", "asdf"));


        String username = username_tf.getText();
        String password = password_tf.getText();

        User login_user = new User(username, password);

        for (User user: userlist) {
            if (login_user.equals(user)) {
                message_lbl.setText("Log in successful!");
                // switch to dashboard
                return;
            }
        }
        message_lbl.setText("Invalid username or password!");
    }

}
