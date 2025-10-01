/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot4.short105;

import com.mycompany.lab211.Utils;
import java.util.List;

/**
 *
 * @author HP
 */
public class Person {

    protected String id;
    protected String fullName, phoneNumber;
    protected int dob;
    protected String major;

    public Person(String id, String fullName, String phoneNumber, int dob, String major) {
        this.id = id;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
        this.major = major;
    }

    public Person() {
        this.id = "";
        this.fullName = "";
        this.phoneNumber = "";
        this.dob = 0;
        this.major = "";
    }

    public void InputAll() {
        // nhập ID và kiểm tra trùng
        id = Utils.readStudentId("Enter ID (6 digits): ");

        fullName = Utils.readName("Enter full name: ");
        phoneNumber = Utils.readPhoneNumber("Enter phone number: ");
        dob = Utils.readYearOfBirth("Enter year of birth: ");
        major = Utils.readMajor("Enter major: ");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getDob() {
        return dob;
    }

    public void setDob(int dob) {
        this.dob = dob;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

   @Override
public String toString() {
    return String.format("%-8s | %-20s | %-12s | %-6d | %-20s",
            id, fullName, phoneNumber, dob, major);
}


}
