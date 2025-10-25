/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot7;

/**
 *
 * @author HP
 */
public class Circle extends TwoDimensionalShape {

    private final double r;

    public Circle(double radius) {
        super("Circle");
        if (radius <= 0) {
            throw new IllegalArgumentException("radius must be > 0");
        }
        this.r = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * r * r;
    }

    @Override
    public String toString() {
        return super.toString() + "(r=" + r + ")";
    }
         @Override
    public void print() {
        System.out.printf("Shape: %s, r = %.2f, Area = %.2f%n",
                getName(), r, getArea());
    }
    }

