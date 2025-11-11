package com.mycompany.lab211.slot6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitShop {

    private List<Fruit> fruitList = new ArrayList<>();
    private List<Order> orderList = new ArrayList<>();

    // Thêm getter để Main có thể lấy dữ liệu để hiển thị
    public List<Fruit> getFruitList() {
        return fruitList;
    }

    public List<Order> getOrderList() {
        return orderList;
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

    public boolean isDuplicatedID(String id) {
        for (Fruit f : fruitList) {
            if (id.equalsIgnoreCase(f.getId())) {
                return true;
            }
        }
        return false;
    }

    // Phương thức để cập nhật tồn kho sau khi mua (logic nghiệp vụ)
    public void updateStock(Fruit fruit, int quantity) {
        fruit.setStockQuantity(fruit.getStockQuantity() - quantity);
    }
    
    // Phương thức để tạo và lưu Order (logic nghiệp vụ)
    public Order createAndSaveOrder(String customerName, Map<Fruit, Integer> mapOrderDetail) {
        Order order = new Order(customerName);
        for (Map.Entry<Fruit, Integer> e : mapOrderDetail.entrySet()) {
            order.addDetail(new OrderDetail(e.getKey(), e.getValue()));
        }
        orderList.add(order);
        return order;
    }
    
    // Các phương thức I/O đã được chuyển sang lớp Main
    // showFruits, shopping, showOrders KHÔNG CÒN Ở ĐÂY
}