package com.team.LMS.controller.administrator;

import com.team.LMS.controller.global.AddStudentController;
import com.team.LMS.controller.global.EditStudentController;
import com.team.LMS.model.Person;
import com.team.LMS.model.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdministratorStudentsController implements Initializable {

    @FXML private Button adminAddStudentBtn;
    @FXML private Button adminEditStudentBtn;
    @FXML private Button adminSearchStudentBtn;
    @FXML private TextField adminDeleteStudentTextField;
    @FXML private TableView<Person> adminStudentsTableView;
    @FXML private TableColumn<Student,String> colFirstname;
    @FXML private TableColumn<Student,String> colId;
    @FXML private TableColumn<Student,String> colLastname;

    ObservableList<Person> getStudent() throws SQLException {
        Student student = new Student();
        ArrayList<Student> students = student.getStudents();
        ObservableList<Person> personObservableList = FXCollections.observableArrayList();
        personObservableList.addAll(students);
        return personObservableList;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        adminStudentsTableView.setEditable(true);
        colId.setCellValueFactory(new PropertyValueFactory<>("username"));
        colFirstname.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLastname.setCellValueFactory(new PropertyValueFactory<>("lastName"));


        try {
            adminStudentsTableView.setItems(getStudent());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addStudentAction() throws IOException {
        AddStudentController addStudentController=new AddStudentController();
        addStudentController.addStudentFunction();
    }

    public void editStudentAction() throws IOException {
        EditStudentController editStudentController=new EditStudentController();
        editStudentController.editStudentFunction();
    }

}
