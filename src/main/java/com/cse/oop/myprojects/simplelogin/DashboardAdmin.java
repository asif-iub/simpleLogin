package com.cse.oop.myprojects.simplelogin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardAdmin {

    @FXML
    private Label user_lbl;

    private User user;

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
