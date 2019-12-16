package com.team.LMS.controller.global;

import com.team.LMS.controller.login.LoginController;
import com.team.LMS.model.Librarian;
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

public class AddLibrarianController {

    @FXML private TextField addLibrarianIDTextField;
    @FXML private TextField addLibrarianFirstNameTextField;
    @FXML private TextField addLibrarianLastNameTextField;
    @FXML private Label fineLastNameText1;
    @FXML private Label addLibrarianErrorMessage;
    @FXML private Button addLibrarianCancelBtn;
    @FXML private Button addLibrariantOKBtn;

    public void addLibrarianFunction() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/com/team/LMS/view/global/AddLibrarian.fxml"));
        primaryStage.setTitle("Add librarian");
        primaryStage.setScene(new Scene(root, 466, 284));
        primaryStage.show();
    }


    public void addNewLibrarian() throws SQLException{
        Librarian librarian=new Librarian();
        String librarianId;
        boolean flag=false;
        ArrayList<Librarian> librarians=librarian.getLibrarians();
        librarianId = addLibrarianIDTextField.getText();
        for(Librarian librarian_ :librarians){
            if (librarian_.getUsername().equals(librarianId)) {
                flag = true;
                break;
            }
        }
        if(flag)
        {     System.out.println("Librarian with this ID already exists");
           addLibrarianErrorMessage.setText("Librarian with this ID already exists");
        }
        else {
            librarian.register(librarianId, "1", addLibrarianFirstNameTextField.getText(), addLibrarianLastNameTextField.getText());
            LoginController.controlWindows(addLibrariantOKBtn);
        }
    }
    public void cancelAdditionLibrarian(){
        LoginController.controlWindows(addLibrarianCancelBtn);
    }

}
