package com.cse.oop.myprojects.simplelogin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    private PasswordField password_tf;

    @FXML
    private TextField username_tf;

    @FXML
    private Label message_lbl;

//    private final Authenticator auth = new Authenticator();

    @FXML
    void onLoginButtonClick(ActionEvent event) throws IOException {
        Authenticator auth = new Authenticator();

        String username = username_tf.getText();
        String password = password_tf.getText();
        if (!validate(username, password)) {
            message_lbl.setText("Username or password cannot be blank!");
            return;
        }

        User login_user = new User(username, password);

        if (auth.checkLogIn(login_user)) {
            message_lbl.setText("Log in successful!");
            // non-static FXMLLoader
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("dashboard_admin.fxml"));
            Scene scene2 = new Scene(fxmlLoader.load());
            ((DashboardAdmin) fxmlLoader.getController()).setUser(login_user);

            // find the current stage (window)
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();

            stage.setTitle("Admin Dashboard");
            stage.setScene(scene2);
        }
        else {
            message_lbl.setText("Invalid username or password!");
        }
    }

    @FXML
    void onRegisterButtonClick(ActionEvent event) {
        Authenticator auth = new Authenticator();

        String username = username_tf.getText();
        String password = password_tf.getText();

        if (!validate(username, password)) {
            message_lbl.setText("Username or password cannot be blank!");
            return;
        }

        if (!validatePassword(password)) {
            message_lbl.setText("Password does not satisfy the criteria.");
            return;
        }

        User login_user = new User(username, password);
        if (auth.addNewUser(login_user)) {
            message_lbl.setText("User added successfully!");
        }
        else {
            message_lbl.setText("Could not add user!");
        }
    }

    private boolean validatePassword(String password) {
        if (password.length() < 6) return false;

        boolean hasdigit = false;
        boolean haslowercase = false;
        boolean hasuppercase = false;
        boolean hasspecialchar = false;

        for (int i = 0; i < password.length(); i++){
            char c = password.charAt(i);
            if (Character.isDigit(c)) hasdigit = true;
            else if (Character.isLowerCase(c)) haslowercase = true;
            else if (Character.isUpperCase(c)) hasuppercase = true;
            else hasspecialchar = true;
        }

        return hasdigit && haslowercase && hasuppercase && !hasspecialchar;
    }

    private boolean validate(String username, String password) {
        if (username.isBlank() || password.isBlank()) {
//            message_lbl.setText("Username or password cannot be blank!");
            return false;
        }
        return true;
    }

    @FXML
    void onDemoAdminClick(ActionEvent actionEvent) {
        // switch to admin dashboard for demo
    }
}
