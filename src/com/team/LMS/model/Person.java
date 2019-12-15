package com.team.LMS.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Person extends LMS {
    String username;
    String password;
    String firstName;
    String lastName;

    public Person() throws SQLException {
        super();
    }

    public Person(String username, String password, String firstName, String lastName) throws java.sql.SQLException {
        super.createTable();
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public abstract boolean login(String username, String password);


    public boolean exists(String username, String password, String query) {
        try {

            ResultSet resultSet = statement.executeQuery(query);

            String login = "";
            String pass = "";
            while (resultSet.next()) {
                login = resultSet.getString("username");
                pass = resultSet.getString("password");
                if (login.equalsIgnoreCase(username)) {
                    if (pass.equals(password)) {
                        return true;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
