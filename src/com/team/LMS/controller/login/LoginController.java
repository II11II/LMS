package com.team.LMS.controller.login;

import com.team.LMS.controller.librarian.LibrarianDashController;
import com.team.LMS.controller.student.StudentDashController;
import com.team.LMS.model.Librarian;
import com.team.LMS.model.Student;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {
    @FXML private TextField txtUsername;
    @FXML private PasswordField txtPassword;
    @FXML private Button btnLogin;
    @FXML private Label lblErrors;
    @FXML private Label errorMessageLabel;

    public void userAuthentication() throws SQLException, IOException {
        Student student = new Student();
        Librarian librarian = new Librarian();

        if (txtUsername.getText().length() == 8) {
            if (student.login(txtUsername.getText(), txtPassword.getText())) {
                System.out.println("Welcome student ");
                controlWindows(btnLogin);
                StudentDashController studentDashController=new StudentDashController();
                studentDashController.SDashboardController();
            }else
                errorMessageLabel.setText("You entered wrong password or username !");
        } else if (librarian.login(txtUsername.getText(), txtPassword.getText())) {
            System.out.println("librarian");
            controlWindows(btnLogin);
            LibrarianDashController librarianDashController = new LibrarianDashController();
            librarianDashController.LDashboardController();
        } else
            errorMessageLabel.setText("You entered wrong password or username !");
    }

    public static void controlWindows(Button button) {
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }

    public static void signoutOption(Button button) throws IOException {
        LoginController.controlWindows(button);
        Stage primaryStage = new Stage();
        AnchorPane root = FXMLLoader.load(LoginController.class.getResource("/com/team/LMS/view/login/Login.fxml"));
        primaryStage.setTitle("Library Management System");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
    }
}