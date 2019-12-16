package com.team.LMS.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OverdueStudent extends Student {

    public OverdueStudent() throws SQLException {
    }


    public boolean isOverdue(String username) throws SQLException {
        String query = "Select returnDate , periodDate from BookIssue where username = '" + username + "';";
        ResultSet resultSet = connection.createStatement().executeQuery(query);
        while (resultSet.next()) {
            String returnDate = resultSet.getString("returnDate").replace("-", "");
            String periodDate = resultSet.getString("periodDate").replace("-", "");
            int returnTime=Integer.parseInt(returnDate);
            int periodTime = Integer.parseInt(periodDate);

            System.out.println(returnDate);
            System.out.println(periodDate);
            if (returnTime<periodTime) {
                return true;
            }

        }
        return false;
    }

}
