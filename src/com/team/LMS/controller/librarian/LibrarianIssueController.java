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
import java.sql.SQLException;

public class LibrarianIssueController {
    @FXML private TextField issueIDTextField;
    @FXML private Button issueIDSearchBtn;
    @FXML private Label issueFirstNameText;
    @FXML private Label issueLastNameText;
    @FXML private Label issueDepartmentText;
    @FXML private Label issueDegreeText;
    @FXML private DatePicker issueDatePicker;
    @FXML private TextField issueISBNTextField;
    @FXML private Button issueISBNSearchBtn;
    @FXML private Label issueTitleText;
    @FXML private Label issueSubjectText;
    @FXML private Label issueStatusText;
    @FXML private Label issueAuthorText;
    @FXML private Label issueCopyrigthText;
    @FXML private Button bookIssueSaveBtn;

    public void LIssueController() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/com/team/LMS/view/librarian/LibrarianIssueBook.fxml"));
        primaryStage.setTitle("Issue book information");
        primaryStage.setScene(new Scene(root, 710, 550));
        primaryStage.show();
    }
    public void searchStudentAction() throws SQLException {
        LibrarianReturnController.returnStudent(issueIDTextField, issueFirstNameText, issueLastNameText, issueDepartmentText, issueDegreeText, issueDatePicker);
    }

    public void searchBookAction()throws SQLException{
        LibrarianReturnController.returnBook(issueISBNTextField, issueTitleText, issueAuthorText, issueCopyrigthText, issueStatusText, issueSubjectText);
    }
}
