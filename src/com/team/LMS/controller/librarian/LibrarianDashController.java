package com.team.LMS.controller.librarian;

import com.team.LMS.controller.login.LoginController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class LibrarianDashController {

    @FXML private Button booksBtn;
    @FXML private Button returnBookBtn;
    @FXML private Button issueBookBtn;
    @FXML private Button issueFineBtn;
    @FXML private Button blockStudentBtn;
    @FXML private Button signoutBtn;
    @FXML private Button studentsBtn;

    public void LDashboardController() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/com/team/LMS/view/librarian/LibrarianDashboard.fxml"));
        primaryStage.setTitle("Library Management System");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
    }


    public void studentsData() throws IOException {
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

    public void issueBookData()throws IOException{
        LoginController.controlWindows(issueBookBtn);
        LibrarianIssueController librarianIssueController;
        librarianIssueController=new LibrarianIssueController();
        librarianIssueController.LIssueController();
    }

    public void returnBookData()throws IOException{
        LoginController.controlWindows(returnBookBtn);
        LibrarianReturnController librarianReturnController;
        librarianReturnController=new LibrarianReturnController();
        librarianReturnController.LReturnController();
    }

    public void issueFineData()throws IOException{
        LoginController.controlWindows(issueFineBtn);
        LibrarianFineController librarianFineController;
        librarianFineController=new LibrarianFineController();
        librarianFineController.LFineController();
    }

    public void blockStudentData()throws IOException{
        LoginController.controlWindows(blockStudentBtn);
        LibrarianBlockController librarianBlockController;
        librarianBlockController=new LibrarianBlockController();
        librarianBlockController.LBlockController();
    }

    public void signoutData()throws IOException{
        LoginController.signoutOption(signoutBtn);
    }

}
