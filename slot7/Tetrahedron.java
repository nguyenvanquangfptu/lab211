/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot7;

/**
 *
 * @author HP
 */
// Hình tứ diện đều
public class Tetrahedron extends ThreeDimensionalShape {

    private final double a; // edge length

    public Tetrahedron(double edge) {
        super("Tetrahedron");
        if (edge <= 0) {
            throw new IllegalArgumentException("edge must be > 0");
        }
        this.a = edge;
    }

    // A = sqrt(3) * a^2
    @Override
    public double getArea() {
        return Math.sqrt(3.0) * a * a;
    }

    // V = (1/12) * sqrt(2) * a^3
    @Override
    public double getVolume() {
        return (1.0 / 12.0) * Math.sqrt(2.0) * a * a * a;
    }

    @Override
    public void print() {
        System.out.printf("Shape: %s, edge = %.2f, Surface Area = %.2f, Volume = %.2f%n",
                getName(), a, getArea(), getVolume());
    }

}
