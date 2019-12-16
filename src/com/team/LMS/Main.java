package com.team.LMS;

import com.team.LMS.model.Admin;
import com.team.LMS.model.Book;
import com.team.LMS.model.OverdueStudent;
import com.team.LMS.model.Student;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.Date;
import java.sql.SQLException;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = FXMLLoader.load(getClass().getResource("view/login/Login.fxml"));
        primaryStage.setTitle("Library Management System");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
    }

    public static void main(String[] args) throws SQLException {
//        Admin admin=new Admin();
//        admin.register("admin","admin","ABDUVOHID","ISROILOV");
        Student model = new Student();
        model.modifyStudent("u1810037", "Islam", "Akhrarov");
        /**Example
         model.issueBook("s1810037",24,new Date(new java.util.Date().getTime()));
         **/
//        model.issueBook("s1810037",24,new Date(new java.util.Date().getTime()),new Date(new java.util.Date().getTime()));
//        model.returnBook("s1810037",24,new Date(new java.util.Date().getTime()));
//        OverdueStudent overdueStudent=new OverdueStudent();
//        System.out.println(overdueStudent.isOverdue("s1810037"));
//        model.getFirstName();
//        model.deleteStudent("u1810037");

//        System.out.println(model.getStudents());
//        System.out.println(model.viewStudents());
//        model.register("s1810037","19991111","Islam","Akhrarov");
//        model.register("s1810032","19991111","C","Akhrarov");
//        model.register("S1810033","19991111","B","Akhrarov");
//        model.register("S1810035","19991111","A","Akhrarov");
//        System.out.println( model.login("u1810037","19991111"));
//        Book book=new Book();
//        Librarian librarian=new Librarian();
//        librarian.register("l19137","1","Islam","Akhrarov");
//        librarian.viewLibrarians();
//        System.out.println( book.getSortedByTitle());
//        System.out.println(book.getSortedByAuthor());
//        System.out.println(book.getSortedByISBN());
//        System.out.println(book.getSortedByPublishDate());
//        System.out.println(book.getSortedBySubject());
//        System.out.println(book.getSortedByQuantity());
//
        Book book=new Book();
//      System.out.println(book.getBook());
        book.modifyBook(24,"PI","Sara","100",new Date(new java.util.Date().getTime()),0);
//
//        book.saveBook("A++","AI","Sara",32,new Date(new java.util.Date().getTime()));
//        book.deleteBook(242);
        launch(args);
    }
}


