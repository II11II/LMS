package com.team.LMS.controller.global;

import com.team.LMS.controller.librarian.LibrarianStudentsController;
import com.team.LMS.controller.login.LoginController;
import com.team.LMS.model.Librarian;
import com.team.LMS.model.Student;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class EditStudentController {

    @FXML private TextField editStudentIDTextField;
    @FXML private Button editStudentSearchBtn;
    @FXML private TextField editStudentFirstNameTextField;
    @FXML private TextField editStudentLastNameTextField;
    @FXML private Button editStudentCancelBtn;
    @FXML private Button editStudentOKBtn;

    public void editStudentFunction() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/com/team/LMS/view/global/EditStudent.fxml"));
        primaryStage.setTitle("Edit student");
        primaryStage.setScene(new Scene(root, 466, 284));
        primaryStage.show();
    }

    public Student editStudentSearch() throws SQLException {
        Student student=new Student();
        String studentId=editStudentIDTextField.getText();
        ArrayList<Student> students=student.getStudents();
        for(Student student_:students){
            if(student_.getUsername().equals(studentId)){
                editStudentFirstNameTextField.setText(student_.getFirstName());
                editStudentLastNameTextField.setText(student_.getLastName());
                return student_;
            }
        }
        return null;
    }

    public void editStudentOk() throws SQLException {
        Student student;
        student=editStudentSearch();
        if(student!=null) {
            student.setFirstName(editStudentFirstNameTextField.getText());
            student.setLastName(editStudentLastNameTextField.getText());
            student.modifyStudent(student.getUsername(),student.getFirstName(),student.getLastName());
            LibrarianStudentsController.refresh();
            LoginController.controlWindows(editStudentOKBtn);
        }else {
            System.out.println("Student with this ID does not exist");
        }
    }

    public void editStudentCancel(){
        LoginController.controlWindows(editStudentCancelBtn);
    }
}
