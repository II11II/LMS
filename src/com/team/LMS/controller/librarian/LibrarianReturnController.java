package com.team.LMS.controller.librarian;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LibrarianReturnController {
    @FXML private TextField returnIDTextField;
    @FXML private Button returnIDSearchBtn;
    @FXML private Label returnFirstNameText;
    @FXML private Label returnLastNameText;
    @FXML private Label returnDepartmentText;
    @FXML private Label returnDegreeText;
    @FXML private DatePicker returnDatePicker;
    @FXML private TextField returnISBNTextField;
    @FXML private Button returnISBNSearchBtn;
    @FXML private Label returnTitleText;
    @FXML private Label returnSubjectText;
    @FXML private Label returnStatusText;
    @FXML private Label returnAuthorText;
    @FXML private Label returnCopyrigthText;
    @FXML private Button returnBookSaveBtn;

    public void LReturnController() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/com/team/LMS/view/librarian/LibrarianReturnBook.fxml"));
        primaryStage.setTitle("Return book information");
        primaryStage.setScene(new Scene(root, 710, 550));
        primaryStage.show();
    }
}
