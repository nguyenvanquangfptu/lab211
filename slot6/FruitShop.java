/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot6;


import com.mycompany.lab211.Validator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Nguyen Phuong
 */
public class FruitShop {

    private List<Fruit> fruitList = new ArrayList<>();
    private List<Order> orderList = new ArrayList<>();

    public void run() {

        while (true) {
            System.out.println("Fruit Shop System");
            System.out.println("1. Create Fruit");
            System.out.println("2. View Fruits");
            System.out.println("3. View Orders");
            System.out.println("4. Shopping (for buyers) ");
            System.out.println("5. Exit.");
            int choice = Validator.inputInt("Enter your choice", 1, 4);
            switch (choice) {
                case 1 -> {
                    while (true) {
                        List<Fruit> newFruits = addFruits();

                        if (!Validator.inputYesNo("Do you want to continue?")) {
                            System.out.println("Fruist you have created: ");
                            showFruits(newFruits);
                            addListFruits(newFruits);
                            break;
                        }
                    }
                }
                case 2 -> {

                    showFruits(fruitList);
                }
                case 3 -> {
                    showOrders();
                }
                case 4 -> {
                    shopping();
                }
                default -> {
                    System.out.println("Exitting..");
                }
            }
        }
        // 1

        // 2
        // 3
    }

    public List<Fruit> addFruits() {
        List<Fruit> newFruits = new ArrayList<>();
        String id;
        while(true){
            id = Validator.inputOneWord("Enter ID fruit: ");
            if(!isDuplicatedID(id)) break;
            System.out.println("ID is duplicated.");
        }
        String name = Validator.inputString("Enter fruit's name: ");
        double price = Validator.inputDouble("Enter price", 0, Double.MAX_VALUE);
        int stockQuantity = Validator.inputInt("Enter stock quantity: ", 0, Integer.MAX_VALUE);
        String origin = Validator.inputString("Enter fruit's origin");

        newFruits.add(new Fruit(id, name, price, stockQuantity, origin));
        return newFruits;
    }

    public void addListFruits(List<Fruit> fruitslist) {
        fruitList.addAll(fruitslist);
    }

    public void addListOrder(List<Order> orderslist) {
        orderList.addAll(orderslist);
    }

    public void addOrder(Order order) {
        orderList.add(order);
    }
    
    public boolean isDuplicatedID(String id){
        for(Fruit f : fruitList){
            if(id.equalsIgnoreCase(f.getId())) return true;
        }
        return false;
    }

    public void showFruits(List<Fruit> fruitlist) {
        if (fruitlist.isEmpty()) {
            System.out.println("List fruits are empty");
        } else {
            System.out.println(" ++ Item ++ | ++ Fruit name ++ | ++ Origin ++ | ++ Price ++ | ++ Stock ++");
            int i = 1;
            for (Fruit fruit : fruitlist) {
                System.out.println(i++ + fruit.toString());
            }
        }
    }

    public Order shopping() {
        showFruits(fruitList);
        
        HashMap<Fruit, Integer> mapOrderDetail = new HashMap<>();
        while (true) {

            int choice = Validator.inputInt("Choose item:", 1, fruitList.size()) - 1;
            Fruit targetFruit = fruitList.get(choice);
            System.out.println("You selected: " + targetFruit.getName());

            int quantityToBuy = Validator.inputInt("Please enter quantity: ", 1, targetFruit.getStockQuantity());
//            if(targetFruit.getStockQuantity() >= quantityToBuy)
            targetFruit.setStockQuantity(targetFruit.getStockQuantity() - quantityToBuy);
            // hashMap
            
            mapOrderDetail.put(targetFruit , mapOrderDetail.getOrDefault(targetFruit, 0) + quantityToBuy );
            
//            order.addDetail(new OrderDetail(targetFruit, quantityToBuy));
            
            if (Validator.inputYesNo("Do you want to order now? ")) {
                
                String customerName = Validator.inputFullName();
                // add to order
                Order order = new Order(customerName);
                for(Map.Entry<Fruit, Integer> e : mapOrderDetail.entrySet()){
                    order.addDetail(new OrderDetail(e.getKey(), e.getValue()));
                }
                orderList.add(order);
                System.out.println(order.toString());
                
                return order;
            }

        }
    }

    public void showOrders() {
        if (orderList.isEmpty()) {
            System.out.println("List orders are empty");
        } else {

            int i = 0;
            for (Order order : orderList) {
                System.out.println(++i + order.toString());
            }
        }
    }

}
