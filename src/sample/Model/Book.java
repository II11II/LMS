package sample.Model;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
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

    Book(String title, String subject, String author, int ISBN, Date publishDate, int quantity) throws SQLException {
        super();
        this.author = author;
        this.ISBN = ISBN;
        this.publishDate = publishDate;
        this.title = title;
        this.subject = subject;
        this.quantity = quantity;
    }

    private Queue<String> sort(String column, String query) {
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

    public Queue<String> sort(String column ) {

        String query = "SELECT "+ column +" FROM Book" +
                " ORDER BY "+ column +" DESC;";
        return sort(column,query);
    }

    public void setTitle(String title) {
        this.title = title;


    }

    public String getSortedBySubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSortedByAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getSortedByISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public Date getSortedByPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public int getSortedByQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

