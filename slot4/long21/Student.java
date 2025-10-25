/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot4.long21;

/**
 *
 * @author HP
 */
public class Student {

    private String id;
    private String name;
    private String semester;
    private String course;

    public Student(String id, String name, String semester, String course) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.course = course;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

//    @Override
//    public String toString() {
//        return "Student{" + "id=" + id + ", name=" + name + ", semester=" + semester + ", course=" + course + '}';
//    }
    @Override
    public String toString() {
        return String.format("%-8s | %-20s | %-12s | %-20s",
                id, name, semester, course);
    }
}
