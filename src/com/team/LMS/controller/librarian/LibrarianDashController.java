package com.team.LMS.controller.librarian;

import com.team.LMS.controller.login.LoginController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class LibrarianDashController {
    @FXML
    public Button booksBtn;
    @FXML
    public Button returnBookBtn;
    @FXML
    public Button issueBookBtn;
    @FXML
    public Button issueFineBtn;
    @FXML
    public Button blockStudentBtn;
    @FXML
    public Button signoutBtn;
    @FXML
    public Button studentsBtn;

    public void LDashboardController() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/com/team/LMS/view/librarian/LibrarianDashboard.fxml"));
        primaryStage.setTitle("Library Management System");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();

    }


    public void studentsData() throws IOException, SQLException {
        LoginController.controlWindows(studentsBtn);
        LibrarianStudentsController librarianStudentsController;
        librarianStudentsController = new LibrarianStudentsController();
        librarianStudentsController.LStudentController();
    }

    public void booksData() throws IOException {
        LoginController.controlWindows(booksBtn);
        LibrarianBooksController librarianBooksController;
        librarianBooksController = new LibrarianBooksController();
        librarianBooksController.LBooksController();
    }
}
