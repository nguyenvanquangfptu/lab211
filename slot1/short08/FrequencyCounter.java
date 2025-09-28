/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot1.short08;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author HP
 */
public class FrequencyCounter {
     private final String normalizedText;
    private final Map<String, Integer> wordFreq = new LinkedHashMap<>();
    private final Map<Character, Integer> letterFreq = new LinkedHashMap<>();

    public FrequencyCounter(String text) {
        // chuẩn hóa: chữ thường + bỏ ký tự không phải chữ/số
        this.normalizedText = text.toLowerCase().replaceAll("[^\\p{L}\\s]", " ");
    }

public void countWords(){
    String[] words = normalizedText.trim().split("\\s+");
    for(String w : words){
        if(!w.isEmpty()){
            if(wordFreq.containsKey(w)){
                wordFreq.put(w, wordFreq.get(w) +1);
            }
            else{
                 wordFreq.put(w, +1);
            }
        }
    }
}

    // ===== Đếm chữ cái =====
    public void countLetters() {
        for (char ch : normalizedText.toCharArray()) {
            if (Character.isLetter(ch)) {
                if (letterFreq.containsKey(ch)) {
                    letterFreq.put(ch, letterFreq.get(ch) + 1); // tăng thêm 1
                } else {
                    letterFreq.put(ch, 1); // thêm mới
                }
            }
        }
    }

    public void printWordFreq() {
        System.out.println("Word frequency: " + wordFreq);
    }

    public void printLetterFreq() {
        System.out.println("Letter frequency: " + letterFreq);
    }
}
