package com.team.LMS.controller.student;

import com.mysql.jdbc.log.Log;
import com.team.LMS.controller.login.LoginController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentDashController {

    @FXML private Button studentProfileBtn;
    @FXML private Button studentBooksBtn;
    @FXML private Button studentReserveBookBtn;
    @FXML private Button signoutBtn;

    public void SDashboardController() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/com/team/LMS/view/student/StudentDashboard.fxml"));
        primaryStage.setTitle("Library Management System");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
    }

    public void profileData() throws IOException {
        LoginController.controlWindows(studentProfileBtn);
        StudentProfileController studentProfileController;
        studentProfileController=new StudentProfileController();
        studentProfileController.SProfileController();
    }

    public void booksData()throws IOException{
        LoginController.controlWindows(studentBooksBtn);
        StudentBooksController studentBooksController;
        studentBooksController=new StudentBooksController();
        studentBooksController.SBooksController();
    }

    public void reserveBookData()throws IOException{
        LoginController.controlWindows(studentReserveBookBtn);
        StudentReserveController studentReserveController;
        studentReserveController=new StudentReserveController();
        studentReserveController.SReserveController();
    }

    public void signoutData()throws IOException{
        LoginController.signoutOption(signoutBtn);
    }
}
