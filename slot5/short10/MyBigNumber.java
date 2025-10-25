/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot5.short10;

/**
 *
 * @author HP
 */
public class MyBigNumber {


    private String value;

    public MyBigNumber(String value) {
        this.value = value;

    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String convertToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int element : arr) {
            sb.append(element);
        }
        return sb.toString();
    }

    public MyBigNumber add( MyBigNumber other) {
        int capacity = Math.max(this.value.length(), other.value.length());
        int[] result = new int[capacity + 1];

        int i = this.value.length() - 1;
        int j = other.value.length() - 1;
        int sodu = 0;
        while (i >= 0 || j >= 0) {

            int so1 = (i >= 0) ? this.value.charAt(i) - '0' : 0;
            int so2 = (j >= 0) ? other.value.charAt(j) - '0' : 0;

            int kq = so1 + so2 + sodu;

            result[capacity] = kq % 10;
            sodu = kq / 10;
            i--;
            j--;
            capacity--;

        }

        if (sodu > 0) {
            result[capacity] = sodu;
        }
//        else{
//            
//            for(int idx = 0; idx < result.length - 2; idx ++){
//                result[i] = result[i+1];
//              }
//             
//        }        

        return new  MyBigNumber(convertToString(result));
    }

    public  MyBigNumber multiply( MyBigNumber other) {
        int capacity = this.value.length() + other.value.length();
        int[] result = new int[capacity];
        int sodu = 0;
        int k = 0;
        for (int i = this.value.length() - 1; i >= 0; i--) {
            System.out.println(" i = " + i);
            int idx = capacity - k - 1;
            int j = other.value.length() - 1;
            while (j >= 0) {
                System.out.println("j = " + j);
                int so1 = (i >= 0) ? this.value.charAt(i) - '0' : 0;
                int so2 = (j >= 0) ? other.value.charAt(j) - '0' : 0;
                int kq = so1 * so2 + sodu + result[idx];
                result[idx] = kq % 10;
                sodu = kq / 10;
                idx--;
                j--;
            }
            if (sodu > 0) {
                result[idx] = sodu;

                sodu = 0;
            }
            k++;
        }
        return new  MyBigNumber(convertToString(result));

    }

    @Override
    public String toString() {
        return " MyBigNumber{" + "value =" + value + '}';
    }

}
