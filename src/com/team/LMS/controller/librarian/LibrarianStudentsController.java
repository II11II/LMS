package com.team.LMS.controller.librarian;

import com.team.LMS.controller.global.AddStudentController;
import com.team.LMS.controller.global.EditStudentController;
import com.team.LMS.model.Librarian;
import com.team.LMS.model.OverdueStudent;
import com.team.LMS.model.Person;
import com.team.LMS.model.Student;
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
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LibrarianStudentsController implements Initializable {
    @FXML private Button searchStudentBtn;
    @FXML private Button overdueStudentsBtn;
    @FXML private Button addStudentBtn;
    @FXML private Button editStudentBtn;
    @FXML private Button deleteStudentBtn;
    @FXML private TextField deleteStudentTextField;
    @FXML private TableView<Person> studentsTableView;
    @FXML private TableColumn<Person,String> colId;
    @FXML private TableColumn<Person,String> colFirstName;
    @FXML private TableColumn<Person,String> colLastName;

    public  static ObservableList<Person> personObservableList = FXCollections.observableArrayList();
     static ObservableList<Person> getStudent(ArrayList<Student>arrayList) throws SQLException {
        Student student = new Student();
        ArrayList<Student> students = student.getStudents();
        if(arrayList.isEmpty()) {
            personObservableList.addAll(students);
        }else
        {
            personObservableList.addAll(arrayList);
        }
        return personObservableList;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        studentsTableView.setEditable(true);
        colId.setCellValueFactory(new PropertyValueFactory<>("username"));
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));


        try {//here was error LIBRARIAN
            studentsTableView.setItems(getStudent(new Student().getStudents()));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addStudentAction() throws IOException {
        AddStudentController addStudentController=new AddStudentController();
        addStudentController.addStudentFunction();
    }

    public void editStudentAction()throws IOException{
        EditStudentController editStudentController=new EditStudentController();
        editStudentController.editStudentFunction();
    }

    public void searchStudent() throws SQLException {
        Student student=new Student();
        ArrayList<Student>students=student.getStudents();
        String searching=deleteStudentTextField.getText();
        boolean flag=false;
        for(Student student_:students) {
            if (searching.equals(student_.getUsername())) {
                flag = true;
//                 personObservableList = FXCollections.observableArrayList();
                personObservableList.clear();
                personObservableList.addAll(student_);
                break;
            }
        }
        if(flag)
            System.out.println("Searching student is found !");
        else
            System.out.println("This kind of student doesn't exist ! ");
    }
   public static void refresh() throws SQLException {
       personObservableList.clear();
       LibrarianStudentsController.getStudent(null);
    }

    public void overdueStudentsButton() throws SQLException {
//        OverdueStudent overdueStudent=new OverdueStudent();
//         Student student=new Student();
//         ArrayList<Student>students=new ArrayList<>();
//         ArrayList<Student>studentOverdue=new ArrayList<>();
//        for(Student student1:students){
//            if(overdueStudent.isOverdue(student1.getUsername())){
//                studentOverdue.add(student1);
//            }
//        }

              OverdueStudent overdueStudent=  new OverdueStudent();
        personObservableList.clear();
        LibrarianStudentsController.getStudent(overdueStudent.overdueStudent());
    }


}

