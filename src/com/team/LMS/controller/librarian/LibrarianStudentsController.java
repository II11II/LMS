package com.team.LMS.controller.librarian;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class LibrarianStudentsController {
    @FXML
    public Button overdueStudentsBtn;
    @FXML
    public Button addStudentBtn;
    @FXML
    public Button editStudentBtn;
    @FXML
    public Button deleteStudentBtn;
    @FXML
    public TextField deleteStudentTextField;//What
    @FXML
    public TableView studentsTableView;//What
    @FXML
    public TableColumn studentDegree;
    @FXML
    public TableColumn studentDepartment;
    @FXML
    public TableColumn studentLast;
    @FXML
    public TableColumn studentFirst;
    @FXML
    public TableColumn studentId;

    public LibrarianStudentsController() throws SQLException {

    }

    public void LStudentController() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/com/team/LMS/view/librarian/LibrarianStudents.fxml"));
        primaryStage.setTitle("Students information");
        primaryStage.setScene(new Scene(root, 710, 500));
        primaryStage.show();
    }

    public void contentTable() throws SQLException {

    }
}
