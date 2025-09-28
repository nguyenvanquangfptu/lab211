/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot1.short50;

import com.mycompany.lab211.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author HP
 */
public class EquationSolver {

    public List<Float> calculateEquation(float a, float b) {
        if (a == 0) {
            if (b == 0) {
                return Collections.emptyList(); // vô số nghiệm
            } else {
                return null; // vô nghiệm
            }
        }
        List<Float> ans = new ArrayList<>(1);
        ans.add(-b / a);
        return ans;
    }

    public List<Float> calculateQuadraticEquation(float a, float b, float c) {
        if (a == 0) {
            // trở về bậc nhất: b x + c = 0
            return calculateEquation(b, c);
        }
        float delta = b * b - 4 * a * c;
        if (delta < 0) {
            return null; // vô nghiệm
        } else if (delta == 0) {
            float x = -b / (2 * a);
            List<Float> ans = new ArrayList<>(1);
            ans.add(x);
            return ans;
        } else {
            float sqrt = (float) Math.sqrt(delta);
            float x1 = (-b + sqrt) / (2 * a);
            float x2 = (-b - sqrt) / (2 * a);
            List<Float> ans = new ArrayList<>(2);
            ans.add(x1);
            ans.add(x2);
            return ans;
        }
    }

    public boolean isOdd(float number) {
        return number % 2 != 0;
    }

    public boolean isPerfectSquare(float number) {
        if (number < 0) {
            return false;
        }
        int n = (int) number;
        int r = (int) Math.sqrt(n);
        return r * r == n;
    }

    public void handleLinear() {
        //  System.out.println("\n-- Superlative Equation (ax + b = 0) --");
        float a = Utils.readFloat("Enter A: ");
        float b = Utils.readFloat("Enter B: ");

        // Giải phương trình
        List<Float> result = calculateEquation(a, b);
        printLinearResult(a, b, result);

    }

    public void handleQuadratic() {
        float a = Utils.readFloat("Enter A: ");
        float b = Utils.readFloat("Enter B: ");
        float c = Utils.readFloat("Enter C: ");

        List<Float> result = calculateQuadraticEquation(a, b, c);
        printQuadraticResult(a, b, c, result);

    }

    public void printLinearResult(float a, float b, List<Float> result) {
        if (result == null) {
            System.out.println(" No solution.");
        } else if (result.isEmpty()) {
            System.out.println(" Infinitely many solutions.");
        } else {
            System.out.printf(" Solution: x = %.3f%n", result.get(0));
            printCoefficientSummary(new float[]{a, b});
        }
    }

    public void printQuadraticResult(float a, float b, float c, List<Float> result) {
        if (result == null) {
            System.out.println(" No solution.");
        } else if (result.isEmpty()) {
            System.out.println(" Infinitely many solutions.");
        } else if (result.size() == 1) {
            System.out.printf("Solution: x1 = %.3f, x2 = %.3f%n", result.get(0), result.get(0));
            printCoefficientSummary(new float[]{a, b, c});
        } else {
            System.out.printf(" Solution: x1 = %.3f, x2 = %.3f%n", result.get(0), result.get(1));
            printCoefficientSummary(new float[]{a, b, c});
        }
    }

    public void printCoefficientSummary(float[] coeffs) {
        StringBuilder odd = new StringBuilder("Odd Number(s):");
        StringBuilder even = new StringBuilder("Number is Even:");
        StringBuilder square = new StringBuilder("Number is Perfect Square:");

        boolean hasOdd = false, hasEven = false, hasSquare = false;

        for (float v : coeffs) {
            if (isOdd(v)) {
                odd.append(v).append(", ");
                hasOdd = true;
            } else {
                even.append(v).append(", ");
                hasEven = true;
            }
            if (isPerfectSquare(v)) {
                square.append(v).append(", ");
                hasSquare = true;
            }
        }

        // Cắt dấu , cuối nếu có
        if (hasOdd) {
            odd.setLength(odd.length() - 2);
        }
        if (hasEven) {
            even.setLength(even.length() - 2);
        }
        if (hasSquare) {
            square.setLength(square.length() - 2);
        }

        // In ra, nếu không có số thì thêm thông báo luôn
        System.out.println(hasOdd ? odd : "Odd Number(s): No old number");
        System.out.println(hasEven ? even : "Number is Even: No even number");
        System.out.println(hasSquare ? square : "Number is Perfect Square: No perfect number");
    }

}
