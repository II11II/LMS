package com.team.LMS.model;


import java.io.IOError;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Book extends LMS {
    private String title;
    private String subject;
    private String author;
    private int ISBN;
    private Date publishDate;
    private int reserved;
    private ArrayList<Book> books = new ArrayList<>();

    private Book(String title, String subject, String author, int ISBN, Date publishDate, int reserved) throws SQLException {
        super();
        this.author = author;
        this.ISBN = ISBN;
        this.publishDate = publishDate;
        this.title = title;
        this.subject = subject;
        this.reserved = reserved;
    }

    public Book() throws SQLException {
        super();
    }

    private Queue<String> sortStringType(String column, String query) {
        Queue<String> stack = new LinkedList<>();
        try {
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                stack.add(resultSet.getString(column));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stack;
    }

    /**
     * example
     * Book book1=new Book("C++","PL","Sarvar",232,new Date(new java.util.Date().getTime()),10);
     **/
    public Book saveBook(String title, String subject, String author, int ISBN, Date publishDate) {
        String query = "Insert into Book ( title , subject ,author, ISBN, publishDate) " +
                "Values ( '" + title + "' ,'" + subject + "','" + author + "'," + ISBN + ", DATE ( '" + publishDate + "' )" + " );";
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this;
    }

    public ArrayList<Book> getBooks(String string) {
        String query;
        switch (string) {
            case "isbn":
                query = "SELECT " + "*" + " FROM Book" +
                        " ORDER BY " + "ISBN" + " ASC;";
                break;
            case "title":
                query = "SELECT " + "*" + " FROM Book" +
                        " ORDER BY " + "title" + " ASC;";
                break;
            case "subject":
                query = "SELECT " + "*" + " FROM Book" +
                        " ORDER BY " + "subject" + " ASC;";
                break;
            case "author":
                query = "SELECT " + "*" + " FROM Book" +
                        " ORDER BY " + "author" + " ASC;";
                break;
            case "copyright":
                query = "SELECT * FROM Book ORDER BY publishDate DESC;";
                break;
            case "default":
            default:
                query = "Select * from Book";
                break;
        }
        try {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                title = resultSet.getString("title");
                subject = resultSet.getString("subject");
                author = resultSet.getString("author");
                ISBN = resultSet.getInt("ISBN");
                publishDate = resultSet.getDate("publishDate");
                books.add(new Book(title, subject, author, ISBN, publishDate, reserved));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    public void deleteBook(int ISBN) {
        String query = "delete from Book where ISBN =" + ISBN;
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //TODO : To check the function to its functionality
    public void modifyBook(int ISBN, Map<String, Object> columnValue) {
        for (Map.Entry<String, Object> entry : columnValue.entrySet()) {


            String query = "UPDATE Book set " + entry.getKey() + "=" + entry.getValue() + " where ISBN = " + ISBN + ";";
            try {
                PreparedStatement pstmt = connection.prepareStatement(query);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new IOError(new Throwable());
            }
        }

    }


    public Date getPublishDate() {
        return this.publishDate;
    }

    public int getISBN() {
        return this.ISBN;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getTitle() {
        return this.title;
    }

    public int getReserved() {
        return this.reserved;
    }
}

