/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot4.short105;

import com.mycompany.lab211.Utils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author HP
 */
public class PersonManagement {

    List<Person> person = new ArrayList<>();

    public void addStudents() {

        String id = Utils.readStudentId("Enter id:");
        String name = Utils.readString("Enter full name: ");
        String phone = Utils.readPhoneNumber("Enter phone number: ");
        int dob = Utils.readYearOfBirth("Enter year of birthday: ");
        String major = Utils.readString("Enter major: ");
        int admYear = Utils.readPositiveInt("Enter admission year: ");
        int Engscore = Utils.readPositiveInt("Enter entrance English score: ");
        Person s = new Student(id, name, phone, dob, major, admYear, Engscore);
        person.add(s);

    }

    public void addTeachers() {

        String id = Utils.readStudentId("Enter id:");
        String name = Utils.readString("Enter full name: ");
        String phone = Utils.readPhoneNumber("Enter phone number: ");
        int dob = Utils.readYearOfBirth("Enter year of birthday: ");
        String major = Utils.readString("Enter major: ");
        int proYear = Utils.readPositiveInt("Enter profession year: ");
        String contractType = Utils.readString("Enter contract type: ");
        float coeSalary = Utils.readFloat("Enter salary corfficient: ");
        Person t = new Teacher(id, name, phone, dob, major, proYear, contractType, coeSalary);
        person.add(t);

    }

    public void printPeople(List<Person> people) {
        if (people == null || people.isEmpty()) {
            System.out.println("No people to print.");
        } else {
            System.out.println("# - ID - Fullname - Phone number - Year of birth - Major - Year of adm - English score");
            for (int i = 0; i < people.size(); i++) {
                Person p = people.get(i); // lấy ra person thứ i

                if (p instanceof Student) {
                    Student st = (Student) p; // ép kiểu
                    System.out.printf("\n%d - Student - %s - %s - %s - %d - %s - %d - %d",
                            i + 1,
                            st.getId(),
                            st.getFullName(),
                            st.getPhoneNumber(),
                            st.getDob(),
                            st.getMajor(),
                            st.getAdmYear(),
                            st.getEngScore()
                    );

                }
            }
        }
    }
// public void printAll() {
//        if (person.isEmpty()) {
//            System.out.println("No people to print.");
//            return;
//        }
//
//        System.out.println("===== PEOPLE LIST =====");
//        System.out.println("# - Type - ID - Full name - Phone - Year of birth - Major - Extra");
//
//        int idx = 1;
//        for (Person p : person) {
//            if (p instanceof Student st) {
//                // Extra: AdmissionYear & EnglishScore
//                System.out.printf("%d - Student - %s - %s - %s - %d - %s - AdmYear: %d, EngScore: %d%n",
//                        idx++, st.getId(), st.getFullName(), st.getPhoneNumber(),
//                        st.getDob(), st.getMajor(), st.getAdmYear(), st.getEngScore());
//            } else if (p instanceof Teacher tc) {
//                // Extra: ProfessionYear, ContractType, CoefSalary
//                System.out.printf("%d - Teacher - %s - %s - %s - %d - %s - Years: %d, Contract: %s, Coef: %.2f%n",
//                        idx++, tc.getId(), tc.getFullName(), tc.getPhoneNumber(),
//                        tc.getDob(), tc.getMajor(), tc.getProYear(), tc.getTypeContract(), tc.getCoeSalary());
//            } else {
//                // Phòng trường hợp sau này có subclass khác
//                System.out.printf("%d - Person  - %s - %s - %s - %d - %s - %s%n",
//                        idx++, p.getId(), p.getFullName(), p.getPhoneNumber(),
//                        p.getDob(), p.getMajor(), "-");
//            }
//        }
//    }

    public void printTeachers(List<Person> person) {
        if (person == null || person.isEmpty()) {
            System.out.println("No teacher to print.");
        } else {
            System.out.println("# - ID - Fullname - Phone number - Year of birth - Major - Year of profession - Contract type - Salary coefficient");
            for (int i = 0; i < person.size(); i++) {
                Person s = person.get(i); // lấy ra student thứ i
                if (s instanceof Teacher) {
                    Teacher st = (Teacher) s;
                    System.out.printf("\n%d - %s - %s - %s - %d - %s - %d - %s - %.2f",
                            i + 1,
                            st.getId(),
                            st.getFullName(),
                            st.getPhoneNumber(),
                            st.getDob(),
                            st.getMajor(),
                            st.getProYear(),
                            st.getTypeContract(),
                            st.getCoeSalary()
                    );
                }
            }
        }
    }

    public void findAndSortByName() {
        String input = Utils.readString("Enter name (or full name): ").trim().toLowerCase();

        // Nếu người dùng nhập cả full name, chỉ lấy từ cuối cùng
        String[] inputParts = input.split("\\s+");
        String keyword = inputParts[inputParts.length - 1]; // chỉ lấy last name

        List<Person> results = new ArrayList<>();

        for (Person s : person) {
            String[] parts = s.getFullName().trim().toLowerCase().split("\\s+");
            String lastName = parts[parts.length - 1];

            if (lastName.equalsIgnoreCase(keyword)) {
                results.add(s);
            }
        }

        if (results.isEmpty()) {
            System.out.println(" No student found with name: " + input);
            return;
        }
        display(results);

    }

    public void display(List<Person> person) {
        person.sort(Comparator.comparing(Person::getFullName, String.CASE_INSENSITIVE_ORDER));
        if (person == null || person.isEmpty()) {
            System.out.println("✗ No students found.");
            return;
        }

        System.out.println("=====  RESULT =====");
        System.out.println("# - ID - Fullname - Phone number - Year of birth - Major");
        for (int i = 0; i < person.size(); i++) {
            Person s = person.get(i); // lấy ra student thứ i

            System.out.printf("\n%d - %s - %s - %s - %d - %s ",
                    i + 1,
                    s.getId(),
                    s.getFullName(),
                    s.getPhoneNumber(),
                    s.getDob(),
                    s.getMajor()
            );

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
                        addTeachers();
                    }
                    case 2 -> {
                        printTeachers(person);
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
                        addStudents();
                    }
                    case 2 -> {
                        printPeople(person);
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
                        display();
                    }
                    case 3 -> {
                        return;

                    }

                }
            }
        };

        searchMenu.run();
    }
}
