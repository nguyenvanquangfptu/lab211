/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot7;

/**
 *
 * @author HP
 */
public class Triangle extends TwoDimensionalShape {

    private final double base, height;

    public Triangle(double base, double height) {
        super("Triangle");
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException("base/height must be > 0");
        }
        this.base = base;
        this.height = height;
    }

    @Override
    public double getArea() {
        return 0.5 * base * height;
    }

    @Override
    public String toString() {
        return super.toString() + "(b=" + base + ", h=" + height + ")";
    }

    @Override
    public void print() {
        System.out.printf("Shape: %s, base = %.2f, height = %.2f, Area = %.2f%n",
                getName(), base, height, getArea());
    }

}
