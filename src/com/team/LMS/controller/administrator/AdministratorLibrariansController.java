package com.team.LMS.controller.administrator;

import com.team.LMS.model.Librarian;
import com.team.LMS.model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdministratorLibrariansController implements Initializable {

    Button adminAddLibrarianBtn;
    @FXML private Button adminEditLibrarianBtn;
    @FXML private Button adminSearchLibrarianBtn;
    @FXML private TextField adminDeleteLibrarianTextField;
    @FXML private TableView<Person> adminLibrariansTableView;
    @FXML private TableColumn<Librarian,String> colFirstName;
    @FXML private TableColumn<Librarian,String> colId;
    @FXML private TableColumn<Librarian,String> colLastName;

    ObservableList<Person> getLibrarian() throws SQLException {
        Librarian librarian = new Librarian();
        ArrayList<Librarian> librarians = librarian.getLibrarians();
        ObservableList<Person> personObservableList = FXCollections.observableArrayList();
        personObservableList.addAll(librarians);
        return personObservableList;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colId.setCellValueFactory(new PropertyValueFactory<>("username"));
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        try {
            adminLibrariansTableView.setItems(getLibrarian());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
