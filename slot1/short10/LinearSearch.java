/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot1.short10;

import java.util.Random;

/**
 *
 * @author HP
 */
public class LinearSearch {

    private int[] array;

    public LinearSearch(int n) {
        this.array = new int[n];
    }

    public void generateArray(int n) {
        Random rnd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(n);
        }
    }

    public int findOfIndex(int n) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == n) {
                return i;
            }
        }
        return -1;
    }

    public void showArray() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
