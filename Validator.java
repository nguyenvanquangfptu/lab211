/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211;

import com.mycompany.lab211.slot4.long21.StudentDAO;
import java.time.Year;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;



public class Validator {

    static Scanner sc = new Scanner(System.in);
    private static final Set<String> VALID_COURSES = Set.of("java", ".net", "c/c++");
    private static StudentDAO stuDAO = new StudentDAO();
//    public static int checkNum(String prompt){
//        
//    }

    public static int inputPositiveInt(String promt) {

        while (true) {
            try {
                System.out.println(promt);
                int number = Integer.parseInt(sc.nextLine());
                if (number <= 0) {
                    System.out.println("Enter a positive integer ");
                    continue;
                }
                return number;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter a number");

            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }

    public static int inputInt(String promt, int min, int max) {

        while (true) {
            try {

                System.out.println(promt);
                int number = Integer.parseInt(sc.nextLine());
                if (number < min || number > max) {
                    System.out.println("Invalid input, input must < "+ max + "and > "+min + "please try again.");
                    continue;
                }
                return number;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter a number");

            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }

    public static int inputInt(String promt) {

        while (true) {
            try {

                System.out.println(promt);
                int number = Integer.parseInt(sc.nextLine());

                return number;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter a number");

            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }

    public static boolean isValidForBase(String value, int base) {
        if (value == null || value.isEmpty()) {
            return false;
        }

        if (value.startsWith("-") || value.startsWith("+")) {
            value = value.substring(1);
        }

        String pattern = switch (base) {
            case 2 ->
                "[01]+";              // binary
            case 8 ->
                "[0-7]+";             // octal
            case 10 ->
                "\\d+";              // decimal
            case 16 ->
                "[0-9A-Fa-f]+";      // hexadecimal
            default ->
                throw new IllegalArgumentException("Invalid value with  base :" + base);
        };

        return value.matches(pattern);
    }

    public static double inputDouble(String promt, double min, double max) {

        while (true) {
            try {

                System.out.println(promt);
                double number = Double.parseDouble(sc.nextLine());
                if (number < min || number > max) {
                    System.out.println("Enter a double number in range " + min + "-" + String.format("%.3f", max));
                    continue;
                }
                return number;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter a number");

            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }

    public static double inputPositiveDouble(String promt) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {

                System.out.println(promt);
                double number = Double.parseDouble(sc.nextLine());
                if (number <= 0.0) {
                    continue;
                }
                return number;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter a number");

            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }

    public static double inputDouble(String promt) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {

                System.out.println(promt);
                double number = Double.parseDouble(sc.nextLine());

                return number;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter a number");

            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }

    public static String inputBase(int base, String msg) {
        String value;
        while (true) {
            System.out.println(msg);
            value = sc.nextLine();
            try {
                if (isValidForBase(value, base)) {
                    break;
                }

            } catch (IllegalArgumentException IAE) {
                System.out.println(IAE.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return value;
    }

    public static boolean isSquareNumber(int number) {
        if (number < 0) {
            return false;
        }
        if (number == 0 || number == 1) {
            return true;
        }
        switch (number % 10) {
            case 2, 3, 7, 8 -> {
                return false;
            }
        }
        for (int i = 4; i * i <= number; i++) {
            if (i * i == number) {
                return true;
            }
        }
        return false;
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static boolean isOdd(int n) {
        return n % 2 != 0;
    }

    public static boolean isValidOperator(String op) {
        return op != null && (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/"));
    }

    public static String inputOperator(String promt) {
        String op;
        while (true) {
            System.out.println("Enter operator: ");
            op = sc.nextLine();
            if (op != null && (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")));
            break;
        }

        return op;
    }

    public static boolean isValidCourseName(String courseName) {
        if (courseName == null || courseName.isBlank()) {
            return false;
        }
        return VALID_COURSES.contains(courseName.trim().toLowerCase());
    }
    
//    public static String inputString(String promt, String patter){
//        
//    }

    public static String inputString(String promt) {
        System.out.println(promt);
        String rs;
        while (true) {

            rs = sc.nextLine();
            if (rs != null && !rs.isBlank()) {
                break;
            }
            System.out.println("Please enter again");
        }
        return rs;
    }

    public static String inputOneWord(String promt) {
        System.out.println(promt);
        String rs;
        while (true) {
            rs = sc.next();
            sc.nextLine();
            if (rs != null && !rs.isBlank()) {
                break;
            }
            sc.nextLine();
            System.out.println("Please enter again");

        }

        return rs;
    }

  

   

    //chatGPT
    private static String inputWithValidation(String prompt, String errorMsg, Pattern pattern, int maxLength) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();

            // Nếu có giới hạn độ dài
            if (maxLength > 0 && input.length() > maxLength) {
                System.out.println(errorMsg);
                continue;
            }

            // Kiểm tra regex pattern
            if (pattern != null && !pattern.matcher(input).matches()) {
                System.out.println(errorMsg);
                continue;
            }

            return input.trim();
        }
    }

    // 1️⃣ Hàm nhập tên — chỉ chứa chữ cái và khoảng trắng
    public static String inputFullName() {
        Pattern namePattern = Pattern.compile("^[A-Za-z ]+$");
        return inputWithValidation(
                "Enter full name: ",
                "Fullname must contain only letters and spaces.",
                namePattern,
                0
        );
    }

    // 2️⃣ Hàm nhập ID — 6 chữ số, không khoảng trắng
    public static String inputID() {
        Pattern idPattern = Pattern.compile("^\\d{6}$");
        return inputWithValidation(
                "Enter ID (6 digits): ",
                "ID must be exactly 6 digits and no spaces.",
                idPattern,
                0
        );
    }

    // 3️⃣ Hàm nhập năm sinh — phải trước năm hiện tại
    public static int inputBirthYear() {
        int currentYear = Year.now().getValue();
        while (true) {
            System.out.print("Enter birth year: ");
            try {
                int year = Integer.parseInt(sc.nextLine().trim());
                if (year >= currentYear || year < 0) {
                    System.out.println(" Year of birth must be before the current year.");
                } else {
                    return year;
                }
            } catch (NumberFormatException e) {
                System.out.println(" Invalid year. Please enter a number.");
            }
        }
    }

    public static int inputAdmission(int birthYear) {
        int currentYear = Year.now().getValue();
        while (true) {
            System.out.print("Enter year of admission");
            try {
                int year = Integer.parseInt(sc.nextLine().trim());
                if (year >= currentYear || year <= birthYear || year < 0) {
                    System.out.println(" Year of Admission must be before the current year and after birth year.");
                } else {
                    return year;
                }
            } catch (NumberFormatException e) {
                System.out.println(" Invalid year. Please enter a number.");
            }
        }
    }

    public static String inputContractType() {
        String contract = "";
        do {
            contract = inputWithValidation(
                    "Enter contract type: ",
                    "contract type include Long or Shor .",
                    null,
                    0
            );

        } while (!contract.trim().equalsIgnoreCase("long") && !contract.trim().equalsIgnoreCase("short"));
        return contract;
    }

    // 4️⃣ Hàm nhập chuyên ngành — chuỗi <= 30 ký tự
    public static String inputMajor() {
        return inputWithValidation(
                "Enter major: ",
                "Major must not exceed 30 characters.",
                null,
                30
        );
    }

    public static String inputPhoneNumber() {
        Pattern phonePattern = Pattern.compile("^\\d{12}$");
        return inputWithValidation(
                "Enter phone number (12 digits): ",
                "Phone number must contain exactly 12 digits.",
                phonePattern,
                0
        );
    }

    public static boolean inputYesNo(String prompt) {
        System.out.println(prompt + " Y/N : ");
        while (true) {
            String choice = sc.nextLine().trim();
            if (choice == null || choice.length() > 1 || choice.isBlank()) {
                System.out.println("Invalid input. Enter again please ");
                continue;
            }
            if(!"Y".equalsIgnoreCase(choice) && !"N".equalsIgnoreCase(choice)){
                System.out.println("Invalid input. Enter again please ");
                
            }else{
                return "y".equalsIgnoreCase(choice);
            }
            

        }
    }

}
