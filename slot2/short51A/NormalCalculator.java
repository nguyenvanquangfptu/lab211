/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot2.short51A;

/**
 *
 * @author HP
 */
public class NormalCalculator {
     private double memory;

    public NormalCalculator(double memory) {
        this.memory = memory;
    }

    public double getMemory() {
        return memory;
    }

    public void setMemory(double memory) {
        this.memory = memory;
    }

    public void calculator(String op, double num) {
        switch (op) {
            case "+":
                memory += num;
                break;
            case "-":
                memory -= num;
                break;
            case "*":
                memory *= num;
                break;
            case "/":
                if (num == 0) {
                    System.out.println("Error. Division by zero!");
                } else {
                    memory /= num;
                }
                break;
            case "^":
                memory = Math.pow(memory, num);
                break;
            default:
                System.out.println("operator is valid.");
                break;
        }
    }
}
