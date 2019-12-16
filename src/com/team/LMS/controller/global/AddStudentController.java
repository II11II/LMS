package com.team.LMS.controller.global;

import com.team.LMS.controller.librarian.LibrarianDashController;
import com.team.LMS.controller.librarian.LibrarianStudentsController;
import com.team.LMS.controller.login.LoginController;
import com.team.LMS.model.Student;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
public class AddStudentController  {
    @FXML private Label addStudentErrorMessage;
    @FXML private TextField addStudentIDTextField;
    @FXML private TextField addStudentFirstNameTextField;
    @FXML private TextField addStudentLastNameTextField;
    @FXML private Button addStudentCancelBtn;
    @FXML private Button addStudentOKBtn;

    public void addStudentFunction() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/com/team/LMS/view/global/AddStudent.fxml"));
        primaryStage.setTitle("Add student");
        primaryStage.setScene(new Scene(root, 466, 284));
        primaryStage.show();
    }

    public void addNewStudent() throws SQLException, IOException {
        Student studentObject=new Student();
        String studentId;
        boolean flag=false;
        ArrayList<Student>students=studentObject.getStudents();
        studentId = addStudentIDTextField.getText();
        for(Student student :students){
            if (student.getUsername().equals(studentId)) {
                flag = true;
                break;
            }
        }
        if(flag)
        {     System.out.println("Student with this ID already exists");
            addStudentErrorMessage.setText("Student with this ID already exists");
        }
        else {
            studentObject.register(studentId, "1", addStudentFirstNameTextField.getText(), addStudentLastNameTextField.getText());
            LoginController.controlWindows(addStudentOKBtn);
            LibrarianStudentsController.refresh();
        }
    }
    public void cancelAdditionStudent(){
        LoginController.controlWindows(addStudentCancelBtn);
    }

}
