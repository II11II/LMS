package com.team.LMS.controller.global;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AddLibrarianController {

    public void addLibrarianFunction() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/com/team/LMS/view/global/AddLibrarian.fxml"));
        primaryStage.setTitle("Add librarian");
        primaryStage.setScene(new Scene(root, 466, 284));
        primaryStage.show();
    }
}
