package sample.Model;

import java.sql.SQLException;
import java.util.Date;

public class Student extends Person {
    Book borrowedBook=new Book();
    Date expireDate;
    double currentFine;


    public Student(String username, String password, String firstName, String lastName) throws SQLException {
        super(username, password, firstName, lastName);

    }

    @Override
    public void login() {

    }

    @Override
    public void register() {
        try {
            statement.executeUpdate("INSERT INTO Student " +
                    "VALUES ('"+username+"', '"+firstName+"','"+lastName+"');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
