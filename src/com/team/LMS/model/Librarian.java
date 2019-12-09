package com.team.LMS.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    //TODO:Check the functionality
    public Librarian deleteLibrarian(String username) throws SQLException {

        String query = "delete from Librarian where 'username' =" + username + ";";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this;
    }

    @Override
    public void register(String username, String password, String firstName, String lastName) {
        try {
            statement.executeUpdate("INSERT INTO Student " +
                    "VALUES ('" + username + "', '" + firstName + "','" + lastName + "','" + password + "');");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
