/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot7;

/**
 *
 * @author HP
 */

// Hình lập phương
public class Cube extends ThreeDimensionalShape {

    private final double a;

    public Cube(double side) {
        super("Cube");
        if (side <= 0) {
            throw new IllegalArgumentException("side must be > 0");
        }
        this.a = side;
    }

    // A = 6a^2
    @Override
    public double getArea() {
        return 6.0 * a * a;
    }

    // V = a^3
    @Override
    public double getVolume() {
        return a * a * a;
    }

    @Override
    public String toString() {
        return super.toString() + "(a=" + a + ")";
    }

    @Override
    public void print() {
        System.out.printf("Shape: %s, side = %.2f, Surface Area = %.2f, Volume = %.2f%n",
                getName(), a, getArea(), getVolume());
    }

}
