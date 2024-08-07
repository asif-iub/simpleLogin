package com.cse.oop.myprojects.simplelogin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.beans.PropertyChangeListenerProxy;
import java.io.IOException;

public class DashboardAdmin {

    @FXML
    private Label user_lbl;

    @FXML
    private Label message_lbl;

    @FXML
    private Label message_lbl2;

    @FXML
    private PasswordField password_tf;

    @FXML
    private TextField username_tf;

    @FXML
    private TextField fullname_tf;

    @FXML
    private TextField age_tf;

    @FXML
    private TextField filter_age_tf;

    @FXML
    private TableView<User> user_tableView;

    @FXML
    private TableColumn<User, String> password_tc;

    @FXML
    private TableColumn<User, String> username_tc;

    @FXML
    private TableColumn<User, String> fullname_tc;

    @FXML
    private TableColumn<User, Integer> age_tc;

    private User user;

    private ObservableList<User> userList;
    private ObservableList<User> filteredList;

    @FXML
    void initialize() {
        username_tc.setCellValueFactory(new PropertyValueFactory<>("username"));
        password_tc.setCellValueFactory(new PropertyValueFactory<>("password"));
        fullname_tc.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        age_tc.setCellValueFactory(new PropertyValueFactory<>("age"));

        user_tableView.getItems().addAll(Authenticator.getUserList());
//        user_tableView.setItems(userList);
    }

    @FXML
    void onFilterButtonClick(ActionEvent event) {
        // loop through userList and copy selected items to filtered List
        try {
            int min_age = Integer.parseInt(filter_age_tf.getText());

            filteredList = FXCollections.observableArrayList();
            for (User user : user_tableView.getItems()) {
                if (user.getAge() >= min_age)
                    filteredList.add(user);
            }

            user_tableView.setItems(filteredList);
        }
        catch (NumberFormatException e) {
            message_lbl2.setText("Minimum age must be a valid number.");
        }
    }

    @FXML
    void onResetButtonClick(ActionEvent event) {
        user_tableView.getItems().clear();
        user_tableView.getItems().addAll(Authenticator.getUserList());
    }

    @FXML
    void onLogOutButtonClick(ActionEvent event) throws IOException {
        // static FXMLLoader
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene scene2 = new Scene(root);

        // find the current stage (window)
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();


        stage.setTitle("Admin Dashboard");
        stage.setScene(scene2);
    }

    @FXML
    void onAddUserButtonClick(ActionEvent event) {
        Authenticator auth = new Authenticator();

        String username = username_tf.getText();
        String password = password_tf.getText();
        String fullName = fullname_tf.getText();

        if (!validate(username, password)) {
            message_lbl.setText("Username or password cannot be blank!");
            return;
        }

        if (!validatePassword(password)) {
            message_lbl.setText("Password does not satisfy the criteria.");
            return;
        }

        int age = -1;
        try {
            age = Integer.parseInt(age_tf.getText());
        } catch (NumberFormatException e) {
            message_lbl.setText("Age must be a valid number!");
        }
        if (age < 18) {
            message_lbl.setText("Age must be at least 18.");
            return;
        }

        User login_user = new User(username, password, fullName, age);
        try {
            auth.addNewUser(login_user);
            message_lbl.setText("User added successfully!");
            user_tableView.getItems().add(login_user);
        } catch (Exception e) {
            message_lbl.setText("Username is not available!");
        }
    }


    private boolean validatePassword(String password) {
        if (password.length() < 6) return false;

        boolean hasdigit = false;
        boolean haslowercase = false;
        boolean hasuppercase = false;
        boolean hasspecialchar = false;

        for (int i = 0; i < password.length(); i++) {
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


    public void setUser(User user) {
        this.user = user;
        user_lbl.setText(user.getUsername());
    }

}
