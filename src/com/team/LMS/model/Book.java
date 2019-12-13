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
    //    private int quantity;
    private ArrayList<Book> books = new ArrayList<>();

    private Book(String title, String subject, String author, int ISBN, Date publishDate, int reserved) throws SQLException {
        super();
        this.author = author;
        this.ISBN = ISBN;
        this.publishDate = publishDate;
        this.title = title;
        this.subject = subject;
//        this.quantity = quantity;
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

//    public Queue<Integer> getSortedByQuantity() {
//        String query = "SELECT " + "quantity" + " FROM Book" +
//                " ORDER BY " + "quantity" + " DESC;";
//        return sortIntegerType("quantity", query);
//
//    }

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
        String query="";
        if(string.equals("default")){
            query = "Select * from Book";
        }else if(string.equals("isbn")){
            query="SELECT " + "*" + " FROM Book" +
                    " ORDER BY " + "ISBN" + " ASC;";
        }else if(string.equals("title")){
            query="SELECT " + "*" + " FROM Book" +
                    " ORDER BY " + "title" + " ASC;";
        }else if(string.equals("subject")){
            query="SELECT " + "*" + " FROM Book" +
                    " ORDER BY " + "subject" + " ASC;";
        }else if(string.equals("author")){
            query="SELECT " + "*" + " FROM Book" +
                    " ORDER BY " + "author" + " ASC;";
        }else if(string.equals("copyright")){
            query= "SELECT * FROM Book ORDER BY publishDate DESC;";
        }else
            query="Select * from Book";
        try {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                title = resultSet.getString("title");
                subject = resultSet.getString("subject");
                author = resultSet.getString("author");
                ISBN = resultSet.getInt("ISBN");
                publishDate = resultSet.getDate("publishDate");
//                quantity = resultSet.getInt("quantity");
//                quantity = resultSet.getInt("reserved");
                books.add(new Book(title, subject, author, ISBN, publishDate,reserved));
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

//    public int getQuantity() {
//        return this.quantity;
//    }

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

