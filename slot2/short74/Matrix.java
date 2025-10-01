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

    public Matrix(int[][] data) {
        this.array = data;
    }

    public int[][] getArray() {
        return array;
    }

    public void setArray(int[][] data) {
        this.array = data;
    }

    public Matrix generateMatrix(int n, int m) {
        array = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = Utils.readInt(
                        String.format("Enter Matrix[%d][%d]: ", i + 1, j + 1)
                );
            }
        }
        return this;  // trả về chính đối tượng Matrix
    }

   public void showMatrix() {
        if (array == null) {
            System.out.println("(empty matrix)");
            return;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print("[" + array[i][j] + "] ");
            }
            System.out.println();
        }
    }

   public Matrix subtract(Matrix other) {
        checkSameSize(other);
        int r = array.length, c = array[0].length;
        int[][] res = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = array[i][j] - other.array[i][j];
            }
        }
        return new Matrix(res);
    }

    public Matrix add(Matrix other) {
        checkSameSize(other);
        int r = array.length, c = array[0].length;
        int[][] res = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = array[i][j] + other.array[i][j];
            }
        }
        return new Matrix(res);
    }

    public Matrix multiply(Matrix other) {
        if (array[0].length != other.array.length) {
            throw new IllegalArgumentException(
                "Matrix1 columns must equal Matrix2 rows."
            );
        }
        int m = array.length;          // rows of A
        int n = array[0].length;       // cols of A = rows of B
        int p = other.array[0].length; // cols of B
        int[][] res = new int[m][p];

        for (int i = 0; i < m; i++) {
            for (int k = 0; k < n; k++) {
                int aik = array[i][k];
                for (int j = 0; j < p; j++) {
                    res[i][j] += aik * other.array[k][j];
                }
            }
        }
        return new Matrix(res);
    }

    private void checkSameSize(Matrix other) {
        if (array == null || other.array == null) {
            throw new IllegalArgumentException("Matrix is null.");
        }
        if (array.length != other.array.length ||
            array[0].length != other.array[0].length) {
            throw new IllegalArgumentException(
                "Matrices must have the same dimensions."
            );
        }
    }
}
