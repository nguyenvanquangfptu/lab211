/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot6;

import java.util.Objects;

/**
 *
 * @author HP
 */
public class Fruit {
    private String id;
    private String name;
    private double price;
    private int stockQuantity;
    private String origin;

    public Fruit(String id, String name, double price, int stockQuantity, String origin) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.origin = origin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Fruit other = (Fruit) obj;
        return id.equalsIgnoreCase(other.id);
    }

    @Override
    public int hashCode() {
         return Objects.hash(id);
    }
    
    

    @Override
    public String toString() {
        return String.format("%15s %15s %15.2f %15d",name,origin,price,stockQuantity );
    }
}
    
