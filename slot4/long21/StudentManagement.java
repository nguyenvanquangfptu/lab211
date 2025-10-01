/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot4.long21;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author xuan1
 */
public class StudentManagement {

    List<Student> studentList = new ArrayList<>();

    public boolean addStudent(Student student) {
        // kiểm tra trùng ID
        for (Student s : studentList) {
            if (s.getId().equals(student.getId())) {
                return false; // không thêm nếu trùng ID
            }
        }
        return studentList.add(student); // thêm bình thường
    }

    public void showStudent() {
        for (Student student : studentList) {
            System.out.println(student.toString());
        }
    }

    public void showStudent(List<Student> list) {
        for (Student student : list) {
            System.out.println(student.toString());
        }
    }

    public boolean isEmpty() {
        return studentList.isEmpty();
    }

    public Student findById(String id) {
        for (Student s : studentList) {
            if (s.getId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null; // không tìm thấy
    }

    public void deleteStudent(String id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                studentList.remove(student);
            }
        }
    }

    public void updateStudent(String id, String newname, String newsemester, String newcourse) {
        for (Student student : studentList) {
            if (student.getId().equalsIgnoreCase(id)) {
                student.setName(newname);
                student.setSemester(newsemester);
                student.setCourse(newcourse);
            }
        }
    }

    public void sortStudent(List<Student> list) {
        list.sort(Comparator.comparing(Student::getName));
        showStudent();
    }

    public List<Student> findStudentsByName(String name) {
        List<Student> result = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getName().equalsIgnoreCase(name)) {
                result.add(student);
            }
        }
        return result;
    }

    public void reportStudent() {
        Map<String, Integer> report = new HashMap<>();
        for (Student student : studentList) {
            String key = student.getId() + "|" + student.getSemester() + "|" + student.getCourse();
            report.put(key, report.getOrDefault(key, 0) + 1);
        }
        for (Map.Entry<String, Integer> student : report.entrySet()) {
            System.out.println(student.getKey() + "|" + student.getValue());

        }
    }
}
