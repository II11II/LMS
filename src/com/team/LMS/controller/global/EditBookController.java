package com.team.LMS.controller.global;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EditBookController {

    public void editBookFunction() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/com/team/LMS/view/global/EditBook.fxml"));
        primaryStage.setTitle("Edit book");
        primaryStage.setScene(new Scene(root, 473, 416));
        primaryStage.show();
    }
}
