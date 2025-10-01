/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot2.short51;

/**
 *
 * @author HP
 */
public class BMICalculator {
    private double weight; // kg
    private double height; // m

    // Constructor có tham số
    public BMICalculator(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    // Getter & Setter
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // Hàm tính BMI
    public double calculateBMI() {
        double h = height / 100.0;
        if (h <= 0) {
            throw new IllegalArgumentException("Height must be greater than 0");
        }
        return weight / (h * h);
    }

    // Hàm phân loại BMI theo WHO
    public String getBMICategory() {
        double bmi = calculateBMI();
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 24.9) {
            return "Normal";
        } else if (bmi < 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}
