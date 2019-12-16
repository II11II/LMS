package com.team.LMS.model;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;

import java.io.IOError;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class Student extends Person {

    boolean isBlocked;
    double fine;


    public Student() throws SQLException {
        super();

    }

    private Student(String username, String password, String firstName, String lastName, boolean isBlocked, double fine) throws SQLException {
        super(username, password, firstName, lastName);
        this.isBlocked = isBlocked;
        this.fine = fine;
    }

    // TODO: Duplication
    public void issueBook(String username, int ISBN, Date issueDate, Date periodDate) throws SQLException {
        String checkQuery="";
        String insertQuery = " Insert into BookIssue  (" + "username," + "isbn," + "periodDate," + "issueDate" + ") values (" + "'" + username + "'," + ISBN + ",'" + issueDate + "'" + ",'" + periodDate + "'" + ")  ;";
        try {
            PreparedStatement statement = connection.prepareStatement(insertQuery);
            statement.executeUpdate();

        } catch (MySQLSyntaxErrorException e) {
            System.out.println(e.toString());

        } catch (MySQLIntegrityConstraintViolationException e) {
            String updateQuery = " UPDATE BookIssue set issueDate = '" + issueDate + "' periodDate = '" + periodDate + "' where username = '" + username + "' and ISBN = " + ISBN + ";";

            PreparedStatement statement = connection.prepareStatement(updateQuery);
            statement.executeUpdate();
        }


    }

    public void returnBook(String username, int ISBN, Date returnDate) throws SQLException {

        String insertQuery = " UPDATE BookIssue set returnDate = '" + returnDate + "' where username = '" + username + "' and ISBN = " + ISBN + ";";
        try {
            PreparedStatement statement = connection.prepareStatement(insertQuery);
            statement.executeUpdate(insertQuery);

        } catch (MySQLSyntaxErrorException e) {
            System.out.println(e.toString());
        }

    }


    @Override
    public boolean login(String username, String password) {
        String query = "SELECT * from Student;";
        return exists(username, password, query);
    }


    public void register(String username, String password, String firstName, String lastName) {
        boolean isBlocked = false;//by default
        double fine = 0.0;//by default
        try {
            statement.executeUpdate("INSERT INTO Student " +
                    "VALUES('" + username + "', '" + firstName + "','" + lastName + "','" + password + "'," + isBlocked + "," + fine + ");");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //TODO:Check the functionality
    public void deleteStudent(String username) {

        String query = "delete from Student where username = '" + username + " ';";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void fineOrBlock(String username, double fine, boolean isBlocked) {
        String query = "update Student set fine= " + fine + ",  isBlocked = " + isBlocked + "" + " where username = " + "'" + username + "';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // TODO: Check the functionality
    public ArrayList<Student> getStudents() {
        String query = "select username,fine,isBlocked,firstName,lastName from Student";
        ArrayList<Student> students = new ArrayList<>();
        ResultSet resultSet;
        try {
            resultSet = statement.executeQuery(query);
            Student student;
            while (resultSet.next()) {
                student = new Student();
                student.firstName = resultSet.getString("firstName");
                student.username = resultSet.getString("username");
                student.lastName = resultSet.getString("lastName");
                student.fine = resultSet.getDouble("fine");
                student.isBlocked = resultSet.getBoolean("isBlocked");
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    //TODO : To check the function to its functionality
    public void modifyStudent(String username, String firstName, String lastName) {


        String query = "UPDATE Student set  firstName" + "=" + firstName + " , set  lastName = " + lastName + " where username = " + username + ";";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IOError(new Throwable());
        }
    }

}
