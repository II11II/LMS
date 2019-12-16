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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class EditBookController {

    @FXML
    private TextField editBookISBNTextField;
    @FXML
    private Button editBookSearchBtn;
    @FXML
    private TextField editBookTitleTextField;
    @FXML
    private TextField editBookSubjectTextField;
    @FXML
    private TextField editBookStatusTextField;
    @FXML
    private TextField editBookAuthorTextField;
    @FXML
    private TextField editBookCopyrightTextField;
    @FXML
    private Button editBookCancelBtn;
    @FXML
    private Button editBookOKBtn;

    public void editBookFunction() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/com/team/LMS/view/global/EditBook.fxml"));
        primaryStage.setTitle("Edit book");
        primaryStage.setScene(new Scene(root, 473, 416));
        primaryStage.show();
    }

    public void editBookSearch() throws SQLException {
        Book book = new Book();
        String bookISBN = editBookISBNTextField.getText();
        ArrayList<Book> books = book.getBooks("default");
        for (Book book_ : books) {
            if (Integer.toString(book_.getISBN()).equals(bookISBN)) {
                editBookAuthorTextField.setText(book_.getAuthor());
                editBookCopyrightTextField.setText(String.valueOf(book_.getPublishDate()));
                editBookTitleTextField.setText(book_.getTitle());
                editBookSubjectTextField.setText(book_.getSubject());
                editBookStatusTextField.setText(String.valueOf(book_.getReserved()));
                break;
            }
        }

    }

    public void editBookOk() throws SQLException {
        Book book;
        book = new Book();
        int reserved = 0;
        ArrayList<Book> s = book.getBooks("");
        for (Book books : s) {
            if (books.getISBN() == Integer.parseInt(editBookISBNTextField.getText())) {
                reserved = books.getReserved();
            }
        }
        if (!editBookISBNTextField.getText().equals("")) {
            book.setTitle(editBookTitleTextField.getText());
            book.setAuthor(editBookAuthorTextField.getText());
            book.setPublishDate(Date.valueOf(editBookCopyrightTextField.getText()));
            book.setReserved(Integer.parseInt(editBookStatusTextField.getText()));
            book.setSubject(editBookSubjectTextField.getText());
            book.modifyBook(Integer.parseInt(editBookISBNTextField.getText()), editBookTitleTextField.getText(),
                    editBookSubjectTextField.getText(), editBookAuthorTextField.getText(), Date.valueOf(editBookCopyrightTextField.getText()),
                    reserved);


            LoginController.controlWindows(editBookOKBtn);
            LibrarianBooksController.refresh();
        } else {
            System.out.println("Book with this ISBN already exist");
        }
    }

    public void editStudentCancel() {
        LoginController.controlWindows(editBookCancelBtn);
    }
}
