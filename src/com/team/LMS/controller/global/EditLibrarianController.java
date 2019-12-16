package com.team.LMS.controller.global;

import com.team.LMS.controller.administrator.AdministratorLibrariansController;
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

public class EditLibrarianController {

    @FXML private Button editLibrarianOKBtn;
    @FXML private TextField editLibrarianIDTextField;
    @FXML private Button editLibrarianSearchBtn;
    @FXML private TextField editLibrarianFirstNameTextField;
    @FXML private TextField editLibrarianLastNameTextField;
    @FXML private Button editLibrarianCancelBtn;

    public void editLibrarianFunction() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/com/team/LMS/view/global/EditLibrarian.fxml"));
        primaryStage.setTitle("Edit librarian");
        primaryStage.setScene(new Scene(root, 466, 284));
        primaryStage.show();
    }


    public void editLibrarianSearch() throws SQLException {
        Librarian librarian=new Librarian();
        String librarianId=editLibrarianIDTextField.getText();
        ArrayList<Librarian> librarians=librarian.getLibrarians();
        for(Librarian librarian_:librarians){
            if(librarian_.getUsername().equals(librarianId)){
                editLibrarianFirstNameTextField.setText(librarian_.getFirstName());
                editLibrarianLastNameTextField.setText(librarian_.getLastName());
                break;
            }
        }

    }

    public void editLibrarianOk() throws SQLException {
        Librarian  librarian=new Librarian();
        if(!editLibrarianIDTextField.getText().equals("")) {
            librarian.setFirstName(editLibrarianFirstNameTextField.getText());
            librarian.setLastName(editLibrarianLastNameTextField.getText());
            librarian.modifyLibrarian(librarian.getUsername(),librarian.getFirstName(),librarian.getLastName());
            LoginController.controlWindows(editLibrarianOKBtn);
            AdministratorLibrariansController.refresh();
        }else {
            System.out.println("Librarian with this ID does not exist");
        }
    }

    public void editStudentCancel(){
        LoginController.controlWindows(editLibrarianCancelBtn);
    }
}
