package com.team.LMS.model;

import java.sql.SQLException;

public class Admin extends Person {

    public Admin() throws SQLException {
        super();
    }

    public Admin(String username, String password, String firstName, String lastName) throws SQLException {
        super(username, password, firstName, lastName);
    }

    @Override
    public boolean login(String username, String password) {
        String query = "SELECT * from Admin;";
        return exists(username, password, query);
    }

    public void register(String username, String password, String firstName, String lastName) {
        try {
            statement.executeUpdate("INSERT INTO Admin " +
                    "VALUES('" + username + "', '" + firstName + "','" + lastName + "','" + password + "');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}