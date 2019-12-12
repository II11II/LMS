package com.team.LMS.controller.librarian;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

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
}
