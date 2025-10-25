/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot5.short10;

import com.mycompany.lab211.Utils;

/**
 *
 * @author HP
 */
public class Test {
    public static void main(String[] args) {
        String number = Utils.readString("Enter: ");
        MyBigNumber x = new MyBigNumber(number);
        String number2 = Utils.readString("Enter: ");
        MyBigNumber y = new MyBigNumber(number2);

        MyBigNumber kq = x.add(y);
        System.out.println("KQ " + kq.toString());

    }
}
