package com.team.LMS.controller.administrator;

import com.team.LMS.controller.global.AddLibrarianController;
import com.team.LMS.controller.global.EditLibrarianController;
import com.team.LMS.controller.librarian.LibrarianBooksController;
import com.team.LMS.model.Librarian;
import com.team.LMS.model.Person;
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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdministratorLibrariansController implements Initializable {

    @FXML private Button adminAddLibrarianBtn;
    @FXML private Button adminEditLibrarianBtn;
    @FXML private Button adminSearchLibrarianBtn;
    @FXML private TextField adminDeleteLibrarianTextField;
    @FXML private TableView<Person> adminLibrariansTableView;
    @FXML private TableColumn<Librarian,String> colFirstName;
    @FXML private TableColumn<Librarian,String> colId;
    @FXML private TableColumn<Librarian,String> colLastName;
    public static ObservableList<Person> personObservableList = FXCollections.observableArrayList();

   public static ObservableList<Person> getLibrarian() throws SQLException {
        Librarian librarian = new Librarian();
        ArrayList<Librarian> librarians = librarian.getLibrarians();
        personObservableList.addAll(librarians);
        return personObservableList;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        adminLibrariansTableView.setEditable(true);
        colId.setCellValueFactory(new PropertyValueFactory<>("username"));
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        try {
            adminLibrariansTableView.setItems(getLibrarian());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addLibrarianAction() throws IOException {
        AddLibrarianController addLibrarianController=new AddLibrarianController();
        addLibrarianController.addLibrarianFunction();
    }

    public void editLibrarianAction() throws IOException {
        EditLibrarianController editLibrarianController=new EditLibrarianController();
        editLibrarianController.editLibrarianFunction();
    }
    public static void refresh() throws SQLException {
        personObservableList.clear();
        AdministratorLibrariansController.getLibrarian();
    }
}
