package com.team.LMS.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookIssue extends Book {
    private String username;
    private int ISBN;
    public BookIssue() throws SQLException {
    }

    private BookIssue(String username,int ISBN) throws SQLException {
        super();
        this.ISBN=ISBN;
        this.username=username;
    }

    public ArrayList<BookIssue> bookIssues() throws SQLException {
        ArrayList<BookIssue> bookIssues=new ArrayList<>();
        BookIssue bookIssue;
        String query="select * from BookIssue";
        ResultSet resultSet= connection.createStatement().executeQuery(query);
        while (resultSet.next()){
           bookIssue=new BookIssue(resultSet.getString("username"),resultSet.getInt("ISBN"));
            bookIssues.add(bookIssue);
        }

        return bookIssues ;
    }

    public String getUsername() {
        return username;
    }


    public int getISBN() {
        return ISBN;
    }
}
