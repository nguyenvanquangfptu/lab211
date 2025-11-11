/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot4.short105;

import com.mycompany.lab211.Menu;
import com.mycompany.lab211.Utils;
import java.util.List;

/**
 *
 * @author HP
 */
public class Main extends Menu {

    private static final String TITLE = "\n ======= Information Management ============";
    private static final String[] ITEMS = {"Teacher", "Student", "Person", "Exit"};

    public Main(String title, String[] mc) {
        super(title, mc);
    }
    PersonManagement p = new PersonManagement();

    @Override
    public void execute(int n) {
        switch (n) {
            case 1: {
                teacherManagement();
                break;
            }
            case 2: {
                studentManagement();
                break;
            }
            case 3: {
                personManagement();
                break;
            }
            case 4: {
                return;
            }

        }

    }

    public void teacherManagement() {
        String[] arr = {
            "Input",
            "Print",
            "Exit",};

        Menu searchMenu = new Menu("\n*******   Teacher Managementt   *******", arr) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1 -> {
                        addTeacher();
                    }
                    case 2 -> {
                        showTeacher();
                    }
                    case 3 -> {
                        return;

                    }

                }
            }
        };

        searchMenu.run();
    }

    public void studentManagement() {
        String[] arr = {
            "Input",
            "Print",
            "Exit",};

        Menu searchMenu = new Menu("\n*******   Student Managementt   *******", arr) {
            @Override
            public void execute(int n) {

                switch (n) {
                    case 1 -> {
                        addStudent();
                    }
                    case 2 -> {
                        showStudent();
                    }
                    case 3 -> {
                        return;

                    }

                }
            }
        };

        searchMenu.run();
    }

    public void personManagement() {
        String[] arr = {
            "Search",
            "Print",
            "Exit",};

        Menu searchMenu = new Menu("\n*******   Person Managementt   *******", arr) {
            @Override
            public void execute(int n) {

                switch (n) {
                    case 1 -> {
                        findAndSortByName();
                    }
                    case 2 -> {
                        showAll();
                    }
                    case 3 -> {
                        return;

                    }

                }
            }
        };

        searchMenu.run();
    }

    private void findAndSortByName() {
        String name = Utils.readString("Enter name( full name): ");
        List<Person> results = p.findAndSortByName(name);
        if (results.isEmpty()) {
            System.out.println("No person found with name: %s" + name);
        } else {
            p.display(results);
        }
    }

    public void addStudent() {
        while (true) {
            Person s = new Student();
            s.InputAll(); // InputAll() KHÔNG có tham số, theo đề

            if (p.existsId(s.getId())) {
                System.out.println(" This ID already exists. Please try again.");
                // lặp lại nhập
            } else {
                if (p.add(s)) {
                    System.out.println(" Student added successfully.");
                    return;
                } else {
                    System.out.println("Cannot add.");
                    return;
                }
            }
        }
    }

    public void addTeacher() {
        while (true) {
            Person s = new Teacher();
            s.InputAll(); // InputAll() KHÔNG có tham số, theo đề

            if (p.existsId(s.getId())) {
                System.out.println(" This ID already exists. Please try again.");
                // lặp lại nhập
            } else {
                if (p.add(s)) {
                    System.out.println(" Teacher added successfully.");
                    return;
                } else {
                    System.out.println("Cannot add.");
                    return;
                }
            }
        }
    }

    public void showStudent() {
        if (p.isEmpty()) {
            System.out.println("No data");
            return;
        }

        System.out.printf("%-3s | %-8s | %-20s | %-12s | %-6s | %-20s | %-12s | %-10s%n",
                "#", "ID", "Fullname", "Phone", "Birth", "Major", "Adm Year", "Eng Score");
        System.out.println("---------------------------------------------------------------------------------------------------");

        p.showStudent();
    }

    public void showAll() {
        if (p.isEmpty()) {
            System.out.println("No data");
            return;
        }
        // Header: 5 cột Person
        System.out.printf("%-3s | %-8s | %-20s | %-12s | %-6s | %-20s%n",
                "#", "ID", "Fullname", "Phone", "Birth", "Major");
        System.out.println("-------------------------------------------------------------------------------");
        p.showAll();
    }

    public void showTeacher() {
        if (p.isEmpty()) {
            System.out.println("No data");
            return;
        }
        System.out.printf("%-3s | %-8s | %-20s | %-12s | %-6s | %-20s | %-10s | %-10s | %-8s%n",
                "#", "ID", "Fullname", "Phone", "Birth", "Major", "Prof Year", "Contract", "Coeff");
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        p.showTeacher();
    }

    public static void main(String[] args) {
        Main app = new Main(TITLE, ITEMS);
        app.run();
    }
}
