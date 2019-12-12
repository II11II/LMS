package com.team.LMS.controller.librarian;

import com.team.LMS.model.Student;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Map;

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

    public void LStudentController() throws IOException, SQLException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/com/team/LMS/view/librarian/LibrarianStudents.fxml"));
        primaryStage.setTitle("Students information");
        primaryStage.setScene(new Scene(root, 710, 500));
        primaryStage.show();
        contentTable();
    }

    public void contentTable() throws SQLException {
        Student student = new Student();
        ArrayList<Map<String, Object>> allStudents = student.getStudents();
//        for (Map<String, Object> allStudent : allStudents) {
//            TableColumn<Map.Entry<String, Object>, K> column1 = new TableColumn<>(col1Name);
//            column1.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getKey()));
//        }
    }
}
