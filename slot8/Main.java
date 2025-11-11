/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot8;

import com.mycompany.lab211.Menu;
import com.mycompany.lab211.Utils;

/**
 *
 * @author HP
 */
public class Main extends Menu {
    CandidateManagement can = new CandidateManagement();
    private static final String TITLE = "\n ======= CANDIDATE MANAGEMENT SYSTEM ============";
    private static final String[] ITEMS = {"Experience", "Fresher", "Internship", "Searching","Print All Candidate", "Exit"};

    public Main() {
    }

    public Main(String title, String[] mc) {
        super(title, mc);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1 -> {
                do {
                    can.inputExperience();
                } while (Utils.readYesNo("Do you want to continue? "));
               // can.printGrouped();
                break;

            }
            case 2 -> {
                do {
                    can.inputFresher();
                } while (Utils.readYesNo("Do you want to continue? "));
             //   can.printGrouped();
                break;
            }
            case 3 -> {
                do {
                    can.inputIntern();
                } while (Utils.readYesNo("Do you want to continue? "));
             //   can.printGrouped();
                break;
            }
            case 4 -> {
                can.searchCandidate();
                break;
            }
            case 5 -> {
                 can.printGrouped();
                break;
            }
             case 6 -> {
                System.out.println("Exit");
                return;
            }
        }
    }

    public static void main(String[] args) {
        Main n = new Main(TITLE, ITEMS);
        n.run();
    }

}
