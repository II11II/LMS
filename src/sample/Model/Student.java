package sample.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Student extends Person {
    Book borrowedBook = new Book();
    Date expireDate;
    double currentFine;


    public Student(String username, String password, String firstName, String lastName) throws SQLException {
        super(username, password, firstName, lastName);

    }

    @Override
    public void login(String username, String password) {

        try {
           String query="SELECT * from Student;";
            ResultSet rs = statement.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                String id = rs.getString("username");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");

                // print the results
                System.out.format("%s, %s, %s \n", id, firstName, lastName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void register() {
        try {
            statement.executeUpdate("INSERT INTO Student " +
                    "VALUES ('" + username + "', '" + firstName + "','" + lastName + "');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
