/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot2.short74;

import com.mycompany.lab211.Utils;

/**
 *
 * @author HP
 */
public class Matrix {

    private int[][] array;

    public Matrix() {

    }

    public int[][] generateMatrix(int n, int m) {
        array = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = Utils.readInt(
                        String.format("Enter Matrix[%d][%d]: ", i + 1, j + 1)
                );
            }
        }
        return array;
    }

    public void showMatrix(int[][] array) {
        for (int i = 0; i < array.length; i++) {             // số dòng
            for (int j = 0; j < array[i].length; j++) {      // số cột của dòng i
                System.out.print("[" + array[i][j] + "] ");
            }
            System.out.println(); // xuống dòng sau khi in hết 1 hàng
        }
    }

    public int[][] SubtractMatrix(int[][] a, int[][] b) {
        if (a.length != b.length || a[0].length != b[0].length) {
            throw new IllegalArgumentException("Matrix dimensions must be the same for subtraction.");
        }
        int row = a.length;
        int col = a[0].length;
        int[][] result = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = a[i][j] - b[i][j];
            }
        }
        return result;
    }

    public int[][] AddMatrix(int[][] a, int[][] b) {
        if (a.length != b.length || a[0].length != b[0].length) {
            throw new IllegalArgumentException("Matrix dimensions must be the same for addition.");
        }
        int row = a.length;
        int col = a[0].length;
        int[][] result = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }

    public int[][] MulMatrix(int[][] a, int[][] b) {
        if (a[0].length != b.length) {
            throw new IllegalArgumentException("Matrix dimensions do not match for multiplication.");
        }
        int m = a.length;       // số dòng của A
        int n = a[0].length;    // số cột của A = số dòng của B
        int p = b[0].length;    // số cột của B

        int[][] result = new int[m][p];

        // Tính tích ma trận
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return result;
    }

}
