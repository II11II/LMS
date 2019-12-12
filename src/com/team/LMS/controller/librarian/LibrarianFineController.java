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

public class LibrarianFineController {
    @FXML private TextField fineIDTextField;
    @FXML private Button fineIDSearchBtn;
    @FXML private Label fineFirstNameText;
    @FXML private Label fineLastNameText;
    @FXML private Label fineDepartmentText;
    @FXML private Label fineDegreeText;
    @FXML private Label blockDegreeText1;
    @FXML private TextField fineAmountTextField;
    @FXML private Button fineSaveBtn;

    public void LFineController() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/com/team/LMS/view/librarian/LibrarianIssueFine.fxml"));
        primaryStage.setTitle("Issue Fine book information");
        primaryStage.setScene(new Scene(root, 710, 550));
        primaryStage.show();
    }
}
