/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot4.short105;

import com.mycompany.lab211.Utils;


/**
 *
 * @author HP
 */
public class Student extends Person {

    private int admYear;
    private int engScore;

    public Student(String id, String fullName, String phoneNumber, int dob, String major, int admYear, int engScore) {
        super(id, fullName, phoneNumber, dob, major);
        this.admYear = admYear;
        this.engScore = engScore;
    }

    public Student() {
        super();
        this.admYear = 0;
        this.engScore = 0;
    }

    @Override
    public void InputAll() {
        super.InputAll();
        admYear = Utils.readPositiveInt("Enter admission year: ");
        engScore = Utils.readPositiveInt("Enter entrance English score: ");
    }

    public int getAdmYear() {
        return admYear;
    }

    public void setAdmYear(int admYear) {
        this.admYear = admYear;
    }

    public int getEngScore() {
        return engScore;
    }

    public void setEngScore(int engScore) {
        this.engScore = engScore;
    }

@Override
public String toString() {
    return super.toString() + String.format(" | %-12d | %-10d", admYear, engScore);
}


    
}
