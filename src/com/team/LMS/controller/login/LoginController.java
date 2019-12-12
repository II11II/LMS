package com.team.LMS.controller.login;

import com.team.LMS.controller.librarian.LibrarianDashController;
import com.team.LMS.model.Librarian;
import com.team.LMS.model.Student;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {
    @FXML
    public TextField txtUsername;
    @FXML
    public PasswordField txtPassword;
    @FXML
    public Button btnLogin;
    @FXML
    public Label lblErrors;

    public void userAuthentication() throws SQLException, IOException {
        Student student = new Student();
        Librarian librarian = new Librarian();
        if (txtUsername.getText().length() == 8) {
            if (student.login(txtUsername.getText(), txtPassword.getText())) {
                System.out.println("Welcome student ");
            }
        } else if (librarian.login(txtUsername.getText(), txtPassword.getText())) {
            System.out.println("librarian");
            controlWindows(btnLogin);
            LibrarianDashController librarianDashController = new LibrarianDashController();
            librarianDashController.LDashboardController();
        }
    }

    public static void controlWindows(Button button) {
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }


}