package com.team.LMS.controllers;


import com.team.LMS.model.Librarian;
import com.team.LMS.model.Student;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class Controller {
    @FXML
    public TextField txtUsername;
    @FXML
    public PasswordField txtPassword;
    @FXML
    public Button btnLogin;
    @FXML
    public Label lblErrors;

    public void onClickButton() throws SQLException {
        Student student = new Student();
        Librarian librarian = new Librarian();
        if (student.login(txtUsername.getText(), txtPassword.getText())) {
            System.out.println("Welcome student ");
        } else if (librarian.login(txtUsername.getText(), txtPassword.getText()))
            System.out.println("Welcome Professor !");
    }
}