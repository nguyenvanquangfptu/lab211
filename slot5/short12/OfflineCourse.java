/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot5.short12;

/**
 *
 * @author HP
 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class OfflineCourse extends Course {

    private LocalDate begin;
    private LocalDate end;
    private String campus;
    private String teacher;

    public OfflineCourse() {
        super();
        this.begin = LocalDate.now();
        this.end = LocalDate.now();
        this.campus = "";
        this.teacher = "";
    }

    public void inputAll(Scanner sc, List<Course> list) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("d/M/yyyy");

        // Course ID
        while (true) {
            System.out.print("Course ID: ");
            String id = sc.nextLine().trim();
            if (id.isEmpty() || isDuplicateID(list, id)) {
                System.out.println("Data input is  invalid");
            } else {
                this.courseID = id;
                break;
            }
        }

        // Course name
        while (true) {
            System.out.print("Course name: ");
            String name = sc.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Data input is  invalid");
            } else {
                this.courseName = name;
                break;
            }
        }

        // Credits
        while (true) {
            try {
                System.out.print("Credits: ");
                int cr = Integer.parseInt(sc.nextLine().trim());
                if (cr <= 0) {
                    System.out.println("Data input is  invalid");
                } else {
                    this.credits = cr;
                    break;
                }
            } catch (Exception e) {
                System.out.println("Data input is  invalid");
            }
        }

        // Begin date
        while (true) {
            try {
                System.out.print("Begin: ");
                LocalDate b = LocalDate.parse(sc.nextLine().trim(), df);
                if (b.isBefore(LocalDate.now())) {
                    System.out.println("Data input is  invalid");
                } else {
                    this.begin = b;
                    break;
                }
            } catch (Exception e) {
                System.out.println("Data input is  invalid");
            }
        }

        // End date
        while (true) {
            try {
                System.out.print("End: ");
                LocalDate e = LocalDate.parse(sc.nextLine().trim(), df);
                if (e.isBefore(begin)) {
                    System.out.println("Data input is  invalid, end must be after begin");
                } else {
                    this.end = e;
                    break;
                }
            } catch (Exception ex) {
                System.out.println("Data input is  invalid");
            }
        }

        // Campus
        while (true) {
            System.out.print("Campus: ");
            String cp = sc.nextLine().trim();
            if (cp.isEmpty()) {
                System.out.println("Data input is  invalid");
            } else {
                this.campus = cp;
                break;
            }
        }

        System.out.print("Teacher name: ");
        this.teacher = sc.nextLine();
    }

    private boolean isDuplicateID(List<Course> list, String id) {
        for (Course c : list) {
            if (c.getCourseID().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("d/M/yyyy");
        return super.toString() + "-" + begin.format(df) + "-" + end.format(df) + "-" + campus + "-" + teacher;
    }
}
