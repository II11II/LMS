package com.team.LMS.model;

import java.io.IOError;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Student extends Person {
    Book borrowedBook;
    Date expireDate;
    double fine;
    boolean isBlocked;

    public Student() throws SQLException {
        super();

    }

    private Student(String username, String password, String firstName, String lastName, boolean isBlocked,double fine) throws SQLException {
        super(username, password, firstName, lastName);
        this.isBlocked = isBlocked;
        this.fine=fine;
    }

    @Override
    public boolean login(String username, String password) {
        String query = "SELECT * from Student;";
        return exists(username, password, query);

    }



    public void register(String username, String password, String firstName, String lastName) {
        boolean isBlocked=false;//by default
        double fine=0.0;//by default
        try {
            statement.executeUpdate("INSERT INTO Student " +
                    "VALUES('" + username + "', '" + firstName + "','" + lastName + "','" + password + "'," +isBlocked+","+fine+");");
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

    // TODO: Check the functionality
    public Student fineOrBlock(String username, double fine, boolean isBlocked) {
        String query = "update " + fine + "," + "" + isBlocked + "" + " from Student where username = " + "'" + username + "';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this;

    }

    // TODO: Check the functionality
    public ArrayList<Student> getStudents(){
        String query="select username,fine,isBlocked,firstName,lastName from Student";
        ArrayList<Student> students=new ArrayList<>();
        ResultSet resultSet ;
        try {
            resultSet = statement.executeQuery(query);


            Student student=new Student();
            while (resultSet.next()) {

                 student.firstName=resultSet.getString("firstName");
                 student.username=resultSet.getString("username");
                 student.lastName=resultSet.getString("lastName");
                 student.fine=resultSet.getDouble("fine");
                 student.isBlocked=resultSet.getBoolean("isBlocked");
                 students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    //TODO : To check the function to its functionality
    public void modifyStudent(String username, Map<String, Object> columnValue) {
        for (Map.Entry<String, Object> entry : columnValue.entrySet()) {


            String query = "UPDATE Student set " + entry.getKey() + "=" + entry.getValue() + " where username = " + username + ";";
            try {
                PreparedStatement pstmt = connection.prepareStatement(query);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new IOError(new Throwable());
            }
        }

    }


}
