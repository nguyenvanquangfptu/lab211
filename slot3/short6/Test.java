/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot3.short6;

import com.mycompany.lab211.Utils;

/**
 *
 * @author HP
 */
public class Test {

    public static void main(String[] args) {
        BinarySearch bir = new BinarySearch(Utils.readPositiveInt("Enter the number of array: "));
        bir.generateArray(Utils.readInt("Enter the scope of array: "));
        bir.bubbleSort();
        int n = Utils.readInt("Enter search value: ");
        System.out.print("Sorted array: ");
        bir.showArray();
        int p = bir.binarySearch(n);
        if (p != -1) {
            System.out.printf("\nFound %d at index: %d", n, p);
        } else {
            System.out.printf("\nNot found %d in array.", n);
        }

    }
}
