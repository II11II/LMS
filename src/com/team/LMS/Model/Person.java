package com.team.LMS.Model;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Person extends LMS {
    String username;
    String password;
    String firstName;
    String lastName;


    public Person(String username, String password, String firstName, String lastName) throws java.sql.SQLException {
        super.createTable();
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public abstract boolean login(String username, String password);

    public abstract void register();

    public boolean exists(String username, String password, String query) {
        try {

            ResultSet resultSet = statement.executeQuery(query);

            // iterate through the java resultset
            String login = "";
            String pass = "";
            while (resultSet.next()) {
                login = resultSet.getString("username");
                pass = resultSet.getString("password");
            }
            if (login.equalsIgnoreCase(username)) {
                if (pass.equals(password)) {
                    return true;
                }
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return false;
    }


}
