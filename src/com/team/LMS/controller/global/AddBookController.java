package com.team.LMS.controller.global;

import com.team.LMS.controller.librarian.LibrarianBooksController;
import com.team.LMS.controller.login.LoginController;
import com.team.LMS.model.Book;
import com.team.LMS.model.Student;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddBookController {
    @FXML private TextField addBookISBNTextField;
    @FXML private TextField addBookTitleTextField;
    @FXML private TextField addBookSubjectTextField;
    @FXML private TextField addBookAuthorTextField;
    @FXML private Label addBookErrorMessage;
    @FXML private Button addBookCancelBtn;
    @FXML private Button addBookOKBtn;
    @FXML private TextField addBookCopyrightTextField;

    public void addBookFunction() throws IOException {
    Stage primaryStage = new Stage();
    Parent root = FXMLLoader.load(getClass().getResource("/com/team/LMS/view/global/AddBook.fxml"));
    primaryStage.setTitle("Add book");
    primaryStage.setScene(new Scene(root, 473, 416));
    primaryStage.show();
    }

    public void addNewBook() throws SQLException{
        Book bookObject=new Book();
        String bookIsbn;
        boolean flag=false;
        ArrayList<Book> books=bookObject.getBooks("default");
        bookIsbn = addBookISBNTextField.getText();
        for(Book book :books){
            if (Integer.toString(book.getISBN()).equals(bookIsbn)) {
                flag = true;
                break;
            }
        }
        if(flag)
        {     System.out.println("Book with this ISBN already exists");
            addBookErrorMessage.setText("Book with this ISBN already exists");
        }
        else {
            bookObject.saveBook(addBookTitleTextField.getText(), addBookSubjectTextField.getText(), addBookAuthorTextField.getText(), Integer.parseInt(addBookISBNTextField.getText()), Date.valueOf(addBookCopyrightTextField.getText()));
            LoginController.controlWindows(addBookOKBtn);
            LibrarianBooksController.refresh();
        }
    }

    public void cancelAdditionBook(){
        LoginController.controlWindows(addBookCancelBtn);
    }
}
