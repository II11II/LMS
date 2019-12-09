package com.team.LMS.model;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.LinkedList;
import java.util.Queue;

public class Book extends LMS {
    private String title;
    private String subject;
    private String author;
    private int ISBN;
    private Date publishDate;
    private int quantity;

    public Book() throws SQLException {
        super();

    }
//PASSING DATE
    // create a sql date object so we can use it in our INSERT statement
//    Calendar calendar = Calendar.getInstance();
//    java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
    public Book(String title, String subject, String author, int ISBN, Date publishDate, int quantity) throws SQLException {
        super();
        this.author = author;
        this.ISBN = ISBN;
        this.publishDate = publishDate;
        this.title = title;
        this.subject = subject;
        this.quantity = quantity;
        String query = "Insert into Book ( title , subject ,author, ISBN, publishDate,quantity) " +
                "Values ( '" + title + "' ,'" + subject + "','" + author + "'," + ISBN + ", DATE (" + publishDate + " , 'yy-mm-dd' )," +
                quantity + " );";
        statement.executeUpdate(query);


    }

    private void setFeature() {

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

    public void setTitle(String title) {
        this.title = title;


    }

    public Queue<String> getSortedBySubject() {

        String query = "SELECT " + "subject" + " FROM Book" +
                " ORDER BY " + "subject" + " DESC;";
        return sortStringType("subject", query);

    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Queue<String> getSortedByAuthor() {

        String query = "SELECT " + "author" + " FROM Book" +
                " ORDER BY " + "author" + " DESC;";
        return sortStringType("author", query);

    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Queue<Integer> getSortedByISBN() {

        String query = "SELECT " + "ISBN" + " FROM Book" +
                " ORDER BY " + "ISBN" + " DESC;";
        return sortIntegerType("ISBN", query);

    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
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

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Queue<Integer> getSortedByQuantity() {
        String query = "SELECT " + "quantity" + " FROM Book" +
                " ORDER BY " + "quantity" + " DESC;";
        return sortIntegerType("quantity", query);

    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

