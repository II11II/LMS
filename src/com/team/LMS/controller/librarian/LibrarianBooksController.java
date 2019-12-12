package com.team.LMS.controller.librarian;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LibrarianBooksController {
    public void LBooksController() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/com/team/LMS/view/librarian/LibrarianBooks.fxml"));
        primaryStage.setTitle("Students information");
        primaryStage.setScene(new Scene(root, 710, 500));
        primaryStage.show();
    }
}
