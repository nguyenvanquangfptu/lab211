/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot3.short83;

import com.mycompany.lab211.Utils;

/**
 *
 * @author HP
 */
public class Test {

    public static void main(String[] args) {
        MyStack stack = new MyStack(Utils.readPositiveInt("Enter the capacity of Stack: "));

        // Push values
        stack.push(Utils.readInt("Enter value: "));
        stack.push(Utils.readInt("Enter value: "));
        stack.push(Utils.readInt("Enter value: "));

        stack.printStack(); // Stack: [10, 20, 30]

        // Get top value
        System.out.println("Top of stack: " + stack.get()); // 30

        // Pop values
        stack.pop();
        stack.printStack(); // Stack: [10, 20]

        stack.pop();
        stack.pop();
        stack.pop();
    }
}
