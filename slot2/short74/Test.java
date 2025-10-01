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
            case 1: { // Add
                int a = Utils.readPositiveInt("Enter Row Matrix 1: ");
                int b = Utils.readPositiveInt("Enter Col Matrix 1: ");
                Matrix m1 = new Matrix().generateMatrix(a, b);

                int x = Utils.readPositiveInt("Enter Row Matrix 2: ");
                int y = Utils.readPositiveInt("Enter Col Matrix 2: ");
                Matrix m2 = new Matrix().generateMatrix(x, y);

                try {
                    System.out.println("----- Result -----");
                    Matrix sum = m1.add(m2);

                    m1.showMatrix();
                    System.out.println("+");
                    m2.showMatrix();
                    System.out.println("=");
                    sum.showMatrix();

                } catch (IllegalArgumentException e) {
                    System.out.println("✗ Cannot add: " + e.getMessage());
                }
                break; // <-- quan trọng
            }

            case 2: { // Subtract
                int a = Utils.readPositiveInt("Enter Row Matrix 1: ");
                int b = Utils.readPositiveInt("Enter Col Matrix 1: ");
                Matrix m1 = new Matrix().generateMatrix(a, b);

                int x = Utils.readPositiveInt("Enter Row Matrix 2: ");
                int y = Utils.readPositiveInt("Enter Col Matrix 2: ");
                Matrix m2 = new Matrix().generateMatrix(x, y);

                try {
                    System.out.println("----- Result -----");
                    Matrix diff = m1.subtract(m2);

                    m1.showMatrix();
                    System.out.println("-");
                    m2.showMatrix();
                    System.out.println("=");
                    diff.showMatrix();

                } catch (IllegalArgumentException e) {
                    System.out.println("✗ Cannot subtract: " + e.getMessage());
                }
                break;
            }

            case 3: { // Multiply
                int a = Utils.readPositiveInt("Enter Row Matrix 1: ");
                int b = Utils.readPositiveInt("Enter Col Matrix 1: ");
                Matrix m1 = new Matrix().generateMatrix(a, b);

                int x = Utils.readPositiveInt("Enter Row Matrix 2: ");
                int y = Utils.readPositiveInt("Enter Col Matrix 2: ");
                Matrix m2 = new Matrix().generateMatrix(x, y);

                try {
                    System.out.println("----- Result -----");
                    Matrix prod = m1.multiply(m2);

                    m1.showMatrix();
                    System.out.println("x");
                    m2.showMatrix();
                    System.out.println("=");
                    prod.showMatrix();

                } catch (IllegalArgumentException e) {
                    System.out.println(" Cannot multiply: " + e.getMessage());
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
