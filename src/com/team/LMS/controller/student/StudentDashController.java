package com.team.LMS.controller.student;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentDashController {
    public void SDashboardController() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/com/team/LMS/view/librarian/LibrarianDashboard.fxml"));
        primaryStage.setTitle("Library Management System");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
    }
}
