package com.team.LMS.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OverdueStudent extends Student {

    public OverdueStudent() throws SQLException {
    }



    public  boolean isOverdue(String username) throws SQLException {
        String query = "Select returnDate , periodDate from BookIssue where username = '" + username + "';";
        ResultSet resultSet = connection.createStatement().executeQuery(query);
        while (resultSet.next()) {
            String returnDate = resultSet.getString("returnDate").replace("-", "");
            String periodDate = resultSet.getString("periodDate").replace("-", "");
            int returnTime=Integer.parseInt(returnDate);
            int periodTime = Integer.parseInt(periodDate);
            if (returnTime>periodTime) {
                return true;
            }

        }
        return false;
    }
//NEED to delete
//    public ArrayList<OverdueStudent> overdueStudents() throws SQLException {
//        OverdueStudent student = new OverdueStudent();
//        ArrayList<OverdueStudent> overdueStudents = new ArrayList<>();
//        Student student1 = new Student();
//        BookIssue bookIssue = new BookIssue();
//        OverdueStudent returnStudents;
//        for (BookIssue issue : bookIssue.bookIssues()) {
//            if (student.isOverdue(issue.getUsername())) {
//                returnStudents = new OverdueStudent();
//                returnStudents.username = issue.getUsername();
//                for (Student s : student1.getStudents()) {
//                    if (s.getUsername().equals(issue.getUsername())) {
//                        returnStudents.lastName = s.getLastName();
//                        returnStudents.firstName = s.getFirstName();
//                    }
//                }
//                overdueStudents.add(returnStudents);
//
//            }
//        }
//        return overdueStudents;
//    }
    public ArrayList<Student> overdueStudent() throws SQLException {
        OverdueStudent student = new OverdueStudent();
        ArrayList<Student> overdueStudents = new ArrayList<>();
        Student student1 = new Student();
        BookIssue bookIssue = new BookIssue();
        Student returnStudents;
        for (BookIssue issue : bookIssue.bookIssues()) {
            if (student.isOverdue(issue.getUsername())) {
                returnStudents = new Student();
                returnStudents.username = issue.getUsername();
                for (Student s : student1.getStudents()) {
                    if (s.getUsername().equals(issue.getUsername())) {
                        returnStudents.lastName = s.getLastName();
                        returnStudents.firstName = s.getFirstName();
                    }
                }
                overdueStudents.add(returnStudents);

            }
        }
        return overdueStudents;
    }
}
