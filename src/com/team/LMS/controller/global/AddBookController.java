package com.team.LMS.controller.global;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AddBookController {
public void addBookFunction() throws IOException {
    Stage primaryStage = new Stage();
    Parent root = FXMLLoader.load(getClass().getResource("/com/team/LMS/view/global/AddBook.fxml"));
    primaryStage.setTitle("Add book");
    primaryStage.setScene(new Scene(root, 473, 416));
    primaryStage.show();
}
}
