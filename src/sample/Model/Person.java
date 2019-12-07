package sample.Model;

public abstract class Person extends LMS {
    String username;
    String password;
    String firstName;
    String lastName;


    Person(String username, String password, String firstName, String lastName) throws java.sql.SQLException {
        super.createTable();
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

     public abstract void login();
     public abstract void register();



}
