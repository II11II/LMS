package com.team.LMS.controller.student;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentReserveController {

    public void SReserveController() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/com/team/LMS/view/student/StudentReserveBook.fxml"));
        primaryStage.setTitle("Student reserve book");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
    }
}
