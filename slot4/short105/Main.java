/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot4.short105;

/**
 *
 * @author HP
 */
public class Main extends Menu {

    private static final String TITLE = "\n ======= Information Management ============";
    private static final String[] ITEMS = {"Teacher", "Student", "Person", "Exit"};

    public Main(String title, String[] mc) {
        super(title, mc);
    }
    PersonManagement p = new PersonManagement();

    @Override
    public void execute(int n) {
        switch (n) {
            case 1: {
                p.teacherManagement();
                break;
            }
            case 2: {
                p.studentManagement();
                break;
            }
            case 3: {
                p.personManagement();
                break;
            }
            case 4: {
                return;
            }

        }

    }

    public static void main(String[] args) {
        Main app = new Main(TITLE, ITEMS);
        app.run();
    }
}
