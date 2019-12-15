package com.team.LMS.controller.global;

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


    public Student editStudent() throws SQLException {
        Student student=new Student();
        String studentId=editStudentIDTextField.getText();
        ArrayList<Student> students=student.getStudents();
        for(Student student_:students){
            if(student_.getUsername().equals(studentId)){
                return student_;
            }
        }
        return null;
    }

    public void editAddition(String studentId) throws SQLException {
        Student student=new Student();
        student=editStudent();
//        if(student!=null){
//            student.modifyStudent;
//        }

    }
}
