package com.team.LMS.controller.student;

import com.team.LMS.model.Book;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class StudentBooksController implements Initializable {

    @FXML private TableView<Book> studentBooksTableView;
    @FXML private TableColumn<Book,Integer> colISBN;
    @FXML private TableColumn<Book,String> colSubject;
    @FXML private TableColumn<Book,Integer> colStatus;
    @FXML private TableColumn<Book,String> colAuthor;
    @FXML private TableColumn<Book,String> colTitle;
    @FXML private TableColumn<Book, Date> colCopyright;
    @FXML private CheckBox studentIsbnCheckBox;
    @FXML private CheckBox studentTitleCheckBox;
    @FXML private CheckBox studentSubjectCheckBox;
    @FXML private CheckBox studentStatusCheckBox;
    @FXML private CheckBox studentAuthorCheckBox;
    @FXML private CheckBox studentCopyrightCheckBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
