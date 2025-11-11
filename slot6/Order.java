/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot6;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class Order {

    private String customerName;
    private List<OrderDetail> items = new ArrayList<>();
    private double total;

    public Order(String customerName) {
        this.customerName = customerName;
    }

    public void addDetail(OrderDetail od) {
        items.add(od);
        total += od.getAmount();
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<OrderDetail> getItems() {
        return items;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Customer: %s ", customerName)).append("\n");
        sb.append(String.format("%-10s | %-10s | %-10s | %-10s\n  ", "Product", "Quantity", "Price", "Amount"));
        int i = 1;
        for (OrderDetail od : items) {
            sb.append(i).append(od.toString()).append("\n");
        }
        return sb.toString();
    }
}
