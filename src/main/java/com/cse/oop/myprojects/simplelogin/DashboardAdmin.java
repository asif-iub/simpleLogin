package com.cse.oop.myprojects.simplelogin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.beans.PropertyChangeListenerProxy;
import java.io.IOException;

public class DashboardAdmin {

    @FXML
    private Label user_lbl;

    @FXML
    private TableView<User> user_tableView;

    @FXML
    private TableColumn<User, String> password_tc;

    @FXML
    private TableColumn<User, String> username_tc;

    private User user;

    @FXML
    void initialize() {
        username_tc.setCellValueFactory(new PropertyValueFactory<>("username"));
        password_tc.setCellValueFactory(new PropertyValueFactory<>("password"));

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

    public void setUser(User user) {
        this.user  = user;
        user_lbl.setText(user.getUsername());
    }

}
