/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot4.long21;


import java.sql.Connection;
import java.sql.DriverManager;

public class DBIConnect {

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
