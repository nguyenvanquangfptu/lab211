/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot7;

/**
 *
 * @author HP
 */

// Hình cầu
public class Sphere extends ThreeDimensionalShape {

    private final double r;

    public Sphere(double radius) {
        super("Sphere");
        if (radius <= 0) {
            throw new IllegalArgumentException("radius must be > 0");
        }
        this.r = radius;
    }

    // A = 4 * pi * r^2
    @Override
    public double getArea() {
        return 4.0 * Math.PI * r * r;
    }

    // V = (4/3) * pi * r^3
    @Override
    public double getVolume() {
        return (4.0 / 3.0) * Math.PI * r * r * r;
    }

    @Override
    public String toString() {
        return super.toString() + "(r=" + r + ")";
    }

    @Override
    public void print() {
        System.out.printf("Shape: %s, r = %.2f, Surface Area = %.2f, Volume = %.2f%n",
                getName(), r, getArea(), getVolume());
    }

}
