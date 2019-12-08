package sample.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Student extends Person {
    Book borrowedBook ;
    Date expireDate;
    double currentFine;


    public Student(String username, String password, String firstName, String lastName) throws SQLException {
        super(username, password, firstName, lastName);

    }

    @Override
    public boolean login(String username, String password) {
        String query = "SELECT * from Student;";
        return exists(username, password, query);

    }


    @Override
    public void register() {
        try {
            statement.executeUpdate("INSERT INTO Student " +
                    "VALUES ('" + username + "', '" + firstName + "','" + lastName + "','" + password + "');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
