package com.mycompany.lab211.slot4.DBI;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class test {
    public static void main(String[] args) {
        try (Connection conn = DBIConnext.getConnection()) {
            if (conn != null) {
                System.out.println("Đang đọc dữ liệu từ bảng Student...");
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM Student");
                while (rs.next()) {
                    System.out.println(
                        rs.getString("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("semester") + " | " +
                        rs.getString("course")
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("file.encoding = " + System.getProperty("file.encoding"));
System.out.println("defaultCharset = " + java.nio.charset.Charset.defaultCharset());

    }
}
