package com.team.LMS.controller.global;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EditLibrarianController {

    public void editLibrarianFunction() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/com/team/LMS/view/global/EditLibrarian.fxml"));
        primaryStage.setTitle("Edit librarian");
        primaryStage.setScene(new Scene(root, 466, 284));
        primaryStage.show();
    }
}
