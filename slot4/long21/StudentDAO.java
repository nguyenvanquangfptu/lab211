/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot4.long21;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.mycompany.lab211.slot4.DBI.DBIConnext;
import java.sql.*;
import java.util.*;

/**
 *
 * @author HP
 */
public class StudentDAO {

    public boolean addStudent(Student student) {
        String sql = "INSERT INTO Student (id,name, semester, course) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBIConnext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, student.getId());
            ps.setString(2, student.getName());
            ps.setString(3, student.getSemester());
            ps.setString(4, student.getCourse());

            return ps.executeUpdate() > 0;

        } catch (SQLServerException e) {
            if (e.getErrorCode() == 2627 || e.getErrorCode() == 2601) {
                System.out.println("⚠️ ID đã tồn tại (trùng khóa chính).");
            } else {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM Student";
        try (Connection conn = DBIConnext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Student s = new Student(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("semester"),
                        rs.getString("course")
                );
                list.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean deleteStudent(String id) {
        String sql = "DELETE FROM Student WHERE id = ?";
        try (Connection conn = DBIConnext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // ✅ Cập nhật thông tin sinh viên
    public boolean updateStudent(Student student) {
        String sql = "UPDATE Student SET name=?, semester=?, course=? WHERE id=?";
        try (Connection conn = DBIConnext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, student.getName());
            ps.setString(2, student.getSemester());
            ps.setString(3, student.getCourse());
            ps.setString(4, student.getId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // StudentDAO.java
    public List<Student> getAllStudentsSortedByName() {
        String sql = "SELECT id,name, semester, course "
                + "FROM Student "
                + "ORDER BY name, id"; // phụ sắp theo ID để ổn định
        List<Student> list = new ArrayList<>();
        try (Connection conn = DBIConnext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Student(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("semester"),
                        rs.getString("course")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
// StudentDAO.java

    public List<Student> findByLastName(String fullInput) {
        // Lấy từ cuối cùng người dùng nhập
        String[] parts = fullInput.trim().split("\\s+");
        String keyword = parts[parts.length - 1].toLowerCase();

        String sql
                = "SELECT id, name, semester, course "
                + "FROM Student "
                + "WHERE LOWER(LTRIM(RTRIM(RIGHT(name, CHARINDEX(' ', REVERSE(name) + ' ') - 1)))) = ? "
                + "ORDER BY name, id";

        List<Student> list = new ArrayList<>();
        try (Connection conn = DBIConnext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, keyword);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(new Student(
                            rs.getString("id"),
                            rs.getString("name"),
                            rs.getString("semester"),
                            rs.getString("course")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
// có thể đặt inner-class trong StudentDAO hoặc tách file riêng

    public static class ReportRow {

        public final String id, semester, course;
        public final int total;

        public ReportRow(String id, String semester, String course, int total) {
            this.id = id;
            this.semester = semester;
            this.course = course;
            this.total = total;
        }
    }

// StudentDAO.java
    public List<ReportRow> getReport_IdSemesterCourse() {
        String sql
                = "SELECT id, semester, course, COUNT(*) AS Total "
                + "FROM Student "
                + "GROUP BY id, semester, course "
                + "ORDER BY id, semester, course";

        List<ReportRow> rows = new ArrayList<>();
        try (Connection conn = DBIConnext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                rows.add(new ReportRow(
                        rs.getString("id"),
                        rs.getString("semester"),
                        rs.getString("course"),
                        rs.getInt("Total")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

}
