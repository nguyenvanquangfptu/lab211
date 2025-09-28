/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot1.short11;

import com.mycompany.lab211.Utils;

/**
 *
 * @author HP
 */
public class BaseConvert {

    public BaseConvert() {
    }

    public int toDecimal(String input, int inBase) {
        input = input.trim().toUpperCase();
        int value = 0;
        int power = 1; // inBase^0
        for (int i = input.length() - 1; i >= 0; i--) {
            char c = input.charAt(i);
            int digit;
            if (c >= '0' && c <= '9') {
                digit = c - '0';
            } else if (c >= 'A' && c <= 'F') {
                digit = 10 + (c - 'A');
            } else {
                throw new NumberFormatException("Invalid digit: " + c);
            }

            if (digit >= inBase) {
                throw new NumberFormatException("Digit " + c + " not valid for base " + inBase);
            }

            value += digit * power;
            power *= inBase;
        }
        return value;
    }

    // Chuyển từ số thập phân sang chuỗi theo base outBase
    public String fromDecimal(int number, int outBase) {
        if (number == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        int n = number;
        while (n > 0) {
            int remainder = n % outBase;
            char c;
            if (remainder < 10) {
                c = (char) ('0' + remainder);
            } else {
                c = (char) ('A' + (remainder - 10));
            }
            sb.append(c);
            n /= outBase;
        }
        return sb.reverse().toString();
    }

    // Hàm tổng hợp: chuyển đổi từ base inBase sang base outBase
    public String convert(String input, int inBase, int outBase) {
        int decimalValue = toDecimal(input, inBase);
        return fromDecimal(decimalValue, outBase);
    }

    public void run() {
        while (true) {
            System.out.println("\n=== Base Converter Program ===");
            System.out.println("1. Binary (base 2)");
            System.out.println("2. Decimal (base 10)");
            System.out.println("3. Hexadecimal (base 16)");
            System.out.println("4. Exit");

            int inChoice = readChoice("Choose input base (1-3, 4 to exit): ");
            if (inChoice == 4) {
                break;
            }
            int outChoice = readChoice("Choose output base (1-3): ");

            int inBase = mapBase(inChoice);
            int outBase = mapBase(outChoice);

            String input = Utils.readString("Enter input value: ");

            try {
                String result = convert(input, inBase, outBase);
                System.out.printf("Output (%d-base): %s%n", outBase, result);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: " + e.getMessage());
            }
        }
        System.out.println("Bye!");
    }

    private int readChoice(String prompt) {
        while (true) {

            String s = Utils.readString(prompt);

            try {
                int choice = Integer.parseInt(s);
                if (choice >= 1 && choice <= 4) {
                    return choice;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Invalid choice, please enter again!");
        }
    }

    private int mapBase(int choice) {
        return switch (choice) {
            case 1 ->
                2;
            case 2 ->
                10;
            case 3 ->
                16;
            default ->
                throw new IllegalArgumentException("Invalid base choice");
        };
    }
}
