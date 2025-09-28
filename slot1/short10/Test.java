/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot1.short10;

import com.mycompany.lab211.Utils;

/**
 *
 * @author HP
 */
public class Test {

    public static void main(String[] args) {
        int size = Utils.readPositiveInt("Enter the size: ");
        LinearSearch linearSearch = new LinearSearch(size);

        linearSearch.generateArray(Utils.readPositiveInt("Enter the scope: "));
        int num = Utils.readPositiveInt("Enter the number: ");
        int n = linearSearch.findOfIndex(num);

        linearSearch.showArray();
        if (n >= 0) {
            System.out.printf("\nNumber %d found at index %d", num, n);
        } else {
            System.out.printf("\nNumber %d not found in array", num);
        }

    }
}
