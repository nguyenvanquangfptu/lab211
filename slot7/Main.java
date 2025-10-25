/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot7;

/**
 *
 * @author HP
 */
public class Main {

    public static void main(String[] args) {
        Shape[] shapes = new Shape[]{
            // 2D
            new Circle(5),
            new Square(4),
            new Triangle(3, 4),
            // 3D (as in the figure branch)
            new Sphere(3),
            new Cube(2.5),
            new Tetrahedron(3)
        };

        System.out.println("=== Shape report ===");
        for (Shape s : shapes) {
            s.print();
        }
    }

}
