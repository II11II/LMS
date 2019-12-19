package com.team.LMS.model;

import java.sql.*;

public abstract class LMS {
    final static String SERVER_NAME = "remotemysql.com:3306";
    final static String TABLE = "ULEVcODlsB";
    final static String SSL = "?autoReconnect=true&useSSL=false";
    final static String driverName = "com.mysql.jdbc.Driver";
    final static String username = "ULEVcODlsB";
    final static String password = "WCO6fjZB8G";
    final static String url = "jdbc:mysql://" + SERVER_NAME + "/" + TABLE + SSL;

    Connection connection =DriverManager.getConnection(url, username, password);
    Statement statement = connection.createStatement();

    protected LMS() throws SQLException {

    }



}
