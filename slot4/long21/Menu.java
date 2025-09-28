/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot4.long21;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public abstract class Menu {
     public String title;
    private ArrayList<String> choices;
    
    public Menu(){}
    
    public Menu(String title, String[] mc){
        this.title= title;
        choices = new ArrayList<>();
        for(String s:mc) choices.add(s);
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getChoices() {
        return choices;
    }
//-------------------------------------------
    public void display(){
        System.out.println(title);
        System.out.println("--------------------------------");
        for(int i=0; i< choices.size();i++)
            System.out.println((i+1)+"."+ choices.get(i));
        System.out.println("--------------------------------");
    }
//-------------------------------------------
    public int getSelected(){
        display();
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter selection: ");
        return sc.nextInt();
    }
//-------------------------------------------
    public abstract void execute(int n);
//-------------------------------------------
    public void run(){
        while(true){
            int n=getSelected();
            if(n<choices.size())execute(n);
            else break;
        }
    }
//-------------------------------------------    
}
