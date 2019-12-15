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

public class LibrarianFineController {
    @FXML private TextField fineIDTextField;
    @FXML private Button fineIDSearchBtn;
    @FXML private Label fineFirstNameText;
    @FXML private Label fineLastNameText;
    @FXML private TextField fineAmountTextField;
    @FXML private Button fineSaveBtn;

    public void issueFineAction() throws SQLException {
        Student student=new Student();
        ArrayList<Student> students=student.getStudents();
        for(Student student_:students){
            if(student_.getUsername().equalsIgnoreCase(fineIDTextField.getText())){
                fineFirstNameText.setText(student_.getFirstName());
                fineLastNameText.setText(student_.getLastName());
                fineAmountTextField.setText("UNKNOWN");
                break;
            }
            else{
                fineFirstNameText.setText(null);
                fineLastNameText.setText(null);
            }
        }
    }
}
