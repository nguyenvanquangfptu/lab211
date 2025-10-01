/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot4.short105;

import com.mycompany.lab211.Utils;
import java.util.Date;
import java.util.List;

/**
 *
 * @author HP
 */
public class Teacher extends Person {

    private int proYear;
    private String typeContract;
    private float coeSalary;

    public Teacher(String id, String fullName, String phoneNumber, int dob, String major, int proYear, String typeContract, float coeSalary) {
        super(id, fullName, phoneNumber, dob, major);
        this.proYear = proYear;
        this.typeContract = typeContract;
        this.coeSalary = coeSalary;
    }

    public Teacher() {
        super();
        this.proYear = 0;
        this.typeContract = "";
        this.coeSalary = 0;
    }

    public int getProYear() {
        return proYear;
    }

    public void setProYear(int proYear) {
        this.proYear = proYear;
    }

    public String getTypeContract() {
        return typeContract;
    }

    public void setTypeContract(String typeContract) {
        this.typeContract = typeContract;
    }

    public float getCoeSalary() {
        return coeSalary;
    }

    public void setCoeSalary(float coeSalary) {
        this.coeSalary = coeSalary;
    }

    @Override
    public void InputAll() {
        super.InputAll();
        proYear = Utils.readPositiveInt("Enter profession year: ");
        typeContract = Utils.readString("Enter contract type: ");
        coeSalary = Utils.readFloat("Enter salary corfficient: ");
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | %-10d | %-10s | %-8.1f", proYear, typeContract, coeSalary);
    }

}
