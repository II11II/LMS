package com.team.LMS.controller.administrator;

import com.team.LMS.controller.global.AddBookController;
import com.team.LMS.controller.global.EditBookController;
import com.team.LMS.controller.librarian.LibrarianBooksController;
import com.team.LMS.model.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdministratorBooksController implements Initializable {
    public TableColumn<Book,Date> colCopyright;
    public TableColumn<Book,String> colAuthor;
    public TableColumn<Book,Integer> colStatus;
    public TableColumn<Book,String> colSubject;
    public TableColumn<Book,String> colTitle;
    public TableColumn<Book,Integer> colIsbn;
    @FXML
    private Button adminAddBookBtn;
    @FXML
    private Button adminEditBookBtn;
    @FXML
    private Button adminSearchBookBtn;
    @FXML
    private TextField adminDeleteBookTextField;
    @FXML
    private TableView<Book> adminBooksTableView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        adminBooksTableView.setEditable(true);
        try {
            setCol();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            adminBooksTableView.setItems(getBook());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    ObservableList<Book> getBook() throws SQLException {
        Book book = new Book();
        ObservableList<Book> booksObservableList = FXCollections.observableArrayList();
        ArrayList<Book> sortDefault = book.getBooks("default");
        booksObservableList.addAll(sortDefault);
        return booksObservableList;
    }

    private void setCol() throws SQLException {
        LibrarianBooksController.setColHelper(colTitle, colSubject, colAuthor, colIsbn, colCopyright);
        colStatus.setCellValueFactory(new PropertyValueFactory<>("reserved"));
        adminBooksTableView.setItems(getBook());

    }
    public void addBookAction() throws IOException {
        AddBookController addBookController=new AddBookController();
        addBookController.addBookFunction();
    }

    public void editBookAction() throws IOException {
        EditBookController editBookController = new EditBookController();
        editBookController.editBookFunction();
    }


}
