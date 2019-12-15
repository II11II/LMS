package com.team.LMS.controller.librarian;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.sql.SQLException;

public class LibrarianIssueController {
    @FXML private TextField issueIDTextField;
    @FXML private Button issueIDSearchBtn;
    @FXML private Label issueFirstNameText;
    @FXML private Label issueLastNameText;
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

    public void searchStudentAction() throws SQLException {
        LibrarianReturnController.returnStudent(issueIDTextField, issueFirstNameText, issueLastNameText, issueDatePicker);
    }

    public void searchBookAction()throws SQLException{
        LibrarianReturnController.returnBook(issueISBNTextField, issueTitleText, issueAuthorText, issueCopyrigthText, issueStatusText, issueSubjectText);
    }
}
