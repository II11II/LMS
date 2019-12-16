package com.team.LMS.controller.librarian;

import com.team.LMS.model.Student;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
                fineAmountTextField.setText(String.valueOf(student_.getFine()));
                break;
            }
            else{
                fineFirstNameText.setText(null);
                fineLastNameText.setText(null);
            }
        }
    }

    public void issueFineButton() throws SQLException {
        Student student=new Student();
        ArrayList<Student>students=new ArrayList<>();
        String studentId=fineIDTextField.getText();
        for(Student student1:students){
            if(student1.getUsername().equals(studentId)){
                student1.setFine(Double.parseDouble(fineAmountTextField.getText()));
                student1.fineOrBlock(studentId,Double.parseDouble(fineAmountTextField.getText()),false);
            }
        }
    }
}
