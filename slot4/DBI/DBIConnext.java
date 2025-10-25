package com.mycompany.lab211.slot4.DBI;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBIConnext {

    private static final String URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=students;encrypt=true;trustServerCertificate=true;";
    private static final String USER = "sa";  // đổi thành user của bạn
    private static final String PASS = "quang"; // đổi password của bạn

    public static Connection getConnection() {
        Connection conn = null;
        try {
            // JDBC 4+ không bắt buộc Class.forName, nhưng thêm cũng được
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
