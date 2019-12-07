package sample.Model;



import java.util.Date;

public class Book  {
    private String title;
    private String subject;
    private String author;
    private int ISBN;
    private Date publishDate;


    Book() {
    }

    Book(String title, String subject, String author, int ISBN, Date publishDate) {
        this.author=author;
        this.ISBN= ISBN;
        this.publishDate=publishDate;
        this.title=title;
        this.subject=subject;
    }


    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;

    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
}

