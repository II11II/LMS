package com.team.LMS.controller.student;

import com.team.LMS.controller.login.LoginController;
import com.team.LMS.model.Book;
import com.team.LMS.model.OverdueStudent;
import com.team.LMS.model.Student;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentReserveController {

    @FXML private TextField reserveISBNTextField;
    @FXML private Button reserveISBNSearchBtn;
    @FXML private Label reserveTitleText;
    @FXML private Label reserveSubjectText;
    @FXML private Label reserveStatusText;
    @FXML private Label reserveAuthorText;
    @FXML private Label reserveCopyrigthText;
    @FXML private Button reserveBookSaveBtn;

    public void searchIsbnButton() throws SQLException {
        Book book = new Book();
        ArrayList<Book>books = book.getBooks("default");
        for(Book book1:books){
            if(Integer.toString(book1.getISBN()).equals(reserveISBNTextField.getText())){
                reserveAuthorText.setText(book1.getAuthor());
                reserveCopyrigthText.setText(String.valueOf(book1.getPublishDate()));
                reserveStatusText.setText(Integer.toString(book1.getReserved()));
                reserveTitleText.setText(book1.getTitle());
                reserveSubjectText.setText(book1.getSubject());
            }
        }
    }

    public void saveBookButton() throws SQLException {
        Student student=new Student();
        LoginController loginController=new LoginController();
        String currentUser = loginController.getCurrentUser();
        student.issueBook(currentUser,Integer.parseInt(reserveISBNTextField.getText()),new Date(new java.util.Date().getTime()),new Date(new java.util.Date().getTime()+15));
    }

}
