package com.team.LMS.model;


import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Book extends LMS {
    private String title;
    private String subject;
    private String author;
    private int ISBN;
    private Date publishDate;
    private int quantity;
    private ArrayList<Book> books = new ArrayList<>();

    private Book(String title, String subject, String author, int ISBN, Date publishDate, int quantity) throws SQLException {
        super();
        this.author = author;
        this.ISBN = ISBN;
        this.publishDate = publishDate;
        this.title = title;
        this.subject = subject;
        this.quantity = quantity;
    }

    public Book() throws SQLException {
        super();

    }

    private Queue<String> sortStringType(String column, String query) {
        Queue<String> stack = new LinkedList<String>();
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
        Queue<Integer> stack = new LinkedList<Integer>();
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
        Queue<Date> publishDate = new LinkedList<Date>();
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

    public ArrayList<Book> getBook() {
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
                books.add(new Book(title, subject, author, ISBN, publishDate, quantity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }
    public Book deleteBook(int ISBN){
        String query="delete from Book where ISBN ="+ISBN;
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return this;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public int getISBN() {
        return ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getSubject() {
        return subject;
    }

    public String getTitle() {
        return title;
    }
}

