/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211;

import java.time.Year;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Utils {

    public static final Scanner sc = new Scanner(System.in);

    public static String checkOperators(String msg) {
        while (true) {
            System.out.print(msg);
            String op = sc.nextLine().trim();
            if (op.equals("+") || op.equals("-") || op.equals("*")
                    || op.equals("/") || op.equals("^") || op.equals("=")) {
                return op;
            }
            System.out.println("Please input one of (+, -, *, /, ^, 😊.");
        }
    }

    public static boolean readYesNo(String prompt) {
        while (true) {
            System.out.print(prompt + " (Y/N): ");
            String input = sc.nextLine().trim();

            if (input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("Yes")) {
                return true;   // chọn Yes
            } else if (input.equalsIgnoreCase("N") || input.equalsIgnoreCase("No")) {
                return false;  // chọn No
            } else {
                System.out.println("✗ Invalid input. Please enter Y or N.");
            }
        }
    }

    public static boolean readUpdateOrDelete(String prompt) {
        while (true) {
            System.out.print(prompt + " (U=Update / D=Delete): ");
            String input = sc.nextLine().trim();

            if (input.equalsIgnoreCase("U")) {
                return true;  // Update
            } else if (input.equalsIgnoreCase("D")) {
                return false; // Delete
            } else {
                System.out.println("✗ Invalid choice. Please enter U or D.");
            }
        }
    }

    public static String readCourseName(String prompt) {
        while (true) {
            System.out.print(prompt + " (Java / .Net / C/C++): ");
            String input = sc.nextLine().trim();

            if (input.equalsIgnoreCase("Java")) {
                return "Java";
            } else if (input.equalsIgnoreCase(".Net") || input.equalsIgnoreCase("Net")) {
                return ".Net";
            } else if (input.equalsIgnoreCase("C/C++") || input.equalsIgnoreCase("C++")) {
                return "C/C++";
            } else {
                System.out.println("✗ Invalid course. Please enter only Java, .Net, or C/C++.");
            }
        }
    }

    public static String readSemester(String prompt) {
        while (true) {
            System.out.print(prompt + " (Fall / Spring / Summer): ");
            String input = sc.nextLine().trim();

            if (input.equalsIgnoreCase("Fall")) {
                return "Fall";
            } else if (input.equalsIgnoreCase("Summer")) {
                return "Summer";
            } else if (input.equalsIgnoreCase("Spring")) {
                return "Spring";
            } else {
                System.out.println(" Invalid semester. Please enter only Spring, Summer, or Fall");
            }
        }
    }

    /// Hàm integer
    public static int readYearOfBirth(String msg) {
        int currentYear = Year.now().getValue(); // current year
        int yob;

        while (true) {
            try {
                System.out.print(msg);
                yob = Integer.parseInt(sc.nextLine().trim());

                if (yob > 1900 && yob < currentYear) {
                    return yob; // valid
                } else {
                    System.out.println("⚠️ Year of birth must be greater than 1900 and less than the current year.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Please enter a valid number!");
            }
        }
    }

    public static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException ignored) {
                System.out.println("Please input integer value.");
            }
        }
    }

    public static int readPositiveInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int x = Integer.parseInt(sc.nextLine().trim());
                if (x > 0) {
                    return x;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Please enter a positive integer.");
        }
    }

//         Hàm String
    public static String readString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine();
            s = (s == null) ? "" : s.trim();
            if (!s.isEmpty()) {
                return s;
            }
            System.out.println(" Input cannot be empty. Please try again.");
        }
    }

    public static String readMajor(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine();
            s = (s == null) ? "" : s.trim();

            // kiểm tra rỗng
            if (s.isEmpty()) {
                System.out.println("✗ Major cannot be empty. Please try again.");
                continue;
            }

            // kiểm tra độ dài
            if (s.length() > 30) {
                System.out.println("✗ Major cannot exceed 30 characters. Please try again.");
                continue;
            }

            // kiểm tra chỉ chữ cái + khoảng trắng
            if (s.matches("[a-zA-Z ]+")) {
                return s;
            } else {
                System.out.println("✗ Major must contain only letters and spaces. Please try again.");
            }
        }
    }

    public static String readName(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine();
            s = (s == null) ? "" : s.trim();

            // kiểm tra rỗng
            if (s.isEmpty()) {
                System.out.println("✗ Input cannot be empty. Please try again.");
                continue;
            }

            // kiểm tra chỉ chữ cái + khoảng trắng
            if (s.matches("[a-zA-Z ]+")) {
                return s;
            } else {
                System.out.println("✗ Name must contain only letters and spaces. Please try again.");
            }
        }
    }

    public static String readStudentId(String prompt) {
        while (true) {
            System.out.print(prompt + " (format: DE/DA/DS + 4 digits, e.g., DE1234): ");
            String input = sc.nextLine().trim().toUpperCase();

            // Kiểm tra độ dài
            if (input.length() != 6) {
                System.out.println(" ID must be exactly 6 characters.");
                continue;
            }

            // Lấy prefix và số phía sau
            String prefix = input.substring(0, 2);   // 2 ký tự đầu
            String number = input.substring(2);      // 4 ký tự sau

            // Kiểm tra prefix
            if (!(prefix.equals("DE") || prefix.equals("DA") || prefix.equals("DS"))) {
                System.out.println(" ID must start with DE, DA, or DS.");
                continue;
            }

            // Kiểm tra phần số
            if (!number.matches("\\d{4}")) {
                System.out.println(" Last 4 characters must be digits (0-9).");
                continue;
            }

            // Hợp lệ
            return input;
        }
    }

    public static String readPhoneNumber(String msg) {
        String phone;

        while (true) {
            System.out.print(msg);
            phone = sc.nextLine().trim();

            // Check: must be exactly 10 digits
            if (phone.matches("\\d{10}")) {
                return phone; // valid
            } else {
                System.out.println("⚠️ Phone number must contain exactly 10 digits.");
            }
        }
    }

    // hàm float
    public static Float checkin(String floatString) {
        try {
            return Float.parseFloat(floatString.trim());
        } catch (NumberFormatException e) {
            return null; // nếu không parse được thì trả về null
        }
    }

    // Hàm nhập float: dùng checkin để validate, bắt nhập lại đến khi đúng
    public static float readFloat(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine();
            Float value = checkin(input); // gọi lại checkin
            if (value != null) {
                return value; // nhập hợp lệ thì trả về
            } else {
                System.out.println("Invalid number, please re-enter!\n");
            }
        }
    }

    // Hàm double
    public static double readDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt + ": ");
                String input = sc.nextLine().trim();
                double value = Double.parseDouble(input);
                return value;
            } catch (NumberFormatException e) {
                System.out.println("✗ Invalid number! Please enter a valid double.");
            }
        }
    }

    public static Double checkIn(String inputVal) {
        try {
            if (inputVal == null) {
                return null;
            }
            return Double.valueOf(inputVal.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
