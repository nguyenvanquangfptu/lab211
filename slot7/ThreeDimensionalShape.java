/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot7;

/**
 *
 * @author HP
 */
 public abstract class ThreeDimensionalShape extends Shape {
    protected ThreeDimensionalShape(String name) { super(name); }
    // Khi cần biết đây là loại hình gì( 2D hay 3D mà k cần dùng instance of

    @Override
    public abstract void print();
    
    public abstract double getArea();    // surface area
    public abstract double getVolume();
}