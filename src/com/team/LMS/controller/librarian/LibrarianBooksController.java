package com.team.LMS.controller.librarian;

import com.team.LMS.controller.global.AddBookController;
import com.team.LMS.controller.global.EditBookController;
import com.team.LMS.model.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LibrarianBooksController implements Initializable {
    @FXML private Button searchBookBtn;
    @FXML private Button borrowedBooksBtn;
    @FXML private Button addBookBtn;
    @FXML private Button editBookBtn;
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
    public static ObservableList<Book> booksObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        booksTableView.setEditable(true);
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
    public static ObservableList<Book> getBook(String string) throws SQLException {
        Book book = new Book();
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
        setColHelper(colTitle, colSubject, colAuthor, colISBN, colCopyright);
//        colStatus.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        booksTableView.setItems(getBook(type));

    }

    public static void setColHelper(TableColumn<Book, String> colTitle, TableColumn<Book, String> colSubject, TableColumn<Book, String> colAuthor, TableColumn<Book, Integer> colISBN, TableColumn<Book, Date> colCopyright) {
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colSubject.setCellValueFactory(new PropertyValueFactory<>("subject"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colISBN.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
        colCopyright.setCellValueFactory(new PropertyValueFactory<>("publishDate"));
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

    public void addBookAction() throws IOException {
        AddBookController addBookController=new AddBookController();
        addBookController.addBookFunction();
    }

    public void editBookAction() throws IOException {
        EditBookController editBookController=new EditBookController();
        editBookController.editBookFunction();
    }
    public static void refresh() throws SQLException {
        booksObservableList.clear();
        LibrarianBooksController.getBook("default");
    }

    public void borrowedBookButton() throws SQLException {
        Book book=new Book();
        ArrayList<Book>bookBorrow=new ArrayList<>();
        ArrayList<Book>books=new ArrayList<>();
        for(Book book1:books){
            if(book1.getReserved()==0){
                bookBorrow.add(book1);
            }
        }
        booksObservableList.addAll(bookBorrow);
    }
}
