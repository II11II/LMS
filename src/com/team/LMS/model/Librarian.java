package com.team.LMS.model;

import java.io.IOError;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Librarian extends Person {

    public Librarian() throws SQLException {
        super();
    }

    private Librarian(String username, String password, String firstName, String lastName) throws SQLException {
        super(username, password, firstName, lastName);
    }

    @Override
    public boolean login(String username, String password) {
        String query = "SELECT * from Librarian;";
        return exists(username, password, query);
    }


    public void register(String username, String password, String firstName, String lastName) {
        try {
            statement.executeUpdate("INSERT INTO Librarian " +
                    "VALUES ('" + username + "', '" + firstName + "','" + lastName + "','" + password + "');");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // TODO: Check the functionality
    public ArrayList<Librarian> getLibrarians() {
        String query = "select username,firstName,lastName from Librarian";
        ArrayList<Librarian> librarians = new ArrayList<>();
        ResultSet resultSet;
        try {
            resultSet = statement.executeQuery(query);
            Librarian librarian;
            while (resultSet.next()) {
                librarian = new Librarian();
                librarian.firstName = resultSet.getString("firstName");
                librarian.username = resultSet.getString("username");
                librarian.lastName = resultSet.getString("lastName");
                librarians.add(librarian);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return librarians;
    }

    //TODO:Check the functionality
    public Librarian deleteLibrarian(String username) {

        String query = "delete from Librarian where 'username' =" + username + ";";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this;
    }

    //TODO : To check the function to its functionality
    public void modifyLibrarian(String username, String firstName, String lastName) {


        String query = "UPDATE Librarian set  firstName = '" + firstName + "' ,   lastName = '" + lastName + "' where username = '" + username + "';";

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IOError(new Throwable());
        }
    }


}
