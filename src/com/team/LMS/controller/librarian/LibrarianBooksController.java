package com.team.LMS.controller.librarian;

import com.team.LMS.model.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.ResourceBundle;

public class LibrarianBooksController implements Initializable {
    @FXML private Button borrowedBooksBtn;
    @FXML private Button addBookBtn;
    @FXML private Button editBookBtn;
    @FXML private Button deleteBookBtn;
    @FXML private TextField deleteBookTextField;
    @FXML private TableView<Book> booksTableView;
    @FXML private CheckBox isbnCheckBox;
    @FXML private CheckBox titleCheckBox;
    @FXML private CheckBox subjectCheckBox;
    @FXML private CheckBox authorCheckBox;
    @FXML private CheckBox copyrightCheckBox;
    @FXML private CheckBox statusCheckBox;
    @FXML private TableColumn<Book,Integer> colISBN;
    @FXML private TableColumn<Book,String> colTitle;
    @FXML private TableColumn<Book,String> colSubject;
    @FXML private TableColumn<Book,Integer> colStatus;
    @FXML private TableColumn<Book,Date> colCopyright;
    @FXML private TableColumn<Book,String> colAuthor;

    public void LBooksController() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/com/team/LMS/view/librarian/LibrarianBooks.fxml"));
        primaryStage.setTitle("Books information");
        primaryStage.setScene(new Scene(root, 710, 550));
        primaryStage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            setCol("default");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            booksTableView.setItems(getBook("default"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    ObservableList<Book> getBook(String string) throws SQLException {
        Book book = new Book();
        ObservableList<Book> booksObservableList = FXCollections.observableArrayList();
        if(string.equals("default")){
            ArrayList<Book> sortDefault = book.getBooks(string);
            booksObservableList.addAll(sortDefault);
        }
        if(string.equals("isbn")){
            ArrayList<Book>sortIsbn=book.getBooks(string);
            booksObservableList.addAll(sortIsbn);
        }
        if(string.equals("title")){
            ArrayList<Book>sortTitle=book.getBooks(string);
            booksObservableList.addAll(sortTitle);
        }
        if(string.equals("subject")){
            ArrayList<Book>sortSubject=book.getBooks(string);
            booksObservableList.addAll(sortSubject);
        }
        if(string.equals("author")){
            ArrayList<Book>sortAuthor=book.getBooks(string);
            booksObservableList.addAll(sortAuthor);
        }
        if(string.equals("copyright")){
            ArrayList<Book>sortCopyright=book.getBooks(string);
            booksObservableList.addAll(sortCopyright);
        }
        return booksObservableList;
    }

    private void setCol(String type) throws SQLException {
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colSubject.setCellValueFactory(new PropertyValueFactory<>("subject"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colISBN.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
        colCopyright.setCellValueFactory(new PropertyValueFactory<>("publishDate"));
//        colStatus.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        booksTableView.setItems(getBook(type));

    }
    public void itemIsSelected() throws SQLException {
        if(isbnCheckBox.isSelected())
            setCol("isbn");
        else if(titleCheckBox.isSelected())
            setCol("title");
        else if(subjectCheckBox.isSelected())
            setCol("subject");
        else if(authorCheckBox.isSelected())
            setCol("author");
        else if(copyrightCheckBox.isSelected())
            setCol("copyright");
        else
            setCol("default");
    }
    public void isbnCheckBoxAction() throws SQLException {
        booksTableView.setItems(getBook("isbn"));
        itemIsSelected();
    }

    public void titleCheckBoxAction()throws SQLException{
        booksTableView.setItems(getBook("title"));
        itemIsSelected();
    }

    public void subjectCheckBoxAction()throws SQLException{
        booksTableView.setItems(getBook("subject"));
        itemIsSelected();
    }

    public void authorCheckBoxAction()throws SQLException{
        booksTableView.setItems(getBook("author"));
        itemIsSelected();
    }

    public void copyrightCheckBoxAction()throws SQLException{
        booksTableView.setItems(getBook("copyright"));
        itemIsSelected();
    }
}
