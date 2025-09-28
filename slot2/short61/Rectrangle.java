/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot2.short61;

/**
 *
 * @author HP
 */
public class Rectrangle extends Shape {

    private double width, length;

    public Rectrangle() {
    }

    public Rectrangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getPerimeter() {
        return (width + length) / 2;
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public void printResult() {
        System.out.println("----- Rectangle -----");
        System.out.printf("Width: %.1f\n", getWidth());
        System.out.printf("Length: %.1f\n", getLength());
        System.out.printf("Area: %.2f\n", getArea());
        System.out.printf("Perimeter: %.2f\n", getPerimeter());
    }

}
