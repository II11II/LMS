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
    private int quantity;
    private ArrayList<Book> books = new ArrayList<>();

    private Book(String title, String subject, String author, int ISBN, Date publishDate, int quantity,int reserved) throws SQLException {
        super();
        this.author = author;
        this.ISBN = ISBN;
        this.publishDate = publishDate;
        this.title = title;
        this.subject = subject;
        this.quantity = quantity;
        this.reserved=reserved;
    }

    public Book() throws SQLException {
        super();

    }
//todo: reserve()
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

    private Queue<Integer> sortIntegerType(String column, String query) {
        Queue<Integer> stack = new LinkedList<>();
        try {
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                stack.add(resultSet.getInt(column));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stack;
    }

    public Queue<String> getSortedByTitle() {

        String query = "SELECT " + "title" + " FROM Book" +
                " ORDER BY " + "title" + " DESC;";
        return sortStringType("title", query);
    }

    public Queue<String> getSortedByAuthor() {

        String query = "SELECT " + "author" + " FROM Book" +
                " ORDER BY " + "author" + " DESC;";
        return sortStringType("author", query);

    }

    public Queue<String> getSortedBySubject() {

        String query = "SELECT " + "subject" + " FROM Book" +
                " ORDER BY " + "subject" + " DESC;";
        return sortStringType("subject", query);

    }

    public Queue<Integer> getSortedByISBN() {

        String query = "SELECT " + "ISBN" + " FROM Book" +
                " ORDER BY " + "ISBN" + " DESC;";
        return sortIntegerType("ISBN", query);

    }

    public Queue<Integer> getSortedByQuantity() {
        String query = "SELECT " + "quantity" + " FROM Book" +
                " ORDER BY " + "quantity" + " DESC;";
        return sortIntegerType("quantity", query);

    }

    public Queue<Date> getSortedByPublishDate() {

        String query = "SELECT publishDate FROM Book ORDER BY publishDate DESC;";
        Queue<Date> publishDate = new LinkedList<>();
        try {
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                publishDate.add(resultSet.getDate("publishDate"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return publishDate;

    }

    /**
     * example
     * Book book1=new Book("C++","PL","Sarvar",232,new Date(new java.util.Date().getTime()),10);
     **/
    public Book saveBook(String title, String subject, String author, int ISBN, Date publishDate, int quantity) {
        String query = "Insert into Book ( title , subject ,author, ISBN, publishDate,quantity) " +
                "Values ( '" + title + "' ,'" + subject + "','" + author + "'," + ISBN + ", DATE ( '" + publishDate + "' )," +
                quantity + " );";
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this;
    }

    public ArrayList<Book> getBooks() {
        String query = "Select * from Book";
        try {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                title = resultSet.getString("title");
                subject = resultSet.getString("subject");
                author = resultSet.getString("author");
                ISBN = resultSet.getInt("ISBN");
                publishDate = resultSet.getDate("publishDate");
                quantity = resultSet.getInt("quantity");
                quantity = resultSet.getInt("reserved");
                books.add(new Book(title, subject, author, ISBN, publishDate, quantity,reserved));
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


//    public Date getPublishDate() {
//        return publishDate;
//    }
//
//    public int getISBN() {
//        return ISBN;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public String getSubject() {
//        return subject;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public int getReserved() {
//        return reserved;
//    }
}

