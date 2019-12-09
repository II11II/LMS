package com.team.LMS;

import com.team.LMS.model.Book;
import com.team.LMS.model.Person;
import com.team.LMS.model.Student;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.sql.Date;
import java.util.Calendar;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("fxml/sample.fxml"));
        primaryStage.setTitle("Library Management System");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
    }


    public static void main(String[] args) throws SQLException {
//        Person model=new Student("u1810037","19991111","Islam","Akhrarov");
//        model.register();
//        System.out.println( model.login("u1810037","19991111"));
        Book book=new Book();
//        System.out.println( book.getSortedByTitle());
//        System.out.println(book.getSortedByAuthor());
//        System.out.println(book.getSortedByISBN());
//        System.out.println(book.getSortedByPublishDate());
//        System.out.println(book.getSortedBySubject());
//        System.out.println(book.getSortedByQuantity());
//
//        Book book1=new Book("C++","PL","Sarvar",232,new Date(new java.util.Date().getTime()),10);
//        System.out.println(book.getBook());
//        book.saveBook("C++","PL","Sarvar",242,new Date(new java.util.Date().getTime()),10);
        book.deleteBook(242);
        launch(args);
    }
}


