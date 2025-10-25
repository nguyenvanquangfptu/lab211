/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot5.short12;

/**
 *
 * @author HP
 */
import java.util.*;

public class CourseManagement {
    private static List<Course> courses = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n*** Course Management ***");
            System.out.println("1. Add online course/ offline course");
            System.out.println("2. Update course");
            System.out.println("3. Delete course");
            System.out.println("4. Print all / online course / offline course");
            System.out.println("5. Search information base on course name");
            System.out.println("6. Exit");
            System.out.print("You choose: ");

            String choice = sc.nextLine();
            switch (choice) {
                case "1": addCourse(); break;
                case "2": updateCourse(); break;
                case "3": deleteCourse(); break;
                case "4": printCourse(); break;
                case "5": searchByName(); break;   // ✅ Sửa: tìm theo tên
                case "6":
                    System.out.println("BYE AND SEE YOU NEXT TIME");
                    return;
                default:
                    System.out.println("Data input is  invalid");
            }
        }
    }

    // ================== Add Course ==================
    private static void addCourse() {
        System.out.println("*** Add new course ***");
        while (true) {
            System.out.print("Online (O) or Offline (F): ");
            String type = sc.nextLine().trim();
            if (type.equalsIgnoreCase("O")) {
                OnlineCourse oc = new OnlineCourse();
                oc.inputAll(sc, courses);
                courses.add(oc);
                break;
            } else if (type.equalsIgnoreCase("F")) {
                OfflineCourse ofc = new OfflineCourse();
                ofc.inputAll(sc, courses);
                courses.add(ofc);
                break;
            } else {
                System.out.println("Data input is  invalid");
            }
        }
    }

    // ================== Find by ID ==================
    private static Course findByID(String id) {
        for (Course c : courses) {
            if (c.getCourseID().equalsIgnoreCase(id)) return c;
        }
        return null;
    }

    // ================== Update ==================
    private static void updateCourse() {
        System.out.println("*** Update course ***");
        Course c = searchByID();
        if (c == null) return;

        System.out.println("*** Updating ***");

        System.out.print("Course name: ");
        String name = sc.nextLine();
        if (!name.isEmpty()) c.setCourseName(name);

        System.out.print("Credits: ");
        String cr = sc.nextLine().trim();
        if (!cr.isEmpty()) {
            try {
                int val = Integer.parseInt(cr);
                if (val > 0) {
                    c.setCredits(val);
                } else {
                    System.out.println("Data input is  invalid");
                }
            } catch (NumberFormatException e) {
                System.out.println("Data input is  invalid");
            }
        }

        System.out.println("Updated successfully");
    }

    // ================== Delete ==================
    private static void deleteCourse() {
        System.out.println("*** Delete course ***");
        Course c = searchByID();
        if (c == null) return;
        courses.remove(c);
        System.out.println("Deleted successfully");
    }

    // ================== Print ==================
    private static void printCourse() {
        System.out.println("*** Print course ***");
        System.out.print("Do you want to print all (A), online course (O) or offline course (F): ");
        String type = sc.nextLine().trim();
        boolean printed = false;

        for (Course c : courses) {
            if (type.equalsIgnoreCase("A")) {
                System.out.println(c);
                printed = true;
            } else if (type.equalsIgnoreCase("O") && c instanceof OnlineCourse) {
                System.out.println(c);
                printed = true;
            } else if (type.equalsIgnoreCase("F") && c instanceof OfflineCourse) {
                System.out.println(c);
                printed = true;
            }
        }

        if (!printed && !(type.equalsIgnoreCase("A") || type.equalsIgnoreCase("O") || type.equalsIgnoreCase("F"))) {
            System.out.println("Data input is  invalid");
        }
    }

    // ================== Search by Name ==================
    private static void searchByName() {
        System.out.println("*** Searching ***");
        System.out.print("Course name: ");
        String keyword = sc.nextLine().trim().toLowerCase();
        boolean found = false;
        for (Course c : courses) {
            if (c.getCourseName().toLowerCase().contains(keyword)) {
                if (!found) System.out.println("*** Search results ***");
                System.out.println(c);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No data found");
        }
    }

    // ================== Search by ID (for update/delete) ==================
    private static Course searchByID() {
        while (true) {
            System.out.print("Course ID: ");
            String id = sc.nextLine();
            Course c = findByID(id);
            if (c == null) {
                System.out.print("No data found, do you want to find again? (Y/N): ");
                if (!sc.nextLine().equalsIgnoreCase("Y")) return null;
            } else return c;
        }
    }
}