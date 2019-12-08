package com.team.LMS.Model;

import java.sql.SQLException;

public class Admin extends Person {
    public Admin(String username, String password, String firstName, String lastName) throws SQLException {
        super(username, password, firstName, lastName);
    }

    @Override
    public boolean login(String username, String password) {
        String query = "SELECT * from Admin;";
        return exists(username, password, query);

    }



    @Override
    public void register() {}

    public void deleteStudent(){

    }

}
