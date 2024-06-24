package com.cse.oop.myprojects.simplelogin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardAdmin {

    @FXML
    void onLogOutButtonClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene2 = new Scene(fxmlLoader.load());

        // find the current stage (window)
        Button btn = (Button) event.getSource();
        Scene scene1 = btn.getScene();
        Stage stage = (Stage) scene1.getWindow();


        stage.setTitle("Admin Dashboard");
        stage.setScene(scene2);
    }

}
