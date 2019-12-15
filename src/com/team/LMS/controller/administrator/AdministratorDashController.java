package com.team.LMS.controller.administrator;

import com.team.LMS.controller.librarian.LibrarianDashController;
import com.team.LMS.controller.login.LoginController;
import com.team.LMS.controller.student.StudentDashController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdministratorDashController implements Initializable {
    AnchorPane adminLibrarianInfo,adminStudentInfo,adminBookInfo;
    @FXML private AnchorPane holderPaneAdmin;
    @FXML private Button adminLibrariansBtn;
    @FXML private Button adminStudentsBtn;
    @FXML private Button adminBooksBtn;
    @FXML private Button adminsignoutBtn;

    public void ADashboardController() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/com/team/LMS/view/administrator/AdministratorDashboard.fxml"));
        primaryStage.setTitle("Administrator");
        primaryStage.setScene(new Scene(root, 970, 576));
        primaryStage.show();
    }

    public void librarianData(ActionEvent event) {
      setNode(adminLibrarianInfo);
    }

    public void studentData(ActionEvent event)  {
        setNode(adminStudentInfo);
    }

    public void bookData(ActionEvent event) {
        setNode(adminBookInfo);
    }
    public void adminSignoutData()throws IOException{
        LoginController.signoutOption(adminsignoutBtn);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            adminLibrarianInfo = FXMLLoader.load(getClass().getResource("/com/team/LMS/view/administrator/AdministratorLibrarians.fxml"));
            adminStudentInfo= FXMLLoader.load(getClass().getResource("/com/team/LMS/view/administrator/AdministratorStudents.fxml"));
            adminBookInfo = FXMLLoader.load(getClass().getResource("/com/team/LMS/view/administrator/AdministratorBooks.fxml"));
            setNode(adminLibrarianInfo);
        } catch (IOException ex) {
            Logger.getLogger(LibrarianDashController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void setNode(Node node) {
        StudentDashController.forSetNode(node, holderPaneAdmin);
    }

}
