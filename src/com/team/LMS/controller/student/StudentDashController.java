package com.team.LMS.controller.student;

import com.mysql.jdbc.log.Log;
import com.team.LMS.controller.librarian.LibrarianDashController;
import com.team.LMS.controller.login.LoginController;
import javafx.animation.FadeTransition;
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
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentDashController implements Initializable {
    AnchorPane studentsProfileInfo,studentsBooksInfo,studentsReserveInfo;
    @FXML private AnchorPane holderPaneStudent;
    @FXML private Button studentProfileBtn;
    @FXML private Button studentBooksBtn;
    @FXML private Button studentReserveBookBtn;
    @FXML private Button signoutBtn;

    public void SDashboardController() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/com/team/LMS/view/student/StudentDashboard.fxml"));
        primaryStage.setTitle("Library Management System");
        primaryStage.setScene(new Scene(root, 970, 576));
        primaryStage.show();
    }

    public void profileData(ActionEvent event)  {
        setNode(studentsProfileInfo);
    }

    public void booksData(ActionEvent event){
        setNode(studentsBooksInfo);
    }

    public void reserveBookData(ActionEvent event){
        setNode(studentsReserveInfo);
    }

    public void signoutData()throws IOException{
        LoginController.signoutOption(signoutBtn);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            studentsProfileInfo = FXMLLoader.load(getClass().getResource("/com/team/LMS/view/student/StudentProfile.fxml"));
            studentsBooksInfo = FXMLLoader.load(getClass().getResource("/com/team/LMS/view/student/StudentBooks.fxml"));
            studentsReserveInfo = FXMLLoader.load(getClass().getResource("/com/team/LMS/view/student/StudentReserveBook.fxml"));
            setNode(studentsProfileInfo);
        } catch (IOException ex) {
            Logger.getLogger(LibrarianDashController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void setNode(Node node) {
        forSetNode(node, holderPaneStudent);
    }

    public static void forSetNode(Node node, AnchorPane holderPane) {
        holderPane.getChildren().clear();
        holderPane.getChildren().add(node);
        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }

}
