package com.team.LMS.controller.librarian;

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

public class LibrarianBlockController {
    @FXML private TextField blockIDTextField;
    @FXML private Button blockIDSearchBtn;
    @FXML private Label blockFirstNameText;
    @FXML private Label blockLastNameText;
    @FXML private Label blockDepartmentText;
    @FXML private Label blockDegreeText;
    @FXML private Button blockSaveBtn;

    public void LBlockController() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/com/team/LMS/view/librarian/LibrarianBlockStudent.fxml"));
        primaryStage.setTitle("Block student information");
        primaryStage.setScene(new Scene(root, 710, 550));
        primaryStage.show();
    }

    public void blockStudentAction() throws SQLException {
        Student student=new Student();
        ArrayList<Student> students=student.getStudents();
        for(Student student_:students){
            if(student_.getUsername().equalsIgnoreCase(blockIDTextField.getText())){
                blockFirstNameText.setText(student_.getFirstName());
                blockLastNameText.setText(student_.getLastName());
                blockDepartmentText.setText("NULL");
                blockDegreeText.setText("NULL");
                break;
            }
            else{
                blockFirstNameText.setText(null);
                blockLastNameText.setText(null);
                blockDepartmentText.setText(null);
                blockDegreeText.setText(null);
            }
        }
    }
}
