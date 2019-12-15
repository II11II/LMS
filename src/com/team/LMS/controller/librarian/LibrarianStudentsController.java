package com.team.LMS.controller.librarian;

import com.team.LMS.model.Person;
import com.team.LMS.model.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LibrarianStudentsController implements Initializable {
    @FXML private Button searchStudentBtn;
    @FXML private Button overdueStudentsBtn;
    @FXML private Button addStudentBtn;
    @FXML private Button editStudentBtn;
    @FXML private Button deleteStudentBtn;
    @FXML private TextField deleteStudentTextField;
    @FXML private TableView<Person> studentsTableView;
    @FXML private TableColumn<Person,String> colId;
    @FXML private TableColumn<Person,String> colFirstName;
    @FXML private TableColumn<Person,String> colLastName;



    ObservableList<Person> getStudent() throws SQLException {
        Student student = new Student();
        ArrayList<Student> students = student.getStudents();
        ObservableList<Person> personObservableList = FXCollections.observableArrayList();
        personObservableList.addAll(students);
        return personObservableList;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colId.setCellValueFactory(new PropertyValueFactory<>("username"));
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));


        try {
            studentsTableView.setItems(getStudent());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addStudentAction(){

    }
}
