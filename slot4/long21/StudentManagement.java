/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot4.long21;

import com.mycompany.lab211.Utils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HP
 */
public class StudentManagement {

    private ArrayList<Student> students = new ArrayList<>();

    public void addSudent() {
        String studentID;
        while (true) {
            studentID = Utils.readStudentId("Enter student id: ");
            boolean idExists = false;
            for (Student s : students) {
                if (studentID.equals(s.getStudentId())) {
                    idExists = true;
                    break;
                }
            }
            if (!idExists) {
                break;
            }
            System.out.println("| >> ID already exists, please try again.");
        }
        String studentName = Utils.readString("Enter student name: ");
        String semester = Utils.readCourseName("Enter semester: ");
        String courseName = Utils.readCourseName("Enter course name: ");
        Student s = new Student(studentID, studentName, semester, courseName);
        students.add(s);
        System.out.println("Student add succesfully.");

    }

    public void findAndSortByName() {
        String input = Utils.readString("Enter student name (or full name): ").trim().toLowerCase();

        // Nếu người dùng nhập cả full name, chỉ lấy từ cuối cùng
        String[] inputParts = input.split("\\s+");
        String keyword = inputParts[inputParts.length - 1]; // chỉ lấy last name

        List<Student> results = new ArrayList<>();

        for (Student s : students) {
            String[] parts = s.getStudentName().trim().toLowerCase().split("\\s+");
            String lastName = parts[parts.length - 1];

            if (lastName.equalsIgnoreCase(keyword)) {
                results.add(s);
            }
        }

        if (results.isEmpty()) {
            System.out.println(" No student found with name: " + input);
            return;
        }

        // Sắp xếp theo tên đầy đủ
        results.sort(Comparator.comparing(Student::getStudentName, String.CASE_INSENSITIVE_ORDER));
        display(results);

    }

    public boolean isEmpty() {
        return students.isEmpty();
    }

    public void updateOrDeleteStudent() {
        String sID = Utils.readStudentId("Enter id: ").trim();

        // Tìm student theo ID
        int idx = -1;
        for (int i = 0; i < students.size(); i++) {
            if (sID.equalsIgnoreCase(students.get(i).getStudentId())) {
                idx = i;
                break;
            }
        }

        if (idx == -1) {
            System.out.println(" Student with ID " + sID + " not found.");
            return;
        }

        Student s = students.get(idx);

        boolean isUpdate = Utils.readUpdateOrDelete("Do you want to update (Y) or delete (N) student?");
        if (isUpdate) {
            // UPDATE
            String newName = Utils.readString("Enter new student name: ");
            String newSemester = Utils.readSemester("Enter new semester: ");
            String newCourse = Utils.readCourseName("Enter new course name: ");

            s.setStudentName(newName);
            s.setSemester(newSemester);
            s.setCourseName(newCourse);

            System.out.println(" Update successfully.");
        } else {
            // DELETE (xóa an toàn bằng index)
            students.remove(idx);
            System.out.println(" Remove successfully.");
        }
    }

    public void createStudent() {
        for (int i = 0; i < 1; i++) {
            addSudent();
        }
        while (true) {
            boolean check = Utils.readYesNo("Do you want to continue (Y/N)? Choose Y to\n"
                    + "continue (a student one time), N to return main screen.");
            if (check) {
                addSudent();
            } else {
                System.out.println("Create students successfully.");
                return;
            }
        }
    }

    public void deleteStudent(String sudentID) {
        String id = Utils.readString("Enter student id to delete: ");
        boolean found = false;
        for (Student s : students) {
            if (s.getStudentId() == id) {
                students.remove(s);
                found = true;
                System.out.println("Delete successfully.");
                return;
            }
        }
        if (!found) {
            System.out.printf("Student with ID %s not found", id);
        }
    }

    public void displayStudentCourses() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        // Map to count courses for each student ID
        Map<String, Integer> courseCount = new HashMap<>();

        for (Student s : students) {
            String key = s.getStudentId();
            courseCount.put(key, courseCount.getOrDefault(key, 0) + 1);
        }

        System.out.println("===== STUDENT COURSES =====");
        for (Student s : students) {
            int total = courseCount.get(s.getStudentId());
            System.out.printf("Name: %-20s | Course: %-10s | Total Courses: %d%n",
                    s.getStudentName(), s.getCourseName(), total);
        }
    }

    public void display(List<Student> results) {
        if (results == null || results.isEmpty()) {
            System.out.println("✗ No students found.");
            return;
        }

        System.out.println("=====  RESULT =====");
        for (Student s : results) {
            System.out.printf("Name: %-20s | Semester: %-5s | Course: %s%n",
                    s.getStudentName(),
                    s.getSemester(),
                    s.getCourseName());
        }
    }

}
