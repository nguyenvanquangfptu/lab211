/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot1.short08;

import com.mycompany.lab211.Utils;

/**
 *
 * @author HP
 */
public class Test {
    public static void main(String[] args) {
        FrequencyCounter counter = new FrequencyCounter(Utils.readString("Enter the string: "));

        counter.countWords();
        counter.printWordFreq();

        counter.countLetters();
        counter.printLetterFreq();
    }
}
