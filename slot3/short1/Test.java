/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot3.short1;

import com.mycompany.lab211.Utils;

/**
 *
 * @author HP
 */
public class Test {

    public static void main(String[] args) {
        BubbleSort bub = new BubbleSort(Utils.readPositiveInt("Enter number of array: "));
        bub.generateArray(Utils.readPositiveInt("Enter scope of array: "));
        System.out.print("Unsorted array: ");
        bub.showArray();
        bub.bubbleSort();
        System.out.print("\nSorted array: ");
        bub.showArray();
    }
}
