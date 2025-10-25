/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot4.short105;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author HP
 */
public class PersonManagement {

    private List<Person> personList = new ArrayList<>();

    public boolean add(Person person) {
        return personList.add(person);      // thêm vào danh sách
    }

    public void showStudent() {
        int index = 1;
        for (Person p : personList) {
            if (p instanceof Student) {
                System.out.printf("%-3d | %s%n", index++, p.toString());
            }
        }
    }

    public boolean isEmpty() {
        return personList == null || personList.isEmpty();
    }

    public void showAll() {
        int index = 1;
        for (Person p : personList) {
            System.out.printf("%-3d | %s%n", index++, p.toString());
        }
    }

    public void showTeacher() {
        int index = 1;
        for (Person p : personList) {
            if (p instanceof Teacher) {
                System.out.printf("%-3d | %s%n", index++, p.toString());
            }
        }
    }

    public List<Person> findAndSortByName(String name) {

        // Nếu người dùng nhập cả full name, chỉ lấy từ cuối cùng
        String[] inputParts = name.split("\\s+");
        String keyword = inputParts[inputParts.length - 1]; // chỉ lấy last name

        List<Person> results = new ArrayList<>();

        for (Person s : personList) {
            String[] parts = s.getFullName().trim().toLowerCase().split("\\s+");
            String lastName = parts[parts.length - 1];

            if (lastName.equalsIgnoreCase(keyword)) {
                results.add(s);
            }
        }
        return results;

    }

    public boolean existsId(String id) {
        return personList.stream().anyMatch(p -> p.getId().equalsIgnoreCase(id));
    }

    public void display(List<Person> persons) {
        persons.sort(Comparator.comparing(Person::getFullName, String.CASE_INSENSITIVE_ORDER));
        for (Person s : persons) {
            System.out.println(s.toString());

        }
    }

}
