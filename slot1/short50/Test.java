/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot1.short50;

/**
 *
 * @author HP
 */
public class Test extends Menu{
     private final EquationSolver solver = new EquationSolver();
    private static String title = "\n ======= Equation Program ============";
    private static String[] arr = {"Calculate Superlative Equation", "Calculate Quadratic Equation", "Exit"};

    public Test() {
        super(title, arr);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1 ->
                solver.handleLinear();
            case 2 ->
                solver.handleQuadratic();
            case 3 -> {
           //     System.out.println("Bye!");
                return;
            }
            default ->
                System.out.println("Invalid choice!");
        }

    }

  
    
    public static void main(String[] args) {
      Test test = new Test();
      test.run();
    }
}
