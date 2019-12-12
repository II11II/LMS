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

    ObservableList<Book> getBook() throws SQLException {
        Book book = new Book();
        ArrayList<Book> books = book.getBooks();
        ObservableList<Book> personObservableList = FXCollections.observableArrayList();
        personObservableList.addAll(books);
        return personObservableList;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colSubject.setCellValueFactory(new PropertyValueFactory<>("subject"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colISBN.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
        colCopyright.setCellValueFactory(new PropertyValueFactory<>("publishDate"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        try {
            booksTableView.setItems(getBook());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
