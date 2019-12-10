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
    public ArrayList<Map<String,Object>> viewLibrarians(){
        String query="select username,firstName,lastName from Librarian";
        ArrayList<Map<String,Object>> librarians=new ArrayList<>();
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(query);
            Map<String,Object> librarian=new HashMap<>();
            while (resultSet.next()) {

                librarian.put("firstName",resultSet.getString("firstName"));
                librarian.put("lastName",resultSet.getString("lastName"));
                librarian.put("fine",resultSet.getString("username"));
                librarians.add(librarian);
                librarian.clear();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return librarians;
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

    //TODO : To check the function to its functionality
    public void modifyLibrarian(int username, Map<String, Object> columnValue) {
        for (Map.Entry<String, Object> entry : columnValue.entrySet()) {


            String query = "UPDATE Librarian set " + entry.getKey() + "=" + entry.getValue() + " where username = " + username + ";";
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
