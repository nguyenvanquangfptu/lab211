/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot4.long21;

/**
 *
 * @author HP
 */
public class Main extends Menu {

    private static final String TITLE = "\n ======= Student Management ============";
    private static final String[] ITEMS = {"Create", "Find and Sort", "Update/ Delete", "Report", "Exit"};

    public Main(String title, String[] mc) {
        super(title, mc);
    }

    StudentManagement std = new StudentManagement();

    @Override
    public void execute(int n) {
        switch (n) {
            case 1: {
                std.createStudent();
                break;
            }
            case 2: {
                if (std.isEmpty()) {
                    System.out.println(" No students found. Please create student first.");
                } else {
                    std.findAndSortByName();
                }
                break;
            }
            case 3: {
                if (std.isEmpty()) {
                    System.out.println(" No students found. Please create student first.");
                } else {
                    std.updateOrDeleteStudent();
                }
                break;
            }
            case 4: {
                if (std.isEmpty()) {
                    System.out.println(" No students found. Please create student first.");
                } else {
                    std.displayStudentCourses();
                }
                break;
            }
            case 5: {
                return;
            }
        }
    }

    public static void main(String[] args) {
        Main m = new Main(TITLE, ITEMS);
        m.run();
    }
}
