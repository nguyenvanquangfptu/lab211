/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot3.short4;

import com.mycompany.lab211.Utils;

/**
 *
 * @author HP
 */
public class Test {
    public static void main(String[] args) {
        int n = Utils.readInt("Enter number of array: ");
         QuickSort quick = new QuickSort(n);
        quick.generateArray(Utils.readInt("Enter scope of array: "));
        System.out.print("Unsorted array: ");
        quick.showArray();
        quick.quickSort(0, n -1);
        System.out.print("\nSorted array: ");
        quick.showArray();
    }
}
