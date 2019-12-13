package com.team.LMS.controller.student;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentBooksController {

    public void SBooksController() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/com/team/LMS/view/student/StudentBooks.fxml"));
        primaryStage.setTitle("Student books");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
    }
}
