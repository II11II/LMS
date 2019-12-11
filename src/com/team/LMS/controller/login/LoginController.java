package com.team.LMS.controller.login;


import com.team.LMS.Main;
import com.team.LMS.controller.librarian.LibrarianBooksController;
import com.team.LMS.model.Librarian;
import com.team.LMS.model.Student;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;



public class LoginController  {
    @FXML
    public TextField txtUsername;
    @FXML
    public PasswordField txtPassword;
    @FXML
    public Button btnLogin;
    @FXML
    public Label lblErrors;


    public void onClickButton() throws SQLException, IOException {
        Student student = new Student();
        Librarian librarian = new Librarian();
        Parent home_page = FXMLLoader.load(getClass().getResource("/com/team/LMS/view/login/Login.fxml"));
        Stage app = (Stage)btnLogin.getScene().getWindow();

        app.close();
        if (student.login(txtUsername.getText(), txtPassword.getText())){


    } else if (librarian.login(txtUsername.getText(), txtPassword.getText()))
            System.out.println("Welcome Professor !");
    }


}