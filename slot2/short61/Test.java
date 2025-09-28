/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot2.short61;

import com.mycompany.lab211.Utils;

/**
 *
 * @author HP
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("=== Calculator Shape Program ===");
         
        double width = Utils.readDouble("Please input the side width of Rectangle");
        double length = Utils.readDouble("Please input the side length of Rectangle");
        Shape rec = new Rectrangle(width, length);
        double radius = Utils.readDouble("Please input the radius of Circle");
        Shape circle = new Circle(radius);
        Shape triangle = null;
        while (triangle == null) {
            try {
                double a = Utils.readDouble("Please input of side A of Triangle");
                double b = Utils.readDouble("Please input of side B of Triangle");
                double c = Utils.readDouble("Please input of side C of Triangle");
                triangle = new Triangle(a, b, c);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please re-enter the side of Triangle.");
            }
        }

          Shape[] shapes = { rec, circle, triangle };
        for (Shape s : shapes) s.printResult();
    } 
    }

