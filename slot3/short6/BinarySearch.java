/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot3.short6;

import java.util.Random;

/**
 *
 * @author HP
 */
public class BinarySearch {

    private int[] array;

    public BinarySearch(int n) {
        this.array = new int[n];
    }

    public void generateArray(int n) {
        Random rnd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(n);
        }
    }

    public void bubbleSort() {
        for (int i = 0; i < array.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public int binarySearch(int key) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // tránh tràn số

            if (array[mid] == key) {
                return mid; // tìm thấy
            }
            if (array[mid] < key) {
                low = mid + 1; // bỏ nửa trái
            } else {
                high = mid - 1; // bỏ nửa phải
            }
        }
        return -1; // không tìm thấy
    }


    public void showArray() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length - 1) {
                System.out.print(", ");
            }
        }
    }
}
