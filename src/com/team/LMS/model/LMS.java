package com.team.LMS.model;

import java.sql.*;

public abstract class LMS {
    final static String SERVER_NAME = "localhost:3306";
    final static String TABLE = "LMS";
    final static String SSL = "?autoReconnect=true&useSSL=false";
    final static String driverName = "com.mysql.jdbc.Driver";
    final static String username = "root";
    final static String password = "";
    final static String url = "jdbc:mysql://" + SERVER_NAME + "/" + TABLE + SSL;
    Connection connection = DriverManager.getConnection(url, username, password);
    Statement statement = connection.createStatement();

    LMS() throws SQLException {
        createTable();
    }

    public void createTable() {
        try {
            Class.forName(driverName);
            final String student = "CREATE TABLE if not exists Student  ("
                    + "username VARCHAR(8),"
                    + "firstName varchar (30),"
                    + "lastName varchar(30), "
                    + "password varchar(30), "
                    + "isBlocked Bool,"
                    + "fine DOUBLE,"
                    + "PRIMARY KEY(username))";
            final String admin = "CREATE TABLE if not exists Admin  ("
                    + "username VARCHAR(8),"
                    + "firstName varchar (30),"
                    + "lastName varchar(30), "
                    + "password varchar(30), "
                    + "PRIMARY KEY(username))";
            final String librarian = "CREATE TABLE if not exists Librarian  ("
                    + "username VARCHAR(8),"
                    + "firstName varchar (30),"
                    + "lastName varchar(30), "
                    + "password varchar(30), "
                    + "PRIMARY KEY(username))";
            final String book = "CREATE TABLE if not exists Book ( "
                    + "title varchar(50),"
                    + "reserved INT ,"
                    + "subject varchar(50),"
                    + "author varchar(50),"
                    + "ISBN int(13),"
                    + "publishDate Date,"
                    + "PRIMARY KEY(ISBN))";
            final String bookIssue = "CREATE TABLE if not exists BookIssue ( "
                    + "`id` int(11) NOT NULL AUTO_INCREMENT,"
                    + "username varchar(8),"
                    + "ISBN int(13),"
                    + "issueDate Date,"
                    + "returnDate Date,"
                    + "PRIMARY KEY(id))";
            final String before = "CREATE TABLE if not exists BookIssue ( "
                    + "ISBN int(13),"
                    + "username varchar(8),"
                    + "FOREIGN KEY (username) REFERENCES Student(username) ,"
                    + "PRIMARY KEY(username))";

            statement.executeUpdate(student);
            statement.executeUpdate(admin);
            statement.executeUpdate(librarian);
            statement.executeUpdate(book);
            statement.executeUpdate(bookIssue);


        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }


}
