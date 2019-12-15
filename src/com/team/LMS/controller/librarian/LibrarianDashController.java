package com.team.LMS.controller.librarian;

import com.team.LMS.controller.login.LoginController;
import com.team.LMS.controller.student.StudentDashController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LibrarianDashController implements Initializable{

    AnchorPane studentsInfo,booksInfo,issueBook,issueFine,returnInfo,blockInfo;
    @FXML private AnchorPane holderPane;
    @FXML private Button studentsBtn;
    @FXML private Button booksBtn;
    @FXML private Button returnBookBtn;
    @FXML private Button issueBookBtn;
    @FXML private Button issueFineBtn;
    @FXML private Button blockStudentBtn;
    @FXML private Button signoutBtn;

    public void LDashboardController() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/com/team/LMS/view/librarian/LibrarianDashboard.fxml"));
        primaryStage.setTitle("Library Management System");
        primaryStage.setScene(new Scene(root, 970, 576));
        primaryStage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            studentsInfo = FXMLLoader.load(getClass().getResource("/com/team/LMS/view/librarian/LibrarianStudents.fxml"));
            booksInfo = FXMLLoader.load(getClass().getResource("/com/team/LMS/view/librarian/LibrarianBooks.fxml"));
            issueFine = FXMLLoader.load(getClass().getResource("/com/team/LMS/view/librarian/LibrarianIssueFine.fxml"));
            issueBook = FXMLLoader.load(getClass().getResource("/com/team/LMS/view/librarian/LibrarianIssueBook.fxml"));
            returnInfo = FXMLLoader.load(getClass().getResource("/com/team/LMS/view/librarian/LibrarianReturnBook.fxml"));
            blockInfo = FXMLLoader.load(getClass().getResource("/com/team/LMS/view/librarian/LibrarianBlockStudent.fxml"));
            setNode(studentsInfo);
        } catch (IOException ex) {
            Logger.getLogger(LibrarianDashController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML private void studentsData(ActionEvent event) {
        setNode(studentsInfo);
    }

    @FXML private void booksData(ActionEvent event) {
        setNode(booksInfo);
    }

    @FXML private void issueBookData(ActionEvent event){
         setNode(issueBook);
    }

    @FXML private void returnBookData(ActionEvent event){
        setNode(returnInfo);
    }

    @FXML private void issueFineData(ActionEvent event){
        setNode(issueFine);
    }

    @FXML private void blockStudentData(ActionEvent event){
        setNode(blockInfo);
    }

    public void signoutData()throws IOException{
        LoginController.signoutOption(signoutBtn);
    }

    public void setNode(Node node) {
        StudentDashController.forSetNode(node, holderPane);
    }
}

