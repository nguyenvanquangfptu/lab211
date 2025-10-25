/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot7;

/**
 *
 * @author HP
 */
public class Square extends TwoDimensionalShape {

    private final double a;

    public Square(double side) {
        super("Square");
        if (side <= 0) {
            throw new IllegalArgumentException("side must be > 0");
        }
        this.a = side;
    }

    @Override
    public double getArea() {
        return a * a;
    }

    @Override
    public String toString() {
        return super.toString() + "(a=" + a + ")";
    }

    @Override
    public void print() {
        System.out.printf("Shape: %s, side = %.2f, Area = %.2f%n",
                getName(), a, getArea());
    }

}
