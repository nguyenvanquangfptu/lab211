/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot4.long21;

import com.mycompany.lab211.Utils;
import java.util.List;

/**
 *
 * @author HP
 */
public class Main extends Menu {

    StudentManagement students = new StudentManagement();
    private static final String TITLE = "\n ======= Student Management ============";
    private static final String[] ITEMS = {"Create", "Find and Sort", "Update/ Delete", "Report", "Exit"};

    public Main(String title, String[] mc) {
        super(title, mc);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1: {
                createStudents();
                break;
            }
            case 2: {
                findAndSort();
                break;
            }
            case 3: {
                updateOrDeleteStudent();
                break;
            }
            case 4: {
                reportStduent();
                break;
            }
            case 5: {
                return;
            }
        }
    }

    private void createStudents() {
        int i = 1;
        for (; i < 4; i++) {
            System.out.printf("Enter Student %d\n", i);
            addSudent();

        }
        while (true) {
            boolean check = Utils.readYesNo("Do you want to continue (Y/N)? Choose Y to\n"
                    + "continue (a student one time), N to return main screen.");
            if (check) {
                System.out.printf("Enter Student %d", i++);
                addSudent();
            } else {
                System.out.println("Create students successfully.");
                return;
            }
        }
    }

    private void addSudent() {
        String studentID = Utils.readStudentId("Enter student id: ");
        String studentName = Utils.readString("Enter student name: ");
        String semester = Utils.readSemester("Enter semester: ");
        String courseName = Utils.readCourseName("Enter course name: ");
        Student s = new Student(studentID, studentName, semester, courseName);
        if (students.addStudent(s)) {
            System.out.println("Student add succesfully. ");
        } else {
            System.out.println("Cannot add. ");
        }
    }

    private void updateOrDeleteStudent() {
        String sID = Utils.readStudentId("Enter id: ").trim();
        if (students.isEmpty()) {
            System.out.println("No student to excute.");
            return;
        }
        Student exist = students.findById(sID);
        if (exist == null) {
            System.out.println("No found student with ID: " + sID);
            return; // thoát hàm, không update/delete nữa
        }
        boolean isUpdate = Utils.readUpdateOrDelete("Do you want to update (Y) or delete (N) student?");
        if (isUpdate) {
            // UPDATE
            String newName = Utils.readString("Enter new student name: ");
            String newSemester = Utils.readSemester("Enter new semester: ");
            String newCourse = Utils.readCourseName("Enter new course name: ");
            students.updateStudent(sID, newName, newSemester, newCourse);

            System.out.println(" Update successfully.");
        } else {
            // DELETE (xóa an toàn bằng index)
            students.deleteStudent(sID);
            System.out.println(" Remove successfully.");
        }
    }

    private void reportStduent() {
        if (students.isEmpty()) {
            System.out.println("No students to report. ");
        } else {
            students.reportStudent();
        }
    }

    private void findAndSort() {
        String input = Utils.readString("Enter student name (or full name): ").trim().toLowerCase();
        if (students.isEmpty()) {
            System.out.println("No student to excute.");
            return;
        } 
        List<Student> result = students.findStudentsByName(input);  
        if(result.isEmpty()){
            System.out.printf("No student found with name %s", input);
            return;
        }
        students.sortStudent(result);
        students.showStudent(result);
    }

    public static void main(String[] args) {
        Main app = new Main(TITLE, ITEMS);
        app.run();
    }
}
