/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot7;

/**
 *
 * @author HP
 */
public abstract class Shape {
    private final String name;
    protected Shape(String name) { this.name = name; }
    public String getName() { return name; }
    /** Return 2 for 2D shapes, 3 for 3D shapes. */
    public abstract void print();
    @Override public String toString() { return getName(); }
}