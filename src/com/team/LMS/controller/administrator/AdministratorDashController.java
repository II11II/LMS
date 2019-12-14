package com.team.LMS.controller.administrator;

import com.team.LMS.controller.login.LoginController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AdministratorDashController {
    @FXML private Button adminLibrariansBtn;
    @FXML private Button adminStudentsBtn;
    @FXML private Button adminBooksBtn;
    @FXML private Button adminsignoutBtn;

    public void ADashboardController() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/com/team/LMS/view/administrator/AdministratorDashboard.fxml"));
        primaryStage.setTitle("Administrator");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
    }

    public void librarianData() throws IOException {
        LoginController.controlWindows(adminLibrariansBtn);
        AdministratorLibrariansController administratorLibrariansController;
        administratorLibrariansController=new AdministratorLibrariansController();
        administratorLibrariansController.ALibrarianController();
    }

    public void studentData() throws IOException {
        LoginController.controlWindows(adminStudentsBtn);
        AdministratorStudentsController administratorStudentsController;
        administratorStudentsController=new AdministratorStudentsController();
        administratorStudentsController.AStudentController();
    }

    public void bookData() throws IOException {
        LoginController.controlWindows(adminBooksBtn);
        AdministratorBooksController administratorBooksController;
        administratorBooksController=new AdministratorBooksController();
        administratorBooksController.ABooksController();
    }
    public void adminSignoutData()throws IOException{
        LoginController.signoutOption(adminsignoutBtn);
    }
}
