/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot7;

/**
 *
 * @author HP
 */
 public abstract class TwoDimensionalShape extends Shape {
    protected TwoDimensionalShape(String name) { super(name); }

    @Override
    public abstract void print();
    
    public abstract double getArea();
}