/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot2.short61;

/**
 *
 * @author HP
 */
public class Circle extends Shape{
  
    
     private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle() {
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
     
    @Override
    public double getPerimeter() {
        return Math.PI * ( radius + radius);
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void printResult() {
         System.out.println("----- Circle -----");
        System.out.printf("Radius: %.1f\n", getRadius());
        System.out.printf("Area: %.10f\n", getArea());
        System.out.printf("Perimeter: %.10f\n", getPerimeter());
    }
    
}
