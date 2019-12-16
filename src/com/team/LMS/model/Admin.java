package com.team.LMS.model;

import java.sql.SQLException;

public class Admin extends Person {

    public Admin() throws SQLException {
        super();
    }


    @Override
    public boolean login(String username, String password) {
        String query = "SELECT * from Admin;";
        return exists(username, password, query);
    }


}