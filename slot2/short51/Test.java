/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot2.short51;

import com.mycompany.lab211.Utils;

/**
 *
 * @author HP
 */
public class Test extends Menu {

    private static final String TITLE = "\n ======= Calculator program ============";
    private static final String[] ITEMS = {"Normal Calculator", "BMI Calculator", "Exit"};

    public Test(String title, String[] mc) {
        super(title, mc);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1: {
                runNormalCalculator();
                break;
            }
            case 2: {
                runBMICalculator();
                break;
            }
            case 3: {
                return;
            }
        }
    }

    private void runBMICalculator() {
        double weight = Utils.readDouble("Enter weight (kg): ");
        double height = Utils.readDouble("Enter height (cm): ");

        BMICalculator bmiCal = new BMICalculator(weight, height);
        double bmi = bmiCal.calculateBMI();

        System.out.printf("Your BMI is: %.2f%n", bmi);
        System.out.println("Category: " + bmiCal.getBMICategory());
    }

    private void runNormalCalculator() {
        double num1 = Utils.readDouble("Enter number: ");
        NormalCalculator cal = new NormalCalculator(num1);

        while (true) {
            String op = Utils.checkOperators("Enter operator (+, -, *, /, ^, =): ");
            if (op.equals("=")) {
                System.out.println("Result: " + cal.getMemory());
                break;
            }

            double num2 = Utils.readDouble("Enter number: ");
            cal.calculator(op, num2);
            System.out.println("Memory: " + cal.getMemory());
        }
    }

    public static void main(String[] args) {
        Test t = new Test(TITLE, ITEMS);
        t.run();
    }
}
