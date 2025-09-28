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
public class Test extends Menu {

    private Matrix matrix = new Matrix();

    private static final String TITLE = "\n ======= Calculator Program ============";
    private static final String[] ITEMS = {"Addition Matrix", "Subtraction Matrix", "Multiplication Matrix", "Quit"};

    public Test() {
    }

    public Test(String title, String[] mc) {
        super(title, mc);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1: {
                int a = Utils.readPositiveInt("Enter Row Matrix 1: ");
                int b = Utils.readPositiveInt("Enter Col Matrix 1: ");
                int[][] matrix1 = matrix.generateMatrix(a, b);
                int x = Utils.readPositiveInt("Enter Row Matrix 2: ");
                int y = Utils.readPositiveInt("Enter Col Matrix 2: ");
                int[][] matrix2 = matrix.generateMatrix(x, y);
                try {
                    System.out.println("----- Result -----");
                    int[][] result = matrix.AddMatrix(matrix1, matrix2);
                    matrix.showMatrix(matrix1);
                    System.out.println("+");
                    matrix.showMatrix(matrix2);
                    System.out.println("=");
                    matrix.showMatrix(result);
                } catch (IllegalArgumentException e) {
                    System.out.println("✗ Cannot add: Matrices must have the same dimensions.");
                }

                break;
            }
            case 2: {
                int a = Utils.readPositiveInt("Enter Row Matrix 1: ");
                int b = Utils.readPositiveInt("Enter Col Matrix 1: ");
                int[][] matrix1 = matrix.generateMatrix(a, b);
                int x = Utils.readPositiveInt("Enter Row Matrix 2: ");
                int y = Utils.readPositiveInt("Enter Col Matrix 2: ");
                int[][] matrix2 = matrix.generateMatrix(x, y);
                try {
                    System.out.println("----- Result -----");
                    int[][] result = matrix.SubtractMatrix(matrix1, matrix2);
                    matrix.showMatrix(matrix1);
                    System.out.println("-");
                    matrix.showMatrix(matrix2);
                    System.out.println("=");
                    matrix.showMatrix(result);
                } catch (IllegalArgumentException e) {
                    System.out.println("✗ Cannot subtract: Matrices must have the same dimensions.");
                }
                break;
            }
            case 3: {
                int a = Utils.readPositiveInt("Enter Row Matrix 1: ");
                int b = Utils.readPositiveInt("Enter Col Matrix 1: ");
                int[][] matrix1 = matrix.generateMatrix(a, b);
                int x = Utils.readPositiveInt("Enter Row Matrix 2: ");
                int y = Utils.readPositiveInt("Enter Col Matrix 2: ");
                int[][] matrix2 = matrix.generateMatrix(x, y);

                try {
                    System.out.println("----- Result -----");
                    int[][] result = matrix.MulMatrix(matrix1, matrix2);
                    matrix.showMatrix(matrix1);
                    System.out.println("x");
                    matrix.showMatrix(matrix2);
                    System.out.println("=");
                    matrix.showMatrix(result);
                } catch (IllegalArgumentException e) {
                    System.out.println(" Cannot multiply: "
                            + "Matrix1 columns must equal Matrix2 rows.");
                }
                break;
            }
            case 4: {
                return;
            }
        }
    }

    public static void main(String[] args) {
        Test test = new Test(TITLE, ITEMS);
        test.run();
    }
}
