/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot5.short12;

/**
 *
 * @author HP
 */
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Nguyen Phuong
 */
public class OnlineCourse extends Course {

    private String platform;
    private String instructors;
    private String note;

    public OnlineCourse() {
        super();
        this.platform = "";
        this.instructors = "";
        this.note = "";
    }

//    @Override
    public void inputAll(Scanner sc, List<Course> list) {
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

        // Platform
        while (true) {
            System.out.print("Platform: ");
            String platform = sc.nextLine().trim();
            if (platform.isEmpty()) {
                System.out.println("Data input is  invalid");
            } else {
                this.platform = platform;
                break;
            }
        }

        System.out.print("Instructors: ");
        this.instructors = sc.nextLine();

        // Note
        while (true) {
            System.out.print("Note: ");
            String note = sc.nextLine().trim();
            if (note.isEmpty()) {
                System.out.println("Data input is  invalid");
            } else {
                this.note = note;
                break;
            }
        }
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
        return super.toString() + "-" + platform + "-" + instructors + "-" + note;
    }

}
