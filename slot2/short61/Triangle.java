/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot2.short61;

/**
 *
 * @author HP
 */
public class Triangle extends Shape {

    private double x, y, z;

    public Triangle(double x, double y, double z) {
        if (x + y <= z || x + z <= y || y + z <= x) {
            throw new IllegalArgumentException("The sides do not form a valid triangle.");
        }
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Triangle() {
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public double getPerimeter() {
        return x + y + z;
    }

    @Override
    public double getArea() {
        double p = getPerimeter() / 2.0;
        return Math.sqrt(p * (p - x) * (p - y) * (p - z));
    }

    @Override

    public void printResult() {
        System.out.println("--- Triangle ---");
        System.out.printf("Side A: %.1f\n", getX());
        System.out.printf("Side B: %.1f\n", getY());
        System.out.printf("Side C: %.1f\n", getZ());

        System.out.printf("Area: %.2f\n", getArea());
        System.out.printf("Perimeter: %.2f\n", getPerimeter());
    }

}
